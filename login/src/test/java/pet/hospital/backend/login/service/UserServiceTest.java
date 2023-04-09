/*
 * @Author: pikapikapi pikapikapi_kaori@icloud.com
 * @Date: 2023-03-15 15:08:34
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-04-10 01:17:06
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
import pet.hospital.backend.common.constant.Constants;
import pet.hospital.backend.common.helper.ResponseHelper;

@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired
    protected UserService userService;

    private static String userName = "userName";

    private static String userPassword = "userPassword";

    private static String userAuthority = "userAuthority";

    @Test
    void testLoginSuccess() {
        userService.addUser("admin@admin.com", "admin", 1);

        JSONObject testRes = userService.login("admin@admin.com", "admin");
        assertEquals(ResponseHelper.successCode, testRes.getInteger(Constants.code));
        assertEquals("admin@admin.com", testRes.getJSONObject(Constants.data).getString(userName));
        assertEquals("admin", testRes.getJSONObject(Constants.data).getString(userPassword));
        assertEquals(1, testRes.getJSONObject(Constants.data).getInteger(userAuthority));
    }

    @Test
    void testLoginFail() {
        userService.addUser("admin@admin.com", "admin", 1);

        JSONObject expected = new JSONObject();
        expected.put(Constants.code, ResponseHelper.authorityErrorCode);
        expected.put(Constants.data, null);
        assertEquals(expected, userService.login("admin@admin.com", "test"));
    }
}
