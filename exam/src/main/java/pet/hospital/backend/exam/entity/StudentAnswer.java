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
@Table(name = "STUDENTANSWER")
public class StudentAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_answer_id", nullable = false)
    int studentAnswerId;

    @Column(name = "student_answer_content")
    String studentAnswerContent;

    @Column(name = "student_answer_point")
    int studentAnswerPoint;

    @ManyToOne
    @JoinColumn(name = "question_in_paper_id", referencedColumnName = "question_in_paper_id")
    QuestionInPaper studentAnswerQuestionInPaper;

    @ManyToOne
    @JoinColumn(name = "result_id", referencedColumnName = "result_id")
    StudentResult studentAnswerStudentResult;
}
