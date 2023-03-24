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
import pet.hospital.backend.medicalRecordManagement.dao.TreatmentProgramRepository;
import pet.hospital.backend.medicalRecordManagement.entity.TreatmentProgram;

@Service
public class TreatmentProgramService {
    @Autowired
    TreatmentProgramRepository treatmentProgramRepository;

    public JSONObject getTreatmentProgram(Integer treatmentProgramId, String treatmentProgramKeyword) {
        JSONObject res = new JSONObject();
        res.put(
                Constants.treatmentProgramList,
                JSONObject.parseArray(JSON.toJSONString(treatmentProgramRepository.findAll().stream()
                        .filter(treatmentProgram -> SearchJudgeHelper.softIncludes(
                                        treatmentProgramKeyword, treatmentProgram.getTreatmentProgramContent())
                                && SearchJudgeHelper.softEquals(
                                        treatmentProgramId, treatmentProgram.getTreatmentProgramId()))
                        .collect(Collectors.toList()))));
        return ResponseHelper.constructSuccessResponse(res);
    }

    public JSONObject addTreatmentProgram(
            String treatmentProgramContent, String treatmentProgramPhoto, String treatmentProgramVideo) {

        TreatmentProgram newTreatmentProgram = new TreatmentProgram();
        newTreatmentProgram.setTreatmentProgramContent(treatmentProgramContent);
        newTreatmentProgram.setTreatmentProgramPhoto(treatmentProgramPhoto);
        newTreatmentProgram.setTreatmentProgramVideo(treatmentProgramVideo);

        TreatmentProgram addedTreatmentProgram = treatmentProgramRepository.saveAndFlush(newTreatmentProgram);

        return ResponseHelper.constructSuccessResponse(addedTreatmentProgram);
    }

    public JSONObject updateTreatmentProgram(
            int treatmentProgramId,
            String treatmentProgramContent,
            String treatmentProgramPhoto,
            String treatmentProgramVideo) {
        Optional<TreatmentProgram> targetTreatmentProgramOptional =
                treatmentProgramRepository.findById(treatmentProgramId);

        if (targetTreatmentProgramOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {

            TreatmentProgram targetTreatmentProgram = targetTreatmentProgramOptional.get();
            targetTreatmentProgram.setTreatmentProgramContent(treatmentProgramContent);
            targetTreatmentProgram.setTreatmentProgramPhoto(treatmentProgramPhoto);
            targetTreatmentProgram.setTreatmentProgramVideo(treatmentProgramVideo);

            TreatmentProgram updatedTreatmentProgram = treatmentProgramRepository.saveAndFlush(targetTreatmentProgram);

            return ResponseHelper.constructSuccessResponse(updatedTreatmentProgram);
        }
    }

    public JSONObject deleteExam(int treatmentProgramId) {
        Optional<TreatmentProgram> targetTreatmentProgramOptional =
                treatmentProgramRepository.findById(treatmentProgramId);

        if (targetTreatmentProgramOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            treatmentProgramRepository.deleteById(treatmentProgramId);

            if (treatmentProgramRepository.findById(treatmentProgramId).isEmpty()) {
                return ResponseHelper.constructSuccessResponse(targetTreatmentProgramOptional.get());
            } else {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            }
        }
    }
}
