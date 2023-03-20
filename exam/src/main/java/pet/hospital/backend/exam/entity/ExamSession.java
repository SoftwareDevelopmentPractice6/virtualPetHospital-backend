package pet.hospital.backend.exam.entity;

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

    @Column(name = "start_time")
    Date examSessionStartTime;

    @Column(name = "end_time")
    Date examSessionEndTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paper_id", referencedColumnName = "paper_id")
    Paper examSessionPaper;
}
