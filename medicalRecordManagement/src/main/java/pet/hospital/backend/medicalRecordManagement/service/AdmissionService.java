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
import pet.hospital.backend.medicalRecordManagement.dao.AdmissionRepository;
import pet.hospital.backend.medicalRecordManagement.entity.Admission;

@Service
public class AdmissionService {
    @Autowired
    AdmissionRepository admissionRepository;

    public JSONObject getAdmission(Integer admissionId, String admissionKeyword) {
        JSONObject res = new JSONObject();
        res.put(
                Constants.admissionList,
                JSONObject.parseArray(JSON.toJSONString(admissionRepository.findAll().stream()
                        .filter(admission ->
                                SearchJudgeHelper.softIncludes(admissionKeyword, admission.getAdmissionContent())
                                        && SearchJudgeHelper.softEquals(admissionId, admission.getAdmissionId()))
                        .collect(Collectors.toList()))));
        return ResponseHelper.constructSuccessResponse(res);
    }

    public JSONObject addAdmission(String admissionContent, String admissionPhoto, String admissionVideo) {

        Admission newAdmission = new Admission();
        newAdmission.setAdmissionContent(admissionContent);
        newAdmission.setAdmissionPhoto(admissionPhoto);
        newAdmission.setAdmissionVideo(admissionVideo);

        Admission addedAdmission = admissionRepository.saveAndFlush(newAdmission);

        return ResponseHelper.constructSuccessResponse(addedAdmission);
    }

    public JSONObject updateAdmission(
            int admissionId, String admissionContent, String admissionPhoto, String admissionVideo) {
        Optional<Admission> targetAdmissionOptional = admissionRepository.findById(admissionId);

        if (targetAdmissionOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {

            Admission targetAdmission = targetAdmissionOptional.get();
            targetAdmission.setAdmissionContent(admissionContent);
            targetAdmission.setAdmissionPhoto(admissionPhoto);
            targetAdmission.setAdmissionVideo(admissionVideo);

            Admission updatedAdmission = admissionRepository.saveAndFlush(targetAdmission);

            return ResponseHelper.constructSuccessResponse(updatedAdmission);
        }
    }

    public JSONObject deleteExam(int admissionId) {
        Optional<Admission> targetAdmissionOptional = admissionRepository.findById(admissionId);

        if (targetAdmissionOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            admissionRepository.deleteById(admissionId);

            if (admissionRepository.findById(admissionId).isEmpty()) {
                return ResponseHelper.constructSuccessResponse(targetAdmissionOptional.get());
            } else {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            }
        }
    }
}
