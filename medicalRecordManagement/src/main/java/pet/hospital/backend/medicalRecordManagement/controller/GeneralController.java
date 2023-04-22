package pet.hospital.backend.medicalRecordManagement.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pet.hospital.backend.medicalRecordManagement.service.GeneralService;

@RestController
@Tag(name = "MedicalRecordManagement模块")
@RequestMapping(
        value = "/api/disease/sys",
        produces = {"application/json;charset=UTF-8"})
public class GeneralController {
    @Autowired
    private GeneralService generalService;

    @Operation(summary = "根据Id获取数据接口")
    @GetMapping(value = "/{tableName}/{id}")
    public JSONObject getDataById(
            @Parameter(description = "表名") @PathVariable String tableName,
            @Parameter(description = "id") @PathVariable int id)
            throws Exception {
        return generalService.getDataById(tableName, id);
    }
}
