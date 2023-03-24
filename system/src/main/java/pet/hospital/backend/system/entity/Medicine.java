/*
 * @Author: dafenqi-11 diaozehao@163.com
 * @Date: 2023-03-22 13:30:54
 * @LastEditors: dafenqi-11 diaozehao@163.com
 * @LastEditTime: 2023-03-24 08:27:38
 * @FilePath: \virtualPetHospital-backend\system\src\main\java\pet\hospital\backend\system\entity\Medicine.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_id", nullable = false)
    int medicineId;

    @Column(name = "medicine_name")
    String medicineName;

    @Column(name = "medicine_price")
    double medicinePrice;

    @Column(name = "manufacturer")
    String manufacturer;

    @Column(name = "class")
    String medicineClass;

    @Column(name = "specification")
    String specification;

    @Column(name = "is_vaccine")
    int isVaccine;
}
