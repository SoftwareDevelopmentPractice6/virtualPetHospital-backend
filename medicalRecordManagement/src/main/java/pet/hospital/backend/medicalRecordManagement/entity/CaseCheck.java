package pet.hospital.backend.medicalRecordManagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CASECHECK")
public class CaseCheck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "casecheck_id", nullable = false)
    int caseCheckId;

    @Column(name = "content")
    String caseCheckContent;

    @Column(name = "photo")
    String caseCheckPhoto;

    @Column(name = "video")
    String caseCheckVideo;
}
