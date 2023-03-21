/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-15 23:36:24
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-21 17:25:12
 * @FilePath: /virtualPetHospital-backend/intermediator/src/main/java/pet/hospital/backend/intermediator/constant/Constants.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.intermediator.constant;

import java.util.Arrays;
import java.util.List;

public class Constants {

    public static final String loginModuleBaseUrl = "http://localhost:8762/";

    public static final String medicalRecordManagementModuleBaseUrl = "http://localhost:8777/";

    public static final String systemModuleBaseUrl = "http://localhost:5678/";

    public static final String examModuleBaseUrl = "http://localhost:8778/";

    public static final String servicePath = "/intermediatorServiceData/data";

    public static final List<String> supportedPictureFormat = Arrays.asList("bmp", "jpg", "gif", "png");

    public static final List<String> supportedVideoFormat =
            Arrays.asList("asx", "asf", "mpg", "wmv", "3gp", "mp4", "mov", "avi", "flv", "rmvb");

    public static String filePath = "filePath";

    public static String expectedFormat = "expectedFormat";

    public static String code = "code";

    public static String message = "message";

    public static String data = "data";

    public static String userId = "userId";

    public static String userName = "userName";

    public static String userPassword = "userPassword";

    public static String userAuthority = "userAuthority";

    public static String userNameKeyword = "userNameKeyword";
}
