/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-19 19:31:04
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-19 20:24:28
 * @FilePath: /virtualPetHospital-backend/exam/src/main/java/pet/hospital/backend/exam/service/QuestionService.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.exam.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.JSON;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.hospital.backend.common.constant.Constants;
import pet.hospital.backend.common.helper.ResponseHelper;
import pet.hospital.backend.exam.dao.CategoryRepository;
import pet.hospital.backend.exam.dao.QuestionRepository;
import pet.hospital.backend.exam.entity.Category;
import pet.hospital.backend.exam.entity.Question;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public JSONObject getQuestionsByContent(String questionKeyword) {
        JSONObject res = new JSONObject();
        res.put(
                Constants.questionList,
                JSONObject.parseArray(JSON.toJSONString(questionRepository.findAll().stream()
                        .filter(question ->
                                !Objects.equals(question.getQuestionContent().indexOf(questionKeyword), -1))
                        .collect(Collectors.toList()))));
        return ResponseHelper.constructSuccessResponse(res);
    }

    public JSONObject getQuestionsByType(String questionType) {
        JSONObject res = new JSONObject();
        res.put(
                Constants.questionList,
                JSONObject.parseArray(JSON.toJSONString(questionRepository.findAll().stream()
                        .filter(question -> Objects.equals(question.getQuestionType(), questionType))
                        .collect(Collectors.toList()))));
        return ResponseHelper.constructSuccessResponse(res);
    }

    public JSONObject getQuestionsByCategoryId(int categoryId) {
        JSONObject res = new JSONObject();
        res.put(
                Constants.questionList,
                JSONObject.parseArray(JSON.toJSONString(questionRepository.findAll().stream()
                        .filter(question ->
                                Objects.equals(question.getQuestionCategory().getCategoryId(), categoryId))
                        .collect(Collectors.toList()))));
        return ResponseHelper.constructSuccessResponse(res);
    }

    public JSONObject addQuestion(String questionContent, String questionType, int categoryId) {
        List<Question> targetQuestionList = questionRepository.findAll().stream()
                .filter(question -> Objects.equals(question.getQuestionContent(), questionContent))
                .collect(Collectors.toList());

        if (!Objects.equals(targetQuestionList.size(), 1)) {
            Optional<Category> targetCategoryOptional = categoryRepository.findById(categoryId);
            if (targetCategoryOptional.isEmpty()) {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            } else {
                Question newQuestion = new Question();
                newQuestion.setQuestionContent(questionContent);
                newQuestion.setQuestionType(questionType);
                newQuestion.setQuestionCategory(targetCategoryOptional.get());

                Question addedQuestion = questionRepository.saveAndFlush(newQuestion);

                return ResponseHelper.constructSuccessResponse(addedQuestion);
            }
        } else {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        }
    }

    public JSONObject updateQuestion(JSONObject newQuestionInfo) {
        Optional<Question> targetQuestionOptional =
                questionRepository.findById(newQuestionInfo.getInteger(Constants.questionId));

        if (targetQuestionOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            Optional<Category> targetCategoryOptional =
                    categoryRepository.findById(newQuestionInfo.getInteger(Constants.categoryId));

            if (targetCategoryOptional.isEmpty()) {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            } else {
                Question targetQuestion = targetQuestionOptional.get();
                targetQuestion.setQuestionContent(newQuestionInfo.getString(Constants.questionContent));
                targetQuestion.setQuestionType(newQuestionInfo.getString(Constants.questionType));
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
