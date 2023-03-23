/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-22 20:00:50
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-23 15:25:46
 * @FilePath: /virtualPetHospital-backend/exam/src/main/java/pet/hospital/backend/exam/entity/ExamSession.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.exam.entity;

import com.alibaba.fastjson.annotation.JSONField;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "EXAMSESSION")
public class ExamSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id", nullable = false)
    int examSessionId;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "start_time")
    Date examSessionStartTime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "end_time")
    Date examSessionEndTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paper_id", referencedColumnName = "paper_id")
    Paper examSessionPaper;
}
