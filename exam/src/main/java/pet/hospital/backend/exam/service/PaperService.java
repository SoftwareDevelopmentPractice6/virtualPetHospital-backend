/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-20 13:43:07
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-04-22 21:08:44
 * @FilePath: /virtualPetHospital-backend/exam/src/main/java/pet/hospital/backend/exam/service/PaperService.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.exam.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.hospital.backend.common.constant.Constants;
import pet.hospital.backend.common.helper.ResponseHelper;
import pet.hospital.backend.common.helper.SearchJudgeHelper;
import pet.hospital.backend.exam.dao.ExamRepository;
import pet.hospital.backend.exam.dao.PaperRepository;
import pet.hospital.backend.exam.entity.Exam;
import pet.hospital.backend.exam.entity.Paper;

@Service
public class PaperService {

    @Autowired
    private PaperRepository paperRepository;

    @Autowired
    private ExamRepository examRepository;

    public JSONObject getPapers(String paperKeyword, String paperDuration, String paperTotalScore, Integer examId) {
        JSONObject res = new JSONObject();
        res.put(
                Constants.paperList,
                JSONObject.parseArray(JSON.toJSONString(paperRepository.findAll().stream()
                        .filter(paper -> SearchJudgeHelper.softIncludes(paperKeyword, paper.getPaperName())
                                && SearchJudgeHelper.softEquals(paperDuration, paper.getPaperDuration())
                                && SearchJudgeHelper.softEquals(paperTotalScore, paper.getPaperTotalScore())
                                && SearchJudgeHelper.softEquals(
                                        examId, paper.getPaperExam().getExamId()))
                        .collect(Collectors.toList()))));
        return ResponseHelper.constructSuccessResponse(res);
    }

    public JSONObject addPaper(String paperName, String paperDuration, String paperTotalScore, int examId) {
        List<Paper> targetPaperList = paperRepository.findAll().stream()
                .filter(paper -> Objects.equals(paper.getPaperExam().getExamId(), examId))
                .collect(Collectors.toList());

        if (Objects.equals(targetPaperList.size(), 0)) {
            Optional<Exam> targetExamOptional = examRepository.findById(examId);
            if (targetExamOptional.isEmpty()) {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            } else {
                Paper newPaper = new Paper();
                newPaper.setPaperName(paperName);
                newPaper.setPaperDuration(paperDuration);
                newPaper.setPaperTotalScore(paperTotalScore);
                newPaper.setPaperExam(targetExamOptional.get());

                Paper addedPaper = paperRepository.saveAndFlush(newPaper);

                return ResponseHelper.constructSuccessResponse(addedPaper);
            }
        } else {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        }
    }

    public JSONObject updatePaper(
            int paperId, String paperName, String paperDuration, String paperTotalScore, int examId) {
        Optional<Paper> targetPaperOptional = paperRepository.findById(paperId);

        if (targetPaperOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            List<Paper> targetPaperList = paperRepository.findAll().stream()
                    .filter(paper -> Objects.equals(paper.getPaperExam().getExamId(), examId)
                            && !Objects.equals(paper.getPaperId(), paperId))
                    .collect(Collectors.toList());

            Optional<Exam> targetExamOptional = examRepository.findById(examId);

            if (targetExamOptional.isEmpty() || !Objects.equals(targetPaperList.size(), 0)) {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            } else {
                Paper targetPaper = targetPaperOptional.get();
                targetPaper.setPaperName(paperName);
                targetPaper.setPaperDuration(paperDuration);
                targetPaper.setPaperTotalScore(paperTotalScore);
                targetPaper.setPaperExam(targetExamOptional.get());

                Paper updatedPaper = paperRepository.saveAndFlush(targetPaper);

                return ResponseHelper.constructSuccessResponse(updatedPaper);
            }
        }
    }

    public JSONObject deletePaper(int paperId) {
        Optional<Paper> targetPaperOptional = paperRepository.findById(paperId);

        if (targetPaperOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            paperRepository.deleteById(paperId);

            if (paperRepository.findById(paperId).isEmpty()) {
                return ResponseHelper.constructSuccessResponse(targetPaperOptional.get());
            } else {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            }
        }
    }
}
