/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-19 19:31:04
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-04-25 20:30:00
 * @FilePath: /virtualPetHospital-backend/exam/src/main/java/pet/hospital/backend/exam/service/QuestionService.java
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
import pet.hospital.backend.exam.dao.CategoryRepository;
import pet.hospital.backend.exam.dao.QuestionRepository;
import pet.hospital.backend.exam.entity.Category;
import pet.hospital.backend.exam.entity.Question;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public JSONObject getQuestions(
            String questionKeyword, String questionAnswerKeyword, String questionType, Integer categoryId) {
        JSONObject res = new JSONObject();
        res.put(
                Constants.questionList,
                JSONObject.parseArray(JSON.toJSONString(questionRepository.findAll().stream()
                        .filter(question -> SearchJudgeHelper.softIncludes(
                                        questionKeyword, question.getQuestionContent())
                                && SearchJudgeHelper.softIncludes(questionAnswerKeyword, question.getQuestionAnswer())
                                && SearchJudgeHelper.softEquals(questionType, question.getQuestionType())
                                && SearchJudgeHelper.softEquals(
                                        categoryId,
                                        question.getQuestionCategory().getCategoryId()))
                        .collect(Collectors.toList()))));
        return ResponseHelper.constructSuccessResponse(res);
    }

    public JSONObject addQuestion(String questionContent, String questionAnswer, String questionType, int categoryId) {
        List<Question> targetQuestionList = questionRepository.findAll().stream()
                .filter(question -> Objects.equals(question.getQuestionContent(), questionContent))
                .collect(Collectors.toList());

        if (Objects.equals(targetQuestionList.size(), 0)) {
            Optional<Category> targetCategoryOptional = categoryRepository.findById(categoryId);
            if (targetCategoryOptional.isEmpty()) {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            } else {
                Question newQuestion = new Question();
                newQuestion.setQuestionContent(questionContent);
                newQuestion.setQuestionAnswer(questionAnswer);
                newQuestion.setQuestionType(questionType);
                newQuestion.setQuestionCategory(targetCategoryOptional.get());

                Question addedQuestion = questionRepository.saveAndFlush(newQuestion);

                return ResponseHelper.constructSuccessResponse(addedQuestion);
            }
        } else {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        }
    }

    public JSONObject updateQuestion(
            int questionId, String questionContent, String questionAnswer, String questionType, int categoryId) {
        Optional<Question> targetQuestionOptional = questionRepository.findById(questionId);

        if (targetQuestionOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            List<Question> targetQuestionList = questionRepository.findAll().stream()
                    .filter(question -> Objects.equals(question.getQuestionContent(), questionContent)
                            && !Objects.equals(question.getQuestionId(), questionId))
                    .collect(Collectors.toList());

            Optional<Category> targetCategoryOptional = categoryRepository.findById(categoryId);

            if (targetCategoryOptional.isEmpty() || !Objects.equals(targetQuestionList.size(), 0)) {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            } else {
                Question targetQuestion = targetQuestionOptional.get();
                targetQuestion.setQuestionContent(questionContent);
                targetQuestion.setQuestionAnswer(questionAnswer);
                targetQuestion.setQuestionType(questionType);
                targetQuestion.setQuestionCategory(targetCategoryOptional.get());

                Question updatedQuestion = questionRepository.saveAndFlush(targetQuestion);

                return ResponseHelper.constructSuccessResponse(updatedQuestion);
            }
        }
    }

    public JSONObject deleteQuestion(int questionId) {
        Optional<Question> targetQuestionOptional = questionRepository.findById(questionId);

        if (targetQuestionOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            questionRepository.deleteById(questionId);

            if (questionRepository.findById(questionId).isEmpty()) {
                return ResponseHelper.constructSuccessResponse(targetQuestionOptional.get());
            } else {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            }
        }
    }
}
