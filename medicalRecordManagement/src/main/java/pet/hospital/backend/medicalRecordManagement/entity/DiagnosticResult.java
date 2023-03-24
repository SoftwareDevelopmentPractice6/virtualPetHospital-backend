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
public class DiagnosticResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diagnostic_result_id", nullable = false)
    int diagnosticResultId;

    @Column(name = "content")
    String diagnosticResultContent;

    @Column(name = "photo")
    String diagnosticResultPhoto;

    @Column(name = "video")
    String diagnosticResultVideo;
}
