package pet.hospital.backend.intermediator.service;

import com.alibaba.fastjson.JSONObject;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import javax.imageio.ImageIO;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pet.hospital.backend.intermediator.constant.Constants;
import pet.hospital.backend.intermediator.helper.EnumCode;
import pet.hospital.backend.intermediator.helper.ResponseData;

@Service
public class FileService {

    public ResponseData<JSONObject> uploadFile(MultipartFile multipartFile, String filePath) {
        try {
            if (multipartFile.isEmpty()) {
                return ResponseData.error(EnumCode.FILE_EMPTY_ERROR);
            }

            Path servicePath = Paths.get(
                            System.getProperty("user.dir"),
                            "../../",
                            Constants.servicePath,
                            filePath,
                            UUID.randomUUID().toString())
                    .normalize();

            File destDir = new File(servicePath.toString());
            if (!(destDir.exists() && destDir.isDirectory())) {
                destDir.mkdirs();
            }

            Files.copy(multipartFile.getInputStream(), servicePath.resolve(multipartFile.getOriginalFilename()));

            JSONObject res = new JSONObject();
            res.put(
                    Constants.filePath,
                    servicePath.resolve(multipartFile.getOriginalFilename()).toString());
            return ResponseData.success(res);
        } catch (Exception e) {
            return ResponseData.error(EnumCode.FILE_TRANSFER_ERROR);
        }
    }

    public ResponseEntity<Resource> downloadFile(String filePath) {
        try {
            Resource fileResource = new UrlResource(Paths.get(filePath).toUri());
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

        if (modifyImageFormat(filePath, destFilePath, expectedFormat)) {
            JSONObject res = new JSONObject();
            res.put(Constants.filePath, destFilePath);
            return ResponseData.success(res);
        } else {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }
    }

    public ResponseData<JSONObject> deleteFile(String filePath) {
        File file = new File(filePath);

        JSONObject res = new JSONObject();
        res.put(Constants.filePath, filePath);

        return file.delete() ? ResponseData.success(res) : ResponseData.error(EnumCode.REQUEST_ERROR);
    }

    /**
     * @param srcPath    原图路径，包含图片名称
     * @param destPath   新图路径
     * @param formatName 图片格式，支持bmp|gif|jpg|jpeg|png
     * @return           转换是否成功
     */
    public boolean modifyImageFormat(String srcPath, String destPath, String formatName) {
        try {
            BufferedImage bufferedImg = ImageIO.read(new File(srcPath));
            return ImageIO.write(bufferedImg, formatName, new File(destPath));
        } catch (Exception e) {
            return false;
        }
    }
}
