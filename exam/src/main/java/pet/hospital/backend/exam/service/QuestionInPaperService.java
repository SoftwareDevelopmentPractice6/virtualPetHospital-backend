/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-23 16:51:39
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-23 16:59:55
 * @FilePath: /virtualPetHospital-backend/exam/src/main/java/pet/hospital/backend/exam/service/QuestionInPaperInPaper.java
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
import pet.hospital.backend.exam.dao.PaperRepository;
import pet.hospital.backend.exam.dao.QuestionInPaperRepository;
import pet.hospital.backend.exam.dao.QuestionRepository;
import pet.hospital.backend.exam.entity.Paper;
import pet.hospital.backend.exam.entity.Question;
import pet.hospital.backend.exam.entity.QuestionInPaper;

@Service
public class QuestionInPaperService {

    @Autowired
    private QuestionInPaperRepository questionInPaperRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private PaperRepository paperRepository;

    public JSONObject getQuestionInPapers(Integer questionPoint, Integer paperId, Integer questionId) {
        JSONObject res = new JSONObject();
        res.put(
                Constants.questionInPaperList,
                JSONObject.parseArray(JSON.toJSONString(questionInPaperRepository.findAll().stream()
                        .filter(questionInPaper ->
                                SearchJudgeHelper.softEquals(questionPoint, questionInPaper.getQuestionPoint())
                                        && SearchJudgeHelper.softEquals(
                                                paperId,
                                                questionInPaper
                                                        .getQuestionInPaperPaper()
                                                        .getPaperId())
                                        && SearchJudgeHelper.softEquals(
                                                questionId,
                                                questionInPaper
                                                        .getQuestionInPaperQuestion()
                                                        .getQuestionId()))
                        .collect(Collectors.toList()))));
        return ResponseHelper.constructSuccessResponse(res);
    }

    public JSONObject addQuestionInPaper(int questionPoint, int paperId, int questionId) {
        List<QuestionInPaper> targetQuestionInPaperList = questionInPaperRepository.findAll().stream()
                .filter(questionInPaper -> Objects.equals(
                                questionInPaper.getQuestionInPaperPaper().getPaperId(), paperId)
                        && Objects.equals(
                                questionInPaper.getQuestionInPaperQuestion().getQuestionId(), questionId))
                .collect(Collectors.toList());

        if (Objects.equals(targetQuestionInPaperList.size(), 0)) {
            Optional<Paper> targetPaperOptional = paperRepository.findById(paperId);
            Optional<Question> targetQuestionOptional = questionRepository.findById(questionId);
            if (targetPaperOptional.isEmpty() || targetQuestionOptional.isEmpty()) {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            } else {
                QuestionInPaper newQuestionInPaper = new QuestionInPaper();
                newQuestionInPaper.setQuestionPoint(questionPoint);
                newQuestionInPaper.setQuestionInPaperPaper(targetPaperOptional.get());
                newQuestionInPaper.setQuestionInPaperQuestion(targetQuestionOptional.get());

                QuestionInPaper addedQuestionInPaper = questionInPaperRepository.saveAndFlush(newQuestionInPaper);

                return ResponseHelper.constructSuccessResponse(addedQuestionInPaper);
            }
        } else {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        }
    }

    public JSONObject updateQuestionInPaper(int questionInPaperId, int questionPoint, int paperId, int questionId) {
        Optional<QuestionInPaper> targetQuestionInPaperOptional = questionInPaperRepository.findById(questionInPaperId);

        if (targetQuestionInPaperOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            List<QuestionInPaper> targetQuestionInPaperList = questionInPaperRepository.findAll().stream()
                    .filter(questionInPaper -> Objects.equals(
                                    questionInPaper.getQuestionInPaperPaper().getPaperId(), paperId)
                            && Objects.equals(
                                    questionInPaper.getQuestionInPaperQuestion().getQuestionId(), questionId)
                            && !Objects.equals(questionInPaper.getQuestionInPaperId(), questionInPaperId))
                    .collect(Collectors.toList());

            Optional<Paper> targetPaperOptional = paperRepository.findById(paperId);
            Optional<Question> targetQuestionOptional = questionRepository.findById(questionId);

            if (targetPaperOptional.isEmpty()
                    || targetQuestionOptional.isEmpty()
                    || !Objects.equals(targetQuestionInPaperList.size(), 0)) {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            } else {
                QuestionInPaper targetQuestionInPaper = targetQuestionInPaperOptional.get();
                targetQuestionInPaper.setQuestionPoint(questionPoint);
                targetQuestionInPaper.setQuestionInPaperPaper(targetPaperOptional.get());
                targetQuestionInPaper.setQuestionInPaperQuestion(targetQuestionOptional.get());

                QuestionInPaper updatedQuestionInPaper = questionInPaperRepository.saveAndFlush(targetQuestionInPaper);

                return ResponseHelper.constructSuccessResponse(updatedQuestionInPaper);
            }
        }
    }

    public JSONObject deleteQuestionInPaper(int questionInPaperId) {
        Optional<QuestionInPaper> targetQuestionInPaperOptional = questionInPaperRepository.findById(questionInPaperId);

        if (targetQuestionInPaperOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            questionInPaperRepository.deleteById(questionInPaperId);

            if (questionInPaperRepository.findById(questionInPaperId).isEmpty()) {
                return ResponseHelper.constructSuccessResponse(targetQuestionInPaperOptional.get());
            } else {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            }
        }
    }
}
