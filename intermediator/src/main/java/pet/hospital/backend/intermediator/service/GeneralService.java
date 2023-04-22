/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-04-22 23:27:40
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-04-23 00:14:09
 * @FilePath: /virtualPetHospital-backend/intermediator/src/main/java/pet/hospital/backend/intermediator/service/GeneralService.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.intermediator.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pet.hospital.backend.intermediator.helper.ResponseData;
import pet.hospital.backend.intermediator.helper.ResponseHelper;

@Service
public class GeneralService {
    @Autowired
    private RestTemplate restTemplate;

    public ResponseData<JSONObject> getDataById(String baseUrl, String moduleName, String tableName, int id) {
        String api = "api/" + moduleName + "/sys/" + tableName + "/" + String.valueOf(id);

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(baseUrl + api);

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.getForObject(uriBuilder.toUriString(), JSONObject.class));
    }
}
