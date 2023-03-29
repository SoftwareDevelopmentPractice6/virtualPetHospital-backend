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
import pet.hospital.backend.medicalRecordManagement.service.CaseCheckService;

@RestController
@Tag(name = "MedicalRecordManagement模块")
@RequestMapping(
        value = "/api/disease/case-check",
        produces = {"application/json;charset=UTF-8"})
public class CaseCheckController {
    @Autowired
    CaseCheckService caseCheckService;

    @Operation(summary = "获取病例检查接口")
    @GetMapping(value = "/get")
    public JSONObject getCaseCheck(
            @Parameter(description = "病例检查Id") @RequestParam(required = false) Integer caseCheckId,
            @Parameter(description = "病例检查内容关键字，支持模糊查询") @RequestParam(required = false) String caseCheckKeyword)
            throws UnsupportedEncodingException {
        return caseCheckService.getCaseCheck(caseCheckId, caseCheckKeyword);
    }

    @Operation(summary = "新增病例检查接口")
    @PostMapping(value = "/add")
    public JSONObject addCaseCheck(
            @Parameter(description = "病例检查内容") @RequestParam String caseCheckContent,
            @Parameter(description = "病例检查图片") @RequestParam String caseCheckPhoto,
            @Parameter(description = "病例检查视频") @RequestParam String caseCheckVideo)
            throws UnsupportedEncodingException {
        return caseCheckService.addCaseCheck(
                URLDecoder.decode(caseCheckContent, Constants.UTF8),
                URLDecoder.decode(caseCheckPhoto, Constants.UTF8),
                URLDecoder.decode(caseCheckVideo, Constants.UTF8));
    }

    @Operation(summary = "更改病例检查信息接口")
    @PutMapping(value = "/update")
    public JSONObject updateCaseCheck(
            @Parameter(description = "病例检查Id") @RequestParam int caseCheckId,
            @Parameter(description = "病例检查内容") @RequestParam String caseCheckContent,
            @Parameter(description = "病例检查图片") @RequestParam String caseCheckPhoto,
            @Parameter(description = "病例检查视频") @RequestParam String caseCheckVideo)
            throws UnsupportedEncodingException {
        return caseCheckService.updateCaseCheck(
                caseCheckId,
                URLDecoder.decode(caseCheckContent, Constants.UTF8),
                URLDecoder.decode(caseCheckPhoto, Constants.UTF8),
                URLDecoder.decode(caseCheckVideo, Constants.UTF8));
    }

    @Operation(summary = "删除病例检查接口")
    @DeleteMapping(value = "/delete")
    public JSONObject deleteCaseCheck(@Parameter(description = "病例检查Id") @RequestParam int caseCheckId) {
        return caseCheckService.deleteCaseCheck(caseCheckId);
    }
}
