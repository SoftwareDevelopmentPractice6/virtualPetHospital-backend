/*
 * @Author: pikapikapi pikapikapi_kaori@icloud.com
 * @Date: 2023-03-15 13:12:14
 * @LastEditors: pikapikapi pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-15 13:50:27
 * @FilePath: /virtualPetHospital-backend/login/src/main/java/service/UserService.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.login.service;

import com.alibaba.fastjson.JSONObject;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.hospital.backend.login.constant.Constants;
import pet.hospital.backend.login.dao.UserRepository;
import pet.hospital.backend.login.entity.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public JSONObject login(String userName, String password) {
        JSONObject res = new JSONObject();

        User targetUser = userRepository.getUser(userName, password);

        if (targetUser == null) {
            res.put(Constants.code, Constants.errorCode);
            res.put(Constants.message, Constants.noUserMessage);
        } else {
            if (Objects.equals(targetUser.getUserName(), userName)
                    && Objects.equals(targetUser.getPassword(), password)) {
                res.put(Constants.code, Constants.successCode);
                res.put(Constants.message, Constants.findUserMessage);
                res.put(Constants.userId, targetUser.getUserId());
                res.put(Constants.userName, targetUser.getUserName());
                res.put(Constants.userPassword, targetUser.getPassword());
                res.put(Constants.userAuthority, targetUser.getAuthority());
            } else {
                res.put(Constants.code, Constants.errorCode);
                res.put(Constants.message, Constants.wrongUserMessage);
            }
        }

        return res;
    }
}
