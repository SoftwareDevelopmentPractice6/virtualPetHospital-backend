/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-16 12:48:39
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-20 22:17:09
 * @FilePath: /virtualPetHospital-backend/intermediator/src/test/java/pet/hospital/backend/intermediator/controller/AuthControllerTest.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.intermediator.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;
import pet.hospital.backend.intermediator.constant.Constants;
import pet.hospital.backend.intermediator.helper.EnumCode;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Autowired
    protected AuthController authController;

    @Autowired
    protected MockMvc mockMvc;

    @MockBean
    protected RestTemplate restTemplate;

    @Test
    void testLogin() throws Exception {

        JSONObject mockApiData = new JSONObject();
        mockApiData.put(Constants.userId, 1);
        mockApiData.put(Constants.userName, "admin@admin.com");
        mockApiData.put(Constants.userPassword, "admin");
        mockApiData.put(Constants.userAuthority, 1);

        JSONObject expected = new JSONObject();
        expected.put(Constants.code, EnumCode.SUCCESS.getCode());
        expected.put(Constants.data, mockApiData);

        Mockito.when(restTemplate.postForObject(Mockito.anyString(), Mockito.any(), Mockito.any()))
                .thenReturn(expected);

        JSONObject expectedResponse = new JSONObject();
        expectedResponse.put(Constants.code, 200);
        expectedResponse.put(Constants.message, "ok");
        expectedResponse.put(Constants.data, mockApiData);

        JSONObject requestObject = new JSONObject();

        requestObject.put(Constants.userName, "admin@admin.com");
        requestObject.put(Constants.userPassword, "admin");

        String resStr = mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONString(requestObject)))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertEquals(expectedResponse, JSON.parseObject(resStr));
    }
}
