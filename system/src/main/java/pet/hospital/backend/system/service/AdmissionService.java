package pet.hospital.backend.system.service;

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
import pet.hospital.backend.system.dao.AdmissionRepository;
import pet.hospital.backend.system.entity.Admission;

@Service
public class AdmissionService {
    @Autowired
    AdmissionRepository admissionRepository;

    public JSONObject getAdmission(String roomStandard, String careLevel, String remark, Double carePrice) {
        JSONObject res = new JSONObject();
        res.put(
                Constants.admissionList,
                JSONObject.parseArray(JSON.toJSONString(admissionRepository.findAll().stream()
                        .filter(admission -> SearchJudgeHelper.softEquals(roomStandard, admission.getRoomStandard())
                                && SearchJudgeHelper.softEquals(careLevel, admission.getCareLevel())
                                && SearchJudgeHelper.softIncludes(remark, admission.getRemark())
                                && SearchJudgeHelper.softEquals(carePrice, admission.getCarePrice()))
                        .collect(Collectors.toList()))));
        return ResponseHelper.constructSuccessResponse(res);
    }

    public JSONObject addAdmission(String roomStandard, String careLevel, String remark, double carePrice) {
        List<Admission> targetAdmissionList = admissionRepository.findAll().stream()
                .filter(admission -> Objects.equals(admission.getRoomStandard(), roomStandard)
                        && Objects.equals(admission.getCareLevel(), careLevel)
                        && Objects.equals(admission.getCarePrice(), carePrice))
                .collect(Collectors.toList());

        if (Objects.equals(targetAdmissionList.size(), 0)) {
            Admission newAdmission = new Admission();
            newAdmission.setRoomStandard(roomStandard);
            newAdmission.setCareLevel(careLevel);
            newAdmission.setRemark(remark);
            newAdmission.setCarePrice(carePrice);

            Admission addedAdmission = admissionRepository.saveAndFlush(newAdmission);

            return ResponseHelper.constructSuccessResponse(addedAdmission);
        } else {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        }
    }

    public JSONObject updateAdmission(
            int admissionId, String roomStandard, String careLevel, String remark, double carePrice) {
        Optional<Admission> targetAdmissionOptional = admissionRepository.findById(admissionId);

        if (targetAdmissionOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {

            List<Admission> targetAdmissionList = admissionRepository.findAll().stream()
                    .filter(admission -> Objects.equals(admission.getRoomStandard(), roomStandard)
                            && Objects.equals(admission.getCareLevel(), careLevel)
                            && Objects.equals(admission.getCarePrice(), carePrice)
                            && !Objects.equals(admission.getAdmissionId(), admissionId))
                    .collect(Collectors.toList());

            if (Objects.equals(targetAdmissionList.size(), 0)) {
                Admission targetAdmission = targetAdmissionOptional.get();
                targetAdmission.setRoomStandard(roomStandard);
                targetAdmission.setCareLevel(careLevel);
                targetAdmission.setRemark(remark);
                targetAdmission.setCarePrice(carePrice);

                Admission updatedAdmission = admissionRepository.saveAndFlush(targetAdmission);

                return ResponseHelper.constructSuccessResponse(updatedAdmission);
            } else {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            }
        }
    }

    public JSONObject deleteAdmission(int admissionId) {
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
