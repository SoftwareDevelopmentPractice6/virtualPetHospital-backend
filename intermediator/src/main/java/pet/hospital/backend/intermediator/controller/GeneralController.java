package pet.hospital.backend.intermediator.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pet.hospital.backend.intermediator.constant.Constants;
import pet.hospital.backend.intermediator.service.GeneralService;

@RestController
@CrossOrigin
@RequestMapping(
        value = "/api",
        produces = {"application/json;charset=UTF-8"})
public class GeneralController {
    @Autowired
    private GeneralService generalService;

    @Tag(name = "系统管理模块")
    @Operation(summary = "根据ID获取入院信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"careLevel\":\"this is a test\",\"admissionId\":1,\"remark\":\"oxjoq\",\"carePrice\":1.0,\"admissionRoom\":{\"roomRole\":\"this is a test\",\"roomName\":\"testroom\"},\"roomStandard\":\"testroom\"},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/system/admission/sys/{id}")
    public ResponseEntity<JSONObject> getAdmissionById(@Parameter(description = "Id") @PathVariable int id) {
        return generalService
                .getDataById(Constants.systemModuleBaseUrl, Constants.systemModuleApiPrefix, "Admission", id)
                .toResponseEntity();
    }

    @Tag(name = "系统管理模块")
    @Operation(summary = "根据ID获取档案信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"petName\":\"小黑\",\"petSex\":\"M\",\"petType\":\"猫\",\"storeTime\":\"2022-01-01 16:30:00\",\"ownerTel\":\"13512345678\",\"diseaseType\":\"感冒\",\"archiveId\":61},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/system/archive/sys/{id}")
    public ResponseEntity<JSONObject> getArchiveById(@Parameter(description = "Id") @PathVariable int id) {
        return generalService
                .getDataById(Constants.systemModuleBaseUrl, Constants.systemModuleApiPrefix, "Archive", id)
                .toResponseEntity();
    }

    @Tag(name = "系统管理模块")
    @Operation(summary = "根据ID获取收费信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"itemName\":\"挂号费\",\"chargeId\":61,\"chargePrice\":10},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/system/charge/sys/{id}")
    public ResponseEntity<JSONObject> getChargeById(@Parameter(description = "Id") @PathVariable int id) {
        return generalService
                .getDataById(Constants.systemModuleBaseUrl, Constants.systemModuleApiPrefix, "Charge", id)
                .toResponseEntity();
    }

    @Tag(name = "系统管理模块")
    @Operation(summary = "根据ID获取化验信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"examineName\":\"疫苗注射\",\"examineRoom\":{\"roomRole\":\"医师，医助\",\"roomName\":\"疫苗接种室\"},\"examineId\":64,\"examinePrice\":100},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/system/examine/sys/{id}")
    public ResponseEntity<JSONObject> getExamineById(@Parameter(description = "Id") @PathVariable int id) {
        return generalService
                .getDataById(Constants.systemModuleBaseUrl, Constants.systemModuleApiPrefix, "Examine", id)
                .toResponseEntity();
    }

    @Tag(name = "系统管理模块")
    @Operation(summary = "根据ID获取药品信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"medicineCategory\":\"抗生素\",\"isVaccine\":0,\"medicinePrice\":12.5,\"medicineId\":61,\"specification\":\"250mg*24片/盒\",\"medicineName\":\"阿莫西林\",\"manufacturer\":\"上海默沙东制药有限公司\"},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/system/medicine/sys/{id}")
    public ResponseEntity<JSONObject> getMedicineById(@Parameter(description = "Id") @PathVariable int id) {
        return generalService
                .getDataById(Constants.systemModuleBaseUrl, Constants.systemModuleApiPrefix, "Medicine", id)
                .toResponseEntity();
    }

    @Tag(name = "系统管理模块")
    @Operation(summary = "根据ID获取功能信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"funcDescription\":\"为宠物提供生活护理服务，如喂食、喂水等\",\"funcName\":\"护理\",\"featureRoom\":{\"roomRole\":\"医助\",\"roomName\":\"护理室\"},\"funcFlow\":\"1.准备喂食用具和食物 2.为宠物喂食和喂水\",\"funcRole\":\"医助\",\"funcTool\":\"喂食器具、食物、水\",\"funcId\":61,\"funcVideo\":\"system/feature/b910097e-51b8-50e1-7eaf-d750f4a80429/video\"},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/system/feature/sys/{id}")
    public ResponseEntity<JSONObject> getFeatureById(@Parameter(description = "Id") @PathVariable int id) {
        return generalService
                .getDataById(Constants.systemModuleBaseUrl, Constants.systemModuleApiPrefix, "Feature", id)
                .toResponseEntity();
    }

    @Tag(name = "鉴权模块")
    @Operation(summary = "根据ID获取用户信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"userPassword\":\"123\",\"userAuthority\":1,\"userName\":\"student\",\"userId\":2},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/auth/user/sys/{id}")
    public ResponseEntity<JSONObject> getUserById(@Parameter(description = "Id") @PathVariable int id) {
        return generalService
                .getDataById(Constants.loginModuleBaseUrl, Constants.authModuleApiPrefix, "User", id)
                .toResponseEntity();
    }

