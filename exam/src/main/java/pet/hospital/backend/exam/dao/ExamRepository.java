/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-19 14:41:14
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-19 14:41:16
 * @FilePath: /virtualPetHospital-backend/exam/src/main/java/pet/hospital/backend/exam/dao/ExamRepository.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.exam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.hospital.backend.exam.entity.Exam;

public interface ExamRepository extends JpaRepository<Exam, Integer> {}
