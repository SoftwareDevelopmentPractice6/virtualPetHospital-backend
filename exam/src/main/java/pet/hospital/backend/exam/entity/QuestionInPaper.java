/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-23 16:48:16
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-23 16:50:21
 * @FilePath: /virtualPetHospital-backend/exam/src/main/java/pet/hospital/backend/exam/entity/QuestionInPaper.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.exam.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "QUESTIONSINPAPER")
public class QuestionInPaper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_in_paper_id", nullable = false)
    int questionInPaperId;

    @Column(name = "points")
    int questionPoint;

    @ManyToOne
    @JoinColumn(name = "paper_id", referencedColumnName = "paper_id")
    Paper questionInPaperPaper;

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    Question questionInPaperQuestion;
}
