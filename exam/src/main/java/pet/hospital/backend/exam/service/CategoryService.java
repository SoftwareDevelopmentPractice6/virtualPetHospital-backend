/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-19 15:10:21
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-19 15:15:40
 * @FilePath: /virtualPetHospital-backend/exam/src/main/java/pet/hospital/backend/exam/service/CategoryService.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.exam.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.JSON;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.hospital.backend.common.constant.Constants;
import pet.hospital.backend.common.helper.ResponseHelper;
import pet.hospital.backend.exam.dao.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public JSONObject getCategories(String categoryKeyword) {
        JSONObject res = new JSONObject();
        res.put(
                Constants.categoryList,
                JSONObject.parseArray(JSON.toJSONString(categoryRepository.findAll().stream()
                        .filter(category ->
                                !Objects.equals(category.getCategoryName().indexOf(categoryKeyword), -1))
                        .collect(Collectors.toList()))));
        return ResponseHelper.constructSuccessResponse(res);
    }
}
