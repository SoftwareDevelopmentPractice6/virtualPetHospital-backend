/*
 * @Author: pikapikapi pikapikapi_kaori@icloud.com
 * @Date: 2023-03-15 13:51:43
 * @LastEditors: pikapikapi pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-15 14:02:04
 * @FilePath: /virtualPetHospital-backend/login/src/main/java/pet/hospital/backend/login/controller/UserController.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.login.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pet.hospital.backend.login.service.UserService;

@RestController
@RequestMapping(
        value = "/api/login",
        produces = {"application/json;charset=UTF-8"})
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public JSONObject login(String userName, String password) {
        return userService.login(userName, password);
    }
}
