/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-04-22 21:42:19
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-04-22 23:22:30
 * @FilePath: /virtualPetHospital-backend/system/src/main/java/pet/hospital/backend/system/service/GeneralService.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.system.service;

import com.alibaba.fastjson.JSONObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.hospital.backend.common.constant.Constants;
import pet.hospital.backend.common.helper.ResponseHelper;
import pet.hospital.backend.system.dao.AdmissionRepository;
import pet.hospital.backend.system.dao.ArchiveRepository;
import pet.hospital.backend.system.dao.ChargeRepository;
import pet.hospital.backend.system.dao.ExamineRepository;
import pet.hospital.backend.system.dao.FeatureRepository;
import pet.hospital.backend.system.dao.MedicineRepository;
import pet.hospital.backend.system.dao.RoomRepository;

@Service
public class GeneralService {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private FeatureRepository featureRepository;

    @Autowired
    private AdmissionRepository admissionRepository;

    @Autowired
    private ArchiveRepository archiveRepository;

    @Autowired
    private ChargeRepository chargeRepository;

    @Autowired
    private ExamineRepository examineRepository;

    @Autowired
    private MedicineRepository medicineRepository;

    public JSONObject getDataById(String tableName, int id) throws Exception {
        Class<?> dataDaoClass = Class.forName(
                Constants.projectPackageName + "." + Constants.systemModulePackageName + "."
                        + Constants.daoClassPackageName
                        + "." + tableName
                        + Constants.daoClassSuffix,
                true,
                Thread.currentThread().getContextClassLoader().getParent());

        Method getByIdMethod = null;

        for (Method classMethods : dataDaoClass.getMethods()) {
            if (Objects.equals(classMethods.getName(), Constants.findByIdMethodName)) {
                getByIdMethod = classMethods;
            }
        }

        for (Field selfField : this.getClass().getDeclaredFields()) {
            if (Objects.equals(selfField.getType().getName(), dataDaoClass.getName())) {
                Optional<?> getIdRes = (Optional<?>) getByIdMethod.invoke(selfField.get(this), id);

                if (getIdRes.isEmpty()) {
                    return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
                } else {
                    return ResponseHelper.constructSuccessResponse(getIdRes.get());
                }
            }
        }

        return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
    }
}
