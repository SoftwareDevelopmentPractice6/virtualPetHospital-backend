/*
 * @Author: pikapikapi pikapikapi_kaori@icloud.com
 * @Date: 2023-03-15 13:12:14
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-17 22:55:46
 * @FilePath: /virtualPetHospital-backend/login/src/main/java/pet/hospital/backend/login/service/UserService.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.login.service;

import com.alibaba.fastjson.JSONObject;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.hospital.backend.login.constant.Constants;
import pet.hospital.backend.login.dao.UserRepository;
import pet.hospital.backend.login.entity.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public JSONObject login(String userName, String userPassword) {
        JSONObject res = new JSONObject();

        User targetUser = userRepository.getUserByUserName(userName);

        if (targetUser == null) {
            res.put(Constants.code, Constants.requestErrorCode);
            res.put(Constants.data, null);
        } else {
            if (Objects.equals(targetUser.getPassword(), userPassword)) {
                JSONObject resData = new JSONObject();
                resData.put(Constants.userId, targetUser.getUserId());
                resData.put(Constants.userName, targetUser.getUserName());
                resData.put(Constants.userPassword, targetUser.getPassword());
                resData.put(Constants.userAuthority, targetUser.getAuthority());

                res.put(Constants.code, Constants.successCode);
                res.put(Constants.data, resData);
            } else {
                res.put(Constants.code, Constants.authorityErrorCode);
                res.put(Constants.data, null);
            }
        }

        return res;
    }

    public JSONObject addUser(String userName, String userPassword, int userAuthority) {
        JSONObject res = new JSONObject();

        User targetUser = userRepository.getUserByUserName(userName);

        if (targetUser == null) {
            User newUser = new User();
            newUser.setUserName(userName);
            newUser.setPassword(userPassword);
            newUser.setAuthority(userAuthority);

            User addedUser = userRepository.saveAndFlush(newUser);

            JSONObject resData = new JSONObject();
            resData.put(Constants.userId, addedUser.getUserId());
            resData.put(Constants.userName, addedUser.getUserName());
            resData.put(Constants.userPassword, addedUser.getPassword());
            resData.put(Constants.userAuthority, addedUser.getAuthority());

            res.put(Constants.code, Constants.successCode);
            res.put(Constants.data, resData);
        } else {
            res.put(Constants.code, Constants.requestErrorCode);
            res.put(Constants.data, null);
        }

        return res;
    }

    public JSONObject updateUser(JSONObject newUserInfo) {
        JSONObject res = new JSONObject();

        Optional<User> targetUserOptional = userRepository.findById(newUserInfo.getInteger(Constants.userId));

        if (targetUserOptional.isEmpty()) {
            res.put(Constants.code, Constants.requestErrorCode);
            res.put(Constants.data, null);
        } else {
            User targetUser = targetUserOptional.get();
            targetUser.setUserName(newUserInfo.getString(Constants.userName));
            targetUser.setPassword(newUserInfo.getString(Constants.userPassword));
            targetUser.setAuthority(newUserInfo.getInteger(Constants.userAuthority));

            User addedUser = userRepository.saveAndFlush(targetUser);

            JSONObject resData = new JSONObject();
            resData.put(Constants.userId, addedUser.getUserId());
            resData.put(Constants.userName, addedUser.getUserName());
            resData.put(Constants.userPassword, addedUser.getPassword());
            resData.put(Constants.userAuthority, addedUser.getAuthority());

            res.put(Constants.code, Constants.successCode);
            res.put(Constants.data, resData);
        }

        return res;
    }

    public JSONObject deleteUser(int userId) {
        JSONObject res = new JSONObject();

        Optional<User> targetUserOptional = userRepository.findById(userId);

        if (targetUserOptional.isEmpty()) {
            res.put(Constants.code, Constants.requestErrorCode);
            res.put(Constants.data, null);
        } else {
            userRepository.deleteById(userId);

            if (userRepository.findById(userId).isEmpty()) {
                JSONObject resData = new JSONObject();
                resData.put(Constants.userId, targetUserOptional.get().getUserId());
                resData.put(Constants.userName, targetUserOptional.get().getUserName());
                resData.put(Constants.userPassword, targetUserOptional.get().getPassword());
                resData.put(Constants.userAuthority, targetUserOptional.get().getAuthority());

                res.put(Constants.code, Constants.successCode);
                res.put(Constants.data, resData);
            }
            else {
                res.put(Constants.code, Constants.requestErrorCode);
                res.put(Constants.data, null);
            }
        }

        return res;
    }
}
