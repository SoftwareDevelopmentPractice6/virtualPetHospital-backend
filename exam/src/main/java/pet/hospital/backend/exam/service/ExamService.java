/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-20 13:22:41
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-04-22 21:08:35
 * @FilePath: /virtualPetHospital-backend/exam/src/main/java/pet/hospital/backend/exam/service/ExamService.java
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
import pet.hospital.backend.exam.entity.Exam;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    public JSONObject getExams(String examKeyword) {
        JSONObject res = new JSONObject();
        res.put(
                Constants.examList,
                JSONObject.parseArray(JSON.toJSONString(examRepository.findAll().stream()
                        .filter(exam -> SearchJudgeHelper.softIncludes(examKeyword, exam.getExamName()))
                        .collect(Collectors.toList()))));
        return ResponseHelper.constructSuccessResponse(res);
    }

    public JSONObject addExam(String examName) {
        List<Exam> targetExamList = examRepository.findAll().stream()
                .filter(exam -> Objects.equals(exam.getExamName(), examName))
                .collect(Collectors.toList());

        if (Objects.equals(targetExamList.size(), 0)) {
            Exam newExam = new Exam();
            newExam.setExamName(examName);

            Exam addedExam = examRepository.saveAndFlush(newExam);

            return ResponseHelper.constructSuccessResponse(addedExam);
        } else {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        }
    }

    public JSONObject updateExam(int examId, String examName) {
        Optional<Exam> targetExamOptional = examRepository.findById(examId);

        if (targetExamOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            List<Exam> targetExamList = examRepository.findAll().stream()
                    .filter(exam ->
                            Objects.equals(exam.getExamName(), examName) && !Objects.equals(exam.getExamId(), examId))
                    .collect(Collectors.toList());

            if (Objects.equals(targetExamList.size(), 0)) {
                Exam targetExam = targetExamOptional.get();
                targetExam.setExamName(examName);

                Exam updatedExam = examRepository.saveAndFlush(targetExam);

                return ResponseHelper.constructSuccessResponse(updatedExam);
            } else {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            }
        }
    }

    public JSONObject deleteExam(int examId) {
        Optional<Exam> targetExamOptional = examRepository.findById(examId);

        if (targetExamOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            examRepository.deleteById(examId);

            if (examRepository.findById(examId).isEmpty()) {
                return ResponseHelper.constructSuccessResponse(targetExamOptional.get());
            } else {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            }
        }
    }
}
