/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-25 00:06:06
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-25 16:57:53
 * @FilePath: /virtualPetHospital-backend/system/src/main/java/pet/hospital/backend/system/controller/FeatureController.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
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
import pet.hospital.backend.system.service.FeatureService;

@RestController
@Tag(name = "System模块")
@RequestMapping(
        value = "/api/system/feature",
        produces = {"application/json;charset=UTF-8"})
public class FeatureController {
    @Autowired
    private FeatureService featureService;

    @Operation(summary = "获取具体功能操作信息接口")
    @GetMapping(value = "/get")
    public JSONObject getFeature(
            @Parameter(description = "具体功能Id") @RequestParam(required = false) Integer funcId,
            @Parameter(description = "具体功能名") @RequestParam(required = false) String funcName,
            @Parameter(description = "具体功能描述，支持模糊查询") @RequestParam(required = false) String funcDescription,
            @Parameter(description = "具体功能流程，支持模糊查询") @RequestParam(required = false) String funcFlow,
            @Parameter(description = "操作人员，NRAD顺序表示无权限、前台、医助、医师") @RequestParam(required = false) String funcRole,
            @Parameter(description = "具体功能使用工具") @RequestParam(required = false) String funcTool,
            @Parameter(description = "对应科室名") @RequestParam(required = false) String roomName)
            throws UnsupportedEncodingException {
        return featureService.getFeature(funcId, funcName, funcDescription, funcFlow, funcRole, funcTool, roomName);
    }

    @Operation(summary = "新增具体功能操作接口")
    @PostMapping(value = "/add")
    public JSONObject addFeature(
            @Parameter(description = "具体功能名") @RequestParam String funcName,
            @Parameter(description = "具体功能描述") @RequestParam String funcDescription,
            @Parameter(description = "具体功能流程") @RequestParam String funcFlow,
            @Parameter(description = "具体功能视频对应存储地址") @RequestParam String funcVideo,
            @Parameter(description = "操作人员，NRAD顺序表示无权限、前台、医助、医师") @RequestParam String funcRole,
            @Parameter(description = "具体功能使用工具") @RequestParam String funcTool,
            @Parameter(description = "对应科室名") @RequestParam String roomName)
            throws UnsupportedEncodingException {
        return featureService.addFeature(
                URLDecoder.decode(funcName, Constants.UTF8),
                URLDecoder.decode(funcDescription, Constants.UTF8),
                URLDecoder.decode(funcFlow, Constants.UTF8),
                URLDecoder.decode(funcVideo, Constants.UTF8),
                URLDecoder.decode(funcRole, Constants.UTF8),
                URLDecoder.decode(funcTool, Constants.UTF8),
                URLDecoder.decode(roomName, Constants.UTF8));
    }

    @Operation(summary = "更改具体功能操作接口")
    @PutMapping(value = "/update")
    public JSONObject updateFeature(
            @Parameter(description = "具体功能操作Id") @RequestParam int funcId,
            @Parameter(description = "具体功能名") @RequestParam String funcName,
            @Parameter(description = "具体功能描述") @RequestParam String funcDescription,
            @Parameter(description = "具体功能流程") @RequestParam String funcFlow,
            @Parameter(description = "具体功能视频对应存储地址") @RequestParam String funcVideo,
            @Parameter(description = "操作人员") @RequestParam String funcRole,
            @Parameter(description = "具体功能使用工具") @RequestParam String funcTool,
            @Parameter(description = "对应科室名") @RequestParam String roomName)
            throws UnsupportedEncodingException {
        return featureService.updateFeature(
                funcId,
                URLDecoder.decode(funcName, Constants.UTF8),
                URLDecoder.decode(funcDescription, Constants.UTF8),
                URLDecoder.decode(funcFlow, Constants.UTF8),
                URLDecoder.decode(funcVideo, Constants.UTF8),
                URLDecoder.decode(funcRole, Constants.UTF8),
                URLDecoder.decode(funcTool, Constants.UTF8),
                URLDecoder.decode(roomName, Constants.UTF8));
    }

    @Operation(summary = "删除具体功能操作接口")
    @DeleteMapping(value = "/delete")
    public JSONObject deleteFeature(@Parameter(description = "具体功能操作id") @RequestParam int funcId)
            throws UnsupportedEncodingException {
        return featureService.deleteFeature(funcId);
    }
}
