/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-16 02:51:18
 * @LastEditors: pikapikapi pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-22 15:01:27
 * @FilePath: /virtualPetHospital-backend/intermediator/src/main/java/pet/hospital/backend/intermediator/service/AuthService.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.intermediator.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pet.hospital.backend.intermediator.constant.Constants;
import pet.hospital.backend.intermediator.helper.ResponseData;
import pet.hospital.backend.intermediator.helper.ResponseHelper;

@Service
public class AuthService {
    @Autowired
    private RestTemplate restTemplate;

    public ResponseData<JSONObject> login(String userName, String userPassword) {
        String api = "api/auth/login";

        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add(Constants.userName, userName);
        requestEntity.add(Constants.userPassword, userPassword);

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.postForObject(Constants.loginModuleBaseUrl + api, requestEntity, JSONObject.class));
    }

    public ResponseData<JSONObject> addUser(String userName, String userPassword, int userAuthority) {
        String api = "api/auth/register";

        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add(Constants.userName, userName);
        requestEntity.add(Constants.userPassword, userPassword);
        requestEntity.add(Constants.userAuthority, String.valueOf(userAuthority));

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.postForObject(Constants.loginModuleBaseUrl + api, requestEntity, JSONObject.class));
    }

    public ResponseData<JSONObject> updateUser(int userId, String userName, String userPassword, int userAuthority) {
        String api = "api/auth/update";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.loginModuleBaseUrl + api)
                .queryParam(Constants.userId, userId)
                .queryParam(Constants.userName, userName)
                .queryParam(Constants.userPassword, userPassword)
                .queryParam(Constants.userAuthority, userAuthority);

        return ResponseHelper.forwardResponseDataDirectly(restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.PUT, null, JSONObject.class)
                .getBody());
    }

    public ResponseData<JSONObject> deleteUser(int userId) {
        String api = "api/auth/delete";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.loginModuleBaseUrl + api)
                .queryParam(Constants.userId, userId);

        return ResponseHelper.forwardResponseDataDirectly(restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.DELETE, null, JSONObject.class)
                .getBody());
    }

    public ResponseData<JSONObject> getUsers(String userNameKeyword) {
        String api = "api/auth/users";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.loginModuleBaseUrl + api)
                .queryParam(Constants.userNameKeyword, userNameKeyword);

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.getForObject(uriBuilder.toUriString(), JSONObject.class));
    }
}
