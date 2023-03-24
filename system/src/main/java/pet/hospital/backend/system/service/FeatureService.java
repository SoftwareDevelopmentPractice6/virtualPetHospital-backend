/*
 * @Author: dafenqi-11 diaozehao@163.com
 * @Date: 2023-03-24 19:59:48
 * @LastEditors: dafenqi-11 diaozehao@163.com
 * @LastEditTime: 2023-03-24 21:49:19
 * @FilePath: \virtualPetHospital-backend\system\src\main\java\pet\hospital\backend\system\service\FeatureService.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.system.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.JSON;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.hospital.backend.common.constant.Constants;
import pet.hospital.backend.common.helper.ResponseHelper;
import pet.hospital.backend.common.helper.SearchJudgeHelper;
import pet.hospital.backend.system.dao.FeatureRepository;
import pet.hospital.backend.system.dao.RoomRepository;
import pet.hospital.backend.system.entity.Feature;
import pet.hospital.backend.system.entity.Room;

@Service
public class FeatureService {

    @Autowired
    FeatureRepository featureRepository;
    @Autowired
    RoomRepository roomRepository;

    public JSONObject getFeature(
            String funcName,
            String funcDescription, String funcFlow, String funcRole, String funcTool, String roomName) {
        JSONObject res = new JSONObject();
        res.put(
                Constants.featureList,
                JSONObject.parseArray(JSON.toJSONString(featureRepository.findAll().stream()
                        .filter(feature -> SearchJudgeHelper.softIncludes(
                                funcName, feature.getFuncName())
                                && SearchJudgeHelper.softIncludes(
                                        funcDescription, feature.getFuncDescription())
                                && SearchJudgeHelper.softIncludes(
                                        funcFlow, feature.getFuncFlow())
                                && SearchJudgeHelper.softIncludes(
                                        funcRole, feature.getFuncRole())
                                && SearchJudgeHelper.softIncludes(
                                        funcTool, feature.getFuncTool())
                                && SearchJudgeHelper.softIncludes(roomName, feature.getFeatureRoom().getRoomName()))
                        .collect(Collectors.toList()))));
        return ResponseHelper.constructSuccessResponse(res);
    }

    public JSONObject addFeature(String funcName,
            String funcDescription, String funcFlow, String funcRole, String funcTool, String roomName) {

        List<Feature> targetFeatureList = featureRepository.findAll().stream()
                .filter(feature -> Objects.equals(feature.getFuncName(), funcName))
                .collect(Collectors.toList());

        if (Objects.equals(targetFeatureList.size(), 0)) {
            Optional<Room> targetRoomOptional = roomRepository.findById(roomName);
            if (targetRoomOptional.isEmpty()) {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            } else {
                Feature newFeature = new Feature();
                newFeature.setFuncName(funcName);
                newFeature.setFuncDescription(funcDescription);
                newFeature.setFuncFlow(funcFlow);
                newFeature.setFuncRole(funcRole);
                newFeature.setFuncTool(funcTool);
                newFeature.setFeatureRoom(targetRoomOptional.get());

                Feature addedFeature = featureRepository.saveAndFlush(newFeature);

                return ResponseHelper.constructSuccessResponse(addedFeature);
            }

        } else

        {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        }
    }

    public JSONObject updateFeature(int funcId, String funcName,
            String funcDescription, String funcFlow, String funcRole, String funcTool, String roomName) {
        Optional<Feature> targetFeatureOptional = featureRepository.findById(funcId);

        if (targetFeatureOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            List<Feature> targetFeatureList = featureRepository.findAll().stream()
                    .filter(feature -> Objects.equals(feature.getFuncName(), funcName)
                            && !Objects.equals(feature.getFuncId(), funcId))
                    .collect(Collectors.toList());

            Optional<Room> targetRoomOptional = roomRepository.findById(roomName);

            if (targetRoomOptional.isEmpty() || !Objects.equals(targetFeatureList.size(), 0)) {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            } else {

                Feature targetFeature = targetFeatureOptional.get();
                targetFeature.setFuncName(funcName);
                targetFeature.setFuncDescription(funcDescription);
                targetFeature.setFuncFlow(funcFlow);
                targetFeature.setFuncRole(funcRole);
                targetFeature.setFuncTool(funcTool);
                targetFeature.setFeatureRoom(targetRoomOptional.get());

                Feature updatedFeature = featureRepository.saveAndFlush(targetFeature);

                return ResponseHelper.constructSuccessResponse(updatedFeature);
            }

        }
    }

    public JSONObject deleteFeature(int featureId) {
        Optional<Feature> targetFeatureOptional = featureRepository.findById(featureId);

        if (targetFeatureOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            featureRepository.deleteById(featureId);

            if (featureRepository.findById(featureId).isEmpty()) {
                return ResponseHelper.constructSuccessResponse(targetFeatureOptional.get());
            } else {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            }
        }
    }
}
