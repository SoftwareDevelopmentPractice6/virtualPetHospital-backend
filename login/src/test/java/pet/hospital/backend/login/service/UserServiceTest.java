/*
 * @Author: pikapikapi pikapikapi_kaori@icloud.com
 * @Date: 2023-03-15 15:08:34
 * @LastEditors: pikapikapi pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-15 15:28:12
 * @FilePath: /virtualPetHospital-backend/login/src/test/java/pet/hospital/backend/login/service/UserServiceTest.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.login.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import pet.hospital.backend.login.constant.Constants;

@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired
    protected UserService userService;

    @Test
    void testLoginSuccess() {
        JSONObject expected = new JSONObject();
        expected.put(Constants.code, Constants.successCode);
        expected.put(Constants.message, Constants.findUserMessage);
        expected.put(Constants.userId, 1);
        expected.put(Constants.userName, "admin@admin.com");
        expected.put(Constants.userPassword, "admin");
        expected.put(Constants.userAuthority, 1);
        assertEquals(expected, userService.login("admin@admin.com", "admin"));
    }

    @Test
    void testLoginFail() {
        JSONObject expected = new JSONObject();
        expected.put(Constants.code, Constants.errorCode);
        expected.put(Constants.message, Constants.noUserMessage);
        assertEquals(expected, userService.login("admin@admin.com", "test"));
    }
}
