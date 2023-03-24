package pet.hospital.backend.medicalRecordManagement.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.JSON;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.hospital.backend.common.constant.Constants;
import pet.hospital.backend.common.helper.ResponseHelper;
import pet.hospital.backend.common.helper.SearchJudgeHelper;
import pet.hospital.backend.medicalRecordManagement.dao.CaseCheckRepository;
import pet.hospital.backend.medicalRecordManagement.entity.CaseCheck;

@Service
public class CaseCheckService {
    @Autowired
    CaseCheckRepository caseCheckRepository;

    public JSONObject getCaseCheck(Integer caseCheckId, String caseCheckKeyword) {
        JSONObject res = new JSONObject();
        res.put(
                Constants.caseCheckList,
                JSONObject.parseArray(JSON.toJSONString(caseCheckRepository.findAll().stream()
                        .filter(caseCheck ->
                                SearchJudgeHelper.softIncludes(caseCheckKeyword, caseCheck.getCaseCheckContent())
                                        && SearchJudgeHelper.softEquals(caseCheckId, caseCheck.getCaseCheckId()))
                        .collect(Collectors.toList()))));
        return ResponseHelper.constructSuccessResponse(res);
    }

    public JSONObject addCaseCheck(String caseCheckContent, String caseCheckPhoto, String caseCheckVideo) {

        CaseCheck newCaseCheck = new CaseCheck();
        newCaseCheck.setCaseCheckContent(caseCheckContent);
        newCaseCheck.setCaseCheckPhoto(caseCheckPhoto);
        newCaseCheck.setCaseCheckVideo(caseCheckVideo);

        CaseCheck addedCaseCheck = caseCheckRepository.saveAndFlush(newCaseCheck);

        return ResponseHelper.constructSuccessResponse(addedCaseCheck);
    }

    public JSONObject updateCaseCheck(
            int caseCheckId, String caseCheckContent, String caseCheckPhoto, String caseCheckVideo) {
        Optional<CaseCheck> targetCaseCheckOptional = caseCheckRepository.findById(caseCheckId);

        if (targetCaseCheckOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {

            CaseCheck targetCaseCheck = targetCaseCheckOptional.get();
            targetCaseCheck.setCaseCheckContent(caseCheckContent);
            targetCaseCheck.setCaseCheckPhoto(caseCheckPhoto);
            targetCaseCheck.setCaseCheckVideo(caseCheckVideo);

            CaseCheck updatedCaseCheck = caseCheckRepository.saveAndFlush(targetCaseCheck);

            return ResponseHelper.constructSuccessResponse(updatedCaseCheck);
        }
    }

    public JSONObject deleteExam(int caseCheckId) {
        Optional<CaseCheck> targetCaseCheckOptional = caseCheckRepository.findById(caseCheckId);

        if (targetCaseCheckOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            caseCheckRepository.deleteById(caseCheckId);

            if (caseCheckRepository.findById(caseCheckId).isEmpty()) {
                return ResponseHelper.constructSuccessResponse(targetCaseCheckOptional.get());
            } else {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            }
        }
    }
}
