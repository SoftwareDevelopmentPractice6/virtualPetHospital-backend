/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-20 13:39:32
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-20 13:41:41
 * @FilePath: /virtualPetHospital-backend/exam/src/main/java/pet/hospital/backend/exam/controller/ExamController.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
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
import pet.hospital.backend.exam.service.ExamService;

@RestController
@Tag(name = "Exam模块")
@RequestMapping(
        value = "/api/exam/exam",
        produces = {"application/json;charset=UTF-8"})
public class ExamController {

    @Autowired
    ExamService examService;

    @Operation(summary = "获取考试信息接口")
    @GetMapping(value = "/get")
    public JSONObject getExams(
            @Parameter(description = "考试名称关键字，支持模糊查询") @RequestParam(required = false) String examKeyword)
            throws UnsupportedEncodingException {
        return examService.getExams(
                Objects.equals(examKeyword, null) ? "" : URLDecoder.decode(examKeyword, Constants.UTF8));
    }

    @Operation(summary = "新增考试接口")
    @PostMapping(value = "/add")
    public JSONObject addExam(@Parameter(description = "考试内容") @RequestParam String examName)
            throws UnsupportedEncodingException {
        return examService.addExam(URLDecoder.decode(examName, Constants.UTF8));
    }

    @Operation(summary = "更改考试信息接口")
    @PutMapping(value = "/update")
    public JSONObject updateExam(
            @Parameter(
                            description = "更改后的考试信息，json字符串",
                            required = true,
                            schema =
                                    @Schema(
                                            type = "string",
                                            format = "json-string",
                                            example = "{\"examId\": 2, \"examName\": \"testExam2\"}"))
                    @RequestParam
                    String newExamInfo)
            throws UnsupportedEncodingException {
        return examService.updateExam(JSON.parseObject(URLDecoder.decode(newExamInfo, Constants.UTF8)));
    }

    @Operation(summary = "删除考试接口")
    @DeleteMapping(value = "/delete")
    public JSONObject deleteExam(@Parameter(description = "考试Id") @RequestParam int examId) {
        return examService.deleteExam(examId);
    }
}
