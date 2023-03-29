/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-27 15:44:31
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-27 17:47:06
 * @FilePath: /virtualPetHospital-backend/intermediator/src/main/java/pet/hospital/backend/intermediator/service/DiseaseService.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.intermediator.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;
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

@Service
public class DiseaseService {
    @Autowired
    private RestTemplate restTemplate;

    public ResponseData<JSONObject> getAdmissions(Integer admissionId, String admissionKeyword) {
        String api = "api/disease/admission/get";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(
                        Constants.medicalRecordManagementModuleBaseUrl + api)
                .queryParam(Constants.diseaseAdmissionId, admissionId)
                .queryParam(Constants.admissionKeyword, admissionKeyword);

        JSONObject apiRes = restTemplate.getForObject(uriBuilder.toUriString(), JSONObject.class);

        if (apiRes == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        if (Objects.equals(apiRes.getInteger(Constants.code), EnumCode.SUCCESS.getCode())) {
            return ResponseData.success(apiRes.getJSONObject(Constants.data));
        } else {
            return ResponseData.error(EnumCode.getEnumCodeType(apiRes.getInteger(Constants.code)));
        }
    }

    public ResponseData<JSONObject> addAdmission(
            String admissionContent, String admissionPhoto, String admissionVideo) {
        String api = "api/disease/admission/add";

        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add(Constants.admissionContent, admissionContent);
        requestEntity.add(Constants.admissionPhoto, admissionPhoto);
        requestEntity.add(Constants.admissionVideo, admissionVideo);

        JSONObject apiRes = restTemplate.postForObject(
                Constants.medicalRecordManagementModuleBaseUrl + api, requestEntity, JSONObject.class);

        if (apiRes == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        if (Objects.equals(apiRes.getInteger(Constants.code), EnumCode.SUCCESS.getCode())) {
            return ResponseData.success(apiRes.getJSONObject(Constants.data));
        } else {
            return ResponseData.error(EnumCode.getEnumCodeType(apiRes.getInteger(Constants.code)));
        }
    }

    public ResponseData<JSONObject> updateAdmission(
            int admissionId, String admissionContent, String admissionPhoto, String admissionVideo) {
        String api = "api/disease/admission/update";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(
                        Constants.medicalRecordManagementModuleBaseUrl + api)
                .queryParam(Constants.diseaseAdmissionId, admissionId)
                .queryParam(Constants.admissionContent, admissionContent)
                .queryParam(Constants.admissionPhoto, admissionPhoto)
                .queryParam(Constants.admissionVideo, admissionVideo);

        JSONObject apiRes = restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.PUT, null, JSONObject.class)
                .getBody();

        if (apiRes == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        if (Objects.equals(apiRes.getInteger(Constants.code), EnumCode.SUCCESS.getCode())) {
            return ResponseData.success(apiRes.getJSONObject(Constants.data));
        } else {
            return ResponseData.error(EnumCode.getEnumCodeType(apiRes.getInteger(Constants.code)));
        }
    }

    public ResponseData<JSONObject> deleteAdmission(int admissionId) {
        String api = "api/disease/admission/delete";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(
                        Constants.medicalRecordManagementModuleBaseUrl + api)
                .queryParam(Constants.diseaseAdmissionId, admissionId);

        JSONObject apiRes = restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.DELETE, null, JSONObject.class)
                .getBody();

        if (apiRes == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        if (Objects.equals(apiRes.getInteger(Constants.code), EnumCode.SUCCESS.getCode())) {
            return ResponseData.success(apiRes.getJSONObject(Constants.data));
        } else {
            return ResponseData.error(EnumCode.getEnumCodeType(apiRes.getInteger(Constants.code)));
        }
    }

    public ResponseData<JSONObject> getCaseChecks(Integer caseCheckId, String caseCheckKeyword) {
        String api = "api/disease/case-check/get";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(
                        Constants.medicalRecordManagementModuleBaseUrl + api)
                .queryParam(Constants.caseCheckId, caseCheckId)
                .queryParam(Constants.caseCheckKeyword, caseCheckKeyword);

        JSONObject apiRes = restTemplate.getForObject(uriBuilder.toUriString(), JSONObject.class);

        if (apiRes == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        if (Objects.equals(apiRes.getInteger(Constants.code), EnumCode.SUCCESS.getCode())) {
            return ResponseData.success(apiRes.getJSONObject(Constants.data));
        } else {
            return ResponseData.error(EnumCode.getEnumCodeType(apiRes.getInteger(Constants.code)));
        }
    }

    public ResponseData<JSONObject> addCaseCheck(
            String caseCheckContent, String caseCheckPhoto, String caseCheckVideo) {
        String api = "api/disease/case-check/add";

        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add(Constants.caseCheckContent, caseCheckContent);
        requestEntity.add(Constants.caseCheckPhoto, caseCheckPhoto);
        requestEntity.add(Constants.caseCheckVideo, caseCheckVideo);

        JSONObject apiRes = restTemplate.postForObject(
                Constants.medicalRecordManagementModuleBaseUrl + api, requestEntity, JSONObject.class);

        if (apiRes == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        if (Objects.equals(apiRes.getInteger(Constants.code), EnumCode.SUCCESS.getCode())) {
            return ResponseData.success(apiRes.getJSONObject(Constants.data));
        } else {
            return ResponseData.error(EnumCode.getEnumCodeType(apiRes.getInteger(Constants.code)));
        }
    }

    public ResponseData<JSONObject> updateCaseCheck(
            int caseCheckId, String caseCheckContent, String caseCheckPhoto, String caseCheckVideo) {
        String api = "api/disease/case-check/update";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(
                        Constants.medicalRecordManagementModuleBaseUrl + api)
                .queryParam(Constants.caseCheckId, caseCheckId)
                .queryParam(Constants.caseCheckContent, caseCheckContent)
                .queryParam(Constants.caseCheckPhoto, caseCheckPhoto)
                .queryParam(Constants.caseCheckVideo, caseCheckVideo);

        JSONObject apiRes = restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.PUT, null, JSONObject.class)
                .getBody();

        if (apiRes == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        if (Objects.equals(apiRes.getInteger(Constants.code), EnumCode.SUCCESS.getCode())) {
            return ResponseData.success(apiRes.getJSONObject(Constants.data));
        } else {
            return ResponseData.error(EnumCode.getEnumCodeType(apiRes.getInteger(Constants.code)));
        }
    }

    public ResponseData<JSONObject> deleteCaseCheck(int caseCheckId) {
        String api = "api/disease/case-check/delete";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(
                        Constants.medicalRecordManagementModuleBaseUrl + api)
                .queryParam(Constants.caseCheckId, caseCheckId);

        JSONObject apiRes = restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.DELETE, null, JSONObject.class)
                .getBody();

        if (apiRes == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        if (Objects.equals(apiRes.getInteger(Constants.code), EnumCode.SUCCESS.getCode())) {
            return ResponseData.success(apiRes.getJSONObject(Constants.data));
        } else {
            return ResponseData.error(EnumCode.getEnumCodeType(apiRes.getInteger(Constants.code)));
        }
    }

    public ResponseData<JSONObject> getDiagnosticResults(Integer diagnosticResultId, String diagnosticResultKeyword) {
        String api = "api/disease/diagnostic-result/get";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(
                        Constants.medicalRecordManagementModuleBaseUrl + api)
                .queryParam(Constants.diagnosticResultId, diagnosticResultId)
                .queryParam(Constants.diagnosticResultKeyword, diagnosticResultKeyword);

        JSONObject apiRes = restTemplate.getForObject(uriBuilder.toUriString(), JSONObject.class);

        if (apiRes == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        if (Objects.equals(apiRes.getInteger(Constants.code), EnumCode.SUCCESS.getCode())) {
            return ResponseData.success(apiRes.getJSONObject(Constants.data));
        } else {
            return ResponseData.error(EnumCode.getEnumCodeType(apiRes.getInteger(Constants.code)));
        }
    }

    public ResponseData<JSONObject> addDiagnosticResult(
            String diagnosticResultContent, String diagnosticResultPhoto, String diagnosticResultVideo) {
        String api = "api/disease/diagnostic-result/add";

        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add(Constants.diagnosticResultContent, diagnosticResultContent);
        requestEntity.add(Constants.diagnosticResultPhoto, diagnosticResultPhoto);
        requestEntity.add(Constants.diagnosticResultVideo, diagnosticResultVideo);

        JSONObject apiRes = restTemplate.postForObject(
                Constants.medicalRecordManagementModuleBaseUrl + api, requestEntity, JSONObject.class);

        if (apiRes == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        if (Objects.equals(apiRes.getInteger(Constants.code), EnumCode.SUCCESS.getCode())) {
            return ResponseData.success(apiRes.getJSONObject(Constants.data));
        } else {
            return ResponseData.error(EnumCode.getEnumCodeType(apiRes.getInteger(Constants.code)));
        }
    }

    public ResponseData<JSONObject> updateDiagnosticResult(
            int diagnosticResultId,
            String diagnosticResultContent,
            String diagnosticResultPhoto,
            String diagnosticResultVideo) {
        String api = "api/disease/diagnostic-result/update";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(
                        Constants.medicalRecordManagementModuleBaseUrl + api)
                .queryParam(Constants.diagnosticResultId, diagnosticResultId)
                .queryParam(Constants.diagnosticResultContent, diagnosticResultContent)
                .queryParam(Constants.diagnosticResultPhoto, diagnosticResultPhoto)
                .queryParam(Constants.diagnosticResultVideo, diagnosticResultVideo);

        JSONObject apiRes = restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.PUT, null, JSONObject.class)
                .getBody();

        if (apiRes == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        if (Objects.equals(apiRes.getInteger(Constants.code), EnumCode.SUCCESS.getCode())) {
            return ResponseData.success(apiRes.getJSONObject(Constants.data));
        } else {
            return ResponseData.error(EnumCode.getEnumCodeType(apiRes.getInteger(Constants.code)));
        }
    }

    public ResponseData<JSONObject> deleteDiagnosticResult(int diagnosticResultId) {
        String api = "api/disease/diagnostic-result/delete";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(
                        Constants.medicalRecordManagementModuleBaseUrl + api)
                .queryParam(Constants.diagnosticResultId, diagnosticResultId);

        JSONObject apiRes = restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.DELETE, null, JSONObject.class)
                .getBody();

        if (apiRes == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        if (Objects.equals(apiRes.getInteger(Constants.code), EnumCode.SUCCESS.getCode())) {
            return ResponseData.success(apiRes.getJSONObject(Constants.data));
        } else {
            return ResponseData.error(EnumCode.getEnumCodeType(apiRes.getInteger(Constants.code)));
        }
    }

    public ResponseData<JSONObject> getTreatmentPrograms(Integer treatmentProgramId, String treatmentProgramKeyword) {
        String api = "api/disease/treatment-program/get";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(
                        Constants.medicalRecordManagementModuleBaseUrl + api)
                .queryParam(Constants.treatmentProgramId, treatmentProgramId)
                .queryParam(Constants.treatmentProgramKeyword, treatmentProgramKeyword);

        JSONObject apiRes = restTemplate.getForObject(uriBuilder.toUriString(), JSONObject.class);

        if (apiRes == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        if (Objects.equals(apiRes.getInteger(Constants.code), EnumCode.SUCCESS.getCode())) {
            return ResponseData.success(apiRes.getJSONObject(Constants.data));
        } else {
            return ResponseData.error(EnumCode.getEnumCodeType(apiRes.getInteger(Constants.code)));
        }
    }

    public ResponseData<JSONObject> addTreatmentProgram(
            String treatmentProgramContent, String treatmentProgramPhoto, String treatmentProgramVideo) {
        String api = "api/disease/treatment-program/add";

        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add(Constants.treatmentProgramContent, treatmentProgramContent);
        requestEntity.add(Constants.treatmentProgramPhoto, treatmentProgramPhoto);
        requestEntity.add(Constants.treatmentProgramVideo, treatmentProgramVideo);

        JSONObject apiRes = restTemplate.postForObject(
                Constants.medicalRecordManagementModuleBaseUrl + api, requestEntity, JSONObject.class);

        if (apiRes == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        if (Objects.equals(apiRes.getInteger(Constants.code), EnumCode.SUCCESS.getCode())) {
            return ResponseData.success(apiRes.getJSONObject(Constants.data));
        } else {
            return ResponseData.error(EnumCode.getEnumCodeType(apiRes.getInteger(Constants.code)));
        }
    }

    public ResponseData<JSONObject> updateTreatmentProgram(
            int treatmentProgramId,
            String treatmentProgramContent,
            String treatmentProgramPhoto,
            String treatmentProgramVideo) {
        String api = "api/disease/treatment-program/update";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(
                        Constants.medicalRecordManagementModuleBaseUrl + api)
                .queryParam(Constants.treatmentProgramId, treatmentProgramId)
                .queryParam(Constants.treatmentProgramContent, treatmentProgramContent)
                .queryParam(Constants.treatmentProgramPhoto, treatmentProgramPhoto)
                .queryParam(Constants.treatmentProgramVideo, treatmentProgramVideo);

        JSONObject apiRes = restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.PUT, null, JSONObject.class)
                .getBody();

        if (apiRes == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        if (Objects.equals(apiRes.getInteger(Constants.code), EnumCode.SUCCESS.getCode())) {
            return ResponseData.success(apiRes.getJSONObject(Constants.data));
        } else {
            return ResponseData.error(EnumCode.getEnumCodeType(apiRes.getInteger(Constants.code)));
        }
    }

    public ResponseData<JSONObject> deleteTreatmentProgram(int treatmentProgramId) {
        String api = "api/disease/treatment-program/delete";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(
                        Constants.medicalRecordManagementModuleBaseUrl + api)
                .queryParam(Constants.treatmentProgramId, treatmentProgramId);

        JSONObject apiRes = restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.DELETE, null, JSONObject.class)
                .getBody();

        if (apiRes == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        if (Objects.equals(apiRes.getInteger(Constants.code), EnumCode.SUCCESS.getCode())) {
            return ResponseData.success(apiRes.getJSONObject(Constants.data));
        } else {
            return ResponseData.error(EnumCode.getEnumCodeType(apiRes.getInteger(Constants.code)));
        }
    }

    public ResponseData<JSONObject> getDiseaseNames(
            Integer diseaseNameId, String diseaseNameKeyword, String diseaseNameCategory) {
        String api = "api/disease/disease-name/get";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(
                        Constants.medicalRecordManagementModuleBaseUrl + api)
                .queryParam(Constants.diseaseNameId, diseaseNameId)
                .queryParam(Constants.diseaseNameKeyword, diseaseNameKeyword)
                .queryParam(Constants.diseaseNameCategory, diseaseNameCategory);

        JSONObject apiRes = restTemplate.getForObject(uriBuilder.toUriString(), JSONObject.class);

        if (apiRes == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        if (Objects.equals(apiRes.getInteger(Constants.code), EnumCode.SUCCESS.getCode())) {
            return ResponseData.success(apiRes.getJSONObject(Constants.data));
        } else {
            return ResponseData.error(EnumCode.getEnumCodeType(apiRes.getInteger(Constants.code)));
        }
    }

    public ResponseData<JSONObject> addDiseaseName(
            String diseaseNameContent, String diseaseNamePhoto, String diseaseNameVideo, String diseaseNameCategory) {
        String api = "api/disease/disease-name/add";

        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add(Constants.diseaseNameContent, diseaseNameContent);
        requestEntity.add(Constants.diseaseNamePhoto, diseaseNamePhoto);
        requestEntity.add(Constants.diseaseNameVideo, diseaseNameVideo);
        requestEntity.add(Constants.diseaseNameCategory, diseaseNameCategory);

        JSONObject apiRes = restTemplate.postForObject(
                Constants.medicalRecordManagementModuleBaseUrl + api, requestEntity, JSONObject.class);

        if (apiRes == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        if (Objects.equals(apiRes.getInteger(Constants.code), EnumCode.SUCCESS.getCode())) {
            return ResponseData.success(apiRes.getJSONObject(Constants.data));
        } else {
            return ResponseData.error(EnumCode.getEnumCodeType(apiRes.getInteger(Constants.code)));
        }
    }

    public ResponseData<JSONObject> updateDiseaseName(
            int diseaseNameId,
            String diseaseNameContent,
            String diseaseNamePhoto,
            String diseaseNameVideo,
            String diseaseNameCategory) {
        String api = "api/disease/disease-name/update";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(
                        Constants.medicalRecordManagementModuleBaseUrl + api)
                .queryParam(Constants.diseaseNameId, diseaseNameId)
                .queryParam(Constants.diseaseNameContent, diseaseNameContent)
                .queryParam(Constants.diseaseNamePhoto, diseaseNamePhoto)
                .queryParam(Constants.diseaseNameVideo, diseaseNameVideo)
                .queryParam(Constants.diseaseNameCategory, diseaseNameCategory);

        JSONObject apiRes = restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.PUT, null, JSONObject.class)
                .getBody();

        if (apiRes == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        if (Objects.equals(apiRes.getInteger(Constants.code), EnumCode.SUCCESS.getCode())) {
            return ResponseData.success(apiRes.getJSONObject(Constants.data));
        } else {
            return ResponseData.error(EnumCode.getEnumCodeType(apiRes.getInteger(Constants.code)));
        }
    }

    public ResponseData<JSONObject> deleteDiseaseName(int diseaseNameId) {
        String api = "api/disease/disease-name/delete";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(
                        Constants.medicalRecordManagementModuleBaseUrl + api)
                .queryParam(Constants.diseaseNameId, diseaseNameId);

        JSONObject apiRes = restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.DELETE, null, JSONObject.class)
                .getBody();

        if (apiRes == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        if (Objects.equals(apiRes.getInteger(Constants.code), EnumCode.SUCCESS.getCode())) {
            return ResponseData.success(apiRes.getJSONObject(Constants.data));
        } else {
            return ResponseData.error(EnumCode.getEnumCodeType(apiRes.getInteger(Constants.code)));
        }
    }

    public ResponseData<JSONObject> getMedicalCases(
            Integer medicalCaseId,
            Integer admissionId,
            Integer caseCheckId,
            Integer diagnosticResultId,
            Integer treatmentProgramId,
            Integer diseaseNameId) {
        String api = "api/disease/medical-case/get";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(
                        Constants.medicalRecordManagementModuleBaseUrl + api)
                .queryParam(Constants.medicalCaseId, medicalCaseId)
                .queryParam(Constants.diseaseAdmissionId, admissionId)
                .queryParam(Constants.caseCheckId, caseCheckId)
                .queryParam(Constants.diagnosticResultId, diagnosticResultId)
                .queryParam(Constants.diseaseNameId, diseaseNameId)
                .queryParam(Constants.treatmentProgramId, treatmentProgramId);

        JSONObject apiRes = restTemplate.getForObject(uriBuilder.toUriString(), JSONObject.class);

        if (apiRes == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        if (Objects.equals(apiRes.getInteger(Constants.code), EnumCode.SUCCESS.getCode())) {
            return ResponseData.success(apiRes.getJSONObject(Constants.data));
        } else {
            return ResponseData.error(EnumCode.getEnumCodeType(apiRes.getInteger(Constants.code)));
        }
    }

    public ResponseData<JSONObject> addMedicalCase(
            int admissionId, int caseCheckId, int diagnosticResultId, int treatmentProgramId, int diseaseNameId) {
        String api = "api/disease/medical-case/add";

        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add(Constants.diseaseAdmissionId, String.valueOf(admissionId));
        requestEntity.add(Constants.caseCheckId, String.valueOf(caseCheckId));
        requestEntity.add(Constants.diagnosticResultId, String.valueOf(diagnosticResultId));
        requestEntity.add(Constants.diseaseNameId, String.valueOf(diseaseNameId));
        requestEntity.add(Constants.treatmentProgramId, String.valueOf(treatmentProgramId));

        JSONObject apiRes = restTemplate.postForObject(
                Constants.medicalRecordManagementModuleBaseUrl + api, requestEntity, JSONObject.class);

        if (apiRes == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        if (Objects.equals(apiRes.getInteger(Constants.code), EnumCode.SUCCESS.getCode())) {
            return ResponseData.success(apiRes.getJSONObject(Constants.data));
        } else {
            return ResponseData.error(EnumCode.getEnumCodeType(apiRes.getInteger(Constants.code)));
        }
    }

    public ResponseData<JSONObject> updateMedicalCase(
            int medicalCaseId,
            int admissionId,
            int caseCheckId,
            int diagnosticResultId,
            int treatmentProgramId,
            int diseaseNameId) {
        String api = "api/disease/medical-case/update";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(
                        Constants.medicalRecordManagementModuleBaseUrl + api)
                .queryParam(Constants.medicalCaseId, medicalCaseId)
                .queryParam(Constants.diseaseAdmissionId, admissionId)
                .queryParam(Constants.caseCheckId, caseCheckId)
                .queryParam(Constants.diagnosticResultId, diagnosticResultId)
                .queryParam(Constants.diseaseNameId, diseaseNameId)
                .queryParam(Constants.treatmentProgramId, treatmentProgramId);

        JSONObject apiRes = restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.PUT, null, JSONObject.class)
                .getBody();

        if (apiRes == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        if (Objects.equals(apiRes.getInteger(Constants.code), EnumCode.SUCCESS.getCode())) {
            return ResponseData.success(apiRes.getJSONObject(Constants.data));
        } else {
            return ResponseData.error(EnumCode.getEnumCodeType(apiRes.getInteger(Constants.code)));
        }
    }

    public ResponseData<JSONObject> deleteMedicalCase(int medicalCaseId) {
        String api = "api/disease/medical-case/delete";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(
                        Constants.medicalRecordManagementModuleBaseUrl + api)
                .queryParam(Constants.medicalCaseId, medicalCaseId);

        JSONObject apiRes = restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.DELETE, null, JSONObject.class)
                .getBody();

        if (apiRes == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        if (Objects.equals(apiRes.getInteger(Constants.code), EnumCode.SUCCESS.getCode())) {
            return ResponseData.success(apiRes.getJSONObject(Constants.data));
        } else {
            return ResponseData.error(EnumCode.getEnumCodeType(apiRes.getInteger(Constants.code)));
        }
    }

    public ResponseData<JSONObject> getMedicalCaseAutomatically(
            String admissionKeyword,
            String caseCheckKeyword,
            String diagnosticResultKeyword,
            String treatmentProgramKeyword,
            Integer diseaseNameId) {
        JSONObject medicalCaseRes = this.getMedicalCases(null, null, null, null, null, diseaseNameId)
                .getData();
        JSONObject admissionRes = this.getAdmissions(null, admissionKeyword).getData();
        JSONObject caseCheckRes = this.getCaseChecks(null, caseCheckKeyword).getData();
        JSONObject diagnosticResultRes =
                this.getDiagnosticResults(null, diagnosticResultKeyword).getData();
        JSONObject treatmentProgramRes =
                this.getTreatmentPrograms(null, treatmentProgramKeyword).getData();

        if (medicalCaseRes == null
                || admissionRes == null
                || caseCheckRes == null
                || diagnosticResultRes == null
                || treatmentProgramRes == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        medicalCaseRes.getJSONArray(Constants.medicalCaseList).removeIf(medicalCase -> {
            JSONObject medicalCaseObject = JSON.parseObject(JSON.toJSONString(medicalCase));

            return !(admissionRes
                            .getJSONArray(Constants.admissionList)
                            .contains(medicalCaseObject.getJSONObject(Constants.medicalCaseAdmission))
                    && caseCheckRes
                            .getJSONArray(Constants.caseCheckList)
                            .contains(medicalCaseObject.getJSONObject(Constants.medicalCaseCaseCheck))
                    && diagnosticResultRes
                            .getJSONArray(Constants.diagnosticResultList)
                            .contains(medicalCaseObject.getJSONObject(Constants.medicalCaseDiagnosticResult))
                    && treatmentProgramRes
                            .getJSONArray(Constants.treatmentProgramList)
                            .contains(medicalCaseObject.getJSONObject(Constants.medicalCaseTreatmentProgram)));
        });

        JSONObject res = new JSONObject();
        res.put(Constants.medicalCaseList, medicalCaseRes);

        return ResponseData.success(res);
    }

    public ResponseData<JSONObject> updateMedicalCaseAutomatically(
            int medicalCaseId,
            int diseaseNameId,
            String admissionContent,
            String caseCheckContent,
            String diagnosticResultContent,
            String treatmentProgramContent) {
        JSONObject getMedicalCaseRes = this.getMedicalCases(medicalCaseId, null, null, null, null, null)
                .getData();
        if (getMedicalCaseRes == null
                || Objects.equals(
                        getMedicalCaseRes
                                .getJSONArray(Constants.medicalCaseList)
                                .size(),
                        0)) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }
        JSONObject targetMedicalCase =
                getMedicalCaseRes.getJSONArray(Constants.medicalCaseList).getJSONObject(0);
        int admissionId = targetMedicalCase
                .getJSONObject(Constants.medicalCaseAdmission)
                .getInteger(Constants.diseaseAdmissionId);
        int caseCheckId =
                targetMedicalCase.getJSONObject(Constants.medicalCaseCaseCheck).getInteger(Constants.caseCheckId);
        int diagnosticResultId = targetMedicalCase
                .getJSONObject(Constants.medicalCaseDiagnosticResult)
                .getInteger(Constants.diagnosticResultId);
        int treatmentProgramId = targetMedicalCase
                .getJSONObject(Constants.medicalCaseTreatmentProgram)
                .getInteger(Constants.treatmentProgramId);

        JSONObject getAdmissionRes = this.getAdmissions(admissionId, null).getData();
        JSONObject getCaseCheckRes = this.getCaseChecks(caseCheckId, null).getData();
        JSONObject getDiagnosticResultRes =
                this.getDiagnosticResults(diagnosticResultId, null).getData();
        JSONObject getTreatmentProgramRes =
                this.getTreatmentPrograms(treatmentProgramId, null).getData();

        if (getAdmissionRes == null
                || Objects.equals(
                        getAdmissionRes.getJSONArray(Constants.admissionList).size(), 0)
                || getCaseCheckRes == null
                || Objects.equals(
                        getCaseCheckRes.getJSONArray(Constants.caseCheckList).size(), 0)
                || getDiagnosticResultRes == null
                || Objects.equals(
                        getDiagnosticResultRes
                                .getJSONArray(Constants.diagnosticResultList)
                                .size(),
                        0)
                || getTreatmentProgramRes == null
                || Objects.equals(
                        getTreatmentProgramRes
                                .getJSONArray(Constants.treatmentProgramList)
                                .size(),
                        0)) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        JSONObject updateAdmissionRes = this.updateAdmission(
                        admissionId,
                        admissionContent,
                        getAdmissionRes
                                .getJSONArray(Constants.admissionList)
                                .getJSONObject(0)
                                .getString(Constants.admissionPhoto),
                        getAdmissionRes
                                .getJSONArray(Constants.admissionList)
                                .getJSONObject(0)
                                .getString(Constants.admissionVideo))
                .getData();
        JSONObject updateCaseCheckRes = this.updateCaseCheck(
                        caseCheckId,
                        caseCheckContent,
                        getCaseCheckRes
                                .getJSONArray(Constants.caseCheckList)
                                .getJSONObject(0)
                                .getString(Constants.caseCheckPhoto),
                        getCaseCheckRes
                                .getJSONArray(Constants.caseCheckList)
                                .getJSONObject(0)
                                .getString(Constants.caseCheckVideo))
                .getData();
        JSONObject updateDiagnosticResultRes = this.updateDiagnosticResult(
                        diagnosticResultId,
                        diagnosticResultContent,
                        getDiagnosticResultRes
                                .getJSONArray(Constants.diagnosticResultList)
                                .getJSONObject(0)
                                .getString(Constants.diagnosticResultPhoto),
                        getDiagnosticResultRes
                                .getJSONArray(Constants.diagnosticResultList)
                                .getJSONObject(0)
                                .getString(Constants.diagnosticResultVideo))
                .getData();
        JSONObject updateTreatmentProgramRes = this.updateTreatmentProgram(
                        treatmentProgramId,
                        treatmentProgramContent,
                        getTreatmentProgramRes
                                .getJSONArray(Constants.treatmentProgramList)
                                .getJSONObject(0)
                                .getString(Constants.treatmentProgramPhoto),
                        getTreatmentProgramRes
                                .getJSONArray(Constants.treatmentProgramList)
                                .getJSONObject(0)
                                .getString(Constants.treatmentProgramVideo))
                .getData();

        JSONObject updateMedicalCaseRes = this.updateMedicalCase(
                        medicalCaseId, admissionId, caseCheckId, diagnosticResultId, treatmentProgramId, diseaseNameId)
                .getData();

        if (updateMedicalCaseRes == null
                || updateAdmissionRes == null
                || updateCaseCheckRes == null
                || updateDiagnosticResultRes == null
                || updateTreatmentProgramRes == null) {
            this.updateMedicalCase(
                    medicalCaseId,
                    admissionId,
                    caseCheckId,
                    diagnosticResultId,
                    treatmentProgramId,
                    targetMedicalCase
                            .getJSONObject(Constants.medicalCaseDiseaseName)
                            .getInteger(Constants.diseaseNameId));
            this.updateAdmission(
                    admissionId,
                    getAdmissionRes
                            .getJSONArray(Constants.admissionList)
                            .getJSONObject(0)
                            .getString(Constants.admissionContent),
                    getAdmissionRes
                            .getJSONArray(Constants.admissionList)
                            .getJSONObject(0)
                            .getString(Constants.admissionPhoto),
                    getAdmissionRes
                            .getJSONArray(Constants.admissionList)
                            .getJSONObject(0)
                            .getString(Constants.admissionVideo));
            this.updateCaseCheck(
                    caseCheckId,
                    getCaseCheckRes
                            .getJSONArray(Constants.caseCheckList)
                            .getJSONObject(0)
                            .getString(Constants.caseCheckContent),
                    getCaseCheckRes
                            .getJSONArray(Constants.caseCheckList)
                            .getJSONObject(0)
                            .getString(Constants.caseCheckPhoto),
                    getCaseCheckRes
                            .getJSONArray(Constants.caseCheckList)
                            .getJSONObject(0)
                            .getString(Constants.caseCheckVideo));
            this.updateDiagnosticResult(
                    diagnosticResultId,
                    getDiagnosticResultRes
                            .getJSONArray(Constants.diagnosticResultList)
                            .getJSONObject(0)
                            .getString(Constants.diagnosticResultContent),
                    getDiagnosticResultRes
                            .getJSONArray(Constants.diagnosticResultList)
                            .getJSONObject(0)
                            .getString(Constants.diagnosticResultPhoto),
                    getDiagnosticResultRes
                            .getJSONArray(Constants.diagnosticResultList)
                            .getJSONObject(0)
                            .getString(Constants.diagnosticResultVideo));
            this.updateTreatmentProgram(
                    treatmentProgramId,
                    getTreatmentProgramRes
                            .getJSONArray(Constants.treatmentProgramList)
                            .getJSONObject(0)
                            .getString(Constants.treatmentProgramContent),
                    getTreatmentProgramRes
                            .getJSONArray(Constants.treatmentProgramList)
                            .getJSONObject(0)
                            .getString(Constants.treatmentProgramPhoto),
                    getTreatmentProgramRes
                            .getJSONArray(Constants.treatmentProgramList)
                            .getJSONObject(0)
                            .getString(Constants.treatmentProgramVideo));

            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        return ResponseData.success(updateMedicalCaseRes);
    }

    public ResponseData<JSONObject> addMedicalCaseAutomatically(
            int diseaseNameId,
            String admissionContent,
            String caseCheckContent,
            String diagnosticResultContent,
            String treatmentProgramContent) {
        String pathPrefix = "disease";
        String randomUUID = UUID.randomUUID().toString();

        JSONObject addAdmissionRes = this.addAdmission(
                        admissionContent,
                        Paths.get(pathPrefix, "admission", randomUUID, "photo").toString(),
                        Paths.get(pathPrefix, "admission", randomUUID, "video").toString())
                .getData();
        JSONObject addCaseCheckRes = this.addCaseCheck(
                        caseCheckContent,
                        Paths.get(pathPrefix, "caseCheck", randomUUID, "photo").toString(),
                        Paths.get(pathPrefix, "caseCheck", randomUUID, "video").toString())
                .getData();
        JSONObject addDiagnosticResultRes = this.addDiagnosticResult(
                        diagnosticResultContent,
                        Paths.get(pathPrefix, "diagnosticResult", randomUUID, "photo")
                                .toString(),
                        Paths.get(pathPrefix, "diagnosticResult", randomUUID, "video")
                                .toString())
                .getData();
        JSONObject addTreatmentProgramRes = this.addTreatmentProgram(
                        treatmentProgramContent,
                        Paths.get(pathPrefix, "treatmentProgram", randomUUID, "photo")
                                .toString(),
                        Paths.get(pathPrefix, "treatmentProgram", randomUUID, "video")
                                .toString())
                .getData();

        if (addAdmissionRes == null
                || addCaseCheckRes == null
                || addDiagnosticResultRes == null
                || addTreatmentProgramRes == null) {
            if (addAdmissionRes != null) {
                this.deleteAdmission(addAdmissionRes.getInteger(Constants.diseaseAdmissionId));
            }
            if (addCaseCheckRes != null) {
                this.deleteCaseCheck(addCaseCheckRes.getInteger(Constants.caseCheckId));
            }
            if (addDiagnosticResultRes != null) {
                this.deleteDiagnosticResult(addDiagnosticResultRes.getInteger(Constants.diagnosticResultId));
            }
            if (addTreatmentProgramRes != null) {
                this.deleteTreatmentProgram(addTreatmentProgramRes.getInteger(Constants.treatmentProgramId));
            }
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        JSONObject addMedicalCaseRes = this.addMedicalCase(
                        addAdmissionRes.getInteger(Constants.diseaseAdmissionId),
                        addCaseCheckRes.getInteger(Constants.caseCheckId),
                        addDiagnosticResultRes.getInteger(Constants.diagnosticResultId),
                        addTreatmentProgramRes.getInteger(Constants.treatmentProgramId),
                        diseaseNameId)
                .getData();

        if (addMedicalCaseRes == null) {
            this.deleteAdmission(addAdmissionRes.getInteger(Constants.diseaseAdmissionId));
            this.deleteCaseCheck(addCaseCheckRes.getInteger(Constants.caseCheckId));
            this.deleteDiagnosticResult(addDiagnosticResultRes.getInteger(Constants.diagnosticResultId));
            this.deleteTreatmentProgram(addTreatmentProgramRes.getInteger(Constants.treatmentProgramId));
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }
        return ResponseData.success(addMedicalCaseRes);
    }

    public ResponseData<JSONObject> deleteMedicalCaseAutomatically(int medicalCaseId) {
        JSONObject getMedicalCaseRes = this.getMedicalCases(medicalCaseId, null, null, null, null, null)
                .getData();
        if (getMedicalCaseRes == null
                || Objects.equals(
                        getMedicalCaseRes
                                .getJSONArray(Constants.medicalCaseList)
                                .size(),
                        0)) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        JSONObject targetMedicalCase =
                getMedicalCaseRes.getJSONArray(Constants.medicalCaseList).getJSONObject(0);
        this.deleteAdmission(targetMedicalCase
                .getJSONObject(Constants.medicalCaseAdmission)
                .getInteger(Constants.diseaseAdmissionId));
        this.deleteCaseCheck(
                targetMedicalCase.getJSONObject(Constants.medicalCaseCaseCheck).getInteger(Constants.caseCheckId));
        this.deleteDiagnosticResult(targetMedicalCase
                .getJSONObject(Constants.medicalCaseDiagnosticResult)
                .getInteger(Constants.diagnosticResultId));
        this.deleteTreatmentProgram(targetMedicalCase
                .getJSONObject(Constants.medicalCaseTreatmentProgram)
                .getInteger(Constants.treatmentProgramId));
        return ResponseData.success(targetMedicalCase);
    }

    public ResponseData<JSONObject> addDiseaseNameAutomatically(String diseaseNameContent, String diseaseNameCategory) {
        String pathPrefix =
                Paths.get("disease/diseaseName", UUID.randomUUID().toString()).toString();
        return this.addDiseaseName(
                diseaseNameContent,
                Paths.get(pathPrefix, "photo").toString(),
                Paths.get(pathPrefix, "video").toString(),
                diseaseNameCategory);
    }

    public ResponseData<JSONObject> updateDiseaseNameAutomatically(
            int diseaseNameId, String diseaseNameContent, String diseaseNameCategory) {
        JSONObject getDiseaseNameRes =
                this.getDiseaseNames(diseaseNameId, null, null).getData();
        if (getDiseaseNameRes == null
                || Objects.equals(
                        getDiseaseNameRes
                                .getJSONArray(Constants.diseaseNameList)
                                .size(),
                        0)) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        JSONObject targetDiseaseName =
                getDiseaseNameRes.getJSONArray(Constants.diseaseNameList).getJSONObject(0);

        return this.updateDiseaseName(
                diseaseNameId,
                diseaseNameContent,
                targetDiseaseName.getString(Constants.diseaseNamePhoto),
                targetDiseaseName.getString(Constants.diseaseNameVideo),
                diseaseNameCategory);
    }
}
