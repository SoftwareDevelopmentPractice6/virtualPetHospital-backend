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
import pet.hospital.backend.medicalRecordManagement.service.DiagnosticResultService;

@RestController
@Tag(name = "MedicalRecordManagement模块")
@RequestMapping(
        value = "/api/medicalRecordManagement/diagnosticResult",
        produces = {"application/json;charset=UTF-8"})

public class DiagnosticResultController {
    @Autowired
    DiagnosticResultService diagnosticResultService;

    @Operation(summary = "获取诊断结果接口")
    @GetMapping(value = "/get")
    public JSONObject getDiagnosticResult(
            @Parameter(description = "诊断结果Id") @RequestParam(required = false) Integer diagnosticResultId,
            @Parameter(description = "诊断结果内容关键字，支持模糊查询") @RequestParam(required = false) String diagnosticResultKeyword
    )
            throws UnsupportedEncodingException {
        return diagnosticResultService.getDiagnosticResult(diagnosticResultId, URLDecoder.decode(diagnosticResultKeyword, Constants.UTF8));
    }

    @Operation(summary = "新增诊断结果接口")
    @PostMapping(value = "/add")
    public JSONObject addDiagnosticResult(
            @Parameter(description = "诊断结果内容") @RequestParam String diagnosticResultContent,
            @Parameter(description = "诊断结果图片") @RequestParam String diagnosticResultPhoto,
            @Parameter(description = "诊断结果视频") @RequestParam String diagnosticResultVideo)
            throws UnsupportedEncodingException {
        return diagnosticResultService.addDiagnosticResult(
                URLDecoder.decode(diagnosticResultContent, Constants.UTF8),
                URLDecoder.decode(diagnosticResultPhoto, Constants.UTF8),
                URLDecoder.decode(diagnosticResultVideo, Constants.UTF8));
    }

    @Operation(summary = "更改诊断结果信息接口")
    @PutMapping(value = "/update")
    public JSONObject updateDiagnosticResult(
            @Parameter(description = "诊断结果Id") @RequestParam int diagnosticResultId,
            @Parameter(description = "诊断结果内容") @RequestParam String diagnosticResultContent,
            @Parameter(description = "诊断结果图片") @RequestParam String diagnosticResultPhoto,
            @Parameter(description = "诊断结果视频") @RequestParam String diagnosticResultVideo)

            throws UnsupportedEncodingException {
        return diagnosticResultService.updateDiagnosticResult(
                diagnosticResultId,
                URLDecoder.decode(diagnosticResultContent, Constants.UTF8),
                URLDecoder.decode(diagnosticResultPhoto, Constants.UTF8),
                URLDecoder.decode(diagnosticResultVideo, Constants.UTF8));
    }

    @Operation(summary = "删除诊断结果接口")
    @DeleteMapping(value = "/delete")
    public JSONObject deleteDiagnosticResult(@Parameter(description = "诊断结果Id") @RequestParam int diagnosticResultId) {
        return diagnosticResultService.deleteDiagnosticResult(diagnosticResultId);
    }
}


