/*
 * @Author: dafenqi-11 diaozehao@163.com
 * @Date: 2023-03-24 09:12:24
 * @LastEditors: dafenqi-11 diaozehao@163.com
 * @LastEditTime: 2023-03-24 13:35:24
 * @FilePath: \virtualPetHospital-backend\system\src\main\java\pet\hospital\backend\system\service\MedicineService.java
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
import pet.hospital.backend.system.dao.MedicineRepository;
import pet.hospital.backend.system.entity.Medicine;

@Service
public class MedicineService {
    @Autowired
    private MedicineRepository medicineRepository;

    public JSONObject getMedicine(
            String medicineName,
            Double medicinePrice,
            String manufacturer,
            String medicineCategory,
            String specification,
            Integer isVaccine) {
        JSONObject res = new JSONObject();
        res.put(
                Constants.medicineList,
                JSONObject.parseArray(JSON.toJSONString(medicineRepository.findAll().stream()
                        .filter(medicine -> SearchJudgeHelper.softIncludes(medicineName, medicine.getMedicineName())
                                && SearchJudgeHelper.softEquals(medicinePrice, medicine.getMedicinePrice())
                                && SearchJudgeHelper.softIncludes(manufacturer, medicine.getManufacturer())
                                && SearchJudgeHelper.softEquals(medicineCategory, medicine.getMedicineCategory())
                                && SearchJudgeHelper.softIncludes(specification, medicine.getSpecification())
                                && SearchJudgeHelper.softEquals(isVaccine, medicine.getIsVaccine()))
                        .collect(Collectors.toList()))));
        return ResponseHelper.constructSuccessResponse(res);
    }

    public JSONObject addMedicine(
            String medicineName,
            double medicinePrice,
            String manufacturer,
            String medicineCategory,
            String specification,
            int isVaccine) {
        List<Medicine> targetMedicineList = medicineRepository.findAll().stream()
                .filter(medicine -> Objects.equals(medicine.getMedicineName(), medicineName))
                .collect(Collectors.toList());

        // 判断药物名称是否已存在，存在则跳过新增
        if (Objects.equals(targetMedicineList.size(), 0)) {
            Medicine newMedicine = new Medicine();
            newMedicine.setMedicineName(medicineName);
            newMedicine.setMedicinePrice(medicinePrice);
            newMedicine.setManufacturer(manufacturer);
            newMedicine.setMedicineCategory(medicineCategory);
            newMedicine.setSpecification(specification);
            newMedicine.setIsVaccine(isVaccine);

            Medicine addedMedicine = medicineRepository.saveAndFlush(newMedicine);

            return ResponseHelper.constructSuccessResponse(addedMedicine);
        } else {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        }
    }

    public JSONObject updateMedicine(
            int medicineId,
            String medicineName,
            double medicinePrice,
            String manufacturer,
            String medicineCategory,
            String specification,
            int isVaccine) {
        Optional<Medicine> targetMedicineOptional = medicineRepository.findById(medicineId);

        if (targetMedicineOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {

            // 判断除了目标id外是否有别的id对应的药物名与更新药物名重复，若有则跳过更改
            List<Medicine> targetMedicineList = medicineRepository.findAll().stream()
                    .filter(medicine -> Objects.equals(medicine.getMedicineName(), medicineName)
                            && !Objects.equals(medicine.getMedicineId(), medicineId))
                    .collect(Collectors.toList());

            if (Objects.equals(targetMedicineList.size(), 0)) {
                Medicine targetMedicine = targetMedicineOptional.get();
                targetMedicine.setMedicineName(medicineName);
                targetMedicine.setMedicinePrice(medicinePrice);
                targetMedicine.setManufacturer(manufacturer);
                targetMedicine.setMedicineCategory(medicineCategory);
                targetMedicine.setSpecification(specification);
                targetMedicine.setIsVaccine(isVaccine);

                Medicine updatedMedicine = medicineRepository.saveAndFlush(targetMedicine);

                return ResponseHelper.constructSuccessResponse(updatedMedicine);
            } else {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            }
        }
    }

    public JSONObject deleteMedicine(int medicineId) {
        Optional<Medicine> targetMedicineOptional = medicineRepository.findById(medicineId);

        if (targetMedicineOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            medicineRepository.deleteById(medicineId);

            if (medicineRepository.findById(medicineId).isEmpty()) {
                return ResponseHelper.constructSuccessResponse(targetMedicineOptional.get());
            } else {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            }
        }
    }
}
