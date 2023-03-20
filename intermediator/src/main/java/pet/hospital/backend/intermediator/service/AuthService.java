/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-16 02:51:18
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-20 16:24:56
 * @FilePath: /virtualPetHospital-backend/intermediator/src/main/java/pet/hospital/backend/intermediator/service/AuthService.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.intermediator.service;

import com.alibaba.fastjson.JSONObject;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
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

    public ResponseData<JSONObject> addUser(String userName, String userPassword, int userAuthority) {
        String api = "api/auth/register";

        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add(Constants.userName, userName);
        requestEntity.add(Constants.userPassword, userPassword);
        requestEntity.add(Constants.userAuthority, String.valueOf(userAuthority));

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

    public ResponseData<JSONObject> updateUser(JSONObject newUserInfo) {
        String api = "api/auth/update";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.loginModuleBaseUrl + api)
                .queryParam(Constants.userId, newUserInfo.getInteger(Constants.userId))
                .queryParam(Constants.userName, newUserInfo.getString(Constants.userName))
                .queryParam(Constants.userPassword, newUserInfo.getString(Constants.userPassword))
                .queryParam(Constants.userAuthority, newUserInfo.getInteger(Constants.userAuthority));

        JSONObject apiRes = restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.PUT, null, JSONObject.class)
                .getBody();

        if (apiRes == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        if (Objects.equals(apiRes.getInteger(Constants.code), EnumCode.SUCCESS.getCode())) {
            return ResponseData.success(apiRes.getJSONObject(Constants.data));
        } else {
            return ResponseData.error(EnumCode.getEnumCodeType(apiRes.getInteger(Constants.code)));
        }
    }

    public ResponseData<JSONObject> deleteUser(int userId) {
        String api = "api/auth/delete";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.loginModuleBaseUrl + api)
                .queryParam(Constants.userId, userId);

        JSONObject apiRes = restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.DELETE, null, JSONObject.class)
                .getBody();

        if (apiRes == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        if (Objects.equals(apiRes.getInteger(Constants.code), EnumCode.SUCCESS.getCode())) {
            return ResponseData.success(apiRes.getJSONObject(Constants.data));
        } else {
            return ResponseData.error(EnumCode.getEnumCodeType(apiRes.getInteger(Constants.code)));
        }
    }

    public ResponseData<JSONObject> getUsers(String userNameKeyword) {
        String api = "api/auth/users";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.loginModuleBaseUrl + api)
                .queryParam(Constants.userNameKeyword, userNameKeyword);

        JSONObject apiRes = restTemplate.getForObject(uriBuilder.toUriString(), JSONObject.class);

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
