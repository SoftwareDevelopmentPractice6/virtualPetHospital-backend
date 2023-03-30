package pet.hospital.backend.intermediator.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pet.hospital.backend.intermediator.constant.Constants;
import pet.hospital.backend.intermediator.service.ExamService;

@RestController
@CrossOrigin
@Tag(name = "测验模块")
@RequestMapping(
        value = "/api/exam",
        produces = {"application/json;charset=UTF-8"})
public class ExamController {
    @Autowired
    private ExamService examService;

    @Hidden
    @Operation(summary = "新增考试接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"examName\":\"test new exam\",\"examId\":3},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PostMapping(value = "/exam")
    public ResponseEntity<JSONObject> addExam(
            @Parameter(
                            description = "新增的考试信息",
                            schema = @Schema(type = "json", example = "{\"examName\": \"test exam\"}"))
                    @RequestBody
                    JSONObject newExamInfo) {
        return examService.addExam(newExamInfo.getString(Constants.examName)).toResponseEntity();
    }

    @Hidden
    @Operation(summary = "更改考试信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"examName\":\"test exam\",\"examId\":2},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PutMapping(value = "/exam")
    public ResponseEntity<JSONObject> updateExam(
            @Parameter(
                            description = "更改后的考试信息",
                            schema = @Schema(type = "json", example = "{\"examId\": 2, \"examName\": \"test exam\"}"))
                    @RequestBody
                    JSONObject newExamInfo) {
        return examService
                .updateExam(newExamInfo.getInteger(Constants.examId), newExamInfo.getString(Constants.examName))
                .toResponseEntity();
    }

    @Hidden
    @Operation(summary = "删除考试接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"examName\":\"test new exam\",\"examId\":3},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @DeleteMapping(value = "/exam/{examId}")
    public ResponseEntity<JSONObject> deleteExam(@Parameter(description = "考试Id") @PathVariable int examId) {
        return examService.deleteExam(examId).toResponseEntity();
    }

    @Hidden
    @Operation(summary = "获取考试列表接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"examList\":[{\"examName\":\"Math Exam\",\"examId\":1},{\"examName\":\"ffff ffff\",\"examId\":2}]},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/exam/{examNameKeyword}")
    public ResponseEntity<JSONObject> getExamsByKeyword(
            @Parameter(description = "考试名关键字，支持模糊查询") @PathVariable String examNameKeyword) {
        return examService.getExams(examNameKeyword).toResponseEntity();
    }

    @Hidden
    @Operation(summary = "获取考试列表接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"examList\":[{\"examName\":\"Math Exam\",\"examId\":1},{\"examName\":\"ffff ffff\",\"examId\":2}]},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/exam")
    public ResponseEntity<JSONObject> getExams() {
        return examService.getExams(null).toResponseEntity();
    }

    @Hidden
    @Operation(summary = "新增考卷接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"paperDuration\":\"tttt hours\",\"paperTotalScore\":\"tttt score\",\"paperExam\":{\"examName\":\"ffff ffff\",\"examId\":2},\"paperName\":\"test new paper\",\"paperId\":2},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PostMapping(value = "/paper")
    public ResponseEntity<JSONObject> addPaper(
            @Parameter(
                            description = "新增的考卷信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example =
                                                    "{\"paperName\": \"testPaper\", \"paperDuration\": \"tttt hours\", \"paperTotalScore\": \"tttt score\", \"examId\": 2}"))
                    @RequestBody
                    JSONObject newPaperInfo) {
        return examService
                .addPaper(
                        newPaperInfo.getString(Constants.paperName),
                        newPaperInfo.getString(Constants.paperDuration),
                        newPaperInfo.getString(Constants.paperTotalScore),
                        newPaperInfo.getInteger(Constants.examId))
                .toResponseEntity();
    }

    @Hidden
    @Operation(summary = "更改考卷信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"paperDuration\":\"tttt hours\",\"paperTotalScore\":\"tttt score\",\"paperExam\":{\"examName\":\"Math Exam\",\"examId\":1},\"paperName\":\"testPaper\",\"paperId\":1},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PutMapping(value = "/paper")
    public ResponseEntity<JSONObject> updatePaper(
            @Parameter(
                            description = "更改后的考卷信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example =
                                                    "{\"paperId\": 2, \"paperName\": \"testPaper\", \"paperDuration\": \"tttt hours\", \"paperTotalScore\": \"tttt score\", \"examId\": 2}"))
                    @RequestBody
                    JSONObject newPaperInfo) {
        return examService
                .updatePaper(
                        newPaperInfo.getInteger(Constants.paperId),
                        newPaperInfo.getString(Constants.paperName),
                        newPaperInfo.getString(Constants.paperDuration),
                        newPaperInfo.getString(Constants.paperTotalScore),
                        newPaperInfo.getInteger(Constants.examId))
                .toResponseEntity();
    }

    @Hidden
    @Operation(summary = "删除考卷接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"paperDuration\":\"tttt hours\",\"paperTotalScore\":\"tttt score\",\"paperExam\":{\"examName\":\"test exam\",\"examId\":2},\"paperName\":\"test new paper\",\"paperId\":2},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @DeleteMapping(value = "/paper/{paperId}")
    public ResponseEntity<JSONObject> deletePaper(@Parameter(description = "考卷Id") @PathVariable int paperId) {
        return examService.deletePaper(paperId).toResponseEntity();
    }

    @Hidden
    @Operation(summary = "获取考卷列表接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"paperList\":[{\"paperDuration\":\"2 hours\",\"paperTotalScore\":\"100\",\"paperExam\":{\"examName\":\"Math Exam\",\"examId\":1},\"paperName\":\"Math Paper\",\"paperId\":1}]},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/paper/{paperNameKeyword}")
    public ResponseEntity<JSONObject> getPapersByKeyword(
            @Parameter(description = "考卷名关键字，支持模糊查询") @PathVariable String paperNameKeyword,
            @Parameter(description = "考卷时长") @RequestParam(required = false) String paperDuration,
            @Parameter(description = "考卷总成绩") @RequestParam(required = false) String paperTotalScore,
            @Parameter(description = "考卷对应考试Id") @RequestParam(required = false) Integer examId) {
        return examService
                .getPapers(paperNameKeyword, paperDuration, paperTotalScore, examId)
                .toResponseEntity();
    }

    @Hidden
    @Operation(summary = "获取考卷列表接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"paperList\":[{\"paperDuration\":\"2 hours\",\"paperTotalScore\":\"100\",\"paperExam\":{\"examName\":\"Math Exam\",\"examId\":1},\"paperName\":\"Math Paper\",\"paperId\":1}]},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/paper")
    public ResponseEntity<JSONObject> getPapers(
            @Parameter(description = "考卷时长") @RequestParam(required = false) String paperDuration,
            @Parameter(description = "考卷总成绩") @RequestParam(required = false) String paperTotalScore,
            @Parameter(description = "考卷对应考试Id") @RequestParam(required = false) Integer examId) {
        return examService
                .getPapers(null, paperDuration, paperTotalScore, examId)
                .toResponseEntity();
    }

    @Hidden
    @Operation(summary = "新增考试具体信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"examSessionId\":4,\"examSessionPaper\":{\"paperDuration\":\"fur\",\"paperTotalScore\":\"122\",\"paperExam\":{\"examName\":\"test name\",\"examId\":4},\"paperName\":\"test paper name\",\"paperId\":3},\"examSessionEndTime\":1647399600000,\"examSessionStartTime\":1647396000000},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PostMapping(value = "/exam-session")
    public ResponseEntity<JSONObject> addExamSession(
            @Parameter(
                            description = "新增的考试具体信息信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example =
                                                    "{\"examSessionStartTime\": \"2022-03-16 10:00:00\", \"examSessionEndTime\": \"2022-03-16 11:00:00\", \"paperId\": 3}"))
                    @RequestBody
                    JSONObject newExamSessionInfo) {
        return examService
                .addExamSession(
                        newExamSessionInfo.getString(Constants.examSessionStartTime),
                        newExamSessionInfo.getString(Constants.examSessionEndTime),
                        newExamSessionInfo.getInteger(Constants.paperId))
                .toResponseEntity();
    }

    @Hidden
    @Operation(summary = "更改考试具体信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"examSessionId\":3,\"examSessionPaper\":{\"paperDuration\":\"cdscs\",\"paperTotalScore\":\"scscs\",\"paperExam\":{\"examName\":\"qxqwsxw\",\"examId\":2},\"paperName\":\"asdcaxwdas\",\"paperId\":2},\"examSessionEndTime\":1647399600000,\"examSessionStartTime\":1647396000000},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PutMapping(value = "/exam-session")
    public ResponseEntity<JSONObject> updateExamSession(
            @Parameter(
                            description = "更改后的考试具体信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example =
                                                    "{\"examSessionId\": 2, \"examSessionStartTime\": \"2022-03-16 10:00:00\", \"examSessionEndTime\": \"2022-03-16 11:00:00\", \"paperId\": 3}"))
                    @RequestBody
                    JSONObject newExamSessionInfo) {
        return examService
                .updateExamSession(
                        newExamSessionInfo.getInteger(Constants.examSessionId),
                        newExamSessionInfo.getString(Constants.examSessionStartTime),
                        newExamSessionInfo.getString(Constants.examSessionEndTime),
                        newExamSessionInfo.getInteger(Constants.paperId))
                .toResponseEntity();
    }

    @Hidden
    @Operation(summary = "删除考试具体信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"examSessionId\":2,\"examSessionPaper\":{\"paperDuration\":\"tttt hours\",\"paperTotalScore\":\"tttt score\",\"paperExam\":{\"examName\":\"Math Exam\",\"examId\":1},\"paperName\":\"testPaper\",\"paperId\":1}},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @DeleteMapping(value = "/exam-session/{examSessionId}")
    public ResponseEntity<JSONObject> deleteExamSession(
            @Parameter(description = "考试具体信息Id") @PathVariable int examSessionId) {
        return examService.deleteExamSession(examSessionId).toResponseEntity();
    }

    @Hidden
    @Operation(summary = "获取考试具体信息列表接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"examSessionList\":[{\"examSessionId\":1,\"examSessionPaper\":{\"paperDuration\":\"tttt hours\",\"paperTotalScore\":\"tttt score\",\"paperExam\":{\"examName\":\"Math Exam\",\"examId\":1},\"paperName\":\"testPaper\",\"paperId\":1},\"examSessionEndTime\":\"2023-03-16 20:00:00\",\"examSessionStartTime\":\"2023-03-16 18:00:00\"}]},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/exam-session")
    public ResponseEntity<JSONObject> getExamSessions(
            @Parameter(description = "考试具体信息开始时间") @RequestParam(required = false) String examSessionStartTime,
            @Parameter(description = "考试具体信息结束时间") @RequestParam(required = false) String examSessionEndTime,
            @Parameter(description = "考试具体信息对应试卷Id") @RequestParam(required = false) Integer paperId) {
        return examService
                .getExamSessions(examSessionStartTime, examSessionEndTime, paperId)
                .toResponseEntity();
    }

    @Operation(summary = "新增学生考试结果接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"studentResultStudentId\":5555,\"studentResultExamSession\":{\"examSessionId\":1,\"examSessionPaper\":{\"paperDuration\":\"2 hours\",\"paperTotalScore\":\"100\",\"paperExam\":{\"examName\":\"Math Exam\",\"examId\":1},\"paperName\":\"Math Paper\",\"paperId\":1},\"examSessionEndTime\":\"2023-03-16 20:00:00\",\"examSessionStartTime\":\"2023-03-16 20:00:00\"},\"studentResultScore\":102,\"studentResultId\":2},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PostMapping(value = "/student-result")
    public ResponseEntity<JSONObject> addStudentResult(
            @Parameter(
                            description = "新增的学生考试结果信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example =
                                                    "{\"studentResultStudentId\": 555555, \"studentResultScore\": 112, \"examSessionId\": 2}"))
                    @RequestBody
                    JSONObject newStudentResultInfo) {
        return examService
                .addStudentResult(
                        newStudentResultInfo.getInteger(Constants.studentResultStudentId),
                        newStudentResultInfo.getInteger(Constants.studentResultScore),
                        newStudentResultInfo.getInteger(Constants.examSessionId))
                .toResponseEntity();
    }

    @Operation(summary = "更改学生考试结果信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"studentResultStudentId\":555555,\"studentResultExamSession\":{\"examSessionId\":1,\"examSessionPaper\":{\"paperDuration\":\"2 hours\",\"paperTotalScore\":\"100\",\"paperExam\":{\"examName\":\"Math Exam\",\"examId\":1},\"paperName\":\"Math Paper\",\"paperId\":1},\"examSessionEndTime\":\"2023-03-16 20:00:00\",\"examSessionStartTime\":\"2023-03-16 20:00:00\"},\"studentResultScore\":112,\"studentResultId\":1},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PutMapping(value = "/student-result")
    public ResponseEntity<JSONObject> updateStudentResult(
            @Parameter(
                            description = "更改后的学生考试结果信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example =
                                                    "{\"studentResultId\": 2, \"studentResultStudentId\": 555555, \"studentResultScore\": 112, \"examSessionId\": 2}"))
                    @RequestBody
                    JSONObject newStudentResultInfo) {
        return examService
                .updateStudentResult(
                        newStudentResultInfo.getInteger(Constants.studentResultId),
                        newStudentResultInfo.getInteger(Constants.studentResultStudentId),
                        newStudentResultInfo.getInteger(Constants.studentResultScore),
                        newStudentResultInfo.getInteger(Constants.examSessionId))
                .toResponseEntity();
    }

    @Operation(summary = "删除学生考试结果接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"studentResultStudentId\":2314,\"studentResultExamSession\":{\"examSessionId\":2,\"examSessionPaper\":{\"paperDuration\":\"tt hours\",\"paperTotalScore\":\"ttt\",\"paperExam\":{\"examName\":\"test Exam\",\"examId\":2},\"paperName\":\"test paper\",\"paperId\":2},\"examSessionEndTime\":\"2022-03-16 11:00:00\",\"examSessionStartTime\":\"2021-03-16 10:00:00\"},\"studentResultScore\":112,\"studentResultId\":4},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @DeleteMapping(value = "/student-result/{studentResultId}")
    public ResponseEntity<JSONObject> deleteStudentResult(
            @Parameter(description = "学生考试结果Id") @PathVariable int studentResultId) {
        return examService.deleteStudentResult(studentResultId).toResponseEntity();
    }

    @Operation(summary = "获取学生考试结果列表接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"studentResultList\":[{\"studentResultStudentId\":1,\"studentResultExamSession\":{\"examSessionId\":1,\"examSessionPaper\":{\"paperDuration\":\"2 hours\",\"paperTotalScore\":\"100\",\"paperExam\":{\"examName\":\"Math Exam\",\"examId\":1},\"paperName\":\"Math Paper\",\"paperId\":1},\"examSessionEndTime\":\"2023-03-16 20:00:00\",\"examSessionStartTime\":\"2023-03-16 18:00:00\"},\"studentResultScore\":90,\"studentResultId\":1}]},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/student-result")
    public ResponseEntity<JSONObject> getStudentResults(
            @Parameter(description = "学生Id") @RequestParam(required = false) Integer studentResultStudentId,
            @Parameter(description = "学生考试成绩") @RequestParam(required = false) Integer studentResultScore,
            @Parameter(description = "学生对应考试信息Id") @RequestParam(required = false) Integer examSessionId) {
        return examService
                .getStudentResults(studentResultStudentId, studentResultScore, examSessionId)
                .toResponseEntity();
    }

    @Operation(summary = "新增问题类别接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"categoryName\":\"test new category\",\"categoryId\":6},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PostMapping(value = "/category")
    public ResponseEntity<JSONObject> addCategory(
            @Parameter(
                            description = "新增的问题类别信息",
                            schema = @Schema(type = "json", example = "{\"categoryName\": \"test category\"}"))
                    @RequestBody
                    JSONObject newCategoryInfo) {
        return examService
                .addCategory(newCategoryInfo.getString(Constants.categoryName))
                .toResponseEntity();
    }

    @Operation(summary = "更改问题类别信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"categoryName\":\"test category\",\"categoryId\":4},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PutMapping(value = "/category")
    public ResponseEntity<JSONObject> updateCategory(
            @Parameter(
                            description = "更改后的问题类别信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example = "{\"categoryId\": 2, \"categoryName\": \"test category\"}"))
                    @RequestBody
                    JSONObject newCategoryInfo) {
        return examService
                .updateCategory(
                        newCategoryInfo.getInteger(Constants.categoryId),
                        newCategoryInfo.getString(Constants.categoryName))
                .toResponseEntity();
    }

    @Operation(summary = "删除问题类别接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"categoryName\":\"test new category\",\"categoryId\":6},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @DeleteMapping(value = "/category/{categoryId}")
    public ResponseEntity<JSONObject> deleteCategory(@Parameter(description = "问题类别Id") @PathVariable int categoryId) {
        return examService.deleteCategory(categoryId).toResponseEntity();
    }

    @Operation(summary = "获取问题类别列表接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"categoryList\":[{\"categoryName\":\"Algebra\",\"categoryId\":1},{\"categoryName\":\"testCategory2\",\"categoryId\":3},{\"categoryName\":\"testCategory9\",\"categoryId\":4}]},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/category/{categoryNameKeyword}")
    public ResponseEntity<JSONObject> getCategoriesByKeyword(
            @Parameter(description = "问题类别名关键字，支持模糊查询") @PathVariable String categoryNameKeyword) {
        return examService.getCategories(categoryNameKeyword).toResponseEntity();
    }

    @Operation(summary = "获取问题类别列表接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"categoryList\":[{\"categoryName\":\"Algebra\",\"categoryId\":1},{\"categoryName\":\"testCategory2\",\"categoryId\":3},{\"categoryName\":\"testCategory9\",\"categoryId\":4}]},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/category")
    public ResponseEntity<JSONObject> getCategories() {
        return examService.getCategories(null).toResponseEntity();
    }

    @Operation(summary = "新增问题接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"questionContent\":\"test new question\",\"questionId\":7,\"questionCategory\":{\"categoryName\":\"Algebra\",\"categoryId\":1},\"questionType\":\"tttt type\"},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PostMapping(value = "/question")
    public ResponseEntity<JSONObject> addQuestion(
            @Parameter(
                            description = "新增的问题信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example =
                                                    "{\"questionContent\": \"test question\", \"questionType\": \"tttt type\", \"categoryId\": 2}"))
                    @RequestBody
                    JSONObject newQuestionInfo) {
        return examService
                .addQuestion(
                        newQuestionInfo.getString(Constants.questionContent),
                        newQuestionInfo.getString(Constants.questionType),
                        newQuestionInfo.getInteger(Constants.categoryId))
                .toResponseEntity();
    }

    @Operation(summary = "更改问题信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"questionContent\":\"test question\",\"questionId\":3,\"questionCategory\":{\"categoryName\":\"Algebra\",\"categoryId\":1},\"questionType\":\"tttt type\"},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PutMapping(value = "/question")
    public ResponseEntity<JSONObject> updateQuestion(
            @Parameter(
                            description = "更改后的问题信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example =
                                                    "{\"questionId\": 2, \"questionContent\": \"test question\", \"questionType\": \"tttt type\", \"categoryId\": 2}"))
                    @RequestBody
                    JSONObject newQuestionInfo) {
        return examService
                .updateQuestion(
                        newQuestionInfo.getInteger(Constants.questionId),
                        newQuestionInfo.getString(Constants.questionContent),
                        newQuestionInfo.getString(Constants.questionType),
                        newQuestionInfo.getInteger(Constants.categoryId))
                .toResponseEntity();
    }

    @Operation(summary = "删除问题接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"questionContent\":\"test new question\",\"questionId\":7,\"questionCategory\":{\"categoryName\":\"Algebra\",\"categoryId\":1},\"questionType\":\"tttt type\"},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @DeleteMapping(value = "/question/{questionId}")
    public ResponseEntity<JSONObject> deleteQuestion(@Parameter(description = "问题Id") @PathVariable int questionId) {
        return examService.deleteQuestion(questionId).toResponseEntity();
    }

    @Operation(summary = "获取问题列表接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"questionList\":[{\"questionContent\":\"What is the value of x in the equation x + 5 = 10?\",\"questionId\":1,\"questionCategory\":{\"categoryName\":\"Algebra\",\"categoryId\":1},\"questionType\":\"Multiple Choice\"},{\"questionContent\":\"cafdqfds\",\"questionId\":3,\"questionCategory\":{\"categoryName\":\"testCategory2\",\"categoryId\":3},\"questionType\":\"aaaaaa\"}]},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/question/{questionContentKeyword}")
    public ResponseEntity<JSONObject> getQuestionsByKeyword(
            @Parameter(description = "问题内容关键字，支持模糊查询") @PathVariable String questionContentKeyword,
            @Parameter(description = "问题种类") @RequestParam(required = false) String questionType,
            @Parameter(description = "问题类别Id") @RequestParam(required = false) Integer categoryId) {
        return examService
                .getQuestions(questionContentKeyword, questionType, categoryId)
                .toResponseEntity();
    }

    @Operation(summary = "获取问题列表接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"questionList\":[{\"questionContent\":\"What is the value of x in the equation x + 5 = 10?\",\"questionId\":1,\"questionCategory\":{\"categoryName\":\"Algebra\",\"categoryId\":1},\"questionType\":\"Multiple Choice\"},{\"questionContent\":\"cafdqfds\",\"questionId\":3,\"questionCategory\":{\"categoryName\":\"testCategory2\",\"categoryId\":3},\"questionType\":\"aaaaaa\"}]},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/question")
    public ResponseEntity<JSONObject> getQuestions(
            @Parameter(description = "问题种类") @RequestParam(required = false) String questionType,
            @Parameter(description = "问题类别Id") @RequestParam(required = false) Integer categoryId) {
        return examService.getQuestions(null, questionType, categoryId).toResponseEntity();
    }

    @Operation(summary = "新增试卷中问题接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"questionInPaperPaper\":{\"paperDuration\":\"2 hours\",\"paperTotalScore\":\"100\",\"paperExam\":{\"examName\":\"Math Exam\",\"examId\":1},\"paperName\":\"Math Paper\",\"paperId\":1},\"questionPoint\":3,\"questionInPaperQuestion\":{\"questionContent\":\"new question 3\",\"questionId\":8,\"questionCategory\":{\"categoryName\":\"Algebra\",\"categoryId\":1},\"questionType\":\"type1\"},\"questionInPaperId\":3},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PostMapping(value = "/question-in-paper")
    public ResponseEntity<JSONObject> addQuestionInPapers(
            @Parameter(
                            description = "新增的试卷中问题信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example = "{\"questionPoint\": 3, \"paperId\": 1, \"questionId\": 2}"))
                    @RequestBody
                    JSONObject newQuestionInPaperInfo) {
        return examService
                .addQuestionInPapers(
                        newQuestionInPaperInfo.getInteger(Constants.questionPoint),
                        newQuestionInPaperInfo.getInteger(Constants.paperId),
                        newQuestionInPaperInfo.getInteger(Constants.questionId))
                .toResponseEntity();
    }

    @Operation(summary = "更改试卷中问题信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"questionInPaperPaper\":{\"paperDuration\":\"2 hours\",\"paperTotalScore\":\"100\",\"paperExam\":{\"examName\":\"Math Exam\",\"examId\":1},\"paperName\":\"Math Paper\",\"paperId\":1},\"questionPoint\":8,\"questionInPaperQuestion\":{\"questionContent\":\"new question 3\",\"questionId\":8,\"questionCategory\":{\"categoryName\":\"Algebra\",\"categoryId\":1},\"questionType\":\"type1\"},\"questionInPaperId\":3},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PutMapping(value = "/question-in-paper")
    public ResponseEntity<JSONObject> updateQuestionInPapers(
            @Parameter(
                            description = "更改后的试卷中问题信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example =
                                                    "{\"questionInPaperId\": 3,\"questionPoint\": 3,\"paperId\": 1, \"questionId\": 2}"))
                    @RequestBody
                    JSONObject newQuestionInPaperInfo) {
        return examService
                .updateQuestionInPapers(
                        newQuestionInPaperInfo.getInteger(Constants.questionInPaperId),
                        newQuestionInPaperInfo.getInteger(Constants.questionPoint),
                        newQuestionInPaperInfo.getInteger(Constants.paperId),
                        newQuestionInPaperInfo.getInteger(Constants.questionId))
                .toResponseEntity();
    }

    @Operation(summary = "删除试卷中问题接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"questionInPaperPaper\":{\"paperDuration\":\"2 hours\",\"paperTotalScore\":\"100\",\"paperExam\":{\"examName\":\"Math Exam\",\"examId\":1},\"paperName\":\"Math Paper\",\"paperId\":1},\"questionPoint\":8,\"questionInPaperQuestion\":{\"questionContent\":\"new question 3\",\"questionId\":8,\"questionCategory\":{\"categoryName\":\"Algebra\",\"categoryId\":1},\"questionType\":\"type1\"},\"questionInPaperId\":3},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @DeleteMapping(value = "/question-in-paper/{questionInPaperId}")
    public ResponseEntity<JSONObject> deleteQuestionInPapers(
            @Parameter(description = "试卷中问题Id") @PathVariable int questionInPaperId) {
        return examService.deleteQuestionInPapers(questionInPaperId).toResponseEntity();
    }

    @Operation(summary = "获取试卷中问题列表接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"questionInPaperList\":[{\"questionInPaperPaper\":{\"paperDuration\":\"2 hours\",\"paperTotalScore\":\"100\",\"paperExam\":{\"examName\":\"Math Exam\",\"examId\":1},\"paperName\":\"Math Paper\",\"paperId\":1},\"questionPoint\":3,\"questionInPaperQuestion\":{\"questionContent\":\"test new\",\"questionId\":2,\"questionCategory\":{\"categoryName\":\"Algebra\",\"categoryId\":1},\"questionType\":\"qa\"},\"questionInPaperId\":2},{\"questionInPaperPaper\":{\"paperDuration\":\"2 hours\",\"paperTotalScore\":\"100\",\"paperExam\":{\"examName\":\"Math Exam\",\"examId\":1},\"paperName\":\"Math Paper\",\"paperId\":1},\"questionPoint\":3,\"questionInPaperQuestion\":{\"questionContent\":\"new question 3\",\"questionId\":8,\"questionCategory\":{\"categoryName\":\"Algebra\",\"categoryId\":1},\"questionType\":\"type1\"},\"questionInPaperId\":3}]},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/question-in-paper")
    public ResponseEntity<JSONObject> getQuestionInPapers(
            @Parameter(description = "试卷中问题分数") @RequestParam(required = false) Integer questionPoint,
            @Parameter(description = "试卷Id") @RequestParam(required = false) Integer paperId,
            @Parameter(description = "问题Id") @RequestParam(required = false) Integer questionId) {
        return examService
                .getQuestionInPapers(questionPoint, paperId, questionId)
                .toResponseEntity();
    }

    @Operation(summary = "新增学生单一问题作答信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"studentAnswerContent\":\"Test Answer 2\",\"studentAnswerId\":2,\"studentAnswerPoint\":0,\"studentAnswerStudentResult\":{\"studentResultStudentId\":1,\"studentResultExamSession\":{\"examSessionId\":1,\"examSessionPaper\":{\"paperDuration\":\"2 hours\",\"paperTotalScore\":\"100\",\"paperExam\":{\"examName\":\"Math Exam\",\"examId\":1},\"paperName\":\"Math Paper\",\"paperId\":1},\"examSessionEndTime\":\"2023-03-16 20:00:00\",\"examSessionStartTime\":\"2023-03-16 18:00:00\"},\"studentResultScore\":90,\"studentResultId\":1},\"studentAnswerQuestionInPaper\":{\"questionInPaperPaper\":{\"paperDuration\":\"tt hours\",\"paperTotalScore\":\"ttt\",\"paperExam\":{\"examName\":\"test Exam\",\"examId\":2},\"paperName\":\"test paper\",\"paperId\":2},\"questionPoint\":40,\"questionInPaperQuestion\":{\"questionContent\":\"What is the value of x in the equation x + 5 = 10?\",\"questionId\":1,\"questionCategory\":{\"categoryName\":\"Algebra\",\"categoryId\":1},\"questionType\":\"Multiple Choice\"},\"questionInPaperId\":4}},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PostMapping(value = "/student-answer")
    public ResponseEntity<JSONObject> addStudentAnswers(
            @Parameter(
                            description = "新增的学生单一问题作答信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example =
                                                    "{\"studentAnswerContent\": \"Test Answer 2\", \"studentAnswerPoint\": 0, \"questionInPaperId\": 2, \"studentResultId\": 2}"))
                    @RequestBody
                    JSONObject newStudentAnswerInfo) {
        return examService
                .addStudentAnswers(
                        newStudentAnswerInfo.getString(Constants.studentAnswerContent),
                        newStudentAnswerInfo.getInteger(Constants.studentAnswerPoint),
                        newStudentAnswerInfo.getInteger(Constants.questionInPaperId),
                        newStudentAnswerInfo.getInteger(Constants.studentResultId))
                .toResponseEntity();
    }

    @Operation(summary = "更改学生单一问题作答信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"studentAnswerContent\":\"Test Answer 3\",\"studentAnswerId\":2,\"studentAnswerPoint\":4,\"studentAnswerStudentResult\":{\"studentResultStudentId\":1,\"studentResultExamSession\":{\"examSessionId\":1,\"examSessionPaper\":{\"paperDuration\":\"2 hours\",\"paperTotalScore\":\"100\",\"paperExam\":{\"examName\":\"Math Exam\",\"examId\":1},\"paperName\":\"Math Paper\",\"paperId\":1},\"examSessionEndTime\":\"2023-03-16 20:00:00\",\"examSessionStartTime\":\"2023-03-16 18:00:00\"},\"studentResultScore\":90,\"studentResultId\":1},\"studentAnswerQuestionInPaper\":{\"questionInPaperPaper\":{\"paperDuration\":\"tt hours\",\"paperTotalScore\":\"ttt\",\"paperExam\":{\"examName\":\"test Exam\",\"examId\":2},\"paperName\":\"test paper\",\"paperId\":2},\"questionPoint\":40,\"questionInPaperQuestion\":{\"questionContent\":\"What is the value of x in the equation x + 5 = 10?\",\"questionId\":1,\"questionCategory\":{\"categoryName\":\"Algebra\",\"categoryId\":1},\"questionType\":\"Multiple Choice\"},\"questionInPaperId\":4}},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PutMapping(value = "/student-answer")
    public ResponseEntity<JSONObject> updateStudentAnswers(
            @Parameter(
                            description = "更改后的学生单一问题作答信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example =
                                                    "{\"studentAnswerId\": 3, \"studentAnswerContent\": \"Test Answer 2\", \"studentAnswerPoint\": 0, \"questionInPaperId\": 2, \"studentResultId\": 2}"))
                    @RequestBody
                    JSONObject newStudentAnswerInfo) {
        return examService
                .updateStudentAnswers(
                        newStudentAnswerInfo.getInteger(Constants.studentAnswerId),
                        newStudentAnswerInfo.getString(Constants.studentAnswerContent),
                        newStudentAnswerInfo.getInteger(Constants.studentAnswerPoint),
                        newStudentAnswerInfo.getInteger(Constants.questionInPaperId),
                        newStudentAnswerInfo.getInteger(Constants.studentResultId))
                .toResponseEntity();
    }

    @Operation(summary = "删除学生单一问题作答信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"studentAnswerContent\":\"Test Answer 3\",\"studentAnswerId\":2,\"studentAnswerPoint\":4,\"studentAnswerStudentResult\":{\"studentResultStudentId\":1,\"studentResultExamSession\":{\"examSessionId\":1,\"examSessionPaper\":{\"paperDuration\":\"2 hours\",\"paperTotalScore\":\"100\",\"paperExam\":{\"examName\":\"Math Exam\",\"examId\":1},\"paperName\":\"Math Paper\",\"paperId\":1},\"examSessionEndTime\":\"2023-03-16 20:00:00\",\"examSessionStartTime\":\"2023-03-16 18:00:00\"},\"studentResultScore\":90,\"studentResultId\":1},\"studentAnswerQuestionInPaper\":{\"questionInPaperPaper\":{\"paperDuration\":\"tt hours\",\"paperTotalScore\":\"ttt\",\"paperExam\":{\"examName\":\"test Exam\",\"examId\":2},\"paperName\":\"test paper\",\"paperId\":2},\"questionPoint\":40,\"questionInPaperQuestion\":{\"questionContent\":\"What is the value of x in the equation x + 5 = 10?\",\"questionId\":1,\"questionCategory\":{\"categoryName\":\"Algebra\",\"categoryId\":1},\"questionType\":\"Multiple Choice\"},\"questionInPaperId\":4}},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @DeleteMapping(value = "/student-answer/{studentAnswerId}")
    public ResponseEntity<JSONObject> deleteStudentAnswers(
            @Parameter(description = "学生单一问题作答信息Id") @PathVariable int studentAnswerId) {
        return examService.deleteStudentAnswers(studentAnswerId).toResponseEntity();
    }

    @Operation(summary = "获取学生单一问题作答信息列表接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"studentAnswerList\":[{\"studentAnswerContent\":\"Test Answer 3\",\"studentAnswerId\":2,\"studentAnswerPoint\":4,\"studentAnswerStudentResult\":{\"studentResultStudentId\":1,\"studentResultExamSession\":{\"examSessionId\":1,\"examSessionPaper\":{\"paperDuration\":\"2 hours\",\"paperTotalScore\":\"100\",\"paperExam\":{\"examName\":\"Math Exam\",\"examId\":1},\"paperName\":\"Math Paper\",\"paperId\":1},\"examSessionEndTime\":\"2023-03-16 20:00:00\",\"examSessionStartTime\":\"2023-03-16 18:00:00\"},\"studentResultScore\":90,\"studentResultId\":1},\"studentAnswerQuestionInPaper\":{\"questionInPaperPaper\":{\"paperDuration\":\"tt hours\",\"paperTotalScore\":\"ttt\",\"paperExam\":{\"examName\":\"test Exam\",\"examId\":2},\"paperName\":\"test paper\",\"paperId\":2},\"questionPoint\":40,\"questionInPaperQuestion\":{\"questionContent\":\"What is the value of x in the equation x + 5 = 10?\",\"questionId\":1,\"questionCategory\":{\"categoryName\":\"Algebra\",\"categoryId\":1},\"questionType\":\"Multiple Choice\"},\"questionInPaperId\":4}}]},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/student-answer")
    public ResponseEntity<JSONObject> getStudentAnswers(
            @Parameter(description = "学生该问题作答内容") @RequestParam(required = false) String studentAnswerKeyword,
            @Parameter(description = "学生该问题得分") @RequestParam(required = false) Integer studentAnswerPoint,
            @Parameter(description = "试卷中问题Id") @RequestParam(required = false) Integer questionInPaperId,
            @Parameter(description = "学生考试结果Id") @RequestParam(required = false) Integer studentResultId) {
        return examService
                .getStudentAnswers(studentAnswerKeyword, studentAnswerPoint, questionInPaperId, studentResultId)
                .toResponseEntity();
    }

    @Operation(summary = "获取考试列表接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"examSessionList\":[{\"examSessionId\":1,\"examSessionPaper\":{\"paperDuration\":\"tttt hours\",\"paperTotalScore\":\"tttt score\",\"paperExam\":{\"examName\":\"Math Exam\",\"examId\":1},\"paperName\":\"testPaper\",\"paperId\":1},\"examSessionEndTime\":\"2023-03-16 20:00:00\",\"examSessionStartTime\":\"2023-03-16 18:00:00\"}]},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @GetMapping(value = "/examinations")
    public ResponseEntity<JSONObject> getExaminations(
            @Parameter(description = "考试名关键字，支持模糊查询") @RequestParam(required = false) String examNameKeyword,
            @Parameter(description = "考卷名关键字，支持模糊查询") @RequestParam(required = false) String paperNameKeyword,
            @Parameter(description = "考卷时长") @RequestParam(required = false) String paperDuration,
            @Parameter(description = "考卷总成绩") @RequestParam(required = false) String paperTotalScore,
            @Parameter(description = "考试具体信息开始时间") @RequestParam(required = false) String examSessionStartTime,
            @Parameter(description = "考试具体信息结束时间") @RequestParam(required = false) String examSessionEndTime) {
        return examService
                .getExaminations(
                        examNameKeyword,
                        paperNameKeyword,
                        paperDuration,
                        paperTotalScore,
                        examSessionStartTime,
                        examSessionEndTime)
                .toResponseEntity();
    }

    @Operation(summary = "删除考试接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"examSessionId\":7,\"examSessionPaper\":{\"paperDuration\":\"tttt hours\",\"paperTotalScore\":\"tttt score\",\"paperExam\":{\"examName\":\"test 2 exam\",\"examId\":7},\"paperName\":\"test 2 paper\",\"paperId\":6},\"examSessionEndTime\":\"2022-03-16 11:00:00\",\"examSessionStartTime\":\"2021-03-16 10:00:00\"},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @DeleteMapping(value = "/examinations/{examId}")
    public ResponseEntity<JSONObject> deleteExamination(@Parameter(description = "考试具体信息Id") @PathVariable int examId) {
        return examService.deleteExamination(examId).toResponseEntity();
    }

    @Operation(summary = "更改考试信息接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"examSessionId\":2,\"examSessionPaper\":{\"paperDuration\":\"tttt hours\",\"paperTotalScore\":\"tttt score\",\"paperExam\":{\"examName\":\"test exam\",\"examId\":2},\"paperName\":\"test paper\",\"paperId\":2},\"examSessionEndTime\":\"2022-03-16 11:00:00\",\"examSessionStartTime\":\"2022-03-16 10:00:00\"},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PutMapping(value = "/examinations")
    public ResponseEntity<JSONObject> updateExamination(
            @Parameter(
                            description = "更改后的考试信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example =
                                                    "{\"examId\": 2, \"examName\": \"test exam\", \"paperName\": \"test paper\", \"paperDuration\": \"tttt hours\", \"paperTotalScore\": \"tttt score\", \"examSessionStartTime\": \"2022-03-16 10:00:00\", \"examSessionEndTime\": \"2022-03-16 11:00:00\"}"))
                    @RequestBody
                    JSONObject newExaminationInfo) {
        return examService
                .updateExamination(
                        newExaminationInfo.getInteger(Constants.examId),
                        newExaminationInfo.getString(Constants.examName),
                        newExaminationInfo.getString(Constants.paperName),
                        newExaminationInfo.getString(Constants.paperDuration),
                        newExaminationInfo.getString(Constants.paperTotalScore),
                        newExaminationInfo.getString(Constants.examSessionStartTime),
                        newExaminationInfo.getString(Constants.examSessionEndTime))
                .toResponseEntity();
    }

    @Operation(summary = "新增考试接口")
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Success message.",
                                                    value =
                                                            "{\"code\":200,\"data\":{\"examSessionId\":5,\"examSessionPaper\":{\"paperDuration\":\"tttt hours\",\"paperTotalScore\":\"tttt score\",\"paperExam\":{\"examName\":\"test new exam\",\"examId\":5},\"paperName\":\"test new paper\",\"paperId\":4},\"examSessionEndTime\":\"2023-03-16 20:00:00\",\"examSessionStartTime\":\"2023-03-16 20:00:00\"},\"message\":\"ok\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE)),
                @ApiResponse(
                        responseCode = "515",
                        description = "Request failed",
                        content =
                                @Content(
                                        examples = {
                                            @ExampleObject(
                                                    description = "Failure message.",
                                                    value = "{\"code\": 515,\"message\": \"Request failed\"}")
                                        },
                                        mediaType = MediaType.APPLICATION_JSON_VALUE))
            })
    @PostMapping(value = "/examinations")
    public ResponseEntity<JSONObject> addExamination(
            @Parameter(
                            description = "新增的考试信息",
                            schema =
                                    @Schema(
                                            type = "json",
                                            example =
                                                    "{\"examName\": \"test exam\", \"paperName\": \"test paper\", \"paperDuration\": \"tttt hours\", \"paperTotalScore\": \"tttt score\", \"examSessionStartTime\": \"2022-03-16 10:00:00\", \"examSessionEndTime\": \"2022-03-16 11:00:00\"}"))
                    @RequestBody
                    JSONObject newExaminationInfo) {
        return examService
                .addExamination(
                        newExaminationInfo.getString(Constants.examName),
                        newExaminationInfo.getString(Constants.paperName),
                        newExaminationInfo.getString(Constants.paperDuration),
                        newExaminationInfo.getString(Constants.paperTotalScore),
                        newExaminationInfo.getString(Constants.examSessionStartTime),
                        newExaminationInfo.getString(Constants.examSessionEndTime))
                .toResponseEntity();
    }
}
