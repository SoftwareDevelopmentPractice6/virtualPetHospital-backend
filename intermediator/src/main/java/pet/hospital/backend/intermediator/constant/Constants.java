/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-15 23:36:24
 * @LastEditors: pikapikapi pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-22 15:36:55
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

    public static String examId = "examId";

    public static String examName = "examName";

    public static String examNameKeyword = "examKeyword";

    public static String paperId = "paperId";

    public static String paperName = "paperName";

    public static String paperDuration = "paperDuration";

    public static String paperTotalScore = "paperTotalScore";

    public static String paperNameKeyword = "paperKeyword";

    public static String examSessionId = "examSessionId";

    public static String examSessionStartTime = "examSessionStartTime";

    public static String examSessionEndTime = "examSessionEndTime";

    public static String studentResultId = "studentResultId";

    public static String studentResultStudentId = "studentResultStudentId";

    public static String studentResultScore = "studentResultScore";

    public static String categoryId = "categoryId";

    public static String categoryName = "categoryName";

    public static String categoryNameKeyword = "categoryKeyword";

    public static String questionId = "questionId";

    public static String questionContent = "questionContent";

    public static String questionType = "questionType";
}
