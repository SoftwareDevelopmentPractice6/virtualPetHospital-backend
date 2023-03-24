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
import pet.hospital.backend.medicalRecordManagement.dao.DiseaseNameRepository;
import pet.hospital.backend.medicalRecordManagement.entity.DiseaseName;

@Service
public class DiseaseNameService {
    @Autowired
    DiseaseNameRepository diseaseNameRepository;

    public JSONObject getDiseaseName(Integer diseaseNameId, String diseaseNameKeyword) {
        JSONObject res = new JSONObject();
        res.put(
                Constants.diseaseNameList,
                JSONObject.parseArray(JSON.toJSONString(diseaseNameRepository.findAll().stream()
                        .filter(diseaseName ->
                                SearchJudgeHelper.softIncludes(diseaseNameKeyword, diseaseName.getDiseaseNameContent())
                                        && SearchJudgeHelper.softEquals(diseaseNameId, diseaseName.getDiseaseNameId()))
                        .collect(Collectors.toList()))));
        return ResponseHelper.constructSuccessResponse(res);
    }

    public JSONObject addDiseaseName(
            String diseaseNameContent, String diseaseNamePhoto, String diseaseNameVideo, String diseaseNameCategory) {

        DiseaseName newDiseaseName = new DiseaseName();
        newDiseaseName.setDiseaseNameContent(diseaseNameContent);
        newDiseaseName.setDiseaseNamePhoto(diseaseNamePhoto);
        newDiseaseName.setDiseaseNameVideo(diseaseNameVideo);
        newDiseaseName.setDiseaseNameCategory(diseaseNameCategory);

        DiseaseName addedDiseaseName = diseaseNameRepository.saveAndFlush(newDiseaseName);

        return ResponseHelper.constructSuccessResponse(addedDiseaseName);
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

            DiseaseName targetDiseaseName = targetDiseaseNameOptional.get();
            targetDiseaseName.setDiseaseNameContent(diseaseNameContent);
            targetDiseaseName.setDiseaseNamePhoto(diseaseNamePhoto);
            targetDiseaseName.setDiseaseNameVideo(diseaseNameVideo);
            targetDiseaseName.setDiseaseNameCategory(diseaseNameCategory);

            DiseaseName updatedDiseaseName = diseaseNameRepository.saveAndFlush(targetDiseaseName);

            return ResponseHelper.constructSuccessResponse(updatedDiseaseName);
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
