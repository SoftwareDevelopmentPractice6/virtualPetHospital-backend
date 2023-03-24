package pet.hospital.backend.medicalRecordManagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class MedicalCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "case_id", nullable = false)
    int medicalCaseId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "disease_name_id", referencedColumnName = "disease_name_id")
    DiseaseName medicalCaseDiseaseName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "admission_id", referencedColumnName = "admission_id")
    Admission medicalCaseAdmission;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "casecheck_id", referencedColumnName = "casecheck_id")
    CaseCheck medicalCaseCaseCheck;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diagnostic_result_id", referencedColumnName = "diagnostic_result_id")
    DiagnosticResult medicalCaseDiagnosticResult;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "treatment_program_id", referencedColumnName = "treatment_program_id")
    TreatmentProgram medicalCaseTreatmentProgram;
}
