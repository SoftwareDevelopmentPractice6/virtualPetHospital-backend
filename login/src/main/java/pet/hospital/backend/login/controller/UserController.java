/*
 * @Author: pikapikapi pikapikapi_kaori@icloud.com
 * @Date: 2023-03-15 13:51:43
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-18 19:29:27
 * @FilePath: /virtualPetHospital-backend/login/src/main/java/pet/hospital/backend/login/controller/UserController.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.login.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pet.hospital.backend.common.constant.Constants;
import pet.hospital.backend.login.service.UserService;

@RestController
@Tag(name = "Login模块")
@RequestMapping(
        value = "/api/auth",
        produces = {"application/json;charset=UTF-8"})
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "系统登录接口")
    @PostMapping(value = "/login")
    public JSONObject login(
            @Parameter(description = "用户名") @RequestParam String userName,
            @Parameter(description = "用户密码") @RequestParam String userPassword)
            throws UnsupportedEncodingException {
        return userService.login(
                URLDecoder.decode(userName, Constants.UTF8), URLDecoder.decode(userPassword, Constants.UTF8));
    }

    @Operation(summary = "新增用户接口")
    @PostMapping(value = "/register")
    public JSONObject addUser(
            @Parameter(description = "用户名") @RequestParam String userName,
            @Parameter(description = "用户密码") @RequestParam String userPassword,
            @Parameter(description = "用户权限") @RequestParam int userAuthority)
            throws UnsupportedEncodingException {
        return userService.addUser(
                URLDecoder.decode(userName, Constants.UTF8),
                URLDecoder.decode(userPassword, Constants.UTF8),
                userAuthority);
    }

    @Operation(summary = "更改用户信息接口")
    @PutMapping(value = "/update")
    public JSONObject updateUser(
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
                    String newUserInfo)
            throws UnsupportedEncodingException {
        return userService.updateUser(JSON.parseObject(URLDecoder.decode(newUserInfo, Constants.UTF8)));
    }

    @Operation(summary = "删除用户信息接口")
    @DeleteMapping(value = "/delete")
    public JSONObject deleteUser(@Parameter(description = "用户Id") @RequestParam int userId) {
        return userService.deleteUser(userId);
    }

    @Operation(summary = "获取用户列表接口")
    @GetMapping(value = "/users")
    public JSONObject getUsers(
            @Parameter(description = "用户名关键字，支持模糊查询") @RequestParam(required = false) String userNameKeyword)
            throws UnsupportedEncodingException {
        return userService.getUsers(
                Objects.equals(userNameKeyword, null) ? "" : URLDecoder.decode(userNameKeyword, Constants.UTF8));
    }
}
