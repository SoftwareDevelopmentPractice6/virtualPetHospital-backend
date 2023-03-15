/*
 * @Author: pikapikapi pikapikapi_kaori@icloud.com
 * @Date: 2023-03-15 15:17:40
 * @LastEditors: pikapikapi pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-15 21:41:32
 * @FilePath: /virtualPetHospital-backend/login/src/test/java/pet/hospital/backend/login/controller/UserControllerTest.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.login.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import pet.hospital.backend.login.constant.Constants;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    protected UserController userController;

    @Autowired
    protected MockMvc mockMvc;

    @Test
    void testLoginSuccess() throws Exception {
        JSONObject expected = new JSONObject();
        expected.put(Constants.code, Constants.successCode);
        expected.put(Constants.message, Constants.findUserMessage);
        expected.put(Constants.userId, 1);
        expected.put(Constants.userName, "admin@admin.com");
        expected.put(Constants.userPassword, "admin");
        expected.put(Constants.userAuthority, 1);

        String resStr = mockMvc.perform(post("/api/auth/login")
                        .param("userName", "admin@admin.com")
                        .param("password", "admin"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertEquals(expected, JSON.parseObject(resStr));
    }
}
