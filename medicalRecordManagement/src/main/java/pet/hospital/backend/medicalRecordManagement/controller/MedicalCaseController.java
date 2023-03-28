package pet.hospital.backend.medicalRecordManagement.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pet.hospital.backend.common.constant.Constants;
import pet.hospital.backend.medicalRecordManagement.service.MedicalCaseService;

@RestController
@Tag(name = "MedicalRecordManagement模块")
@RequestMapping(
        value = "/api/medicalRecordManagement/medicalCase",
        produces = {"application/json;charset=UTF-8"})

public class MedicalCaseController {
    @Autowired
    MedicalCaseService medicalCaseService;

    @Operation(summary = "获取病例接口")
    @GetMapping(value = "/get")
    public JSONObject getMedicalCase(
            @Parameter(description = "病例Id") @RequestParam(required = false) Integer medicalCaseId,
            @Parameter(description = "接诊Id") @RequestParam(required = false) Integer admissionId,
            @Parameter(description = "病例检查Id") @RequestParam(required = false) Integer caseCheckId,
            @Parameter(description = "诊断结果Id") @RequestParam(required = false) Integer diagnosticResultId,
            @Parameter(description = "治疗方案Id") @RequestParam(required = false) Integer treatmentProgramId,
            @Parameter(description = "疾病名称Id") @RequestParam(required = false) Integer diseaseNameId
    )
            throws UnsupportedEncodingException {
        return medicalCaseService.getMedicalCase(medicalCaseId, admissionId, caseCheckId, diagnosticResultId,treatmentProgramId,diseaseNameId);
    }

    @Operation(summary = "新增病例接口")
    @PostMapping(value = "/add")
    public JSONObject addMedicalCase(
            @Parameter(description = "接诊Id") @RequestParam(required = false) Integer admissionId,
            @Parameter(description = "病例检查Id") @RequestParam(required = false) Integer caseCheckId,
            @Parameter(description = "诊断结果Id") @RequestParam(required = false) Integer diagnosticResultId,
            @Parameter(description = "治疗方案Id") @RequestParam(required = false) Integer treatmentProgramId,
            @Parameter(description = "疾病名称Id") @RequestParam(required = false) Integer diseaseNameId)
            throws UnsupportedEncodingException {
        return medicalCaseService.addMedicalCase(
                admissionId, caseCheckId, diagnosticResultId,treatmentProgramId,diseaseNameId);
    }

    @Operation(summary = "更改病例信息接口")
    @PutMapping(value = "/update")
    public JSONObject updateMedicalCase(
            @Parameter(description = "病例Id") @RequestParam(required = false) Integer medicalCaseId,
            @Parameter(description = "接诊Id") @RequestParam(required = false) Integer admissionId,
            @Parameter(description = "病例检查Id") @RequestParam(required = false) Integer caseCheckId,
            @Parameter(description = "诊断结果Id") @RequestParam(required = false) Integer diagnosticResultId,
            @Parameter(description = "治疗方案Id") @RequestParam(required = false) Integer treatmentProgramId,
            @Parameter(description = "疾病名称Id") @RequestParam(required = false) Integer diseaseNameId)

            throws UnsupportedEncodingException {
        return medicalCaseService.updateMedicalCase(
                medicalCaseId, admissionId, caseCheckId, diagnosticResultId, treatmentProgramId, diseaseNameId);
    }

    @Operation(summary = "删除病例接口")
    @DeleteMapping(value = "/delete")
    public JSONObject deleteMedicalCase(@Parameter(description = "病例Id") @RequestParam int medicalCaseId) {
        return medicalCaseService.deleteMedicalCase(medicalCaseId);
    }
}


