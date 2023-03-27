/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-27 18:51:51
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-27 19:02:21
 * @FilePath: /virtualPetHospital-backend/medicalRecordManagement/src/main/java/pet/hospital/backend/medicalRecordManagement/service/DiseaseNameService.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.medicalRecordManagement.service;

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
import pet.hospital.backend.medicalRecordManagement.dao.DiseaseNameRepository;
import pet.hospital.backend.medicalRecordManagement.entity.DiseaseName;

@Service
public class DiseaseNameService {
    @Autowired
    DiseaseNameRepository diseaseNameRepository;

    public JSONObject getDiseaseName(Integer diseaseNameId, String diseaseNameKeyword, String diseaseNameCategory) {
        JSONObject res = new JSONObject();
        res.put(
                Constants.diseaseNameList,
                JSONObject.parseArray(JSON.toJSONString(diseaseNameRepository.findAll().stream()
                        .filter(diseaseName ->
                                SearchJudgeHelper.softIncludes(diseaseNameKeyword, diseaseName.getDiseaseNameContent())
                                        && SearchJudgeHelper.softEquals(diseaseNameId, diseaseName.getDiseaseNameId())
                                        && SearchJudgeHelper.softEquals(
                                                diseaseNameCategory, diseaseName.getDiseaseNameCategory()))
                        .collect(Collectors.toList()))));
        return ResponseHelper.constructSuccessResponse(res);
    }

    public JSONObject addDiseaseName(
            String diseaseNameContent, String diseaseNamePhoto, String diseaseNameVideo, String diseaseNameCategory) {

        List<DiseaseName> targetDiseaseNameList = diseaseNameRepository.findAll().stream()
                .filter(diseaseName -> Objects.equals(diseaseName.getDiseaseNameContent(), diseaseNameContent))
                .collect(Collectors.toList());

        if (Objects.equals(targetDiseaseNameList.size(), 0)) {
            DiseaseName newDiseaseName = new DiseaseName();
            newDiseaseName.setDiseaseNameContent(diseaseNameContent);
            newDiseaseName.setDiseaseNamePhoto(diseaseNamePhoto);
            newDiseaseName.setDiseaseNameVideo(diseaseNameVideo);
            newDiseaseName.setDiseaseNameCategory(diseaseNameCategory);

            DiseaseName addedDiseaseName = diseaseNameRepository.saveAndFlush(newDiseaseName);

            return ResponseHelper.constructSuccessResponse(addedDiseaseName);
        } else {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        }
    }

    public JSONObject updateDiseaseName(
            int diseaseNameId,
            String diseaseNameContent,
            String diseaseNamePhoto,
            String diseaseNameVideo,
            String diseaseNameCategory) {
        Optional<DiseaseName> targetDiseaseNameOptional = diseaseNameRepository.findById(diseaseNameId);

        if (targetDiseaseNameOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            List<DiseaseName> targetDiseaseNameList = diseaseNameRepository.findAll().stream()
                    .filter(diseaseName -> Objects.equals(diseaseName.getDiseaseNameContent(), diseaseNameContent)
                            && !Objects.equals(diseaseName.getDiseaseNameId(), diseaseNameId))
                    .collect(Collectors.toList());

            if (Objects.equals(targetDiseaseNameList.size(), 0)) {
                DiseaseName targetDiseaseName = targetDiseaseNameOptional.get();
                targetDiseaseName.setDiseaseNameContent(diseaseNameContent);
                targetDiseaseName.setDiseaseNamePhoto(diseaseNamePhoto);
                targetDiseaseName.setDiseaseNameVideo(diseaseNameVideo);
                targetDiseaseName.setDiseaseNameCategory(diseaseNameCategory);

                DiseaseName updatedDiseaseName = diseaseNameRepository.saveAndFlush(targetDiseaseName);

                return ResponseHelper.constructSuccessResponse(updatedDiseaseName);
            } else {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            }
        }
    }

    public JSONObject deleteExam(int diseaseNameId) {
        Optional<DiseaseName> targetDiseaseNameOptional = diseaseNameRepository.findById(diseaseNameId);

        if (targetDiseaseNameOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            diseaseNameRepository.deleteById(diseaseNameId);

            if (diseaseNameRepository.findById(diseaseNameId).isEmpty()) {
                return ResponseHelper.constructSuccessResponse(targetDiseaseNameOptional.get());
            } else {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            }
        }
    }
}
