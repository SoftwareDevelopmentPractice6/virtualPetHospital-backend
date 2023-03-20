/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-20 14:28:06
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-20 15:18:46
 * @FilePath: /virtualPetHospital-backend/exam/src/main/java/pet/hospital/backend/exam/controller/ExamSessionController.java
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import pet.hospital.backend.exam.service.ExamSessionService;
import pet.hospital.backend.common.helper.DateHelper;

@RestController
@Tag(name = "Exam模块")
@RequestMapping(
        value = "/api/exam/exam-session",
        produces = {"application/json;charset=UTF-8"})
public class ExamSessionController {
    
    @Autowired
    ExamSessionService examSessionService;

    @Operation(summary = "获取考试具体信息接口")
    @GetMapping(value = "/get")
    public JSONObject getExamSessions(
            @Parameter(description = "考试具体信息开始时间") @RequestParam(required = false) String examSessionStartTime,
            @Parameter(description = "考试具体信息结束时间") @RequestParam(required = false) String examSessionEndTime,
            @Parameter(description = "考试具体信息对应试卷Id") @RequestParam(required = false) Integer paperId)
            throws UnsupportedEncodingException {
                return examSessionService.getExamSessions(DateHelper.stringToDate(examSessionStartTime), DateHelper.stringToDate(examSessionEndTime), paperId);
    }

    @Operation(summary = "新增考试具体信息接口")
    @PostMapping(value = "/add")
    public JSONObject addExamSession(
        @Parameter(description = "考试具体信息开始时间") @RequestParam String examSessionStartTime,
        @Parameter(description = "考试具体信息结束时间") @RequestParam String examSessionEndTime,
        @Parameter(description = "考试具体信息对应试卷Id") @RequestParam int paperId)
            throws UnsupportedEncodingException {
        return examSessionService.addExamSession(
            DateHelper.stringToDate(examSessionStartTime), DateHelper.stringToDate(examSessionEndTime), paperId);
    }

    @Operation(summary = "更改考试具体信息接口")
    @PutMapping(value = "/update")
    public JSONObject updateExamSession(
            @Parameter(
                            description = "更改后的考试具体信息，json字符串",
                            required = true,
                            schema =
                                    @Schema(
                                            type = "string",
                                            format = "json-string",
                                            example =
                                                    "{\"examSessionId\": 2, \"examSessionStartTime\": \"2023-03-16 10:00:00\", \"examSessionEndTime\": \"2023-03-16 15:00:00\", \"paperId\": 2}"))
                    @RequestParam
                    String newExamSessionInfo)
            throws UnsupportedEncodingException {
        return examSessionService.updateExamSession(JSON.parseObject(URLDecoder.decode(newExamSessionInfo, Constants.UTF8)));
    }

    @Operation(summary = "删除考试具体信息接口")
    @DeleteMapping(value = "/delete")
    public JSONObject deleteExamSession(@Parameter(description = "考试具体信息Id") @RequestParam int examSessionId) {
        return examSessionService.deleteExamSession(examSessionId);
    }
}
