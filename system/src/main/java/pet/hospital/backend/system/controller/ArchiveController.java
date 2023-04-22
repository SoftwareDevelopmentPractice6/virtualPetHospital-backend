/*
 * @Author: dafenqi-11 diaozehao@163.com
 * @Date: 2023-03-24 20:36:28
 * @LastEditors: dafenqi-11 diaozehao@163.com
 * @LastEditTime: 2023-03-24 21:46:35
 * @FilePath: \virtualPetHospital-backend\system\src\main\java\pet\hospital\backend\system\controller\ArchiveController.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/*
 * @Author: dafenqi-11 diaozehao@163.com
 * @Date: 2023-03-24 20:36:28
 * @LastEditors: dafenqi-11 diaozehao@163.com
 * @LastEditTime: 2023-03-24 20:56:00
 * @FilePath: \virtualPetHospital-backend\system\src\main\java\pet\hospital\backend\system\controller\ArchiveController.java
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
import pet.hospital.backend.common.helper.DateHelper;
import pet.hospital.backend.system.service.ArchiveService;

@RestController
@Tag(name = "System模块")
@RequestMapping(
        value = "/api/system/archive",
        produces = {"application/json;charset=UTF-8"})
public class ArchiveController {
    @Autowired
    private ArchiveService archiveService;

    @Operation(summary = "获取档案信息接口")
    @GetMapping(value = "/get")
    public JSONObject getArchive(
            @Parameter(description = "记录时间") @RequestParam(required = false) String storeTime,
            @Parameter(description = "疾病类型") @RequestParam(required = false) String diseaseType,
            @Parameter(description = "宠物类型") @RequestParam(required = false) String petType,
            @Parameter(description = "宠物名字") @RequestParam(required = false) String petName,
            @Parameter(description = "宠物性别") @RequestParam(required = false) Character petSex,
            @Parameter(description = "主人联系电话") @RequestParam(required = false) String ownerTel)
            throws UnsupportedEncodingException {
        return archiveService.getArchive(
                DateHelper.stringToDate(storeTime), diseaseType, petType, petName, petSex, ownerTel);
    }

    @Operation(summary = "新增档案接口")
    @PostMapping(value = "/add")
    public JSONObject addArchive(
            @Parameter(description = "记录时间") @RequestParam String storeTime,
            @Parameter(description = "疾病类型") @RequestParam String diseaseType,
            @Parameter(description = "宠物类型") @RequestParam String petType,
            @Parameter(description = "宠物名字") @RequestParam String petName,
            @Parameter(description = "宠物性别") @RequestParam char petSex,
            @Parameter(description = "主人联系电话") @RequestParam String ownerTel)
            throws UnsupportedEncodingException {
        return archiveService.addArchive(
                DateHelper.stringToDate(storeTime),
                URLDecoder.decode(diseaseType, Constants.UTF8),
                URLDecoder.decode(petType, Constants.UTF8),
                URLDecoder.decode(petName, Constants.UTF8),
                petSex,
                URLDecoder.decode(ownerTel, Constants.UTF8));
    }

    @Operation(summary = "更改档案接口")
    @PutMapping(value = "/update")
    public JSONObject updateArchive(
            @Parameter(description = "档案Id") @RequestParam int archiveId,
            @Parameter(description = "记录时间") @RequestParam String storeTime,
            @Parameter(description = "疾病类型") @RequestParam String diseaseType,
            @Parameter(description = "宠物类型") @RequestParam String petType,
            @Parameter(description = "宠物名字") @RequestParam String petName,
            @Parameter(description = "宠物性别") @RequestParam char petSex,
            @Parameter(description = "主人联系电话") @RequestParam String ownerTel)
            throws UnsupportedEncodingException {
        return archiveService.updateArchive(
                archiveId,
                DateHelper.stringToDate(storeTime),
                URLDecoder.decode(diseaseType, Constants.UTF8),
                URLDecoder.decode(petType, Constants.UTF8),
                URLDecoder.decode(petName, Constants.UTF8),
                petSex,
                URLDecoder.decode(ownerTel, Constants.UTF8));
    }

    @Operation(summary = "删除档案接口")
    @DeleteMapping(value = "/delete")
    public JSONObject deleteArchive(@Parameter(description = "档案id") @RequestParam int archiveId)
            throws UnsupportedEncodingException {
        return archiveService.deleteArchive(archiveId);
    }
}
