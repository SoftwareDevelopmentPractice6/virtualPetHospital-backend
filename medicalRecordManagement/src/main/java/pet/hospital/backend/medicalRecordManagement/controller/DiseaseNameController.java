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
import pet.hospital.backend.medicalRecordManagement.service.DiseaseNameService;

@RestController
@Tag(name = "MedicalRecordManagement模块")
@RequestMapping(
        value = "/api/disease/disease-name",
        produces = {"application/json;charset=UTF-8"})
public class DiseaseNameController {
    @Autowired
    DiseaseNameService diseaseNameService;

    @Operation(summary = "获取疾病名称接口")
    @GetMapping(value = "/get")
    public JSONObject getDiseaseName(
            @Parameter(description = "疾病名称Id") @RequestParam(required = false) Integer diseaseNameId,
            @Parameter(description = "疾病名称内容关键字，支持模糊查询") @RequestParam(required = false) String diseaseNameKeyword,
            @Parameter(description = "疾病名称种类") @RequestParam(required = false) String diseaseNameCategory)
            throws UnsupportedEncodingException {
        return diseaseNameService.getDiseaseName(diseaseNameId, diseaseNameKeyword, diseaseNameCategory);
    }

    @Operation(summary = "新增疾病名称接口")
    @PostMapping(value = "/add")
    public JSONObject addDiseaseName(
            @Parameter(description = "疾病名称内容") @RequestParam String diseaseNameContent,
            @Parameter(description = "疾病名称图片") @RequestParam String diseaseNamePhoto,
            @Parameter(description = "疾病名称视频") @RequestParam String diseaseNameVideo,
            @Parameter(description = "疾病名称种类") @RequestParam String diseaseNameCategory)
            throws UnsupportedEncodingException {
        return diseaseNameService.addDiseaseName(
                URLDecoder.decode(diseaseNameContent, Constants.UTF8),
                URLDecoder.decode(diseaseNamePhoto, Constants.UTF8),
                URLDecoder.decode(diseaseNameVideo, Constants.UTF8),
                URLDecoder.decode(diseaseNameCategory, Constants.UTF8));
    }

    @Operation(summary = "更改疾病名称信息接口")
    @PutMapping(value = "/update")
    public JSONObject updateDiseaseName(
            @Parameter(description = "疾病名称Id") @RequestParam int diseaseNameId,
            @Parameter(description = "疾病名称内容") @RequestParam String diseaseNameContent,
            @Parameter(description = "疾病名称图片") @RequestParam String diseaseNamePhoto,
            @Parameter(description = "疾病名称视频") @RequestParam String diseaseNameVideo,
            @Parameter(description = "疾病名称种类") @RequestParam String diseaseNameCategory)
            throws UnsupportedEncodingException {
        return diseaseNameService.updateDiseaseName(
                diseaseNameId,
                URLDecoder.decode(diseaseNameContent, Constants.UTF8),
                URLDecoder.decode(diseaseNamePhoto, Constants.UTF8),
                URLDecoder.decode(diseaseNameVideo, Constants.UTF8),
                URLDecoder.decode(diseaseNameCategory, Constants.UTF8));
    }

    @Operation(summary = "删除疾病名称接口")
    @DeleteMapping(value = "/delete")
    public JSONObject deleteDiseaseName(@Parameter(description = "疾病名称Id") @RequestParam int diseaseNameId) {
        return diseaseNameService.deleteDiseaseName(diseaseNameId);
    }
}
