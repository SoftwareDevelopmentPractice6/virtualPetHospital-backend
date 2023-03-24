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
import pet.hospital.backend.system.entity.Examine;

@Service
public class ExamineService {
    @Autowired
    ExamineRepository examineRepository;

    public JSONObject getExamine(String examineName, Double examinePrice) {
        JSONObject res = new JSONObject();
        res.put(
                Constants.examineList,
                JSONObject.parseArray(JSON.toJSONString(examineRepository.findAll().stream()
                        .filter(examine -> SearchJudgeHelper.softIncludes(examineName, examine.getExamineName()) &&
                                SearchJudgeHelper.softEquals(examinePrice, examine.getExaminePrice()))
                        .collect(Collectors.toList()))));
        return ResponseHelper.constructSuccessResponse(res);
    }

    public JSONObject addExamine(String examineName, double examinePrice) {
        List<Examine> targetExamineList = examineRepository.findAll().stream()
                .filter(examine -> Objects.equals(examine.getExamineName(), examineName))
                .collect(Collectors.toList());

        if (Objects.equals(targetExamineList.size(), 0)) {
            Examine newExamine = new Examine();
            newExamine.setExamineName(examineName);
            newExamine.setExaminePrice(examinePrice);

            Examine addedExamine = examineRepository.saveAndFlush(newExamine);

            return ResponseHelper.constructSuccessResponse(addedExamine);
        } else {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        }
    }

    public JSONObject updateExamine(int examineId, String examineName, double examinePrice) {
        Optional<Examine> targetExamineOptional = examineRepository.findById(examineId);

        if (targetExamineOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {

            List<Examine> targetExamineList = examineRepository.findAll().stream()
                    .filter(examine -> Objects.equals(examine.getExamineName(),
                            examineName)
                            && !Objects.equals(examine.getExamineId(), examineId))
                    .collect(Collectors.toList());

            if (Objects.equals(targetExamineList.size(), 0)) {
                Examine targetExamine = targetExamineOptional.get();
                targetExamine.setExamineName(examineName);
                targetExamine.setExaminePrice(examinePrice);

                Examine updatedExamine = examineRepository.saveAndFlush(targetExamine);

                return ResponseHelper.constructSuccessResponse(updatedExamine);
            } else {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
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
