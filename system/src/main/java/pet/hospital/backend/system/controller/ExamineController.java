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
    ExamineService examineService;

    @Operation(summary = "获取化验信息接口")
    @GetMapping(value = "/get")
    public JSONObject getExamine(
            @Parameter(description = "化验名称") @RequestParam(required = false) String examineName,
            @Parameter(description = "化验价格") @RequestParam(required = false) Double examinePrice)
            throws UnsupportedEncodingException {
        return examineService.getExamine(examineName, examinePrice);
    }

    @Operation(summary = "新增化验接口")
    @PostMapping(value = "/add")
    public JSONObject addExamine(
            @Parameter(description = "化验名称") @RequestParam String examineName,
            @Parameter(description = "化验价格") @RequestParam double examinePrice)
            throws UnsupportedEncodingException {
        return examineService.addExamine(URLDecoder.decode(examineName, Constants.UTF8), examinePrice);
    }

    @Operation(summary = "更改化验接口")
    @PutMapping(value = "/update")
    public JSONObject updateExamine(
            @Parameter(description = "化验Id") @RequestParam int examineId,
            @Parameter(description = "化验名称") @RequestParam String examineName,
            @Parameter(description = "化验价格") @RequestParam double examinePrice)
            throws UnsupportedEncodingException {
        return examineService.updateExamine(examineId, URLDecoder.decode(examineName, Constants.UTF8), examinePrice);
    }

    @Operation(summary = "删除化验接口")
    @DeleteMapping(value = "/delete")
    public JSONObject deleteExamine(@Parameter(description = "化验id") @RequestParam int examineId)
            throws UnsupportedEncodingException {
        return examineService.deleteExamine(examineId);
    }
}
