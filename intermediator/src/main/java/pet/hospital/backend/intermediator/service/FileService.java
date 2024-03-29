package pet.hospital.backend.intermediator.service;

import com.alibaba.fastjson.JSONObject;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;
import javax.imageio.ImageIO;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pet.hospital.backend.intermediator.constant.Constants;
import pet.hospital.backend.intermediator.helper.EnumCode;
import pet.hospital.backend.intermediator.helper.ResponseData;
import pet.hospital.backend.intermediator.helper.VideoType;
import ws.schild.jave.Encoder;
import ws.schild.jave.MultimediaObject;
import ws.schild.jave.encode.AudioAttributes;
import ws.schild.jave.encode.EncodingAttributes;
import ws.schild.jave.encode.VideoAttributes;

@Service
public class FileService {

    private String projectDirectoryPath = Paths.get(System.getProperty("user.dir"), "../../", Constants.servicePath)
            .normalize()
            .toString();

    public ResponseData<JSONObject> getDirectoryFileNames(String directoryPath) {
        Path destDirPath = Paths.get(projectDirectoryPath, directoryPath);
        File destDir = new File(destDirPath.toString());
        if (!(destDir.exists() && destDir.isDirectory())) {
            destDir.mkdirs();
        }

        try (Stream<Path> filePaths = Files.walk(destDirPath, 2)) {
            List<String> filePathList = new ArrayList<>();

            filePaths.filter(Files::isRegularFile).forEach(filePath -> {
                String sourceFormatName =
                        filePath.toString().substring(filePath.toString().lastIndexOf(".") + 1);
                if (Constants.supportedPictureFormat.contains(sourceFormatName)
                        || Constants.supportedVideoFormat.contains(sourceFormatName)) {
                    filePathList.add(filePath.toString()
                            .substring(filePath.toString().lastIndexOf(projectDirectoryPath)
                                    + projectDirectoryPath.length()
                                    + 1));
                }
            });

            JSONObject res = new JSONObject();
            res.put(Constants.filePathList, filePathList);

            return ResponseData.success(res);
        } catch (Exception e) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }
    }

    public ResponseData<JSONObject> uploadFile(MultipartFile multipartFile, String filePath) {
        try {
            if (multipartFile.isEmpty()) {
                return ResponseData.error(EnumCode.FILE_EMPTY_ERROR);
            }

            Path newFilePath = Paths.get(filePath, UUID.randomUUID().toString());

            Path servicePath = Paths.get(projectDirectoryPath, newFilePath.toString());

            File destDir = new File(servicePath.toString());
            if (!(destDir.exists() && destDir.isDirectory())) {
                destDir.mkdirs();
            }

            Files.copy(multipartFile.getInputStream(), servicePath.resolve(multipartFile.getOriginalFilename()));

            JSONObject res = new JSONObject();
            res.put(
                    Constants.filePath,
                    Paths.get(newFilePath.toString(), multipartFile.getOriginalFilename())
                            .toString());
            return ResponseData.success(res);
        } catch (Exception e) {
            return ResponseData.error(EnumCode.FILE_TRANSFER_ERROR);
        }
    }

    public ResponseEntity<Resource> downloadFile(String filePath) {
        try {
            Resource fileResource =
                    new UrlResource(Paths.get(projectDirectoryPath, filePath).toUri());
            if (fileResource.exists() || fileResource.isReadable()) {
                return ResponseEntity.ok().body(fileResource);
            } else {
                return ResponseEntity.status(EnumCode.REQUEST_ERROR.getCode()).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(EnumCode.REQUEST_ERROR.getCode()).body(null);
        }
    }

    public ResponseData<JSONObject> convertImage(String filePath, String expectedFormat) {
        String destFilePath = filePath.substring(0, filePath.lastIndexOf(".")) + "." + expectedFormat;

        if (modifyImageFormat(
                Paths.get(projectDirectoryPath, filePath).toString(),
                Paths.get(projectDirectoryPath, destFilePath).toString(),
                expectedFormat)) {
            JSONObject res = new JSONObject();
            res.put(Constants.filePath, destFilePath);
            return ResponseData.success(res);
        } else {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }
    }

    public ResponseData<JSONObject> convertVideo(String filePath, VideoType videoType) {
        String sourceFormatName = filePath.substring(filePath.lastIndexOf(".") + 1);
        String destFilePath = filePath.substring(0, filePath.lastIndexOf(".")) + "." + videoType.getFormat();

        if (modifyVideoFormat(
                Paths.get(projectDirectoryPath, filePath).toString(),
                Paths.get(projectDirectoryPath, destFilePath).toString(),
                sourceFormatName,
                videoType.getAudioEncode(),
                videoType.getVideoEncode(),
                videoType.getFormat())) {
            JSONObject res = new JSONObject();
            res.put(Constants.filePath, destFilePath);
            return ResponseData.success(res);
        } else {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }
    }

    public ResponseData<JSONObject> deleteFile(String filePath) {
        File file = new File(Paths.get(projectDirectoryPath, filePath).toString());

        JSONObject res = new JSONObject();
        res.put(Constants.filePath, filePath);

        return file.delete() ? ResponseData.success(res) : ResponseData.error(EnumCode.REQUEST_ERROR);
    }

    /**
     * @param srcPath    原图路径，包含图片名称
     * @param destPath   新图路径
     * @param formatName 图片格式，支持bmp|gif|jpg|jpeg|png
     * @return 转换是否成功
     */
    public boolean modifyImageFormat(String srcPath, String destPath, String formatName) {
        try {
            BufferedImage bufferedImg = ImageIO.read(new File(srcPath));
            return ImageIO.write(bufferedImg, formatName, new File(destPath));
        } catch (Exception e) {
            return false;
        }
    }

    public boolean modifyVideoFormat(
            String srcPath,
            String destPath,
            String sourceFormatName,
            String targetFormatAudioEncode,
            String targetFormatVideoEncode,
            String targetFormatName) {
        try {
            File source = new File(srcPath);
            MultimediaObject multimediaObject = new MultimediaObject(source);
            File target = new File(destPath);

            // Set encoding.
            AudioAttributes audio = new AudioAttributes();
            audio.setCodec(targetFormatAudioEncode);
            // audio.setBitRate(128000);
            // audio.setSamplingRate(44100);
            // audio.setChannels(2);
            VideoAttributes video = new VideoAttributes();
            // video.setBitRate(160000);
            // video.setFrameRate(20);
            video.setCodec(targetFormatVideoEncode);
            EncodingAttributes attrs = new EncodingAttributes();
            attrs.setInputFormat(sourceFormatName);
            attrs.setOutputFormat(targetFormatName);
            attrs.setAudioAttributes(audio);
            attrs.setVideoAttributes(video);

            int processorNum = Runtime.getRuntime().availableProcessors();
            int threadsNumToUse = (processorNum / 2) <= 5 ? Math.min(processorNum, 5) : Math.min(processorNum / 2, 12);

            attrs.setDecodingThreads(threadsNumToUse);
            attrs.setEncodingThreads(threadsNumToUse);

            Encoder encoder = new Encoder();
            encoder.encode(multimediaObject, target, attrs);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
