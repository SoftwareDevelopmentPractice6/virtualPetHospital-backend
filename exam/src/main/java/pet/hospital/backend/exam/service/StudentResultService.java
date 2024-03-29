/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-20 15:02:00
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-04-22 21:09:01
 * @FilePath: /virtualPetHospital-backend/exam/src/main/java/pet/hospital/backend/exam/service/StudentResultService.java
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
import pet.hospital.backend.exam.dao.ExamSessionRepository;
import pet.hospital.backend.exam.dao.StudentResultRepository;
import pet.hospital.backend.exam.entity.ExamSession;
import pet.hospital.backend.exam.entity.StudentResult;

@Service
public class StudentResultService {

    @Autowired
    private StudentResultRepository studentResultRepository;

    @Autowired
    private ExamSessionRepository examSessionRepository;

    public JSONObject getStudentResults(
            Integer studentResultStudentId, Integer studentResultScore, Integer examSessionId) {
        JSONObject res = new JSONObject();
        res.put(
                Constants.studentResultList,
                JSONObject.parseArray(JSON.toJSONString(studentResultRepository.findAll().stream()
                        .filter(studentResult -> SearchJudgeHelper.softEquals(
                                        studentResultStudentId, studentResult.getStudentResultStudentId())
                                && SearchJudgeHelper.softEquals(
                                        studentResultScore, studentResult.getStudentResultScore())
                                && SearchJudgeHelper.softEquals(
                                        examSessionId,
                                        studentResult
                                                .getStudentResultExamSession()
                                                .getExamSessionId()))
                        .collect(Collectors.toList()))));
        return ResponseHelper.constructSuccessResponse(res);
    }

    public JSONObject addStudentResult(int studentResultStudentId, int studentResultScore, int examSessionId) {
        List<StudentResult> targetStudentResultList = studentResultRepository.findAll().stream()
                .filter(studentResult -> Objects.equals(
                                studentResult.getStudentResultStudentId(), studentResultStudentId)
                        && Objects.equals(
                                studentResult.getStudentResultExamSession().getExamSessionId(), examSessionId))
                .collect(Collectors.toList());

        if (Objects.equals(targetStudentResultList.size(), 0)) {
            Optional<ExamSession> targetExamSessionOptional = examSessionRepository.findById(examSessionId);
            if (targetExamSessionOptional.isEmpty()) {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            } else {
                StudentResult newStudentResult = new StudentResult();
                newStudentResult.setStudentResultStudentId(studentResultStudentId);
                newStudentResult.setStudentResultScore(studentResultScore);
                newStudentResult.setStudentResultExamSession(targetExamSessionOptional.get());

                StudentResult addedStudentResult = studentResultRepository.saveAndFlush(newStudentResult);

                return ResponseHelper.constructSuccessResponse(addedStudentResult);
            }
        } else {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        }
    }

    public JSONObject updateStudentResult(
            int studentResultId, int studentResultStudentId, int studentResultScore, int examSessionId) {
        Optional<StudentResult> targetStudentResultOptional = studentResultRepository.findById(studentResultId);

        if (targetStudentResultOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            Optional<ExamSession> targetExamSessionOptional = examSessionRepository.findById(examSessionId);

            List<StudentResult> targetStudentResultList = studentResultRepository.findAll().stream()
                    .filter(studentResult -> Objects.equals(
                                    studentResult.getStudentResultStudentId(), studentResultStudentId)
                            && Objects.equals(
                                    studentResult.getStudentResultExamSession().getExamSessionId(), examSessionId)
                            && !Objects.equals(studentResult.getStudentResultId(), studentResultStudentId))
                    .collect(Collectors.toList());

            if (targetExamSessionOptional.isEmpty() || !Objects.equals(targetStudentResultList.size(), 0)) {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            } else {
                StudentResult targetStudentResult = targetStudentResultOptional.get();
                targetStudentResult.setStudentResultStudentId(studentResultStudentId);
                targetStudentResult.setStudentResultScore(studentResultScore);
                targetStudentResult.setStudentResultExamSession(targetExamSessionOptional.get());

                StudentResult updatedStudentResult = studentResultRepository.saveAndFlush(targetStudentResult);

                return ResponseHelper.constructSuccessResponse(updatedStudentResult);
            }
        }
    }

    public JSONObject deleteStudentResult(int studentResultId) {
        Optional<StudentResult> targetStudentResultOptional = studentResultRepository.findById(studentResultId);

        if (targetStudentResultOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            studentResultRepository.deleteById(studentResultId);

            if (studentResultRepository.findById(studentResultId).isEmpty()) {
                return ResponseHelper.constructSuccessResponse(targetStudentResultOptional.get());
            } else {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            }
        }
    }
}
