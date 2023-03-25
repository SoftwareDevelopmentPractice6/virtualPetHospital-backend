/*
 * @Author: dafenqi-11 diaozehao@163.com
 * @Date: 2023-03-24 10:00:44
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-25 01:31:31
 * @FilePath: \virtualPetHospital-backend\system\src\main\java\pet\hospital\backend\system\controller\MedicineController.java
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
import pet.hospital.backend.system.service.MedicineService;

@RestController
@Tag(name = "System模块")
@RequestMapping(
        value = "/api/system/medicine",
        produces = {"application/json;charset=UTF-8"})
public class MedicineController {
    @Autowired
    MedicineService medicineService;

    @Operation(summary = "获取药品信息接口")
    @GetMapping(value = "/get")
    public JSONObject getMedicine(
            @Parameter(description = "药物名称") @RequestParam(required = false) String medicineName,
            @Parameter(description = "药物价格") @RequestParam(required = false) Double medicinePrice,
            @Parameter(description = "药物说明，支持模糊查询") @RequestParam(required = false) String manufacturer,
            @Parameter(description = "药物类别") @RequestParam(required = false) String medicineCategory,
            @Parameter(description = "药物规格，支持模糊查询") @RequestParam(required = false) String specification,
            @Parameter(description = "是否为疫苗0/1") @RequestParam(required = false) Integer isVaccine)
            throws UnsupportedEncodingException {
        return medicineService.getMedicine(
                medicineName, medicinePrice, manufacturer, medicineCategory, specification, isVaccine);
    }

    @Operation(summary = "新增药物接口")
    @PostMapping(value = "/add")
    public JSONObject addMedicine(
            @Parameter(description = "药物名称") @RequestParam String medicineName,
            @Parameter(description = "药物价格") @RequestParam double medicinePrice,
            @Parameter(description = "药物说明") @RequestParam String manufacturer,
            @Parameter(description = "药物类别") @RequestParam String medicineCategory,
            @Parameter(description = "药物规格") @RequestParam String specification,
            @Parameter(description = "是否为疫苗0/1") @RequestParam int isVaccine)
            throws UnsupportedEncodingException {
        return medicineService.addMedicine(
                URLDecoder.decode(medicineName, Constants.UTF8), medicinePrice,
                URLDecoder.decode(manufacturer, Constants.UTF8), URLDecoder.decode(medicineCategory, Constants.UTF8),
                URLDecoder.decode(specification, Constants.UTF8), isVaccine);
    }

    @Operation(summary = "更改药物接口")
    @PutMapping(value = "/update")
    public JSONObject updateMedicine(
            @Parameter(description = "药物Id") @RequestParam int medicineId,
            @Parameter(description = "药物名称") @RequestParam String medicineName,
            @Parameter(description = "药物价格") @RequestParam double medicinePrice,
            @Parameter(description = "药物说明") @RequestParam String manufacturer,
            @Parameter(description = "药物类别") @RequestParam String medicineCategory,
            @Parameter(description = "药物规格") @RequestParam String specification,
            @Parameter(description = "是否为疫苗0/1") @RequestParam int isVaccine)
            throws UnsupportedEncodingException {
        return medicineService.updateMedicine(
                medicineId,
                URLDecoder.decode(medicineName, Constants.UTF8),
                medicinePrice,
                URLDecoder.decode(manufacturer, Constants.UTF8),
                URLDecoder.decode(medicineCategory, Constants.UTF8),
                URLDecoder.decode(specification, Constants.UTF8),
                isVaccine);
    }

    @Operation(summary = "删除药物接口")
    @DeleteMapping(value = "/delete")
    public JSONObject deleteMedicine(@Parameter(description = "药物id") @RequestParam int medicineId)
            throws UnsupportedEncodingException {
        return medicineService.deleteMedicine(medicineId);
    }
}
