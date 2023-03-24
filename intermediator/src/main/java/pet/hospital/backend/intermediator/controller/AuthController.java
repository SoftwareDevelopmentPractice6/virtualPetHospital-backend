/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-16 02:51:46
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-22 21:25:36
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pet.hospital.backend.intermediator.constant.Constants;
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
                                                    description = "Success message.",
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
                                                    description = "Failure message.",
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
                                                    description = "Failure message.",
                                                    value = "{\"code\": 401,\"message\": \"Unauthorized\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PostMapping(value = "/login")
    public ResponseEntity<JSONObject> login(
            @Parameter(
                            description = "登录用户信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example = "{\"userName\": \"test@test.com\", \"userPassword\": \"tttt\"}"))
                    @RequestBody
                    JSONObject userInfo) {
        return authService
                .login(userInfo.getString(Constants.userName), userInfo.getString(Constants.userPassword))
                .toResponseEntity();
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
                                                    description = "Success message.",
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
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PostMapping(value = "/user")
    public ResponseEntity<JSONObject> addUser(
            @Parameter(
                            description = "新增的用户信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example =
                                                    "{\"userName\": \"test@test.com\", \"userPassword\": \"tttt\", \"userAuthority\": 3}"))
                    @RequestBody
                    JSONObject newUserInfo) {
        return authService
                .addUser(
                        newUserInfo.getString(Constants.userName),
                        newUserInfo.getString(Constants.userPassword),
                        newUserInfo.getInteger(Constants.userAuthority))
                .toResponseEntity();
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
                                                    description = "Success message.",
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
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PutMapping(value = "/user")
    public ResponseEntity<JSONObject> updateUser(
            @Parameter(
                            description = "更改后的用户信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example =
                                                    "{\"userId\": 2, \"userName\": \"test@test.com\", \"userPassword\": \"tttt\", \"userAuthority\": 3}"))
                    @RequestBody
                    JSONObject newUserInfo) {
        return authService
                .updateUser(
                        newUserInfo.getInteger(Constants.userId),
                        newUserInfo.getString(Constants.userName),
                        newUserInfo.getString(Constants.userPassword),
                        newUserInfo.getInteger(Constants.userAuthority))
                .toResponseEntity();
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
                                                    description = "Success message.",
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
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @DeleteMapping(value = "/user/{userId}")
    public ResponseEntity<JSONObject> deleteUser(@Parameter(description = "用户Id") @PathVariable int userId) {
        return authService.deleteUser(userId).toResponseEntity();
    }

    @Operation(summary = "获取用户列表接口")
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
                                                            "{\"code\":200,\"data\":{\"userList\":[{\"userPassword\":\"test\",\"userAuthority\":3,\"userName\":\"test@test.com\",\"userId\":2},{\"userPassword\":\"tttt\",\"userAuthority\":3,\"userName\":\"tt\",\"userId\":6}]}}")
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
    @GetMapping(value = "/user/{userNameKeyword}")
    public ResponseEntity<JSONObject> getUsersByKeyword(
            @Parameter(description = "用户名关键字，支持模糊查询") @PathVariable String userNameKeyword) {
        return authService.getUsers(userNameKeyword).toResponseEntity();
    }

    @Operation(summary = "获取用户列表接口")
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
                                                            "{\"code\":200,\"data\":{\"userList\":[{\"userPassword\":\"test\",\"userAuthority\":3,\"userName\":\"test@test.com\",\"userId\":2},{\"userPassword\":\"tttt\",\"userAuthority\":3,\"userName\":\"tt\",\"userId\":6}]}}}")
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
    @GetMapping(value = "/user")
    public ResponseEntity<JSONObject> getUsers() {
        return authService.getUsers(null).toResponseEntity();
    }
}
