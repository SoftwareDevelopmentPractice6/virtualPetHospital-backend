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
import pet.hospital.backend.common.helper.DateHelper;
import pet.hospital.backend.system.service.FeatureService;

@RestController
@Tag(name = "System模块")
@RequestMapping(value = "/api/system/feature", produces = { "application/json;charset=UTF-8" })
public class FeatureController {
    @Autowired
    FeatureService featureService;

    @Operation(summary = "获取方法操作信息接口")
    @GetMapping(value = "/get")
    public JSONObject getFeature(
            @Parameter(description = "方法名") @RequestParam(required = false) String funcName,
            @Parameter(description = "方法描述") @RequestParam(required = false) String funcDescription,
            @Parameter(description = "方法流程") @RequestParam(required = false) String funcFlow,
            @Parameter(description = "操作人员") @RequestParam(required = false) String funcRole,
            @Parameter(description = "方法使用工具") @RequestParam(required = false) String funcTool,
            @Parameter(description = "对应科室名") @RequestParam(required = false) String roomName)
            throws UnsupportedEncodingException {
        return featureService.getFeature(funcName,
            funcDescription, funcFlow, funcRole, funcTool, roomName);
    }

    @Operation(summary = "新增方法操作接口")
    @PostMapping(value = "/add")
    public JSONObject addFeature(
            @Parameter(description = "方法名") @RequestParam String funcName,
            @Parameter(description = "方法描述") @RequestParam String funcDescription,
            @Parameter(description = "方法流程") @RequestParam String funcFlow,
            @Parameter(description = "操作人员") @RequestParam String funcRole,
            @Parameter(description = "方法使用工具") @RequestParam String funcTool,
            @Parameter(description = "对应科室名") @RequestParam String roomName)
            throws UnsupportedEncodingException {
        return featureService.addFeature(
                URLDecoder.decode(
                        funcName, Constants.UTF8),
                URLDecoder.decode(
                        funcDescription, Constants.UTF8),
                URLDecoder.decode(
                        funcFlow, Constants.UTF8),
                URLDecoder.decode(
                        funcRole, Constants.UTF8),URLDecoder.decode(
                        funcTool, Constants.UTF8),
                URLDecoder.decode(
                        roomName, Constants.UTF8));
    }

    @Operation(summary = "更改方法操作接口")
    @PutMapping(value = "/update")
    public JSONObject updateFeature(
            @Parameter(description = "方法操作Id") @RequestParam int featureId,
            @Parameter(description = "方法名") @RequestParam String funcName,
            @Parameter(description = "方法描述") @RequestParam String funcDescription,
            @Parameter(description = "方法流程") @RequestParam String funcFlow,
            @Parameter(description = "操作人员") @RequestParam String funcRole,
            @Parameter(description = "方法使用工具") @RequestParam String funcTool,
            @Parameter(description = "对应科室名") @RequestParam String roomName)
            throws UnsupportedEncodingException {
        return featureService.updateFeature(
                featureId,
                URLDecoder.decode(
                        funcName, Constants.UTF8),
                URLDecoder.decode(
                        funcDescription, Constants.UTF8),
                URLDecoder.decode(
                        funcFlow, Constants.UTF8),
                URLDecoder.decode(
                        funcRole, Constants.UTF8),
                URLDecoder.decode(
                        funcTool, Constants.UTF8),
                URLDecoder.decode(
                        roomName, Constants.UTF8));
    }

    @Operation(summary = "删除方法操作接口")
    @DeleteMapping(value = "/delete")
    public JSONObject deleteFeature(@Parameter(description = "方法操作id") @RequestParam int featureId)
            throws UnsupportedEncodingException {
        return featureService.deleteFeature(featureId);
    }
}