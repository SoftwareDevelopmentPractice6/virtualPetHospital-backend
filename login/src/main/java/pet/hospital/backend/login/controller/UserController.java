/*
 * @Author: pikapikapi pikapikapi_kaori@icloud.com
 * @Date: 2023-03-15 13:51:43
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-17 22:57:53
 * @FilePath: /virtualPetHospital-backend/login/src/main/java/pet/hospital/backend/login/controller/UserController.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.login.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pet.hospital.backend.login.service.UserService;

@RestController
@Api(value = "Login模块")
@RequestMapping(
        value = "/api/auth",
        produces = {"application/json;charset=UTF-8"})
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "系统登录接口")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String"),
        @ApiImplicitParam(name = "userPassword", value = "用户密码", required = true, dataType = "String")
    })
    @PostMapping(value = "/login")
    public JSONObject login(String userName, String userPassword) {
        return userService.login(userName, userPassword);
    }

    @ApiOperation(value = "新增用户接口")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String"),
        @ApiImplicitParam(name = "userPassword", value = "用户密码", required = true, dataType = "String"),
        @ApiImplicitParam(name = "userAuthority", value = "用户权限", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/register")
    public JSONObject addUser(String userName, String userPassword, int userAuthority) {
        return userService.addUser(userName, userPassword, userAuthority);
    }

    @ApiOperation(value = "更改用户信息接口")
    @ApiImplicitParam(name = "newUserInfo", value = "更改后的用户信息", required = true, dataType = "String")
    @PutMapping(value = "/update")
    public JSONObject updateUser(String newUserInfo) {
        return userService.updateUser(JSON.parseObject(newUserInfo));
    }

    @ApiOperation(value = "删除用户信息接口")
    @ApiImplicitParam(name = "userId", value = "用户Id", required = true, dataType = "Integer")
    @DeleteMapping(value = "/delete")
    public JSONObject deleteUser(int userId) {
        return userService.deleteUser(userId);
    }
}
