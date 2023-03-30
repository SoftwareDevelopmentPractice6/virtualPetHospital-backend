/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-15 23:36:24
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-31 00:26:08
 * @FilePath: /virtualPetHospital-backend/intermediator/src/main/java/pet/hospital/backend/intermediator/constant/Constants.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.intermediator.constant;

import jakarta.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Constants {

    @Value("${application.login.url}")
    private String injectedLoginModuleBaseUrl;

    @Value("${application.medicalRecordManagement.url}")
    private String injectedMedicalRecordManagementModuleBaseUrl;

    @Value("${application.system.url}")
    private String injectedSystemModuleBaseUrl;

    @Value("${application.exam.url}")
    private String injectedExamModuleBaseUrl;

    public static String loginModuleBaseUrl;

    public static String medicalRecordManagementModuleBaseUrl;

    public static String systemModuleBaseUrl;

    public static String examModuleBaseUrl;

    @PostConstruct
    public void init() {
        loginModuleBaseUrl = injectedLoginModuleBaseUrl;
        medicalRecordManagementModuleBaseUrl = injectedMedicalRecordManagementModuleBaseUrl;
        systemModuleBaseUrl = injectedSystemModuleBaseUrl;
        examModuleBaseUrl = injectedExamModuleBaseUrl;
    }

    public static final String servicePath = "/intermediatorServiceData/data";

    public static final List<String> supportedPictureFormat = Arrays.asList("bmp", "jpg", "gif", "png");

    public static final List<String> supportedVideoFormat =
            Arrays.asList("asx", "asf", "mpg", "wmv", "3gp", "mp4", "mov", "avi", "flv", "rmvb");

    public static String filePath = "filePath";

    public static String filePathList = "filePathList";

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

    public static String examList = "examList";

    public static String paperId = "paperId";

    public static String paperName = "paperName";

    public static String paperDuration = "paperDuration";

    public static String paperTotalScore = "paperTotalScore";

    public static String paperNameKeyword = "paperKeyword";

    public static String paperExam = "paperExam";

    public static String paperList = "paperList";

    public static String examSessionId = "examSessionId";

    public static String examSessionStartTime = "examSessionStartTime";

    public static String examSessionEndTime = "examSessionEndTime";

    public static String examSessionPaper = "examSessionPaper";

    public static String examSessionList = "examSessionList";

    public static String studentResultId = "studentResultId";

    public static String studentResultStudentId = "studentResultStudentId";

    public static String studentResultScore = "studentResultScore";

    public static String categoryId = "categoryId";

    public static String categoryName = "categoryName";

    public static String categoryNameKeyword = "categoryKeyword";

    public static String questionId = "questionId";

    public static String questionContent = "questionContent";

    public static String questionType = "questionType";

    public static String questionContentKeyword = "questionKeyword";

    public static String questionInPaperId = "questionInPaperId";

    public static String studentAnswerId = "studentAnswerId";

    public static String studentAnswerContent = "studentAnswerContent";

    public static String studentAnswerPoint = "studentAnswerPoint";

    public static String studentAnswerKeyword = "studentAnswerKeyword";

    public static String questionPoint = "questionPoint";

    public static String admissionId = "admissionId";

    public static String roomStandard = "roomStandard";

    public static String careLevel = "careLevel";

    public static String remark = "remark";

    public static String carePrice = "carePrice";

    public static String archiveId = "archiveId";

    public static String storeTime = "storeTime";

    public static String diseaseType = "diseaseType";

    public static String petType = "petType";

    public static String petName = "petName";

    public static String petSex = "petSex";

    public static String ownerTel = "ownerTel";

    public static String chargeId = "chargeId";

    public static String itemName = "itemName";

    public static String chargePrice = "chargePrice";

    public static String examineId = "examineId";

    public static String examineName = "examineName";

    public static String examinePrice = "examinePrice";

    public static String funcId = "funcId";

    public static String funcName = "funcName";

    public static String funcDescription = "funcDescription";

    public static String funcFlow = "funcFlow";

    public static String funcVideo = "funcVideo";

    public static String funcRole = "funcRole";

    public static String funcTool = "funcTool";

    public static String featureList = "featureList";

    public static String medicineId = "medicineId";

    public static String medicineName = "medicineName";

    public static String medicinePrice = "medicinePrice";

    public static String manufacturer = "manufacturer";

    public static String medicineCategory = "medicineCategory";

    public static String specification = "specification";

    public static String isVaccine = "isVaccine";

    public static String roomName = "roomName";

    public static String roomRole = "roomRole";

    public static String previousRoomName = "previousRoomName";

    public static String roomKeyword = "roomKeyword";

    public static String diseaseAdmissionId = "admissionId";

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
