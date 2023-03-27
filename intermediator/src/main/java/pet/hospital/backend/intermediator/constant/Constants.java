/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-15 23:36:24
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-27 16:47:38
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

    public static String admissionId = "admissionId";

    public static String admissionContent = "admissionContent";

    public static String admissionPhoto = "admissionPhoto";

    public static String admissionVideo = "admissionVideo";

    public static String admissionKeyword = "admissionKeyword";

    public static String admissionList = "admissionList";

    public static String caseCheckId = "caseCheckId";

    public static String caseCheckContent = "caseCheckContent";

    public static String caseCheckPhoto = "caseCheckPhoto";

    public static String caseCheckVideo = "caseCheckVideo";

    public static String caseCheckKeyword = "caseCheckKeyword";

    public static String caseCheckList = "caseCheckList";

    public static String diagnosticResultId = "diagnosticResultId";

    public static String diagnosticResultContent = "diagnosticResultContent";

    public static String diagnosticResultPhoto = "diagnosticResultPhoto";

    public static String diagnosticResultVideo = "diagnosticResultVideo";

    public static String diagnosticResultKeyword = "diagnosticResultKeyword";

    public static String diagnosticResultList = "diagnosticResultList";

    public static String treatmentProgramId = "treatmentProgramId";

    public static String treatmentProgramContent = "treatmentProgramContent";

    public static String treatmentProgramPhoto = "treatmentProgramPhoto";

    public static String treatmentProgramVideo = "treatmentProgramVideo";

    public static String treatmentProgramKeyword = "treatmentProgramKeyword";

    public static String treatmentProgramList = "treatmentProgramList";

    public static String diseaseNameId = "diseaseNameId";

    public static String diseaseNameContent = "diseaseNameContent";

    public static String diseaseNamePhoto = "diseaseNamePhoto";

    public static String diseaseNameVideo = "diseaseNameVideo";

    public static String diseaseNameCategory = "diseaseNameCategory";

    public static String diseaseNameKeyword = "diseaseNameKeyword";

    public static String diseaseNameList = "diseaseNameList";

    public static String medicalCaseId = "medicalCaseId";

    public static String medicalCaseList = "medicalCaseList";

    public static String medicalCaseDiseaseName = "medicalCaseDiseaseName";

    public static String medicalCaseAdmission = "medicalCaseAdmission";

    public static String medicalCaseCaseCheck = "medicalCaseCaseCheck";

    public static String medicalCaseDiagnosticResult = "medicalCaseDiagnosticResult";

    public static String medicalCaseTreatmentProgram = "medicalCaseTreatmentProgram";
}
