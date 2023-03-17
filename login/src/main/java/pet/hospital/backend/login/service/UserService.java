/*
 * @Author: pikapikapi pikapikapi_kaori@icloud.com
 * @Date: 2023-03-15 13:12:14
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-18 00:46:00
 * @FilePath: /virtualPetHospital-backend/login/src/main/java/pet/hospital/backend/login/service/UserService.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.login.service;

import com.alibaba.fastjson.JSONObject;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.hospital.backend.common.constant.Constants;
import pet.hospital.backend.common.helper.ResponseHelper;
import pet.hospital.backend.login.dao.UserRepository;
import pet.hospital.backend.login.entity.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public JSONObject login(String userName, String userPassword) {
        User targetUser = userRepository.getUserByUserName(userName);

        if (targetUser == null) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            if (Objects.equals(targetUser.getUserPassword(), userPassword)) {
                return ResponseHelper.constructSuccessResponse(targetUser);
            } else {
                return ResponseHelper.constructFailedResponse(ResponseHelper.authorityErrorCode);
            }
        }
    }

    public JSONObject addUser(String userName, String userPassword, int userAuthority) {
        User targetUser = userRepository.getUserByUserName(userName);

        if (targetUser == null) {
            User newUser = new User();
            newUser.setUserName(userName);
            newUser.setUserPassword(userPassword);
            newUser.setUserAuthority(userAuthority);

            User addedUser = userRepository.saveAndFlush(newUser);

            return ResponseHelper.constructSuccessResponse(addedUser);
        } else {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        }
    }

    public JSONObject updateUser(JSONObject newUserInfo) {
        Optional<User> targetUserOptional = userRepository.findById(newUserInfo.getInteger(Constants.userId));

        if (targetUserOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            User targetUser = targetUserOptional.get();
            targetUser.setUserName(newUserInfo.getString(Constants.userName));
            targetUser.setUserPassword(newUserInfo.getString(Constants.userPassword));
            targetUser.setUserAuthority(newUserInfo.getInteger(Constants.userAuthority));

            User updatedUser = userRepository.saveAndFlush(targetUser);

            return ResponseHelper.constructSuccessResponse(updatedUser);
        }
    }

    public JSONObject deleteUser(int userId) {
        Optional<User> targetUserOptional = userRepository.findById(userId);

        if (targetUserOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            userRepository.deleteById(userId);

            if (userRepository.findById(userId).isEmpty()) {
                return ResponseHelper.constructSuccessResponse(targetUserOptional.get());
            } else {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            }
        }
    }
}
