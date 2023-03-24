/*
 * @Author: dafenqi-11 diaozehao@163.com
 * @Date: 2023-03-22 13:42:20
 * @LastEditors: dafenqi-11 diaozehao@163.com
 * @LastEditTime: 2023-03-24 08:29:02
 * @FilePath: \virtualPetHospital-backend\system\src\main\java\pet\hospital\backend\system\entity\Archive.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Archive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "archive_id", nullable = false)
    int archiveId;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "store_time")
    Date storeTime;

    @Column(name = "disease_type")
    String diseaseType;

    @Column(name = "pet_type")
    String petType;

    @Column(name = "pet_name")
    String petName;

    @Column(name = "pet_sex")
    char petSex;

    @Column(name = "owner_tel")
    char ownerTel;
}
