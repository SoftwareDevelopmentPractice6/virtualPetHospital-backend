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
import pet.hospital.backend.exam.service.StudentResultService;

@RestController
@Tag(name = "Exam模块")
@RequestMapping(
        value = "/api/exam/student-result",
        produces = {"application/json;charset=UTF-8"})
public class StudentResultController {

    @Autowired
    StudentResultService studentResultService;

    @Operation(summary = "获取学生考试结果接口")
    @GetMapping(value = "/get")
    public JSONObject getStudentResults(
            @Parameter(description = "学生Id") @RequestParam(required = false) Integer studentResultStudentId,
            @Parameter(description = "学生考试成绩") @RequestParam(required = false) Integer studentResultScore,
            @Parameter(description = "学生对应考试信息Id") @RequestParam(required = false) Integer examSessionId)
            throws UnsupportedEncodingException {
        return studentResultService.getStudentResults(studentResultStudentId, studentResultScore, examSessionId);
    }

    @Operation(summary = "新增学生考试结果接口")
    @PostMapping(value = "/add")
    public JSONObject addStudentResult(
            @Parameter(description = "学生Id") @RequestParam int studentResultStudentId,
            @Parameter(description = "学生考试成绩") @RequestParam int studentResultScore,
            @Parameter(description = "学生对应考试信息Id") @RequestParam int examSessionId)
            throws UnsupportedEncodingException {
        return studentResultService.addStudentResult(studentResultStudentId, studentResultScore, examSessionId);
    }

    @Operation(summary = "更改学生考试结果信息接口")
    @PutMapping(value = "/update")
    public JSONObject updateStudentResult(
            @Parameter(description = "学生考试结果Id") @RequestParam int studentResultId,
            @Parameter(description = "学生Id") @RequestParam int studentResultStudentId,
            @Parameter(description = "学生考试成绩") @RequestParam int studentResultScore,
            @Parameter(description = "学生对应考试信息Id") @RequestParam int examSessionId)
            throws UnsupportedEncodingException {
        return studentResultService.updateStudentResult(
                studentResultId, studentResultStudentId, studentResultScore, examSessionId);
    }

    @Operation(summary = "删除学生考试结果接口")
    @DeleteMapping(value = "/delete")
    public JSONObject deleteStudentResult(@Parameter(description = "学生考试结果Id") @RequestParam int studentResultId) {
        return studentResultService.deleteStudentResult(studentResultId);
    }
}
