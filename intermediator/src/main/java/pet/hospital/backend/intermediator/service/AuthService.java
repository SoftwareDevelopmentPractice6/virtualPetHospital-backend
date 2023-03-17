/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-16 02:51:18
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-17 22:03:04
 * @FilePath: /virtualPetHospital-backend/intermediator/src/main/java/pet/hospital/backend/intermediator/service/AuthService.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.intermediator.service;

import com.alibaba.fastjson.JSONObject;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import pet.hospital.backend.intermediator.constant.Constants;
import pet.hospital.backend.intermediator.helper.EnumCode;
import pet.hospital.backend.intermediator.helper.ResponseData;

@Service
public class AuthService {
    @Autowired
    private RestTemplate restTemplate;

    public ResponseData<JSONObject> login(String userName, String userPassword) {
        String api = "api/auth/login";

        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add(Constants.userName, userName);
        requestEntity.add(Constants.userPassword, userPassword);

        JSONObject apiRes =
                restTemplate.postForObject(Constants.loginModuleBaseUrl + api, requestEntity, JSONObject.class);

        if (apiRes == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        if (Objects.equals(apiRes.getInteger(Constants.code), EnumCode.SUCCESS.getCode())) {
            return ResponseData.success(apiRes.getJSONObject(Constants.data));
        } else {
            return ResponseData.error(EnumCode.getEnumCodeType(apiRes.getInteger(Constants.code)));
        }
    }
}
