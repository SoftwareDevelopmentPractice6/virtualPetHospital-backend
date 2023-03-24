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
import pet.hospital.backend.system.dao.ChargeRepository;
import pet.hospital.backend.system.entity.Charge;

@Service
public class ChargeService {
    @Autowired
    ChargeRepository chargeRepository;

    public JSONObject getCharge(String itemName, Double chargePrice) {
        JSONObject res = new JSONObject();
        res.put(
                Constants.chargeList,
                JSONObject.parseArray(JSON.toJSONString(chargeRepository.findAll().stream()
                        .filter(charge -> SearchJudgeHelper.softIncludes(itemName, charge.getItemName())
                                && SearchJudgeHelper.softEquals(chargePrice, charge.getChargePrice()))
                        .collect(Collectors.toList()))));
        return ResponseHelper.constructSuccessResponse(res);
    }

    public JSONObject addCharge(String itemName, double chargePrice) {
        List<Charge> targetChargeList = chargeRepository.findAll().stream()
                .filter(charge -> Objects.equals(charge.getItemName(), itemName))
                .collect(Collectors.toList());

        if (Objects.equals(targetChargeList.size(), 0)) {
            Charge newCharge = new Charge();
            newCharge.setItemName(itemName);
            newCharge.setChargePrice(chargePrice);

            Charge addedCharge = chargeRepository.saveAndFlush(newCharge);

            return ResponseHelper.constructSuccessResponse(addedCharge);
        } else {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        }
    }

    public JSONObject updateCharge(int chargeId, String itemName, double chargePrice) {
        Optional<Charge> targetChargeOptional = chargeRepository.findById(chargeId);

        if (targetChargeOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {

            List<Charge> targetChargeList = chargeRepository.findAll().stream()
                    .filter(charge -> Objects.equals(charge.getItemName(), itemName)
                            && !Objects.equals(charge.getChargeId(), chargeId))
                    .collect(Collectors.toList());

            if (Objects.equals(targetChargeList.size(), 0)) {
                Charge targetCharge = targetChargeOptional.get();
                targetCharge.setItemName(itemName);
                targetCharge.setChargePrice(chargePrice);

                Charge updatedCharge = chargeRepository.saveAndFlush(targetCharge);

                return ResponseHelper.constructSuccessResponse(updatedCharge);
            } else {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            }
        }
    }

    public JSONObject deleteCharge(int chargeId) {
        Optional<Charge> targetChargeOptional = chargeRepository.findById(chargeId);

        if (targetChargeOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            chargeRepository.deleteById(chargeId);

            if (chargeRepository.findById(chargeId).isEmpty()) {
                return ResponseHelper.constructSuccessResponse(targetChargeOptional.get());
            } else {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            }
        }
    }
}
