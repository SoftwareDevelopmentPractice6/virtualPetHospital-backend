/*
 * @Author: pikapikapikaori pikapikapi_kaori@icloud.com
 * @Date: 2023-03-27 18:51:51
 * @LastEditors: pikapikapikaori pikapikapi_kaori@icloud.com
 * @LastEditTime: 2023-03-27 19:15:49
 * @FilePath: /virtualPetHospital-backend/medicalRecordManagement/src/main/java/pet/hospital/backend/medicalRecordManagement/entity/MedicalCase.java
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
package pet.hospital.backend.medicalRecordManagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "MEDICALCASE")
public class MedicalCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "case_id", nullable = false)
    int medicalCaseId;

    @ManyToOne
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
