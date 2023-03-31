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
import pet.hospital.backend.system.dao.ExamineRepository;
import pet.hospital.backend.system.dao.RoomRepository;
import pet.hospital.backend.system.entity.Examine;
import pet.hospital.backend.system.entity.Room;

@Service
public class ExamineService {
    @Autowired
    ExamineRepository examineRepository;

    @Autowired
    RoomRepository roomRepository;

    public JSONObject getExamine(String examineName, Double examinePrice, String roomName) {
        JSONObject res = new JSONObject();
        res.put(
                Constants.examineList,
                JSONObject.parseArray(JSON.toJSONString(examineRepository.findAll().stream()
                        .filter(examine -> SearchJudgeHelper.softIncludes(examineName, examine.getExamineName())
                                && SearchJudgeHelper.softEquals(examinePrice, examine.getExaminePrice())
                                && SearchJudgeHelper.softEquals(
                                        roomName, examine.getExamineRoom().getRoomName()))
                        .collect(Collectors.toList()))));
        return ResponseHelper.constructSuccessResponse(res);
    }

    public JSONObject addExamine(String examineName, double examinePrice, String roomName) {
        List<Examine> targetExamineList = examineRepository.findAll().stream()
                .filter(examine -> Objects.equals(examine.getExamineName(), examineName))
                .collect(Collectors.toList());

        if (Objects.equals(targetExamineList.size(), 0)) {
            Optional<Room> targetRoomOptional = roomRepository.findById(roomName);

            if (targetRoomOptional.isEmpty()) {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            } else {
                Examine newExamine = new Examine();
                newExamine.setExamineName(examineName);
                newExamine.setExaminePrice(examinePrice);
                newExamine.setExamineRoom(targetRoomOptional.get());

                Examine addedExamine = examineRepository.saveAndFlush(newExamine);

                return ResponseHelper.constructSuccessResponse(addedExamine);
            }
        } else {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        }
    }

    public JSONObject updateExamine(int examineId, String examineName, double examinePrice, String roomName) {
        Optional<Examine> targetExamineOptional = examineRepository.findById(examineId);

        if (targetExamineOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {

            List<Examine> targetExamineList = examineRepository.findAll().stream()
                    .filter(examine -> Objects.equals(examine.getExamineName(), examineName)
                            && !Objects.equals(examine.getExamineId(), examineId))
                    .collect(Collectors.toList());

            Optional<Room> targetRoomOptional = roomRepository.findById(roomName);

            if (targetRoomOptional.isEmpty() || !Objects.equals(targetExamineList.size(), 0)) {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            } else {
                Examine targetExamine = targetExamineOptional.get();
                targetExamine.setExamineName(examineName);
                targetExamine.setExaminePrice(examinePrice);
                targetExamine.setExamineRoom(targetRoomOptional.get());

                Examine updatedExamine = examineRepository.saveAndFlush(targetExamine);

                return ResponseHelper.constructSuccessResponse(updatedExamine);
            }
        }
    }

    public JSONObject deleteExamine(int examineId) {
        Optional<Examine> targetExamineOptional = examineRepository.findById(examineId);

        if (targetExamineOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            examineRepository.deleteById(examineId);

            if (examineRepository.findById(examineId).isEmpty()) {
                return ResponseHelper.constructSuccessResponse(targetExamineOptional.get());
            } else {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            }
        }
    }
}
