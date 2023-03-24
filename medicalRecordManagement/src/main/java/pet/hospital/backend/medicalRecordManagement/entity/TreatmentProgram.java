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
public class TreatmentProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "treatment_program_id", nullable = false)
    int treatmentProgramId;

    @Column(name = "content")
    String treatmentProgramContent;

    @Column(name = "photo")
    String treatmentProgramPhoto;

    @Column(name = "video")
    String treatmentProgramVideo;
}
