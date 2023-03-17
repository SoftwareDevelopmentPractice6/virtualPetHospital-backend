/*
 * @Author: pikapikapi pikapikapi_kaori@icloud.com
 * @Date: 2023-03-15 15:08:34
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-17 21:53:22
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
        JSONObject expectedData = new JSONObject();
        expectedData.put(Constants.userId, 1);
        expectedData.put(Constants.userName, "admin@admin.com");
        expectedData.put(Constants.userPassword, "admin");
        expectedData.put(Constants.userAuthority, 1);

        JSONObject expected = new JSONObject();
        expected.put(Constants.code, Constants.successCode);
        expected.put(Constants.data, expectedData);
    }

    @Test
    void testLoginFail() {
        JSONObject expected = new JSONObject();
        expected.put(Constants.code, Constants.authorityErrorCode);
        expected.put(Constants.data, null);
        assertEquals(expected, userService.login("admin@admin.com", "test"));
    }
}
