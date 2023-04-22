/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-04-22 22:12:19
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-04-22 23:30:17
 * @FilePath: /virtualPetHospital-backend/system/src/main/java/pet/hospital/backend/system/controller/GeneralController.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.system.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pet.hospital.backend.system.service.GeneralService;

@RestController
@Tag(name = "System模块")
@RequestMapping(
        value = "/api/system/sys",
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
