/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-14 22:39:34
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-14 23:33:06
 * @FilePath: /virtualPetHospital-backend/swagger/src/main/java/pet/hospital/backend/swagger/controller/TestController.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.swagger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Swagger模块")
@RequestMapping(value = "/api/swagger", produces = { "application/json;charset=UTF-8" })
public class TestController {
    
    @ApiOperation(value = "Swagger测试用接口")
    @ApiImplicitParam(name = "status", value = "测试返回消息判断", required = true, dataType = "Boolean")
    @GetMapping(value = "/test/{status}")
    public String swaggerTestAPI (@PathVariable (value = "status") Boolean status) {
        return status ? "Swagger Message: Swagger test returns message \"Success!\"." : "Swagger Message: Swagger test returns message \"Failure!\".";
    }
}
