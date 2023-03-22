/*
 * @Author: dafenqi-11 diaozehao.163.com
 * @Date: 2023-03-22 13:19:50
 * @LastEditors: dafenqi-11 diaozehao.163.com
 * @LastEditTime: 2023-03-22 13:36:31
 * @FilePath: \virtualPetHospital-backend\system\src\main\java\pet\hospital\backend\system\entity\Feature.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.system.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "func_id", nullable = false)
    int funcId;

    @Column(name = "func_name")
    String funcName;

    @Column(name = "func_description")
    String funcDescription;

    @Column(name = "func_flow")
    String funcFlow;

    @Column(name = "func_video")
    String funcVideo;

    @Column(name = "func_role")
    String funcRole;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_name", referencedColumnName = "room_name")
    Room featureRoom;
}
