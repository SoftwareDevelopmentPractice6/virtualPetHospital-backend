package pet.hospital.backend.exam.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @GetMapping(value = "/get-by-content")
    public JSONObject getQuestionsByContent(
            @Parameter(description = "问题内容关键字，支持模糊查询") @RequestParam(required = false) String questionKeyword)
            throws UnsupportedEncodingException {
        return questionService.getQuestionsByContent(
                Objects.equals(questionKeyword, null) ? "" : URLDecoder.decode(questionKeyword, Constants.UTF8));
    }

    @Operation(summary = "获取问题接口")
    @GetMapping(value = "/get-by-type")
    public JSONObject getQuestionsByType(@Parameter(description = "问题种类") @RequestParam String questionType)
            throws UnsupportedEncodingException {
        return questionService.getQuestionsByType(URLDecoder.decode(questionType, Constants.UTF8));
    }

    @Operation(summary = "获取问题接口")
    @GetMapping(value = "/get-by-category-id")
    public JSONObject getQuestionsByCategoryId(@Parameter(description = "问题类别Id") @RequestParam int categoryId)
            throws UnsupportedEncodingException {
        return questionService.getQuestionsByCategoryId(categoryId);
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
            @Parameter(
                            description = "更改后的问题信息，json字符串",
                            required = true,
                            schema =
                                    @Schema(
                                            type = "string",
                                            format = "json-string",
                                            example =
                                                    "{\"questionId\": 2, \"questionContent\": \"testQuestion2\", \"questionType\": \"testType\", \"categoryId\": 2}"))
                    @RequestParam
                    String newQuestionInfo)
            throws UnsupportedEncodingException {
        return questionService.updateQuestion(JSON.parseObject(URLDecoder.decode(newQuestionInfo, Constants.UTF8)));
    }

    @Operation(summary = "删除问题接口")
    @DeleteMapping(value = "/delete")
    public JSONObject deleteQuestion(@Parameter(description = "问题Id") @RequestParam int questionId) {
        return questionService.deleteQuestion(questionId);
    }
}
