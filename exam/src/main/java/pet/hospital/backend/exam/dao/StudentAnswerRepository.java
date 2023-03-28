/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-28 18:07:42
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-28 18:07:44
 * @FilePath: /virtualPetHospital-backend/exam/src/main/java/pet/hospital/backend/exam/dao/StudentAnswerRepository.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.exam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.hospital.backend.exam.entity.StudentAnswer;

public interface StudentAnswerRepository extends JpaRepository<StudentAnswer, Integer> {}
