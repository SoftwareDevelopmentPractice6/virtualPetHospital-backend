/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-28 19:04:37
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-28 19:05:01
 * @FilePath: /virtualPetHospital-backend/medicalRecordManagement/src/main/java/pet/hospital/backend/medicalRecordManagement/controller/AdmissionController.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
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
import pet.hospital.backend.medicalRecordManagement.service.AdmissionService;

@RestController
@Tag(name = "MedicalRecordManagement模块")
@RequestMapping(
        value = "/api/disease/admission",
        produces = {"application/json;charset=UTF-8"})
public class AdmissionController {
    @Autowired
    private AdmissionService admissionService;

    @Operation(summary = "获取接诊接口")
    @GetMapping(value = "/get")
    public JSONObject getAdmission(
            @Parameter(description = "接诊Id") @RequestParam(required = false) Integer admissionId,
            @Parameter(description = "接诊内容关键字，支持模糊查询") @RequestParam(required = false) String admissionKeyword)
            throws UnsupportedEncodingException {
        return admissionService.getAdmission(admissionId, admissionKeyword);
    }

    @Operation(summary = "新增接诊接口")
    @PostMapping(value = "/add")
    public JSONObject addAdmission(
            @Parameter(description = "接诊内容") @RequestParam String admissionContent,
            @Parameter(description = "接诊图片") @RequestParam String admissionPhoto,
            @Parameter(description = "接诊视频") @RequestParam String admissionVideo)
            throws UnsupportedEncodingException {
        return admissionService.addAdmission(
                URLDecoder.decode(admissionContent, Constants.UTF8),
                URLDecoder.decode(admissionPhoto, Constants.UTF8),
                URLDecoder.decode(admissionVideo, Constants.UTF8));
    }

    @Operation(summary = "更改接诊信息接口")
    @PutMapping(value = "/update")
    public JSONObject updateAdmission(
            @Parameter(description = "接诊Id") @RequestParam int admissionId,
            @Parameter(description = "接诊内容") @RequestParam String admissionContent,
            @Parameter(description = "接诊图片") @RequestParam String admissionPhoto,
            @Parameter(description = "接诊视频") @RequestParam String admissionVideo)
            throws UnsupportedEncodingException {
        return admissionService.updateAdmission(
                admissionId,
                URLDecoder.decode(admissionContent, Constants.UTF8),
                URLDecoder.decode(admissionPhoto, Constants.UTF8),
                URLDecoder.decode(admissionVideo, Constants.UTF8));
    }

    @Operation(summary = "删除接诊接口")
    @DeleteMapping(value = "/delete")
    public JSONObject deleteAdmission(@Parameter(description = "接诊Id") @RequestParam int admissionId) {
        return admissionService.deleteAdmission(admissionId);
    }
}
