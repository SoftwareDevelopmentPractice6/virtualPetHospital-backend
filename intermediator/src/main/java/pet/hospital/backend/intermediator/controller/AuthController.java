/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-16 02:51:46
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-18 16:15:49
 * @FilePath: /virtualPetHospital-backend/intermediator/src/main/java/pet/hospital/backend/intermediator/controller/AuthController.java
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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pet.hospital.backend.intermediator.service.AuthService;

@RestController
@Tag(name = "鉴权模块")
@RequestMapping(
        value = "/api/auth",
        produces = {"application/json;charset=UTF-8"})
public class AuthController {
    @Autowired
    private AuthService authService;

    @Operation(summary = "系统登录接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    name = "login",
                                                    description = "Login success message.",
                                                    value =
                                                            "{\"code\": 200,\"message\": \"ok\",\"data\": {\"userPassword\": \"admin\",\"userName\": \"admin@admin.com\",\"userAuthority\": 1,\"userId\": 1}}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    name = "login",
                                                    description = "Login failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "401",
                        description = "Unauthorized",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    name = "login",
                                                    description = "Login failure message.",
                                                    value = "{\"code\": 401,\"message\": \"Unauthorized\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PostMapping(value = "/login")
    public ResponseEntity<JSONObject> login(
            @Parameter(description = "用户名", required = true) @RequestParam String userName,
            @Parameter(description = "用户密码", required = true) @RequestParam String userPassword) {
        return authService.login(userName, userPassword).toResponseEntity();
    }

    @Operation(summary = "新增用户接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    name = "login",
                                                    description = "Login success message.",
                                                    value =
                                                            "{\"code\": 200,\"message\": \"ok\",\"data\": {\"userPassword\": \"admin\",\"userName\": \"admin@admin.com\",\"userAuthority\": 1,\"userId\": 1}}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    name = "login",
                                                    description = "Login failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PostMapping(value = "/user")
    public ResponseEntity<JSONObject> addUser(
            @Parameter(description = "用户名", required = true) @RequestParam String userName,
            @Parameter(description = "用户密码", required = true) @RequestParam String userPassword,
            @Parameter(description = "用户权限", required = true) @RequestParam int userAuthority) {
        return authService.addUser(userName, userPassword, userAuthority).toResponseEntity();
    }

    @Operation(summary = "更改用户信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    name = "login",
                                                    description = "Login success message.",
                                                    value =
                                                            "{\"code\": 200,\"message\": \"ok\",\"data\": {\"userPassword\": \"admin\",\"userName\": \"admin@admin.com\",\"userAuthority\": 1,\"userId\": 1}}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    name = "login",
                                                    description = "Login failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PutMapping(value = "/user")
    public ResponseEntity<JSONObject> updateUser(
            @Parameter(
                            description = "更改后的用户信息，json字符串",
                            required = true,
                            schema =
                                    @Schema(
                                            type = "string",
                                            format = "json-string",
                                            example =
                                                    "{\"userId\": 2, \"userName\": \"test@test.com\", \"userPassword\": \"tttt\", \"userAuthority\": 3}"))
                    @RequestParam
                    String newUserInfo) {
        return authService.updateUser(newUserInfo).toResponseEntity();
    }

    @Operation(summary = "删除用户接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    name = "login",
                                                    description = "Login success message.",
                                                    value =
                                                            "{\"code\": 200,\"message\": \"ok\",\"data\": {\"userPassword\": \"admin\",\"userName\": \"admin@admin.com\",\"userAuthority\": 1,\"userId\": 1}}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    name = "login",
                                                    description = "Login failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @DeleteMapping(value = "/user")
    public ResponseEntity<JSONObject> deleteUser(
            @Parameter(description = "用户Id", required = true) @RequestParam int userId) {
        return authService.deleteUser(userId).toResponseEntity();
    }
}