    @Tag(name = "病例模块")
    @Operation(summary = "根据ID获取疾病信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"diseaseNameContent\":\"胃炎\",\"diseaseNameCategory\":\"消化系统疾病\",\"diseaseNameId\":12,\"diseaseNamePhoto\":\"disease/diseaseName/ecb4009c-2da5-059c-36eb-4550c93b39ff/photo\",\"diseaseNameVideo\":\"disease/diseaseName/ecb4009c-2da5-059c-36eb-4550c93b39ff/video\"},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/disease/disease/sys/{id}")
    public ResponseEntity<JSONObject> getDiseaseById(@Parameter(description = "Id") @PathVariable int id) {
        return generalService
                .getDataById(
                        Constants.medicalRecordManagementModuleBaseUrl,
                        Constants.diseaseModuleApiPrefix,
                        "DiseaseName",
                        id)
                .toResponseEntity();
    }

    @Tag(name = "病例模块")
    @Operation(summary = "根据ID获取病例信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"medicalCaseAdmission\":{\"admissionVideo\":\"disease/admission/1a8af183-172f-e834-94f8-6be6ab62589f/video\",\"admissionId\":12,\"admissionPhoto\":\"disease/admission/1a8af183-172f-e834-94f8-6be6ab62589f/photo\",\"admissionContent\":\"患者反复出现腹痛、恶心、呕吐等症状，就诊\"},\"medicalCaseDiagnosticResult\":{\"diagnosticResultPhoto\":\"disease/diagnosticResult/1a8af183-172f-e834-94f8-6be6ab62589f/photo\",\"diagnosticResultId\":12,\"diagnosticResultVideo\":\"disease/diagnosticResult/1a8af183-172f-e834-94f8-6be6ab62589f/video\",\"diagnosticResultContent\":\"胃部压痛明显，胃镜检查显示胃体部位存在浅表性胃炎病变\"},\"medicalCaseDiseaseName\":{\"diseaseNameContent\":\"胃炎\",\"diseaseNameCategory\":\"消化系统疾病\",\"diseaseNameId\":12,\"diseaseNamePhoto\":\"disease/diseaseName/ecb4009c-2da5-059c-36eb-4550c93b39ff/photo\",\"diseaseNameVideo\":\"disease/diseaseName/ecb4009c-2da5-059c-36eb-4550c93b39ff/video\"},\"medicalCaseTreatmentProgram\":{\"treatmentProgramPhoto\":\"disease/treatmentProgram/1a8af183-172f-e834-94f8-6be6ab62589f/photo\",\"treatmentProgramVideo\":\"disease/treatmentProgram/1a8af183-172f-e834-94f8-6be6ab62589f/video\",\"treatmentProgramId\":12,\"treatmentProgramContent\":\"通过规律饮食、注意休息、避免吸烟饮酒等方式调理胃肠功能，同时根据病情选择口服药物或其他治疗方式\"},\"medicalCaseId\":12,\"medicalCaseCaseCheck\":{\"caseCheckId\":12,\"caseCheckContent\":\"患者血常规、肝功能、肾功能、电解质等检查均正常，胃镜检查显示胃体部位存在浅表性胃炎病变\",\"caseCheckVideo\":\"disease/caseCheck/1a8af183-172f-e834-94f8-6be6ab62589f/video\",\"caseCheckPhoto\":\"disease/caseCheck/1a8af183-172f-e834-94f8-6be6ab62589f/photo\"}},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/disease/medical-case/sys/{id}")
    public ResponseEntity<JSONObject> getMedicalCaseById(@Parameter(description = "Id") @PathVariable int id) {
        return generalService
                .getDataById(
                        Constants.medicalRecordManagementModuleBaseUrl,
                        Constants.diseaseModuleApiPrefix,
                        "MedicalCase",
                        id)
                .toResponseEntity();
    }

    @Tag(name = "测验模块")
    @Operation(summary = "根据ID获取考试信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"examSessionId\":6,\"examSessionPaper\":{\"paperDuration\":\"60分钟\",\"paperTotalScore\":\"100分\",\"paperExam\":{\"examName\":\"宠物医院实习生测试6\",\"examId\":6},\"paperName\":\"宠物医院实习生测试卷6\",\"paperId\":6},\"examSessionEndTime\":\"2023-04-18 19:00:00\",\"examSessionStartTime\":\"2023-04-18 18:00:00\"},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/exam/exam-session/sys/{id}")
    public ResponseEntity<JSONObject> getExamSessionById(@Parameter(description = "Id") @PathVariable int id) {
        return generalService
                .getDataById(Constants.examModuleBaseUrl, Constants.examModuleApiPrefix, "ExamSession", id)
                .toResponseEntity();
    }

