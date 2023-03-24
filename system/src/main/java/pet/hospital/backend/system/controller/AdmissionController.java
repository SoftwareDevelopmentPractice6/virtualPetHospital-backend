package pet.hospital.backend.system.controller;

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
import pet.hospital.backend.system.service.AdmissionService;

@RestController
@Tag(name = "System模块")
@RequestMapping(
        value = "/api/system/admission",
        produces = {"application/json;charset=UTF-8"})
public class AdmissionController {
    @Autowired
    AdmissionService admissionService;

    @Operation(summary = "获取住院信息接口")
    @GetMapping(value = "/get")
    public JSONObject getAdmission(
            @Parameter(description = "房间标准") @RequestParam(required = false) String roomStandard,
            @Parameter(description = "互理级别") @RequestParam(required = false) String careLevel,
            @Parameter(description = "备注，支持模糊查询") @RequestParam(required = false) String remark,
            @Parameter(description = "住院价格") @RequestParam(required = false) Double carePrice)
            throws UnsupportedEncodingException {
        return admissionService.getAdmission(roomStandard, careLevel, remark, carePrice);
    }

    @Operation(summary = "新增住院接口")
    @PostMapping(value = "/add")
    public JSONObject addAdmission(
            @Parameter(description = "房间标准") @RequestParam String roomStandard,
            @Parameter(description = "互理级别") @RequestParam String careLevel,
            @Parameter(description = "备注") @RequestParam String remark,
            @Parameter(description = "住院价格") @RequestParam double carePrice)
            throws UnsupportedEncodingException {
        return admissionService.addAdmission(
                URLDecoder.decode(roomStandard, Constants.UTF8),
                URLDecoder.decode(careLevel, Constants.UTF8),
                URLDecoder.decode(remark, Constants.UTF8),
                carePrice);
    }

    @Operation(summary = "更改住院接口")
    @PutMapping(value = "/update")
    public JSONObject updateAdmission(
            @Parameter(description = "住院Id") @RequestParam int admissionId,
            @Parameter(description = "房间标准") @RequestParam String roomStandard,
            @Parameter(description = "互理级别") @RequestParam String careLevel,
            @Parameter(description = "备注") @RequestParam String remark,
            @Parameter(description = "住院价格") @RequestParam double carePrice)
            throws UnsupportedEncodingException {
        return admissionService.updateAdmission(
                admissionId,
                URLDecoder.decode(roomStandard, Constants.UTF8),
                URLDecoder.decode(careLevel, Constants.UTF8),
                URLDecoder.decode(remark, Constants.UTF8),
                carePrice);
    }

    @Operation(summary = "删除住院接口")
    @DeleteMapping(value = "/delete")
    public JSONObject deleteAdmission(@Parameter(description = "住院id") @RequestParam int admissionId)
            throws UnsupportedEncodingException {
        return admissionService.deleteAdmission(admissionId);
    }
}
