/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-25 14:24:59
 * @LastEditors: pikapikapi pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-31 08:51:18
 * @FilePath: /virtualPetHospital-backend/intermediator/src/main/java/pet/hospital/backend/intermediator/service/SystemService.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.intermediator.service;

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
import pet.hospital.backend.intermediator.helper.ResponseHelper;

@Service
public class SystemService {
    @Autowired
    private RestTemplate restTemplate;

    public ResponseData<JSONObject> getAdmissions(
            String roomStandard, String careLevel, String remark, Double carePrice, String roomName) {
        String api = "api/system/admission/get";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.systemModuleBaseUrl + api)
                .queryParam(Constants.roomStandard, roomStandard)
                .queryParam(Constants.careLevel, careLevel)
                .queryParam(Constants.remark, remark)
                .queryParam(Constants.carePrice, carePrice)
                .queryParam(Constants.roomName, roomName);

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.getForObject(uriBuilder.toUriString(), JSONObject.class));
    }

    public ResponseData<JSONObject> addAdmission(
            String roomStandard, String careLevel, String remark, double carePrice, String roomName) {
        String api = "api/system/admission/add";

        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add(Constants.roomStandard, roomStandard);
        requestEntity.add(Constants.careLevel, careLevel);
        requestEntity.add(Constants.remark, remark);
        requestEntity.add(Constants.carePrice, String.valueOf(carePrice));
        requestEntity.add(Constants.roomName, roomName);

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.postForObject(Constants.systemModuleBaseUrl + api, requestEntity, JSONObject.class));
    }

    public ResponseData<JSONObject> updateAdmission(
            int admissionId, String roomStandard, String careLevel, String remark, double carePrice, String roomName) {
        String api = "api/system/admission/update";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.systemModuleBaseUrl + api)
                .queryParam(Constants.admissionId, admissionId)
                .queryParam(Constants.roomStandard, roomStandard)
                .queryParam(Constants.careLevel, careLevel)
                .queryParam(Constants.remark, remark)
                .queryParam(Constants.carePrice, carePrice)
                .queryParam(Constants.roomName, roomName);

        return ResponseHelper.forwardResponseDataDirectly(restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.PUT, null, JSONObject.class)
                .getBody());
    }

    public ResponseData<JSONObject> deleteAdmission(int admissionId) {
        String api = "api/system/admission/delete";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.systemModuleBaseUrl + api)
                .queryParam(Constants.admissionId, admissionId);

        return ResponseHelper.forwardResponseDataDirectly(restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.DELETE, null, JSONObject.class)
                .getBody());
    }

    public ResponseData<JSONObject> getArchives(
            String storeTime, String diseaseType, String petType, String petName, Character petSex, String ownerTel) {
        String api = "api/system/archive/get";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.systemModuleBaseUrl + api)
                .queryParam(Constants.storeTime, storeTime)
                .queryParam(Constants.diseaseType, diseaseType)
                .queryParam(Constants.petType, petType)
                .queryParam(Constants.petName, petName)
                .queryParam(Constants.petSex, petSex)
                .queryParam(Constants.ownerTel, ownerTel);

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.getForObject(uriBuilder.toUriString(), JSONObject.class));
    }

    public ResponseData<JSONObject> addArchive(
            String storeTime, String diseaseType, String petType, String petName, char petSex, String ownerTel) {
        String api = "api/system/archive/add";

        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add(Constants.storeTime, storeTime);
        requestEntity.add(Constants.diseaseType, diseaseType);
        requestEntity.add(Constants.petType, petType);
        requestEntity.add(Constants.petName, petName);
        requestEntity.add(Constants.petSex, String.valueOf(petSex));
        requestEntity.add(Constants.ownerTel, ownerTel);

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.postForObject(Constants.systemModuleBaseUrl + api, requestEntity, JSONObject.class));
    }

    public ResponseData<JSONObject> updateArchive(
            int archiveId,
            String storeTime,
            String diseaseType,
            String petType,
            String petName,
            char petSex,
            String ownerTel) {
        String api = "api/system/archive/update";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.systemModuleBaseUrl + api)
                .queryParam(Constants.archiveId, archiveId)
                .queryParam(Constants.storeTime, storeTime)
                .queryParam(Constants.diseaseType, diseaseType)
                .queryParam(Constants.petType, petType)
                .queryParam(Constants.petName, petName)
                .queryParam(Constants.petSex, petSex)
                .queryParam(Constants.ownerTel, ownerTel);

        return ResponseHelper.forwardResponseDataDirectly(restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.PUT, null, JSONObject.class)
                .getBody());
    }

    public ResponseData<JSONObject> deleteArchive(int archiveId) {
        String api = "api/system/archive/delete";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.systemModuleBaseUrl + api)
                .queryParam(Constants.archiveId, archiveId);

        return ResponseHelper.forwardResponseDataDirectly(restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.DELETE, null, JSONObject.class)
                .getBody());
    }

    public ResponseData<JSONObject> getCharges(String itemName, Double chargePrice) {
        String api = "api/system/charge/get";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.systemModuleBaseUrl + api)
                .queryParam(Constants.itemName, itemName)
                .queryParam(Constants.chargePrice, chargePrice);

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.getForObject(uriBuilder.toUriString(), JSONObject.class));
    }

    public ResponseData<JSONObject> addCharge(String itemName, double chargePrice) {
        String api = "api/system/charge/add";

        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add(Constants.itemName, itemName);
        requestEntity.add(Constants.chargePrice, String.valueOf(chargePrice));

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.postForObject(Constants.systemModuleBaseUrl + api, requestEntity, JSONObject.class));
    }

    public ResponseData<JSONObject> updateCharge(int chargeId, String itemName, double chargePrice) {
        String api = "api/system/charge/update";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.systemModuleBaseUrl + api)
                .queryParam(Constants.chargeId, chargeId)
                .queryParam(Constants.itemName, itemName)
                .queryParam(Constants.chargePrice, chargePrice);

        return ResponseHelper.forwardResponseDataDirectly(restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.PUT, null, JSONObject.class)
                .getBody());
    }

    public ResponseData<JSONObject> deleteCharge(int chargeId) {
        String api = "api/system/charge/delete";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.systemModuleBaseUrl + api)
                .queryParam(Constants.chargeId, chargeId);

        return ResponseHelper.forwardResponseDataDirectly(restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.DELETE, null, JSONObject.class)
                .getBody());
    }

    public ResponseData<JSONObject> getExamines(String examineName, Double examinePrice, String roomName) {
        String api = "api/system/examine/get";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.systemModuleBaseUrl + api)
                .queryParam(Constants.examineName, examineName)
                .queryParam(Constants.examinePrice, examinePrice)
                .queryParam(Constants.roomName, roomName);

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.getForObject(uriBuilder.toUriString(), JSONObject.class));
    }

    public ResponseData<JSONObject> addExamine(String examineName, double examinePrice, String roomName) {
        String api = "api/system/examine/add";

        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add(Constants.examineName, examineName);
        requestEntity.add(Constants.examinePrice, String.valueOf(examinePrice));
        requestEntity.add(Constants.roomName, roomName);

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.postForObject(Constants.systemModuleBaseUrl + api, requestEntity, JSONObject.class));
    }

    public ResponseData<JSONObject> updateExamine(
            int examineId, String examineName, double examinePrice, String roomName) {
        String api = "api/system/examine/update";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.systemModuleBaseUrl + api)
                .queryParam(Constants.examineId, examineId)
                .queryParam(Constants.examineName, examineName)
                .queryParam(Constants.examinePrice, examinePrice)
                .queryParam(Constants.roomName, roomName);

        return ResponseHelper.forwardResponseDataDirectly(restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.PUT, null, JSONObject.class)
                .getBody());
    }

    public ResponseData<JSONObject> deleteExamine(int examineId) {
        String api = "api/system/examine/delete";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.systemModuleBaseUrl + api)
                .queryParam(Constants.examineId, examineId);

        return ResponseHelper.forwardResponseDataDirectly(restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.DELETE, null, JSONObject.class)
                .getBody());
    }

    public ResponseData<JSONObject> getFeatures(
            Integer funcId,
            String funcName,
            String funcDescription,
            String funcFlow,
            String funcRole,
            String funcTool,
            String roomName) {
        String api = "api/system/feature/get";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.systemModuleBaseUrl + api)
                .queryParam(Constants.funcId, funcId)
                .queryParam(Constants.funcName, funcName)
                .queryParam(Constants.funcDescription, funcDescription)
                .queryParam(Constants.funcFlow, funcFlow)
                .queryParam(Constants.funcRole, funcRole)
                .queryParam(Constants.funcTool, funcTool)
                .queryParam(Constants.roomName, roomName);

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.getForObject(uriBuilder.toUriString(), JSONObject.class));
    }

    public ResponseData<JSONObject> addFeature(
            String funcName,
            String funcDescription,
            String funcFlow,
            String funcVideo,
            String funcRole,
            String funcTool,
            String roomName) {
        String api = "api/system/feature/add";

        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add(Constants.funcName, funcName);
        requestEntity.add(Constants.funcDescription, funcDescription);
        requestEntity.add(Constants.funcFlow, funcFlow);
        requestEntity.add(Constants.funcVideo, funcVideo);
        requestEntity.add(Constants.funcRole, funcRole);
        requestEntity.add(Constants.funcTool, funcTool);
        requestEntity.add(Constants.roomName, roomName);

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.postForObject(Constants.systemModuleBaseUrl + api, requestEntity, JSONObject.class));
    }

    public ResponseData<JSONObject> updateFeature(
            int funcId,
            String funcName,
            String funcDescription,
            String funcFlow,
            String funcVideo,
            String funcRole,
            String funcTool,
            String roomName) {
        String api = "api/system/feature/update";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.systemModuleBaseUrl + api)
                .queryParam(Constants.funcId, funcId)
                .queryParam(Constants.funcName, funcName)
                .queryParam(Constants.funcDescription, funcDescription)
                .queryParam(Constants.funcFlow, funcFlow)
                .queryParam(Constants.funcVideo, funcVideo)
                .queryParam(Constants.funcRole, funcRole)
                .queryParam(Constants.funcTool, funcTool)
                .queryParam(Constants.roomName, roomName);

        return ResponseHelper.forwardResponseDataDirectly(restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.PUT, null, JSONObject.class)
                .getBody());
    }

    public ResponseData<JSONObject> deleteFeature(int funcId) {
        String api = "api/system/feature/delete";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.systemModuleBaseUrl + api)
                .queryParam(Constants.funcId, funcId);

        return ResponseHelper.forwardResponseDataDirectly(restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.DELETE, null, JSONObject.class)
                .getBody());
    }

    public ResponseData<JSONObject> getMedicines(
            String medicineName,
            Double medicinePrice,
            String manufacturer,
            String medicineCategory,
            String specification,
            Integer isVaccine) {
        String api = "api/system/medicine/get";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.systemModuleBaseUrl + api)
                .queryParam(Constants.medicineName, medicineName)
                .queryParam(Constants.medicinePrice, medicinePrice)
                .queryParam(Constants.manufacturer, manufacturer)
                .queryParam(Constants.medicineCategory, medicineCategory)
                .queryParam(Constants.specification, specification)
                .queryParam(Constants.isVaccine, isVaccine);

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.getForObject(uriBuilder.toUriString(), JSONObject.class));
    }

    public ResponseData<JSONObject> addMedicine(
            String medicineName,
            double medicinePrice,
            String manufacturer,
            String medicineCategory,
            String specification,
            int isVaccine) {
        String api = "api/system/medicine/add";

        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add(Constants.medicineName, medicineName);
        requestEntity.add(Constants.medicinePrice, String.valueOf(medicinePrice));
        requestEntity.add(Constants.manufacturer, manufacturer);
        requestEntity.add(Constants.medicineCategory, medicineCategory);
        requestEntity.add(Constants.specification, specification);
        requestEntity.add(Constants.isVaccine, String.valueOf(isVaccine));

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.postForObject(Constants.systemModuleBaseUrl + api, requestEntity, JSONObject.class));
    }

    public ResponseData<JSONObject> updateMedicine(
            int medicineId,
            String medicineName,
            double medicinePrice,
            String manufacturer,
            String medicineCategory,
            String specification,
            int isVaccine) {
        String api = "api/system/medicine/update";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.systemModuleBaseUrl + api)
                .queryParam(Constants.medicineId, medicineId)
                .queryParam(Constants.medicineName, medicineName)
                .queryParam(Constants.medicinePrice, medicinePrice)
                .queryParam(Constants.manufacturer, manufacturer)
                .queryParam(Constants.medicineCategory, medicineCategory)
                .queryParam(Constants.specification, specification)
                .queryParam(Constants.isVaccine, isVaccine);

        return ResponseHelper.forwardResponseDataDirectly(restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.PUT, null, JSONObject.class)
                .getBody());
    }

    public ResponseData<JSONObject> deleteMedicine(int medicineId) {
        String api = "api/system/medicine/delete";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.systemModuleBaseUrl + api)
                .queryParam(Constants.medicineId, medicineId);

        return ResponseHelper.forwardResponseDataDirectly(restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.DELETE, null, JSONObject.class)
                .getBody());
    }

    public ResponseData<JSONObject> getRooms(String roomKeyword, String roomRole) {
        String api = "api/system/room/get";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.systemModuleBaseUrl + api)
                .queryParam(Constants.roomKeyword, roomKeyword)
                .queryParam(Constants.roomRole, roomRole);

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.getForObject(uriBuilder.toUriString(), JSONObject.class));
    }

    public ResponseData<JSONObject> addRoom(String roomName, String roomRole) {
        String api = "api/system/room/add";

        MultiValueMap<String, String> requestEntity = new LinkedMultiValueMap<>();
        requestEntity.add(Constants.roomName, roomName);
        requestEntity.add(Constants.roomRole, roomRole);

        return ResponseHelper.forwardResponseDataDirectly(
                restTemplate.postForObject(Constants.systemModuleBaseUrl + api, requestEntity, JSONObject.class));
    }

    public ResponseData<JSONObject> updateRoom(String previousRoomName, String roomName, String roomRole) {
        String api = "api/system/room/update";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.systemModuleBaseUrl + api)
                .queryParam(Constants.previousRoomName, previousRoomName)
                .queryParam(Constants.roomName, roomName)
                .queryParam(Constants.roomRole, roomRole);

        return ResponseHelper.forwardResponseDataDirectly(restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.PUT, null, JSONObject.class)
                .getBody());
    }

    public ResponseData<JSONObject> deleteRoom(String roomName) {
        String api = "api/system/room/delete";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(Constants.systemModuleBaseUrl + api)
                .queryParam(Constants.roomName, roomName);

        return ResponseHelper.forwardResponseDataDirectly(restTemplate
                .exchange(uriBuilder.toUriString(), HttpMethod.DELETE, null, JSONObject.class)
                .getBody());
    }

    public ResponseData<JSONObject> addFeatureAutomatically(
            String funcName,
            String funcDescription,
            String funcFlow,
            String funcRole,
            String funcTool,
            String roomName) {
        return this.addFeature(
                funcName,
                funcDescription,
                funcFlow,
                Paths.get("system/feature", UUID.randomUUID().toString(), funcName, "video")
                        .normalize()
                        .toString(),
                funcRole,
                funcTool,
                roomName);
    }

    public ResponseData<JSONObject> updateFeatureAutomatically(
            int funcId,
            String funcName,
            String funcDescription,
            String funcFlow,
            String funcRole,
            String funcTool,
            String roomName) {
        JSONObject getFeatureRes =
                this.getFeatures(funcId, null, null, null, null, null, null).getData();

        if (getFeatureRes == null) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        if (Objects.equals(getFeatureRes.getJSONArray(Constants.featureList).size(), 0)) {
            return ResponseData.error(EnumCode.REQUEST_ERROR);
        }

        return this.updateFeature(
                funcId,
                funcName,
                funcDescription,
                funcFlow,
                getFeatureRes
                        .getJSONArray(Constants.featureList)
                        .getJSONObject(0)
                        .getString(Constants.funcVideo),
                funcRole,
                funcTool,
                roomName);
    }
}
