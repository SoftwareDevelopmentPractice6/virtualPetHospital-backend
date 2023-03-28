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
import pet.hospital.backend.common.helper.SearchJudgeHelper;
import pet.hospital.backend.exam.dao.QuestionInPaperRepository;
import pet.hospital.backend.exam.dao.StudentAnswerRepository;
import pet.hospital.backend.exam.dao.StudentResultRepository;
import pet.hospital.backend.exam.entity.QuestionInPaper;
import pet.hospital.backend.exam.entity.StudentAnswer;
import pet.hospital.backend.exam.entity.StudentResult;

@Service
public class StudentAnswerService {

    @Autowired
    StudentAnswerRepository studentAnswerRepository;

    @Autowired
    StudentResultRepository studentResultRepository;

    @Autowired
    QuestionInPaperRepository questionInPaperRepository;

    public JSONObject getStudentAnswers(
            String studentAnswerKeyword,
            Integer studentAnswerPoint,
            Integer questionInPaperId,
            Integer studentResultId) {
        JSONObject res = new JSONObject();
        res.put(
                Constants.studentAnswerList,
                JSONObject.parseArray(JSON.toJSONString(studentAnswerRepository.findAll().stream()
                        .filter(studentAnswer -> SearchJudgeHelper.softIncludes(
                                        studentAnswerKeyword, studentAnswer.getStudentAnswerContent())
                                && SearchJudgeHelper.softEquals(
                                        studentAnswerPoint, studentAnswer.getStudentAnswerPoint())
                                && SearchJudgeHelper.softEquals(
                                        questionInPaperId,
                                        studentAnswer
                                                .getStudentAnswerQuestionInPaper()
                                                .getQuestionInPaperId())
                                && SearchJudgeHelper.softEquals(
                                        studentResultId,
                                        studentAnswer
                                                .getStudentAnswerStudentResult()
                                                .getStudentResultId()))
                        .collect(Collectors.toList()))));
        return ResponseHelper.constructSuccessResponse(res);
    }

    public JSONObject addStudentAnswer(
            String studentAnswerContent, int studentAnswerPoint, int questionInPaperId, int studentResultId) {
        List<StudentAnswer> targetStudentAnswerList = studentAnswerRepository.findAll().stream()
                .filter(studentAnswer -> Objects.equals(
                                studentAnswer.getStudentAnswerQuestionInPaper().getQuestionInPaperId(),
                                questionInPaperId)
                        && Objects.equals(
                                studentAnswer.getStudentAnswerStudentResult().getStudentResultId(), studentResultId))
                .collect(Collectors.toList());

        if (Objects.equals(targetStudentAnswerList.size(), 0)) {
            Optional<QuestionInPaper> targetQuestionInPaperOptional =
                    questionInPaperRepository.findById(questionInPaperId);
            Optional<StudentResult> targetStudentResultOptional = studentResultRepository.findById(studentResultId);
            if (targetQuestionInPaperOptional.isEmpty() || targetStudentResultOptional.isEmpty()) {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            } else {
                StudentAnswer newStudentAnswer = new StudentAnswer();
                newStudentAnswer.setStudentAnswerContent(studentAnswerContent);
                newStudentAnswer.setStudentAnswerPoint(studentAnswerPoint);
                newStudentAnswer.setStudentAnswerQuestionInPaper(targetQuestionInPaperOptional.get());
                newStudentAnswer.setStudentAnswerStudentResult(targetStudentResultOptional.get());

                StudentAnswer addedStudentAnswer = studentAnswerRepository.saveAndFlush(newStudentAnswer);

                return ResponseHelper.constructSuccessResponse(addedStudentAnswer);
            }
        } else {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        }
    }

    public JSONObject updateStudentAnswer(
            int studentAnswerId,
            String studentAnswerContent,
            int studentAnswerPoint,
            int questionInPaperId,
            int studentResultId) {
        Optional<StudentAnswer> targetStudentAnswerOptional = studentAnswerRepository.findById(studentAnswerId);

        if (targetStudentAnswerOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            Optional<QuestionInPaper> targetQuestionInPaperOptional =
                    questionInPaperRepository.findById(questionInPaperId);
            Optional<StudentResult> targetStudentResultOptional = studentResultRepository.findById(studentResultId);

            List<StudentAnswer> targetStudentAnswerList = studentAnswerRepository.findAll().stream()
                    .filter(studentAnswer -> Objects.equals(
                                    studentAnswer
                                            .getStudentAnswerQuestionInPaper()
                                            .getQuestionInPaperId(),
                                    questionInPaperId)
                            && Objects.equals(
                                    studentAnswer
                                            .getStudentAnswerStudentResult()
                                            .getStudentResultId(),
                                    studentResultId)
                            && !Objects.equals(studentAnswer.getStudentAnswerId(), studentAnswerId))
                    .collect(Collectors.toList());

            if (targetQuestionInPaperOptional.isEmpty()
                    || targetStudentResultOptional.isEmpty()
                    || !Objects.equals(targetStudentAnswerList.size(), 0)) {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            } else {
                StudentAnswer targetStudentAnswer = targetStudentAnswerOptional.get();
                targetStudentAnswer.setStudentAnswerContent(studentAnswerContent);
                targetStudentAnswer.setStudentAnswerPoint(studentAnswerPoint);
                targetStudentAnswer.setStudentAnswerQuestionInPaper(targetQuestionInPaperOptional.get());
                targetStudentAnswer.setStudentAnswerStudentResult(targetStudentResultOptional.get());

                StudentAnswer updatedStudentAnswer = studentAnswerRepository.saveAndFlush(targetStudentAnswer);

                return ResponseHelper.constructSuccessResponse(updatedStudentAnswer);
            }
        }
    }

    public JSONObject deleteStudentAnswer(int studentAnswerId) {
        Optional<StudentAnswer> targetStudentAnswerOptional = studentAnswerRepository.findById(studentAnswerId);

        if (targetStudentAnswerOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            studentAnswerRepository.deleteById(studentAnswerId);

            if (studentAnswerRepository.findById(studentAnswerId).isEmpty()) {
                return ResponseHelper.constructSuccessResponse(targetStudentAnswerOptional.get());
            } else {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            }
        }
    }
}
