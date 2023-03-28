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
import pet.hospital.backend.medicalRecordManagement.dao.DiagnosticResultRepository;
import pet.hospital.backend.medicalRecordManagement.entity.DiagnosticResult;

@Service
public class DiagnosticResultService {
    @Autowired
    DiagnosticResultRepository diagnosticResultRepository;

    public JSONObject getDiagnosticResult(Integer diagnosticResultId, String diagnosticResultKeyword) {
        JSONObject res = new JSONObject();
        res.put(
                Constants.diagnosticResultList,
                JSONObject.parseArray(JSON.toJSONString(diagnosticResultRepository.findAll().stream()
                        .filter(diagnosticResult -> SearchJudgeHelper.softIncludes(
                                        diagnosticResultKeyword, diagnosticResult.getDiagnosticResultContent())
                                && SearchJudgeHelper.softEquals(
                                        diagnosticResultId, diagnosticResult.getDiagnosticResultId()))
                        .collect(Collectors.toList()))));
        return ResponseHelper.constructSuccessResponse(res);
    }

    public JSONObject addDiagnosticResult(
            String diagnosticResultContent, String diagnosticResultPhoto, String diagnosticResultVideo) {

        DiagnosticResult newDiagnosticResult = new DiagnosticResult();
        newDiagnosticResult.setDiagnosticResultContent(diagnosticResultContent);
        newDiagnosticResult.setDiagnosticResultPhoto(diagnosticResultPhoto);
        newDiagnosticResult.setDiagnosticResultVideo(diagnosticResultVideo);

        DiagnosticResult addedDiagnosticResult = diagnosticResultRepository.saveAndFlush(newDiagnosticResult);

        return ResponseHelper.constructSuccessResponse(addedDiagnosticResult);
    }

    public JSONObject updateDiagnosticResult(
            int diagnosticResultId,
            String diagnosticResultContent,
            String diagnosticResultPhoto,
            String diagnosticResultVideo) {
        Optional<DiagnosticResult> targetDiagnosticResultOptional =
                diagnosticResultRepository.findById(diagnosticResultId);

        if (targetDiagnosticResultOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {

            DiagnosticResult targetDiagnosticResult = targetDiagnosticResultOptional.get();
            targetDiagnosticResult.setDiagnosticResultContent(diagnosticResultContent);
            targetDiagnosticResult.setDiagnosticResultPhoto(diagnosticResultPhoto);
            targetDiagnosticResult.setDiagnosticResultVideo(diagnosticResultVideo);

            DiagnosticResult updatedDiagnosticResult = diagnosticResultRepository.saveAndFlush(targetDiagnosticResult);

            return ResponseHelper.constructSuccessResponse(updatedDiagnosticResult);
        }
    }

    public JSONObject deleteDiagnosticResult(int diagnosticResultId) {
        Optional<DiagnosticResult> targetDiagnosticResultOptional =
                diagnosticResultRepository.findById(diagnosticResultId);

        if (targetDiagnosticResultOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            diagnosticResultRepository.deleteById(diagnosticResultId);

            if (diagnosticResultRepository.findById(diagnosticResultId).isEmpty()) {
                return ResponseHelper.constructSuccessResponse(targetDiagnosticResultOptional.get());
            } else {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            }
        }
    }
}