    @Tag(name = "测验模块")
    @Operation(summary = "根据ID获取学生考试结果信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"studentResultStudentId\":2,\"studentResultExamSession\":{\"examSessionId\":3,\"examSessionPaper\":{\"paperDuration\":\"60分钟\",\"paperTotalScore\":\"100分\",\"paperExam\":{\"examName\":\"宠物医院实习生测试3\",\"examId\":3},\"paperName\":\"宠物医院实习生测试卷3\",\"paperId\":3},\"examSessionEndTime\":\"2023-04-14 19:00:00\",\"examSessionStartTime\":\"2023-04-14 18:00:00\"},\"studentResultScore\":95,\"studentResultId\":3},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/exam/student-result/sys/{id}")
    public ResponseEntity<JSONObject> getStudentResultById(@Parameter(description = "Id") @PathVariable int id) {
        return generalService
                .getDataById(Constants.examModuleBaseUrl, Constants.examModuleApiPrefix, "StudentResult", id)
                .toResponseEntity();
    }

    @Tag(name = "测验模块")
    @Operation(summary = "根据ID获取问题类别信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"categoryName\":\"猫\",\"categoryId\":2},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/exam/category/sys/{id}")
    public ResponseEntity<JSONObject> getCategoryById(@Parameter(description = "Id") @PathVariable int id) {
        return generalService
                .getDataById(Constants.examModuleBaseUrl, Constants.examModuleApiPrefix, "Category", id)
                .toResponseEntity();
    }

    @Tag(name = "测验模块")
    @Operation(summary = "根据问题信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"questionContent\":\"猫咪为什么会打喷嚏？ A.因为感冒 B.因为过敏 C.因为异物刺激 D.其他\",\"questionId\":2,\"questionCategory\":{\"categoryName\":\"猫\",\"categoryId\":2},\"questionType\":\"单选\"},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/exam/question/sys/{id}")
    public ResponseEntity<JSONObject> getQuestionById(@Parameter(description = "Id") @PathVariable int id) {
        return generalService
                .getDataById(Constants.examModuleBaseUrl, Constants.examModuleApiPrefix, "Question", id)
                .toResponseEntity();
    }

    @Tag(name = "测验模块")
    @Operation(summary = "根据试卷中问题信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"questionInPaperPaper\":{\"paperDuration\":\"60分钟\",\"paperTotalScore\":\"100分\",\"paperExam\":{\"examName\":\"宠物医院实习生测试2\",\"examId\":2},\"paperName\":\"宠物医院实习生测试卷2\",\"paperId\":2},\"questionPoint\":15,\"questionInPaperQuestion\":{\"questionContent\":\"半夜突然听到宠物在呕吐声，应该怎么办？ A.立刻喂水 B.观察一段时间再决定是否送医 C.在网上找解决方案 D.带宠物到宠物医院\",\"questionId\":5,\"questionCategory\":{\"categoryName\":\"其他\",\"categoryId\":4},\"questionType\":\"多选\"},\"questionInPaperId\":7},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/exam/question-in-paper/sys/{id}")
    public ResponseEntity<JSONObject> getQuestionInPaperById(@Parameter(description = "Id") @PathVariable int id) {
        return generalService
                .getDataById(Constants.examModuleBaseUrl, Constants.examModuleApiPrefix, "QuestionInPaper", id)
                .toResponseEntity();
    }

    @Tag(name = "测验模块")
    @Operation(summary = "根据学生单一问题作答信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"studentAnswerContent\":\"Answer 1\",\"studentAnswerId\":1,\"studentAnswerPoint\":0,\"studentAnswerStudentResult\":{\"studentResultStudentId\":1,\"studentResultExamSession\":{\"examSessionId\":1,\"examSessionPaper\":{\"paperDuration\":\"2 hours\",\"paperTotalScore\":\"100\",\"paperExam\":{\"examName\":\"Math Exam\",\"examId\":1},\"paperName\":\"Math Paper\",\"paperId\":1},\"examSessionEndTime\":\"2023-03-16 20:00:00\",\"examSessionStartTime\":\"2023-03-16 18:00:00\"},\"studentResultScore\":90,\"studentResultId\":1},\"studentAnswerQuestionInPaper\":{\"questionInPaperPaper\":{\"paperDuration\":\"2 hours\",\"paperTotalScore\":\"100\",\"paperExam\":{\"examName\":\"Math Exam\",\"examId\":1},\"paperName\":\"Math Paper\",\"paperId\":1},\"questionPoint\":2,\"questionInPaperQuestion\":{\"questionContent\":\"What is the value of x in the equation x + 5 = 10?\",\"questionId\":1,\"questionCategory\":{\"categoryName\":\"Algebra\",\"categoryId\":1},\"questionType\":\"Multiple Choice\"},\"questionInPaperId\":1}},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/exam/student-answer/sys/{id}")
    public ResponseEntity<JSONObject> getStudentAnswerById(@Parameter(description = "Id") @PathVariable int id) {
        return generalService
                .getDataById(Constants.examModuleBaseUrl, Constants.examModuleApiPrefix, "StudentAnswer", id)
                .toResponseEntity();
    }
}
