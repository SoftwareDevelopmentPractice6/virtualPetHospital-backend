/*
 * @Author: dafenqi-11 diaozehao@163.com
 * @Date: 2023-03-22 14:27:24
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-26 01:44:34
 * @FilePath: \virtualPetHospital-backend\system\src\main\java\pet\hospital\backend\system\service\RoomService.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
/*
 * @Author: dafenqi-11 diaozehao.163.com
 * @Date: 2023-03-22 14:27:24
 * @LastEditors: dafenqi-11 diaozehao@163.com
 * @LastEditTime: 2023-03-24 09:07:27
 * @FilePath: \virtualPetHospital-backend\system\src\main\java\pet\hospital\backend\system\service\RoomService.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
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
import pet.hospital.backend.system.dao.FeatureRepository;
import pet.hospital.backend.system.dao.RoomRepository;
import pet.hospital.backend.system.entity.Room;

@Service
public class RoomService {
    @Autowired
    RoomRepository roomRepository;

    @Autowired
    FeatureRepository featureRepository;

    public JSONObject getRoom(String roomKeyword, String roomRole) {
        JSONObject res = new JSONObject();
        res.put(
                Constants.roomList,
                JSONObject.parseArray(JSON.toJSONString(roomRepository.findAll().stream()
                        .filter(room -> SearchJudgeHelper.softIncludes(roomKeyword, room.getRoomName())
                                && SearchJudgeHelper.softIncludes(roomRole, room.getRoomRole()))
                        .collect(Collectors.toList()))));
        return ResponseHelper.constructSuccessResponse(res);
    }

    public JSONObject addRoom(String roomName, String roomRole) {
        List<Room> targetRoomList = roomRepository.findAll().stream()
                .filter(room -> Objects.equals(room.getRoomName(), roomName))
                .collect(Collectors.toList());

        if (Objects.equals(targetRoomList.size(), 0)) {
            Room newRoom = new Room();
            newRoom.setRoomName(roomName);
            newRoom.setRoomRole(roomRole);

            Room addedRoom = roomRepository.saveAndFlush(newRoom);

            return ResponseHelper.constructSuccessResponse(addedRoom);
        } else {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        }
    }

    public JSONObject updateRoom(String previousRoomName, String roomName, String roomRole) {
        Optional<Room> targetRoomOptional = roomRepository.findById(previousRoomName);

        if (targetRoomOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {

            if (Objects.equals(roomName, previousRoomName)) {
                Room targetRoom = targetRoomOptional.get();
                targetRoom.setRoomName(roomName);
                targetRoom.setRoomRole(roomRole);

                Room updatedRoom = roomRepository.saveAndFlush(targetRoom);

                return ResponseHelper.constructSuccessResponse(updatedRoom);
            } else {
                List<Room> targetRoomList = roomRepository.findAll().stream()
                        .filter(room -> Objects.equals(room.getRoomName(), roomName))
                        .collect(Collectors.toList());

                if (Objects.equals(targetRoomList.size(), 0)) {
                    Room newRoom = new Room();
                    newRoom.setRoomName(roomName);
                    newRoom.setRoomRole(roomRole);

                    Room updatedRoom = roomRepository.saveAndFlush(newRoom);

                    featureRepository.findAll().stream()
                            .filter(feature ->
                                    Objects.equals(feature.getFeatureRoom().getRoomName(), previousRoomName))
                            .forEach(feature -> {
                                feature.setFeatureRoom(updatedRoom);
                                featureRepository.saveAndFlush(feature);
                            });

                    roomRepository.deleteById(previousRoomName);

                    return ResponseHelper.constructSuccessResponse(updatedRoom);
                } else {
                    return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
                }
            }
        }
    }

    public JSONObject deleteRoom(String roomName) {
        Optional<Room> targetRoomOptional = roomRepository.findById(roomName);

        if (targetRoomOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            roomRepository.deleteById(roomName);

            if (roomRepository.findById(roomName).isEmpty()) {
                return ResponseHelper.constructSuccessResponse(targetRoomOptional.get());
            } else {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            }
        }
    }
}
