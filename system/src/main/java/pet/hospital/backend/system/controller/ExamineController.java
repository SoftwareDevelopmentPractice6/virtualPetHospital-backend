/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-25 00:06:06
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-04-22 21:33:05
 * @FilePath: /virtualPetHospital-backend/system/src/main/java/pet/hospital/backend/system/controller/ExamineController.java
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
import pet.hospital.backend.system.service.ExamineService;

@RestController
@Tag(name = "System模块")
@RequestMapping(
        value = "/api/system/examine",
        produces = {"application/json;charset=UTF-8"})
public class ExamineController {
    @Autowired
    private ExamineService examineService;

    @Operation(summary = "获取化验信息接口")
    @GetMapping(value = "/get")
    public JSONObject getExamine(
            @Parameter(description = "化验名称，支持模糊查询") @RequestParam(required = false) String examineName,
            @Parameter(description = "化验价格") @RequestParam(required = false) Double examinePrice,
            @Parameter(description = "科室名称") @RequestParam(required = false) String roomName)
            throws UnsupportedEncodingException {
        return examineService.getExamine(examineName, examinePrice, roomName);
    }

    @Operation(summary = "新增化验接口")
    @PostMapping(value = "/add")
    public JSONObject addExamine(
            @Parameter(description = "化验名称") @RequestParam String examineName,
            @Parameter(description = "化验价格") @RequestParam double examinePrice,
            @Parameter(description = "科室名称") @RequestParam String roomName)
            throws UnsupportedEncodingException {
        return examineService.addExamine(
                URLDecoder.decode(examineName, Constants.UTF8),
                examinePrice,
                URLDecoder.decode(roomName, Constants.UTF8));
    }

    @Operation(summary = "更改化验接口")
    @PutMapping(value = "/update")
    public JSONObject updateExamine(
            @Parameter(description = "化验Id") @RequestParam int examineId,
            @Parameter(description = "化验名称") @RequestParam String examineName,
            @Parameter(description = "化验价格") @RequestParam double examinePrice,
            @Parameter(description = "科室名称") @RequestParam String roomName)
            throws UnsupportedEncodingException {
        return examineService.updateExamine(
                examineId,
                URLDecoder.decode(examineName, Constants.UTF8),
                examinePrice,
                URLDecoder.decode(roomName, Constants.UTF8));
    }

    @Operation(summary = "删除化验接口")
    @DeleteMapping(value = "/delete")
    public JSONObject deleteExamine(@Parameter(description = "化验id") @RequestParam int examineId)
            throws UnsupportedEncodingException {
        return examineService.deleteExamine(examineId);
    }
}
