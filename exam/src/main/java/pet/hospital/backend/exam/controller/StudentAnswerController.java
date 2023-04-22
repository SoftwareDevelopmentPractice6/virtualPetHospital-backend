/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-28 18:18:23
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-28 18:50:52
 * @FilePath: /virtualPetHospital-backend/exam/src/main/java/pet/hospital/backend/exam/controller/StudentAnswerController.java
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
import pet.hospital.backend.exam.service.StudentAnswerService;

@RestController
@Tag(name = "Exam模块")
@RequestMapping(
        value = "/api/exam/student-answer",
        produces = {"application/json;charset=UTF-8"})
public class StudentAnswerController {
    @Autowired
    private StudentAnswerService studentAnswerService;

    @Operation(summary = "获取学生单一问题作答信息接口")
    @GetMapping(value = "/get")
    public JSONObject getStudentAnswers(
            @Parameter(description = "学生该问题作答内容") @RequestParam(required = false) String studentAnswerKeyword,
            @Parameter(description = "学生该问题得分") @RequestParam(required = false) Integer studentAnswerPoint,
            @Parameter(description = "试卷中问题Id") @RequestParam(required = false) Integer questionInPaperId,
            @Parameter(description = "学生考试结果Id") @RequestParam(required = false) Integer studentResultId)
            throws UnsupportedEncodingException {
        return studentAnswerService.getStudentAnswers(
                studentAnswerKeyword, studentAnswerPoint, questionInPaperId, studentResultId);
    }

    @Operation(summary = "新增学生单一问题作答信息接口")
    @PostMapping(value = "/add")
    public JSONObject addStudentAnswer(
            @Parameter(description = "学生该问题作答内容") @RequestParam String studentAnswerContent,
            @Parameter(description = "学生该问题得分") @RequestParam int studentAnswerPoint,
            @Parameter(description = "试卷中问题Id") @RequestParam int questionInPaperId,
            @Parameter(description = "学生考试结果Id") @RequestParam int studentResultId)
            throws UnsupportedEncodingException {
        return studentAnswerService.addStudentAnswer(
                URLDecoder.decode(studentAnswerContent, Constants.UTF8),
                studentAnswerPoint,
                questionInPaperId,
                studentResultId);
    }

    @Operation(summary = "更改学生单一问题作答信息接口")
    @PutMapping(value = "/update")
    public JSONObject updateStudentAnswer(
            @Parameter(description = "学生单一问题作答信息Id") @RequestParam int studentAnswerId,
            @Parameter(description = "学生该问题作答内容") @RequestParam String studentAnswerContent,
            @Parameter(description = "学生该问题得分") @RequestParam int studentAnswerPoint,
            @Parameter(description = "试卷中问题Id") @RequestParam int questionInPaperId,
            @Parameter(description = "学生考试结果Id") @RequestParam int studentResultId)
            throws UnsupportedEncodingException {
        return studentAnswerService.updateStudentAnswer(
                studentAnswerId,
                URLDecoder.decode(studentAnswerContent, Constants.UTF8),
                studentAnswerPoint,
                questionInPaperId,
                studentResultId);
    }

    @Operation(summary = "删除学生单一问题作答信息接口")
    @DeleteMapping(value = "/delete")
    public JSONObject deleteStudentAnswer(@Parameter(description = "学生单一问题作答信息Id") @RequestParam int studentAnswerId) {
        return studentAnswerService.deleteStudentAnswer(studentAnswerId);
    }
}
