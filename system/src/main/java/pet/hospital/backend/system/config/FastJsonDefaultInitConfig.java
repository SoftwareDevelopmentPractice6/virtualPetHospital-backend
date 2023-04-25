/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-04-25 18:27:43
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-04-25 18:35:25
 * @FilePath: /virtualPetHospital-backend/system/src/main/java/pet/hospital/backend/system/config/FastJsonDefaultInitConfig.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.system.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class FastJsonDefaultInitConfig {

    @PostConstruct
    public void postConstruct() {
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.DisableCircularReferenceDetect.getMask();
    }
}
