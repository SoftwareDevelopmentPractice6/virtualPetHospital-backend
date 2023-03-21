/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-21 14:20:30
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-21 17:34:22
 * @FilePath: /virtualPetHospital-backend/intermediator/src/main/java/pet/hospital/backend/intermediator/controller/FileController.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.intermediator.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pet.hospital.backend.intermediator.constant.Constants;
import pet.hospital.backend.intermediator.service.FileService;

@RestController
@Tag(name = "数据传输模块")
@RequestMapping(
        value = "/api/file",
        produces = {"application/json;charset=UTF-8"})
public class FileController {

    @Autowired
    FileService fileService;

    @Operation(summary = "上传文件接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value = "{\"code\": 200,\"message\": \"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "430",
                        description = "File transfer failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 430,\"message\": \"File transfer error\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "431",
                        description = "File empty",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 431,\"message\": \"File empty error\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PostMapping(value = "/files", consumes = "multipart/form-data")
    public ResponseEntity<JSONObject> uploadFile(
            @Parameter(description = "文件") @RequestParam MultipartFile file,
            @Parameter(description = "文件存储路径") @RequestParam String filePath) {
        return fileService.uploadFile(file, filePath).toResponseEntity();
    }

    @Operation(summary = "下载文件接口")
    @GetMapping(value = "/files", produces = "multipart/form-data")
    public ResponseEntity<Resource> downloadFile(@Parameter(description = "文件存储路径") @RequestParam String filePath) {
        return fileService.downloadFile(filePath);
    }

    @Operation(summary = "图片格式转换接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\": 200,\"message\": \"ok\",\"filePath\": \"/Users/xxx/Documents/Java/intermediatorServiceData/data/test/fe0151e3-188a-4342-8042-33d476394aa0/WallPaper_KirbyDiscovery_1920_1080.png\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PutMapping(value = "/image")
    public ResponseEntity<JSONObject> convertImage(
            @Parameter(
                            description = "图片格式转换信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example =
                                                    "{\"filePath\": \"/Users/xxx/Documents/Java/intermediatorServiceData/data/test/fe0151e3-188a-4342-8042-33d476394aa0/WallPaper_KirbyDiscovery_1920_1080.jpg\", \"expectedFormat\": \"png\"}"))
                    @RequestBody
                    JSONObject newFileInfo) {
        return fileService
                .convertImage(
                        newFileInfo.getString(Constants.filePath), newFileInfo.getString(Constants.expectedFormat))
                .toResponseEntity();
    }
}
