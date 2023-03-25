/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-23 17:00:43
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-23 17:07:22
 * @FilePath: /virtualPetHospital-backend/exam/src/main/java/pet/hospital/backend/exam/controller/QuesionInPaperController.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.exam.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.io.UnsupportedEncodingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pet.hospital.backend.exam.service.QuestionInPaperService;

@RestController
@Tag(name = "Exam模块")
@RequestMapping(
        value = "/api/exam/question-in-paper",
        produces = {"application/json;charset=UTF-8"})
public class QuestionInPaperController {

    @Autowired
    QuestionInPaperService questionInPaperService;

    @Operation(summary = "获取试卷中问题接口")
    @GetMapping(value = "/get")
    public JSONObject getQuestionInPapers(
            @Parameter(description = "试卷中问题分数") @RequestParam(required = false) Integer questionPoint,
            @Parameter(description = "试卷Id") @RequestParam(required = false) Integer paperId,
            @Parameter(description = "问题Id") @RequestParam(required = false) Integer questionId)
            throws UnsupportedEncodingException {
        return questionInPaperService.getQuestionInPapers(questionPoint, paperId, questionId);
    }

    @Operation(summary = "新增试卷中问题接口")
    @PostMapping(value = "/add")
    public JSONObject addQuestionInPaper(
            @Parameter(description = "试卷中问题分数") @RequestParam int questionPoint,
            @Parameter(description = "试卷Id") @RequestParam int paperId,
            @Parameter(description = "问题Id") @RequestParam int questionId)
            throws UnsupportedEncodingException {
        return questionInPaperService.addQuestionInPaper(questionPoint, paperId, questionId);
    }

    @Operation(summary = "更改试卷中问题信息接口")
    @PutMapping(value = "/update")
    public JSONObject updateQuestionInPaper(
            @Parameter(description = "试卷中问题Id") @RequestParam int questionInPaperId,
            @Parameter(description = "试卷中问题分数") @RequestParam int questionPoint,
            @Parameter(description = "试卷Id") @RequestParam int paperId,
            @Parameter(description = "问题Id") @RequestParam int questionId)
            throws UnsupportedEncodingException {
        return questionInPaperService.updateQuestionInPaper(questionInPaperId, questionPoint, paperId, questionId);
    }

    @Operation(summary = "删除试卷中问题接口")
    @DeleteMapping(value = "/delete")
    public JSONObject deleteQuestionInPaper(@Parameter(description = "试卷中问题Id") @RequestParam int questionInPaperId) {
        return questionInPaperService.deleteQuestionInPaper(questionInPaperId);
    }
}
