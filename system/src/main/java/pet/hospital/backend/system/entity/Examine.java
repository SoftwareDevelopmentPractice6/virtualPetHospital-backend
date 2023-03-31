/*
 * @Author: pikapikapi pikapikapi_kaori@icloud.com
 * @Date: 2023-03-29 14:06:11
 * @LastEditors: pikapikapi pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-31 08:28:07
 * @FilePath: /virtualPetHospital-backend/system/src/main/java/pet/hospital/backend/system/entity/Examine.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Examine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "examine_id", nullable = false)
    int examineId;

    @Column(name = "examine_name")
    String examineName;

    @Column(name = "examine_price")
    double examinePrice;

    @ManyToOne
    @JoinColumn(name = "room_name", referencedColumnName = "room_name")
    Room examineRoom;
}
