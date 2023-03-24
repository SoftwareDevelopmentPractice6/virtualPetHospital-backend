package pet.hospital.backend.medicalRecordManagement.entity;

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
public class Admission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admission_id", nullable = false)
    int admissionId;

    @Column(name = "content")
    String admissionContent;

    @Column(name = "photo")
    String admissionPhoto;

    @Column(name = "video")
    String admissionVideo;
}
