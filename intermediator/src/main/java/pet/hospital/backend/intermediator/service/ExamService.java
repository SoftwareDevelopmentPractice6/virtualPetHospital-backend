/*
 * @Author: pikapikapi pikapikapi_kaori@icloud.com
 * @Date: 2023-03-22 14:01:53
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-23 15:11:41
 * @FilePath: /virtualPetHospital-backend/intermediator/src/main/java/pet/hospital/backend/intermediator/service/ExamService.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.intermediator.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pet.hospital.backend.intermediator.constant.Constants;
import pet.hospital.backend.intermediator.helper.EnumCode;
import pet.hospital.backend.intermediator.helper.ResponseData;
import pet.hospital.backend.intermediator.helper.ResponseHelper;

@Service
public class ExamService {
    @Autowired
    private RestTemplate restTemplate;

    public ResponseData<JSONObject> addExam(String examName) {
        String api = "api/exam/exam/add";

        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add(Constants.examName, examName);

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.postForObject(Constants.examModuleBaseUrl + api, requestEntity, JSONObject.class));
    }

    public ResponseData<JSONObject> updateExam(int examId, String examName) {
        String api = "api/exam/exam/update";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.examModuleBaseUrl + api)
                .queryParam(Constants.examId, examId)
                .queryParam(Constants.examName, examName);

        return ResponseHelper.forwardResponseDataDirectly(restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.PUT, null, JSONObject.class)
                .getBody());
    }

    public ResponseData<JSONObject> deleteExam(int examId) {
        String api = "api/exam/exam/delete";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.examModuleBaseUrl + api)
                .queryParam(Constants.examId, examId);

        return ResponseHelper.forwardResponseDataDirectly(restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.DELETE, null, JSONObject.class)
                .getBody());
    }

    public ResponseData<JSONObject> getExams(String examNameKeyword) {
        String api = "api/exam/exam/get";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.examModuleBaseUrl + api)
                .queryParam(Constants.examNameKeyword, examNameKeyword);

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.getForObject(uriBuilder.toUriString(), JSONObject.class));
    }

    public ResponseData<JSONObject> addPaper(
            String paperName, String paperDuration, String paperTotalScore, int examId) {
        String api = "api/exam/paper/add";

        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add(Constants.paperName, paperName);
        requestEntity.add(Constants.paperDuration, paperDuration);
        requestEntity.add(Constants.paperTotalScore, paperTotalScore);
        requestEntity.add(Constants.examId, String.valueOf(examId));

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.postForObject(Constants.examModuleBaseUrl + api, requestEntity, JSONObject.class));
    }

    public ResponseData<JSONObject> updatePaper(
            int paperId, String paperName, String paperDuration, String paperTotalScore, int examId) {
        String api = "api/exam/paper/update";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.examModuleBaseUrl + api)
                .queryParam(Constants.paperId, paperId)
                .queryParam(Constants.paperName, paperName)
                .queryParam(Constants.paperDuration, paperDuration)
                .queryParam(Constants.paperTotalScore, paperTotalScore)
                .queryParam(Constants.examId, examId);

        return ResponseHelper.forwardResponseDataDirectly(restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.PUT, null, JSONObject.class)
                .getBody());
    }

    public ResponseData<JSONObject> deletePaper(int paperId) {
        String api = "api/exam/paper/delete";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.examModuleBaseUrl + api)
                .queryParam(Constants.paperId, paperId);

        return ResponseHelper.forwardResponseDataDirectly(restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.DELETE, null, JSONObject.class)
                .getBody());
    }

    public ResponseData<JSONObject> getPapers(
            String paperNameKeyword, String paperDuration, String paperTotalScore, Integer examId) {
        String api = "api/exam/paper/get";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.examModuleBaseUrl + api)
                .queryParam(Constants.paperName, paperNameKeyword)
                .queryParam(Constants.paperDuration, paperDuration)
                .queryParam(Constants.paperTotalScore, paperTotalScore)
                .queryParam(Constants.examId, examId);

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.getForObject(uriBuilder.toUriString(), JSONObject.class));
    }

    public ResponseData<JSONObject> addExamSession(
            String examSessionStartTime, String examSessionEndTime, int paperId) {
        String api = "api/exam/exam-session/add";

        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add(Constants.examSessionStartTime, examSessionStartTime);
        requestEntity.add(Constants.examSessionEndTime, examSessionEndTime);
        requestEntity.add(Constants.paperId, String.valueOf(paperId));

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.postForObject(Constants.examModuleBaseUrl + api, requestEntity, JSONObject.class));
    }

    public ResponseData<JSONObject> updateExamSession(
            int examSessionId, String examSessionStartTime, String examSessionEndTime, int paperId) {
        String api = "api/exam/exam-session/update";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.examModuleBaseUrl + api)
                .queryParam(Constants.examSessionId, examSessionId)
                .queryParam(Constants.examSessionStartTime, examSessionStartTime)
                .queryParam(Constants.examSessionEndTime, examSessionEndTime)
                .queryParam(Constants.paperId, paperId);

        return ResponseHelper.forwardResponseDataDirectly(restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.PUT, null, JSONObject.class)
                .getBody());
    }

    public ResponseData<JSONObject> deleteExamSession(int examSessionId) {
        String api = "api/exam/exam-session/delete";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.examModuleBaseUrl + api)
                .queryParam(Constants.examSessionId, examSessionId);

        return ResponseHelper.forwardResponseDataDirectly(restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.DELETE, null, JSONObject.class)
                .getBody());
    }

    public ResponseData<JSONObject> getExamSessions(
            String examSessionStartTime, String examSessionEndTime, Integer paperId) {
        String api = "api/exam/exam-session/get";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.examModuleBaseUrl + api)
                .queryParam(Constants.examSessionStartTime, examSessionStartTime)
                .queryParam(Constants.examSessionEndTime, examSessionEndTime)
                .queryParam(Constants.paperId, paperId);

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.getForObject(uriBuilder.toUriString(), JSONObject.class));
    }

    public ResponseData<JSONObject> addStudentResult(
            int studentResultStudentId, int studentResultScore, int examSessionId) {
        String api = "api/exam/student-result/add";

        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add(Constants.studentResultStudentId, String.valueOf(studentResultStudentId));
        requestEntity.add(Constants.studentResultScore, String.valueOf(studentResultScore));
        requestEntity.add(Constants.examSessionId, String.valueOf(examSessionId));

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.postForObject(Constants.examModuleBaseUrl + api, requestEntity, JSONObject.class));
    }

    public ResponseData<JSONObject> updateStudentResult(
            int studentResultId, int studentResultStudentId, int studentResultScore, int examSessionId) {
        String api = "api/exam/student-result/update";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.examModuleBaseUrl + api)
                .queryParam(Constants.studentResultId, studentResultId)
                .queryParam(Constants.studentResultStudentId, studentResultStudentId)
                .queryParam(Constants.studentResultScore, studentResultScore)
                .queryParam(Constants.examSessionId, examSessionId);

        return ResponseHelper.forwardResponseDataDirectly(restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.PUT, null, JSONObject.class)
                .getBody());
    }

    public ResponseData<JSONObject> deleteStudentResult(int studentResultId) {
        String api = "api/exam/student-result/delete";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.examModuleBaseUrl + api)
                .queryParam(Constants.studentResultId, studentResultId);

        return ResponseHelper.forwardResponseDataDirectly(restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.DELETE, null, JSONObject.class)
                .getBody());
    }

    public ResponseData<JSONObject> getStudentResults(
            Integer studentResultStudentId, Integer studentResultScore, Integer examSessionId) {
        String api = "api/exam/student-result/get";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.examModuleBaseUrl + api)
                .queryParam(Constants.studentResultStudentId, studentResultStudentId)
                .queryParam(Constants.studentResultScore, studentResultScore)
                .queryParam(Constants.examSessionId, examSessionId);

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.getForObject(uriBuilder.toUriString(), JSONObject.class));
    }

    public ResponseData<JSONObject> addCategory(String categoryName) {
        String api = "api/exam/category/add";

        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add(Constants.categoryName, categoryName);

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.postForObject(Constants.examModuleBaseUrl + api, requestEntity, JSONObject.class));
    }

    public ResponseData<JSONObject> updateCategory(int categoryId, String categoryName) {
        String api = "api/exam/category/update";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.examModuleBaseUrl + api)
                .queryParam(Constants.categoryId, categoryId)
                .queryParam(Constants.categoryName, categoryName);

        return ResponseHelper.forwardResponseDataDirectly(restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.PUT, null, JSONObject.class)
                .getBody());
    }

    public ResponseData<JSONObject> deleteCategory(int categoryId) {
        String api = "api/exam/category/delete";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.examModuleBaseUrl + api)
                .queryParam(Constants.categoryId, categoryId);

        return ResponseHelper.forwardResponseDataDirectly(restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.DELETE, null, JSONObject.class)
                .getBody());
    }

    public ResponseData<JSONObject> getCategories(String categoryNameKeyword) {
        String api = "api/exam/category/get";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.examModuleBaseUrl + api)
                .queryParam(Constants.categoryNameKeyword, categoryNameKeyword);

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.getForObject(uriBuilder.toUriString(), JSONObject.class));
    }

    public ResponseData<JSONObject> addQuestion(String questionContent, String questionType, int categoryId) {
        String api = "api/exam/question/add";

        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add(Constants.questionContent, questionContent);
        requestEntity.add(Constants.questionType, questionType);
        requestEntity.add(Constants.categoryId, String.valueOf(categoryId));

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.postForObject(Constants.examModuleBaseUrl + api, requestEntity, JSONObject.class));
    }

    public ResponseData<JSONObject> updateQuestion(
            int questionId, String questionContent, String questionType, int categoryId) {
        String api = "api/exam/question/update";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.examModuleBaseUrl + api)
                .queryParam(Constants.questionId, questionId)
                .queryParam(Constants.questionContent, questionContent)
                .queryParam(Constants.questionType, questionType)
                .queryParam(Constants.categoryId, categoryId);

        return ResponseHelper.forwardResponseDataDirectly(restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.PUT, null, JSONObject.class)
                .getBody());
    }

    public ResponseData<JSONObject> deleteQuestion(int questionId) {
        String api = "api/exam/question/delete";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.examModuleBaseUrl + api)
                .queryParam(Constants.questionId, questionId);

        return ResponseHelper.forwardResponseDataDirectly(restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.DELETE, null, JSONObject.class)
                .getBody());
    }

    public ResponseData<JSONObject> getQuestions(
            String questionContentKeyword, String questionType, Integer categoryId) {
        String api = "api/exam/question/get";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.examModuleBaseUrl + api)
                .queryParam(Constants.questionContentKeyword, questionContentKeyword)
                .queryParam(Constants.questionType, questionType)
                .queryParam(Constants.categoryId, categoryId);

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.getForObject(uriBuilder.toUriString(), JSONObject.class));
    }

    public ResponseData<JSONObject> getExaminations(
            String examNameKeyword,
            String paperNameKeyword,
            String paperDuration,
            String paperTotalScore,
            String examSessionStartTime,
            String examSessionEndTime) {
        JSONObject examResData = this.getExams(examNameKeyword).getData();
        JSONObject paperResData = this.getPapers(paperNameKeyword, paperDuration, paperTotalScore, null)
                .getData();
        JSONObject examSessionResData = this.getExamSessions(examSessionStartTime, examSessionEndTime, null)
                .getData();

        if (examResData == null || paperResData == null || examSessionResData == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        JSONArray examRes = examResData.getJSONArray(Constants.examList);
        JSONArray paperRes = paperResData.getJSONArray(Constants.paperList);
        JSONArray examSessionRes = examSessionResData.getJSONArray(Constants.examSessionList);

        examSessionRes.removeIf(examSession -> {
            List<Boolean> judger = new ArrayList<>();

            JSONObject examSessionPaperJsonObject =
                    JSON.parseObject(JSON.toJSONString(examSession)).getJSONObject(Constants.examSessionPaper);

            paperRes.stream().anyMatch(paper -> {
                if (Objects.equals(
                        examSessionPaperJsonObject.getInteger(Constants.paperId),
                        JSON.parseObject(JSON.toJSONString(paper)).getInteger(Constants.paperId))) {
                    judger.add(true);
                    return true;
                }
                return false;
            });

            examRes.stream().anyMatch(exam -> {
                if (Objects.equals(
                        examSessionPaperJsonObject
                                .getJSONObject(Constants.paperExam)
                                .getInteger(Constants.examId),
                        JSON.parseObject(JSON.toJSONString(exam)).getInteger(Constants.examId))) {
                    judger.add(true);
                    return true;
                }
                return false;
            });

            return Objects.equals(judger.size(), 2) ? !(judger.get(0) && judger.get(1)) : true;
        });

        JSONObject res = new JSONObject();
        res.put(Constants.examSessionList, examSessionRes);

        return ResponseData.success(res);
    }

    public ResponseData<JSONObject> deleteExamination(int examId) {
        JSONObject paperResData = this.getPapers(null, null, null, examId).getData();

        if (paperResData == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        JSONObject examSessionData = this.getExamSessions(
                        null,
                        null,
                        paperResData
                                .getJSONArray(Constants.paperList)
                                .getJSONObject(0)
                                .getInteger(Constants.paperId))
                .getData();

        if (examSessionData == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        return this.deleteExamSession(examSessionData
                .getJSONArray(Constants.examSessionList)
                .getJSONObject(0)
                .getInteger(Constants.examSessionId));
    }

    public ResponseData<JSONObject> updateExamination(
            int examId,
            String examName,
            String paperName,
            String paperDuration,
            String paperTotalScore,
            String examSessionStartTime,
            String examSessionEndTime) {
        JSONObject paperResData = this.getPapers(null, null, null, examId).getData();

        if (paperResData == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        int paperId =
                paperResData.getJSONArray(Constants.paperList).getJSONObject(0).getInteger(Constants.paperId);

        JSONObject examSessionData = this.getExamSessions(null, null, paperId).getData();

        if (examSessionData == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        JSONObject previousExamSessionData =
                examSessionData.getJSONArray(Constants.examSessionList).getJSONObject(0);
        JSONObject previousPaperData = previousExamSessionData.getJSONObject(Constants.examSessionPaper);
        JSONObject previousExamData = previousPaperData.getJSONObject(Constants.paperExam);

        int examSessionId = previousExamSessionData.getInteger(Constants.examSessionId);

        JSONObject examUpdateRes = this.updateExam(examId, examName).getData();
        JSONObject paperUpdateRes = this.updatePaper(paperId, paperName, paperDuration, paperTotalScore, examId)
                .getData();
        JSONObject examSessionUpdateRes = this.updateExamSession(
                        examSessionId, examSessionStartTime, examSessionEndTime, paperId)
                .getData();

        if (examUpdateRes == null || paperUpdateRes == null || examSessionUpdateRes == null) {
            this.updateExam(examId, previousExamData.getString(Constants.examName));
            this.updatePaper(
                    paperId,
                    previousPaperData.getString(Constants.paperName),
                    previousPaperData.getString(Constants.paperDuration),
                    previousPaperData.getString(Constants.paperTotalScore),
                    examId);
            this.updateExamSession(
                    examSessionId,
                    previousExamSessionData.getString(Constants.examSessionStartTime),
                    previousExamSessionData.getString(Constants.examSessionEndTime),
                    paperId);
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        } else {
            return ResponseData.success(previousExamSessionData);
        }
    }

    public ResponseData<JSONObject> addExamination(
            String examName,
            String paperName,
            String paperDuration,
            String paperTotalScore,
            String examSessionStartTime,
            String examSessionEndTime) {
        JSONObject addExamRes = this.addExam(examName).getData();

        if (addExamRes == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        int examId = addExamRes.getInteger(Constants.examId);

        JSONObject addPaperRes =
                this.addPaper(paperName, paperDuration, paperTotalScore, examId).getData();

        if (addPaperRes == null) {
            this.deleteExam(examId);
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        int paperId = addPaperRes.getInteger(Constants.paperId);

        JSONObject addExamSessionRes = this.addExamSession(examSessionStartTime, examSessionEndTime, paperId)
                .getData();

        if (addExamSessionRes == null) {
            this.deleteExam(examId);
            this.deletePaper(paperId);
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        } else {
            return ResponseData.success(addExamSessionRes);
        }
    }
}
