/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-20 14:11:06
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-20 16:37:52
 * @FilePath: /virtualPetHospital-backend/exam/src/main/java/pet/hospital/backend/exam/controller/PaperController.java
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
import pet.hospital.backend.exam.service.PaperService;

@RestController
@Tag(name = "Exam模块")
@RequestMapping(
        value = "/api/exam/paper",
        produces = {"application/json;charset=UTF-8"})
public class PaperController {

    @Autowired
    PaperService paperService;

    @Operation(summary = "获取考卷接口")
    @GetMapping(value = "/get")
    public JSONObject getPapers(
            @Parameter(description = "考卷名称关键字，支持模糊查询") @RequestParam(required = false) String paperKeyword,
            @Parameter(description = "考卷时长") @RequestParam(required = false) String paperDuration,
            @Parameter(description = "考卷总成绩") @RequestParam(required = false) String paperTotalScore,
            @Parameter(description = "考卷对应考试Id") @RequestParam(required = false) Integer examId)
            throws UnsupportedEncodingException {
        return paperService.getPapers(paperKeyword, paperDuration, paperTotalScore, examId);
    }

    @Operation(summary = "新增考卷接口")
    @PostMapping(value = "/add")
    public JSONObject addPaper(
            @Parameter(description = "考卷名称") @RequestParam String paperName,
            @Parameter(description = "考卷时长") @RequestParam String paperDuration,
            @Parameter(description = "考卷总成绩") @RequestParam String paperTotalScore,
            @Parameter(description = "考卷对应考试Id") @RequestParam int examId)
            throws UnsupportedEncodingException {
        return paperService.addPaper(
                URLDecoder.decode(paperName, Constants.UTF8),
                URLDecoder.decode(paperDuration, Constants.UTF8),
                URLDecoder.decode(paperTotalScore, Constants.UTF8),
                examId);
    }

    @Operation(summary = "更改考卷信息接口")
    @PutMapping(value = "/update")
    public JSONObject updatePaper(
            @Parameter(description = "考卷Id") @RequestParam int paperId,
            @Parameter(description = "考卷名称") @RequestParam String paperName,
            @Parameter(description = "考卷时长") @RequestParam String paperDuration,
            @Parameter(description = "考卷总成绩") @RequestParam String paperTotalScore,
            @Parameter(description = "考卷对应考试Id") @RequestParam int examId)
            throws UnsupportedEncodingException {
        return paperService.updatePaper(
                paperId,
                URLDecoder.decode(paperName, Constants.UTF8),
                URLDecoder.decode(paperDuration, Constants.UTF8),
                URLDecoder.decode(paperTotalScore, Constants.UTF8),
                examId);
    }

    @Operation(summary = "删除考卷接口")
    @DeleteMapping(value = "/delete")
    public JSONObject deletePaper(@Parameter(description = "考卷Id") @RequestParam int paperId) {
        return paperService.deletePaper(paperId);
    }
}
