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
import pet.hospital.backend.medicalRecordManagement.service.TreatmentProgramService;

@RestController
@Tag(name = "MedicalRecordManagement模块")
@RequestMapping(
        value = "/api/medicalRecordManagement/treatmentProgram",
        produces = {"application/json;charset=UTF-8"})

public class TreatmentProgramController {
    @Autowired
    TreatmentProgramService treatmentProgramService;

    @Operation(summary = "获取治疗方案接口")
    @GetMapping(value = "/get")
    public JSONObject getTreatmentProgram(
            @Parameter(description = "治疗方案Id") @RequestParam(required = false) Integer treatmentProgramId,
            @Parameter(description = "治疗方案内容关键字，支持模糊查询") @RequestParam(required = false) String treatmentProgramKeyword
    )
            throws UnsupportedEncodingException {
        return treatmentProgramService.getTreatmentProgram(treatmentProgramId, URLDecoder.decode(treatmentProgramKeyword, Constants.UTF8));
    }

    @Operation(summary = "新增治疗方案接口")
    @PostMapping(value = "/add")
    public JSONObject addTreatmentProgram(
            @Parameter(description = "治疗方案内容") @RequestParam String treatmentProgramContent,
            @Parameter(description = "治疗方案图片") @RequestParam String treatmentProgramPhoto,
            @Parameter(description = "治疗方案视频") @RequestParam String treatmentProgramVideo)
            throws UnsupportedEncodingException {
        return treatmentProgramService.addTreatmentProgram(
                URLDecoder.decode(treatmentProgramContent, Constants.UTF8),
                URLDecoder.decode(treatmentProgramPhoto, Constants.UTF8),
                URLDecoder.decode(treatmentProgramVideo, Constants.UTF8));
    }

    @Operation(summary = "更改治疗方案信息接口")
    @PutMapping(value = "/update")
    public JSONObject updateTreatmentProgram(
            @Parameter(description = "治疗方案Id") @RequestParam int treatmentProgramId,
            @Parameter(description = "治疗方案内容") @RequestParam String treatmentProgramContent,
            @Parameter(description = "治疗方案图片") @RequestParam String treatmentProgramPhoto,
            @Parameter(description = "治疗方案视频") @RequestParam String treatmentProgramVideo)

            throws UnsupportedEncodingException {
        return treatmentProgramService.updateTreatmentProgram(
                treatmentProgramId,
                URLDecoder.decode(treatmentProgramContent, Constants.UTF8),
                URLDecoder.decode(treatmentProgramPhoto, Constants.UTF8),
                URLDecoder.decode(treatmentProgramVideo, Constants.UTF8));
    }

    @Operation(summary = "删除治疗方案接口")
    @DeleteMapping(value = "/delete")
    public JSONObject deleteTreatmentProgram(@Parameter(description = "治疗方案Id") @RequestParam int treatmentProgramId) {
        return treatmentProgramService.deleteTreatmentProgram(treatmentProgramId);
    }
}


