package pet.hospital.backend.exam.entity;

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
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id", nullable = false)
    int questionId;

    @Column(name = "question_content")
    String questionContent;

    @Column(name = "question_type")
    String questionType;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    Category questionCategory;
}
