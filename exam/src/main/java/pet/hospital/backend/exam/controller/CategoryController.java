/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-19 15:15:52
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-20 17:52:13
 * @FilePath: /virtualPetHospital-backend/exam/src/main/java/pet/hospital/backend/exam/controller/CategoryController.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.exam.controller;

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
import pet.hospital.backend.exam.service.CategoryService;

@RestController
@Tag(name = "Exam模块")
@RequestMapping(
        value = "/api/exam/category",
        produces = {"application/json;charset=UTF-8"})
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Operation(summary = "获取问题类别接口")
    @GetMapping(value = "/get")
    public JSONObject getCategories(
            @Parameter(description = "问题类别关键字，支持模糊查询") @RequestParam(required = false) String categoryKeyword)
            throws UnsupportedEncodingException {
        return categoryService.getCategories(categoryKeyword);
    }

    @Operation(summary = "新增问题类别接口")
    @PostMapping(value = "/add")
    public JSONObject addCategory(@Parameter(description = "问题类别名") @RequestParam String categoryName)
            throws UnsupportedEncodingException {
        return categoryService.addCategory(URLDecoder.decode(categoryName, Constants.UTF8));
    }

    @Operation(summary = "更改问题类别信息接口")
    @PutMapping(value = "/update")
    public JSONObject updateCategory(
            @Parameter(description = "问题类别Id") @RequestParam int categoryId,
            @Parameter(description = "问题类别名") @RequestParam String categoryName)
            throws UnsupportedEncodingException {
        return categoryService.updateCategory(categoryId, URLDecoder.decode(categoryName, Constants.UTF8));
    }

    @Operation(summary = "删除问题类别接口")
    @DeleteMapping(value = "/delete")
    public JSONObject deleteCategory(@Parameter(description = "问题类别Id") @RequestParam int categoryId) {
        return categoryService.deleteCategory(categoryId);
    }
}
