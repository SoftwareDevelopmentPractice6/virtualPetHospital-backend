/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-27 17:37:20
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-27 18:01:02
 * @FilePath: /virtualPetHospital-backend/intermediator/src/main/java/pet/hospital/backend/intermediator/controller/DiseaseController.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.intermediator.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pet.hospital.backend.intermediator.constant.Constants;
import pet.hospital.backend.intermediator.service.DiseaseService;

@RestController
@Tag(name = "病例模块")
@RequestMapping(
        value = "/api/disease",
        produces = {"application/json;charset=UTF-8"})
public class DiseaseController {
    @Autowired
    DiseaseService diseaseService;

    @Operation(summary = "获取疾病信息列表接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {@ExampleObject(description = "Success message.", value = "")},
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
    @GetMapping(value = "/disease/{diseaseNameKeyword}")
    public ResponseEntity<JSONObject> getDiseasesByDiseaseName(
            @Parameter(description = "疾病名称关键字，支持模糊查询") @PathVariable String diseaseNameKeyword,
            @Parameter(description = "疾病类别") @RequestParam(required = false) String diseaseNameCategory) {
        return diseaseService
                .getDiseaseNames(null, diseaseNameKeyword, diseaseNameCategory)
                .toResponseEntity();
    }

    @Operation(summary = "获取疾病信息列表接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {@ExampleObject(description = "Success message.", value = "")},
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
    @GetMapping(value = "/disease")
    public ResponseEntity<JSONObject> getDiseases(
            @Parameter(description = "疾病类别") @RequestParam(required = false) String diseaseNameCategory) {
        return diseaseService.getDiseaseNames(null, null, diseaseNameCategory).toResponseEntity();
    }

    @Operation(summary = "新增疾病信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {@ExampleObject(description = "Success message.", value = "")},
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
    @PostMapping(value = "/disease")
    public ResponseEntity<JSONObject> addDisease(
            @Parameter(
                            description = "新增的疾病信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example =
                                                    "{\"diseaseNameContent\": \"test disease\", \"diseaseNameCategory\": \"test disease category\"}"))
                    @RequestBody
                    JSONObject newDiseaseInfo) {
        return diseaseService
                .addDiseaseNameAutomatically(
                        newDiseaseInfo.getString(Constants.diseaseNameContent),
                        newDiseaseInfo.getString(Constants.diseaseNameCategory))
                .toResponseEntity();
    }

    @Operation(summary = "更改疾病信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {@ExampleObject(description = "Success message.", value = "")},
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
    @PutMapping(value = "/disease")
    public ResponseEntity<JSONObject> updateDisease(
            @Parameter(
                            description = "更改后的疾病信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example =
                                                    "{\"diseaseNameId\": 2, \"diseaseNameContent\": \"test disease\", \"diseaseNameCategory\": \"test disease category\"}"))
                    @RequestBody
                    JSONObject newDiseaseInfo) {
        return diseaseService
                .updateDiseaseNameAutomatically(
                        newDiseaseInfo.getInteger(Constants.diseaseNameId),
                        newDiseaseInfo.getString(Constants.diseaseNameContent),
                        newDiseaseInfo.getString(Constants.diseaseNameCategory))
                .toResponseEntity();
    }

    @Operation(summary = "删除疾病信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {@ExampleObject(description = "Success message.", value = "")},
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
    @DeleteMapping(value = "/disease/{diseaseNameId}")
    public ResponseEntity<JSONObject> deleteDisease(
            @Parameter(description = "疾病信息Id") @PathVariable int diseaseNameId) {
        return diseaseService.deleteDiseaseName(diseaseNameId).toResponseEntity();
    }

    @Operation(summary = "获取病例信息列表接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {@ExampleObject(description = "Success message.", value = "")},
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
    @GetMapping(value = "/medical-case")
    public ResponseEntity<JSONObject> getMedicalCases(
            @Parameter(description = "接诊文字关键字，支持模糊查询") @RequestParam(required = false) String admissionKeyword,
            @Parameter(description = "病例检察文字关键字，支持模糊查询") @RequestParam(required = false) String caseCheckKeyword,
            @Parameter(description = "诊断结果文字关键字，支持模糊查询") @RequestParam(required = false) String diagnosticResultKeyword,
            @Parameter(description = "治疗方案文字关键字，支持模糊查询") @RequestParam(required = false) String treatmentProgramKeyword,
            @Parameter(description = "疾病Id") @RequestParam(required = false) Integer diseaseNameId) {
        return diseaseService
                .getMedicalCaseAutomatically(
                        admissionKeyword,
                        caseCheckKeyword,
                        diagnosticResultKeyword,
                        treatmentProgramKeyword,
                        diseaseNameId)
                .toResponseEntity();
    }

    @Operation(summary = "新增病例信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {@ExampleObject(description = "Success message.", value = "")},
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
    @PostMapping(value = "/medical-case")
    public ResponseEntity<JSONObject> addMedicalCase(
            @Parameter(
                            description = "新增的病例信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example =
                                                    "{\"diseaseNameId\": 2, \"admissionContent\": \"test admission\", \"caseCheckContent\": \"test case check\", \"diagnosticResultContent\": \"test diagnostic result\", \"treatmentProgramContent\": \"test treatment program\"}"))
                    @RequestBody
                    JSONObject newMedicalCaseInfo) {
        return diseaseService
                .addMedicalCaseAutomatically(
                        newMedicalCaseInfo.getInteger(Constants.diseaseNameId),
                        newMedicalCaseInfo.getString(Constants.admissionContent),
                        newMedicalCaseInfo.getString(Constants.caseCheckContent),
                        newMedicalCaseInfo.getString(Constants.diagnosticResultContent),
                        newMedicalCaseInfo.getString(Constants.treatmentProgramContent))
                .toResponseEntity();
    }

    @Operation(summary = "更改病例信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {@ExampleObject(description = "Success message.", value = "")},
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
    @PutMapping(value = "/medical-case")
    public ResponseEntity<JSONObject> updateMedicalCase(
            @Parameter(
                            description = "更改后的病例信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example =
                                                    "{\"medicalCaseId\": 2, \"diseaseNameId\": 2, \"admissionContent\": \"test admission\", \"caseCheckContent\": \"test case check\", \"diagnosticResultContent\": \"test diagnostic result\", \"treatmentProgramContent\": \"test treatment program\"}"))
                    @RequestBody
                    JSONObject newMedicalCaseInfo) {
        return diseaseService
                .updateMedicalCaseAutomatically(
                        newMedicalCaseInfo.getInteger(Constants.medicalCaseId),
                        newMedicalCaseInfo.getInteger(Constants.diseaseNameId),
                        newMedicalCaseInfo.getString(Constants.admissionContent),
                        newMedicalCaseInfo.getString(Constants.caseCheckContent),
                        newMedicalCaseInfo.getString(Constants.diagnosticResultContent),
                        newMedicalCaseInfo.getString(Constants.treatmentProgramContent))
                .toResponseEntity();
    }

    @Operation(summary = "删除病例信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {@ExampleObject(description = "Success message.", value = "")},
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
    @DeleteMapping(value = "/medical-case/{medicalCaseId}")
    public ResponseEntity<JSONObject> deleteMedicalCase(
            @Parameter(description = "病例信息Id") @PathVariable int medicalCaseId) {
        return diseaseService.deleteMedicalCase(medicalCaseId).toResponseEntity();
    }
}
