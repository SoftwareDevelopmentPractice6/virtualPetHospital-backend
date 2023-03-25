/*
 * @Author: dafenqi-11 diaozehao.163.com
 * @Date: 2023-03-22 13:14:47
 * @LastEditors: dafenqi-11 diaozehao.163.com
 * @LastEditTime: 2023-03-22 14:06:52
 * @FilePath: \virtualPetHospital-backend\system\src\main\java\pet\hospital\backend\system\entity\Room.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Room {
    @Id
    @Column(name = "room_name", nullable = false)
    String roomName;

    @Column(name = "room_role")
    String roomRole;
}
