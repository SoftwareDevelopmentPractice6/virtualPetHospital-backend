/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-15 23:36:24
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-16 01:42:56
 * @FilePath: /virtualPetHospital-backend/intermediator/src/main/java/pet/hospital/backend/intermediator/constant/Constants.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.intermediator.constant;

import org.springframework.beans.factory.annotation.Value;

public class Constants {

    @Value("${module.login.url}")
    public static String loginModuleBaseUrl;

    @Value("${module.medicalRecordManagement.url}")
    public static String medicalRecordManagementModuleBaseUrl;

    @Value("${module.system.url}")
    public static String systemModuleBaseUrl;
}
