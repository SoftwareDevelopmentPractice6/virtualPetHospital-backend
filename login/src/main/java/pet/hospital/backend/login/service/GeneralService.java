package pet.hospital.backend.login.service;

import com.alibaba.fastjson.JSONObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.hospital.backend.common.constant.Constants;
import pet.hospital.backend.common.helper.ResponseHelper;
import pet.hospital.backend.login.dao.UserRepository;

@Service
public class GeneralService {
    @Autowired
    private UserRepository userRepository;

    public JSONObject getDataById(String tableName, int id) throws Exception {
        Class<?> dataDaoClass = Class.forName(
                Constants.projectPackageName + "." + Constants.authModulePackageName + "."
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
