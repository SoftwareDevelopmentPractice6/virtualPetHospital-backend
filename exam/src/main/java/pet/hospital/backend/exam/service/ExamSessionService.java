/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-20 14:16:42
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-04-22 21:08:39
 * @FilePath: /virtualPetHospital-backend/exam/src/main/java/pet/hospital/backend/exam/service/ExamSessionService.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.exam.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.Date;
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
import pet.hospital.backend.exam.dao.PaperRepository;
import pet.hospital.backend.exam.entity.ExamSession;
import pet.hospital.backend.exam.entity.Paper;

@Service
public class ExamSessionService {

    @Autowired
    private ExamSessionRepository examSessionRepository;

    @Autowired
    private PaperRepository paperRepository;

    public JSONObject getExamSessions(Date examSessionStartTime, Date examSessionEndTime, Integer paperId) {
        JSONObject res = new JSONObject();
        res.put(
                Constants.examSessionList,
                JSONObject.parseArray(JSON.toJSONString(examSessionRepository.findAll().stream()
                        .filter(examSession -> SearchJudgeHelper.softEquals(
                                        examSessionStartTime, examSession.getExamSessionStartTime())
                                && SearchJudgeHelper.softEquals(examSessionEndTime, examSession.getExamSessionEndTime())
                                && SearchJudgeHelper.softEquals(
                                        paperId,
                                        examSession.getExamSessionPaper().getPaperId()))
                        .collect(Collectors.toList()))));
        return ResponseHelper.constructSuccessResponse(res);
    }

    public JSONObject addExamSession(Date examSessionStartTime, Date examSessionEndTime, int paperId) {

        List<ExamSession> targetExamSessionList = examSessionRepository.findAll().stream()
                .filter(examSession ->
                        Objects.equals(examSession.getExamSessionPaper().getPaperId(), paperId))
                .collect(Collectors.toList());

        if (Objects.equals(targetExamSessionList.size(), 0)) {
            Optional<Paper> targetPaperOptional = paperRepository.findById(paperId);
            if (targetPaperOptional.isEmpty()) {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            } else {
                ExamSession newExamSession = new ExamSession();
                newExamSession.setExamSessionStartTime(examSessionStartTime);
                newExamSession.setExamSessionEndTime(examSessionEndTime);
                newExamSession.setExamSessionPaper(targetPaperOptional.get());

                ExamSession addedExamSession = examSessionRepository.saveAndFlush(newExamSession);

                return ResponseHelper.constructSuccessResponse(addedExamSession);
            }
        } else {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        }
    }

    public JSONObject updateExamSession(
            int examSessionId, Date examSessionStartTime, Date examSessionEndTime, int paperId) {
        Optional<ExamSession> targetExamSessionOptional = examSessionRepository.findById(examSessionId);

        if (targetExamSessionOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            List<ExamSession> targetExamSessionList = examSessionRepository.findAll().stream()
                    .filter(examSession ->
                            Objects.equals(examSession.getExamSessionPaper().getPaperId(), paperId)
                                    && !Objects.equals(examSession.getExamSessionId(), examSessionId))
                    .collect(Collectors.toList());

            Optional<Paper> targetPaperOptional = paperRepository.findById(paperId);

            if (targetPaperOptional.isEmpty() || !Objects.equals(targetExamSessionList.size(), 0)) {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            } else {
                ExamSession targetExamSession = targetExamSessionOptional.get();
                targetExamSession.setExamSessionStartTime(examSessionStartTime);
                targetExamSession.setExamSessionEndTime(examSessionEndTime);
                targetExamSession.setExamSessionPaper(targetPaperOptional.get());

                ExamSession updatedExamSession = examSessionRepository.saveAndFlush(targetExamSession);

                return ResponseHelper.constructSuccessResponse(updatedExamSession);
            }
        }
    }

    public JSONObject deleteExamSession(int examSessionId) {
        Optional<ExamSession> targetExamSessionOptional = examSessionRepository.findById(examSessionId);

        if (targetExamSessionOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            examSessionRepository.deleteById(examSessionId);

            if (examSessionRepository.findById(examSessionId).isEmpty()) {
                return ResponseHelper.constructSuccessResponse(targetExamSessionOptional.get());
            } else {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            }
        }
    }
}
