/*
 * @Author: pikapikapi pikapikapi_kaori@icloud.com
 * @Date: 2023-03-22 14:01:53
 * @LastEditors: pikapikapi pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-22 15:21:47
 * @FilePath: /virtualPetHospital-backend/intermediator/src/main/java/pet/hospital/backend/intermediator/service/ExamService.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.intermediator.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pet.hospital.backend.intermediator.constant.Constants;
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

    public ResponseData<JSONObject> addPaper(String paperName, String paperDuration, String paperTotalScore, int examId) {
        String api = "api/exam/paper/add";

        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add(Constants.paperName, paperName);
        requestEntity.add(Constants.paperDuration, paperDuration);
        requestEntity.add(Constants.paperTotalScore, paperTotalScore);
        requestEntity.add(Constants.examId, String.valueOf(examId));

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.postForObject(Constants.examModuleBaseUrl + api, requestEntity, JSONObject.class));
    }

    public ResponseData<JSONObject> updatePaper(int paperId, String paperName, String paperDuration, String paperTotalScore, int examId) {
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

    public ResponseData<JSONObject> getPapers(String paperNameKeyword, String paperDuration, String paperTotalScore, Integer examId) {
        String api = "api/exam/paper/get";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.examModuleBaseUrl + api)
                .queryParam(Constants.paperName, paperNameKeyword)
                .queryParam(Constants.paperDuration, paperDuration)
                .queryParam(Constants.paperTotalScore, paperTotalScore)
                .queryParam(Constants.examId, examId);

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.getForObject(uriBuilder.toUriString(), JSONObject.class));
    }

    public ResponseData<JSONObject> addExamSession(String examSessionStartTime, String examSessionEndTime, int paperId) {
        String api = "api/exam/exam-session/add";

        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add(Constants.examSessionStartTime, examSessionStartTime);
        requestEntity.add(Constants.examSessionEndTime, examSessionEndTime);
        requestEntity.add(Constants.paperId, String.valueOf(paperId));

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.postForObject(Constants.examModuleBaseUrl + api, requestEntity, JSONObject.class));
    }

    public ResponseData<JSONObject> updateExamSession(int examSessionId, String examSessionStartTime, String examSessionEndTime, int paperId) {
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

    public ResponseData<JSONObject> getExamSessions(String examSessionStartTime, String examSessionEndTime, Integer paperId) {
        String api = "api/exam/exam-session/get";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.examModuleBaseUrl + api)
                .queryParam(Constants.examSessionStartTime, examSessionStartTime)
                .queryParam(Constants.examSessionEndTime, examSessionEndTime)
                .queryParam(Constants.paperId, paperId);

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.getForObject(uriBuilder.toUriString(), JSONObject.class));
    }
}
