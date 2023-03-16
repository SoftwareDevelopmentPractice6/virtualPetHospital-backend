/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-16 11:56:45
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-16 12:59:04
 * @FilePath: /virtualPetHospital-backend/intermediator/src/test/java/pet/hospital/backend/intermediator/service/AuthServiceTest.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.intermediator.service;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import pet.hospital.backend.intermediator.constant.Constants;

@SpringBootTest
public class AuthServiceTest {

    @Autowired
    protected AuthService authService;

    @MockBean
    protected RestTemplate restTemplate;

    @BeforeEach
    void init() {
        Mockito.when(restTemplate.postForObject(Mockito.anyString(), Mockito.any(), Mockito.any()))
                .thenReturn(null);
    }

    @Test
    void testLogin() {
        String api = "api/auth/login";

        MultiValueMap<String, String> mockRequestEntity = new LinkedMultiValueMap<>();
        mockRequestEntity.add(Constants.userName, "admin@admin.com");
        mockRequestEntity.add(Constants.userPassword, "admin");

        authService.login("admin@admin.com", "admin");
        Mockito.verify(restTemplate)
                .postForObject(
                        Mockito.eq(Constants.loginModuleBaseUrl + api),
                        Mockito.eq(mockRequestEntity),
                        Mockito.eq((JSONObject.class)));
    }
}
