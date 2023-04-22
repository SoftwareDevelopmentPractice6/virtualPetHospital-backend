/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-04-22 23:12:23
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-04-23 00:00:11
 * @FilePath: /virtualPetHospital-backend/exam/src/main/java/pet/hospital/backend/exam/service/GeneralService.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.exam.service;

import com.alibaba.fastjson.JSONObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.hospital.backend.common.constant.Constants;
import pet.hospital.backend.common.helper.ResponseHelper;
import pet.hospital.backend.exam.dao.CategoryRepository;
import pet.hospital.backend.exam.dao.ExamRepository;
import pet.hospital.backend.exam.dao.ExamSessionRepository;
import pet.hospital.backend.exam.dao.PaperRepository;
import pet.hospital.backend.exam.dao.QuestionInPaperRepository;
import pet.hospital.backend.exam.dao.QuestionRepository;
import pet.hospital.backend.exam.dao.StudentAnswerRepository;
import pet.hospital.backend.exam.dao.StudentResultRepository;

@Service
public class GeneralService {
    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private PaperRepository paperRepository;

    @Autowired
    private ExamSessionRepository examSessionRepository;

    @Autowired
    private StudentResultRepository studentResultRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionInPaperRepository questionInPaperRepository;

    @Autowired
    private StudentAnswerRepository studentAnswerRepository;

    public JSONObject getDataById(String tableName, int id) throws Exception {
        Class<?> dataDaoClass = Class.forName(
                Constants.projectPackageName + "." + Constants.examModulePackageName + "."
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
