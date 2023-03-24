/*
 * @Author: dafenqi-11 diaozehao@163.com
 * @Date: 2023-03-24 13:18:17
 * @LastEditors: dafenqi-11 diaozehao@163.com
 * @LastEditTime: 2023-03-24 13:19:58
 * @FilePath: \virtualPetHospital-backend\system\src\main\java\pet\hospital\backend\system\controller\ChargeController.java
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
import pet.hospital.backend.system.service.ChargeService;

@RestController
@Tag(name = "System模块")
@RequestMapping(
        value = "/api/system/charge",
        produces = {"application/json;charset=UTF-8"})
public class ChargeController {
    @Autowired
    ChargeService chargeService;

    @Operation(summary = "获取收费信息接口")
    @GetMapping(value = "/get")
    public JSONObject getCharge(
            @Parameter(description = "收费名称") @RequestParam(required = false) String itemName,
            @Parameter(description = "收费价格") @RequestParam(required = false) Double chargePrice)
            throws UnsupportedEncodingException {
        return chargeService.getCharge(itemName, chargePrice);
    }

    @Operation(summary = "新增收费接口")
    @PostMapping(value = "/add")
    public JSONObject addCharge(
            @Parameter(description = "收费名称") @RequestParam String itemName,
            @Parameter(description = "收费价格") @RequestParam double chargePrice)
            throws UnsupportedEncodingException {
        return chargeService.addCharge(URLDecoder.decode(itemName, Constants.UTF8), chargePrice);
    }

    @Operation(summary = "更改收费接口")
    @PutMapping(value = "/update")
    public JSONObject updateCharge(
            @Parameter(description = "收费Id") @RequestParam int chargeId,
            @Parameter(description = "收费名称") @RequestParam String itemName,
            @Parameter(description = "收费价格") @RequestParam double chargePrice)
            throws UnsupportedEncodingException {
        return chargeService.updateCharge(chargeId, URLDecoder.decode(itemName, Constants.UTF8), chargePrice);
    }

    @Operation(summary = "删除收费接口")
    @DeleteMapping(value = "/delete")
    public JSONObject deleteCharge(@Parameter(description = "收费id") @RequestParam int chargeId)
            throws UnsupportedEncodingException {
        return chargeService.deleteCharge(chargeId);
    }
}
