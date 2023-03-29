/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-27 18:51:51
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-27 18:55:51
 * @FilePath: /virtualPetHospital-backend/medicalRecordManagement/src/main/java/pet/hospital/backend/medicalRecordManagement/entity/DiseaseName.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.medicalRecordManagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "DISEASENAME")
public class DiseaseName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "disease_name_id", nullable = false)
    int diseaseNameId;

    @Column(name = "content")
    String diseaseNameContent;

    @Column(name = "photo")
    String diseaseNamePhoto;

    @Column(name = "video")
    String diseaseNameVideo;

    @Column(name = "category")
    String diseaseNameCategory;
}
