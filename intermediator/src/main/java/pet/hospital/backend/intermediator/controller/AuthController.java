/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-16 02:51:46
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-17 21:32:08
 * @FilePath: /virtualPetHospital-backend/intermediator/src/main/java/pet/hospital/backend/intermediator/controller/AuthController.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.intermediator.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pet.hospital.backend.intermediator.service.AuthService;

@RestController
@Api(tags = "鉴权模块")
@RequestMapping(
        value = "/api/auth",
        produces = {"application/json;charset=UTF-8"})
public class AuthController {
    @Autowired
    private AuthService authService;

    @ApiOperation(value = "系统登录接口")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String"),
        @ApiImplicitParam(name = "password", value = "用户密码", required = true, dataType = "String")
    })
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
    public ResponseEntity<JSONObject> login(String userName, String userPassword) {
        return authService.login(userName, userPassword).toResponseEntity();
    }
}
