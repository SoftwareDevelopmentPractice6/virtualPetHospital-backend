/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-19 20:34:15
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-20 16:28:25
 * @FilePath: /virtualPetHospital-backend/exam/src/main/java/pet/hospital/backend/exam/controller/QuestionController.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.exam.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pet.hospital.backend.common.constant.Constants;
import pet.hospital.backend.exam.service.QuestionService;

@RestController
@Tag(name = "Exam模块")
@RequestMapping(
        value = "/api/exam/question",
        produces = {"application/json;charset=UTF-8"})
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Operation(summary = "获取问题接口")
    @GetMapping(value = "/get")
    public JSONObject getQuestions(
            @Parameter(description = "问题内容关键字，支持模糊查询") @RequestParam(required = false) String questionKeyword,
            @Parameter(description = "问题种类") @RequestParam(required = false) String questionType,
            @Parameter(description = "问题类别Id") @RequestParam(required = false) Integer categoryId)
            throws UnsupportedEncodingException {
        return questionService.getQuestions(
                Objects.equals(questionKeyword, null) ? "" : URLDecoder.decode(questionKeyword, Constants.UTF8),
                Objects.equals(questionType, null) ? "" : URLDecoder.decode(questionType, Constants.UTF8),
                categoryId);
    }

    @Operation(summary = "新增问题接口")
    @PostMapping(value = "/add")
    public JSONObject addQuestion(
            @Parameter(description = "问题内容") @RequestParam String questionContent,
            @Parameter(description = "问题种类") @RequestParam String questionType,
            @Parameter(description = "问题类别Id") @RequestParam int categoryId)
            throws UnsupportedEncodingException {
        return questionService.addQuestion(
                URLDecoder.decode(questionContent, Constants.UTF8),
                URLDecoder.decode(questionType, Constants.UTF8),
                categoryId);
    }

    @Operation(summary = "更改问题信息接口")
    @PutMapping(value = "/update")
    public JSONObject updateQuestion(
            @Parameter(description = "问题Id") @RequestParam int questionId,
            @Parameter(description = "问题内容") @RequestParam String questionContent,
            @Parameter(description = "问题种类") @RequestParam String questionType,
            @Parameter(description = "问题类别Id") @RequestParam int categoryId)
            throws UnsupportedEncodingException {
        return questionService.updateQuestion(
                questionId,
                URLDecoder.decode(questionContent, Constants.UTF8),
                URLDecoder.decode(questionType, Constants.UTF8),
                categoryId);
    }

    @Operation(summary = "删除问题接口")
    @DeleteMapping(value = "/delete")
    public JSONObject deleteQuestion(@Parameter(description = "问题Id") @RequestParam int questionId) {
        return questionService.deleteQuestion(questionId);
    }
}
