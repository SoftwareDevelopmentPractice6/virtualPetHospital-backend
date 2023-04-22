/*
 * @Author: pikapikapi pikapikapi_kaori@icloud.com
 * @Date: 2023-03-29 14:06:11
 * @LastEditors: pikapikapi pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-31 08:37:00
 * @FilePath: /virtualPetHospital-backend/system/src/main/java/pet/hospital/backend/system/service/AdmissionService.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.system.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
import pet.hospital.backend.system.dao.RoomRepository;
import pet.hospital.backend.system.entity.Admission;
import pet.hospital.backend.system.entity.Room;

@Service
public class AdmissionService {
    @Autowired
    AdmissionRepository admissionRepository;

    @Autowired
    RoomRepository roomRepository;

    public JSONObject getAdmission(
            String roomStandard, String careLevel, String remark, Double carePrice, String roomName) {
        JSONObject res = new JSONObject();
        res.put(
                Constants.admissionList,
                JSONObject.parseArray(JSON.toJSONString(admissionRepository.findAll().stream()
                        .filter(admission -> SearchJudgeHelper.softEquals(roomStandard, admission.getRoomStandard())
                                && SearchJudgeHelper.softEquals(careLevel, admission.getCareLevel())
                                && SearchJudgeHelper.softIncludes(remark, admission.getRemark())
                                && SearchJudgeHelper.softEquals(carePrice, admission.getCarePrice())
                                && SearchJudgeHelper.softEquals(
                                        roomName, admission.getAdmissionRoom().getRoomName()))
                        .collect(Collectors.toList()))));
        return ResponseHelper.constructSuccessResponse(res);
    }

    public JSONObject addAdmission(
            String roomStandard, String careLevel, String remark, double carePrice, String roomName) {
        List<Admission> targetAdmissionList = admissionRepository.findAll().stream()
                .filter(admission -> Objects.equals(admission.getRoomStandard(), roomStandard)
                        && Objects.equals(admission.getCareLevel(), careLevel)
                        && Objects.equals(admission.getCarePrice(), carePrice))
                .collect(Collectors.toList());

        if (Objects.equals(targetAdmissionList.size(), 0)) {
            Optional<Room> targetRoomOptional = roomRepository.findById(roomName);

            if (targetRoomOptional.isEmpty()) {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            } else {
                Admission newAdmission = new Admission();
                newAdmission.setRoomStandard(roomStandard);
                newAdmission.setCareLevel(careLevel);
                newAdmission.setRemark(remark);
                newAdmission.setCarePrice(carePrice);
                newAdmission.setAdmissionRoom(targetRoomOptional.get());

                Admission addedAdmission = admissionRepository.saveAndFlush(newAdmission);

                return ResponseHelper.constructSuccessResponse(addedAdmission);
            }
        } else {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        }
    }

    public JSONObject updateAdmission(
            int admissionId, String roomStandard, String careLevel, String remark, double carePrice, String roomName) {
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

            Optional<Room> targetRoomOptional = roomRepository.findById(roomName);

            if (targetRoomOptional.isEmpty() || !Objects.equals(targetAdmissionList.size(), 0)) {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            } else {
                Admission targetAdmission = targetAdmissionOptional.get();
                targetAdmission.setRoomStandard(roomStandard);
                targetAdmission.setCareLevel(careLevel);
                targetAdmission.setRemark(remark);
                targetAdmission.setCarePrice(carePrice);
                targetAdmission.setAdmissionRoom(targetRoomOptional.get());

                Admission updatedAdmission = admissionRepository.saveAndFlush(targetAdmission);

                return ResponseHelper.constructSuccessResponse(updatedAdmission);
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
