/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-15 11:47:38
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-15 11:53:04
 * @FilePath: /virtualPetHospital-backend/login/src/main/java/pet/hospital/backend/login/dao/UserDao.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.login.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pet.hospital.backend.login.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.user_name = :user_name and u.password = :password")
    User get_user(@Param("user_name") String email, @Param("password") String password);
}
