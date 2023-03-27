package pet.hospital.backend.medicalRecordManagement.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.JSON;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.hospital.backend.common.constant.Constants;
import pet.hospital.backend.common.helper.ResponseHelper;
import pet.hospital.backend.common.helper.SearchJudgeHelper;
import pet.hospital.backend.medicalRecordManagement.dao.AdmissionRepository;
import pet.hospital.backend.medicalRecordManagement.dao.CaseCheckRepository;
import pet.hospital.backend.medicalRecordManagement.dao.DiagnosticResultRepository;
import pet.hospital.backend.medicalRecordManagement.dao.DiseaseNameRepository;
import pet.hospital.backend.medicalRecordManagement.dao.MedicalCaseRepository;
import pet.hospital.backend.medicalRecordManagement.dao.TreatmentProgramRepository;
import pet.hospital.backend.medicalRecordManagement.entity.Admission;
import pet.hospital.backend.medicalRecordManagement.entity.CaseCheck;
import pet.hospital.backend.medicalRecordManagement.entity.DiagnosticResult;
import pet.hospital.backend.medicalRecordManagement.entity.DiseaseName;
import pet.hospital.backend.medicalRecordManagement.entity.MedicalCase;
import pet.hospital.backend.medicalRecordManagement.entity.TreatmentProgram;

@Service
public class MedicalCaseService {
    @Autowired
    MedicalCaseRepository medicalCaseRepository;

    @Autowired
    AdmissionRepository admissionRepository;

    @Autowired
    CaseCheckRepository caseCheckRepository;

    @Autowired
    DiagnosticResultRepository diagnosticResultRepository;

    @Autowired
    DiseaseNameRepository diseaseNameRepository;

    @Autowired
    TreatmentProgramRepository treatmentProgramRepository;

    public JSONObject getMedicalCase(
            Integer medicalCaseId,
            Integer admissionId,
            Integer caseCheckId,
            Integer diagnosticResultId,
            Integer treatmentProgramId,
            Integer diseaseNameId) {
        JSONObject res = new JSONObject();
        res.put(
                Constants.medicalCaseList,
                JSONObject.parseArray(JSON.toJSONString(medicalCaseRepository.findAll().stream()
                        .filter(medicalCase -> SearchJudgeHelper.softEquals(
                                        admissionId,
                                        medicalCase.getMedicalCaseAdmission().getAdmissionId())
                                && SearchJudgeHelper.softEquals(
                                        caseCheckId,
                                        medicalCase.getMedicalCaseCaseCheck().getCaseCheckId())
                                && SearchJudgeHelper.softEquals(
                                        diagnosticResultId,
                                        medicalCase
                                                .getMedicalCaseDiagnosticResult()
                                                .getDiagnosticResultId())
                                && SearchJudgeHelper.softEquals(
                                        diseaseNameId,
                                        medicalCase.getMedicalCaseDiseaseName().getDiseaseNameId())
                                && SearchJudgeHelper.softEquals(
                                        treatmentProgramId,
                                        medicalCase
                                                .getMedicalCaseTreatmentProgram()
                                                .getTreatmentProgramId())
                                && SearchJudgeHelper.softEquals(medicalCaseId, medicalCase.getMedicalCaseId()))
                        .collect(Collectors.toList()))));
        return ResponseHelper.constructSuccessResponse(res);
    }

    public JSONObject addMedicalCase(
            int admissionId, int caseCheckId, int diagnosticResultId, int treatmentProgramId, int diseaseNameId) {

        Optional<Admission> targetAdmissionOptional = admissionRepository.findById(admissionId);
        Optional<CaseCheck> targetCaseCheckIdOptional = caseCheckRepository.findById(caseCheckId);
        Optional<DiagnosticResult> targetDiagnosticResultOptional =
                diagnosticResultRepository.findById(diagnosticResultId);
        Optional<DiseaseName> targetDiseaseNameOptional = diseaseNameRepository.findById(diseaseNameId);
        Optional<TreatmentProgram> targetTreatmentProgramOptional =
                treatmentProgramRepository.findById(treatmentProgramId);

        if (targetAdmissionOptional.isEmpty()
                || targetCaseCheckIdOptional.isEmpty()
                || targetDiagnosticResultOptional.isEmpty()
                || targetDiseaseNameOptional.isEmpty()
                || targetTreatmentProgramOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {

            List<MedicalCase> targetMedicalCaseList = medicalCaseRepository.findAll().stream()
                    .filter(medicalCase -> Objects.equals(
                                    medicalCase.getMedicalCaseAdmission().getAdmissionId(), admissionId)
                            || Objects.equals(
                                    medicalCase.getMedicalCaseCaseCheck().getCaseCheckId(), caseCheckId)
                            || Objects.equals(
                                    medicalCase.getMedicalCaseDiagnosticResult().getDiagnosticResultId(),
                                    diagnosticResultId)
                            || Objects.equals(
                                    medicalCase.getMedicalCaseTreatmentProgram().getTreatmentProgramId(),
                                    treatmentProgramId))
                    .collect(Collectors.toList());
            if (Objects.equals(targetMedicalCaseList.size(), 0)) {
                MedicalCase newMedicalCase = new MedicalCase();

                newMedicalCase.setMedicalCaseDiseaseName(targetDiseaseNameOptional.get());
                newMedicalCase.setMedicalCaseAdmission(targetAdmissionOptional.get());
                newMedicalCase.setMedicalCaseCaseCheck(targetCaseCheckIdOptional.get());
                newMedicalCase.setMedicalCaseDiagnosticResult(targetDiagnosticResultOptional.get());
                newMedicalCase.setMedicalCaseTreatmentProgram(targetTreatmentProgramOptional.get());

                MedicalCase addedMedicalCase = medicalCaseRepository.saveAndFlush(newMedicalCase);

                return ResponseHelper.constructSuccessResponse(addedMedicalCase);
            } else {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            }
        }
    }

    public JSONObject updateMedicalCase(
            int medicalCaseId,
            int admissionId,
            int caseCheckId,
            int diagnosticResultId,
            int treatmentProgramId,
            int diseaseNameId) {
        Optional<MedicalCase> targetMedicalCaseOptional = medicalCaseRepository.findById(medicalCaseId);

        if (targetMedicalCaseOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            Optional<Admission> targetAdmissionOptional = admissionRepository.findById(admissionId);
            Optional<CaseCheck> targetCaseCheckIdOptional = caseCheckRepository.findById(caseCheckId);
            Optional<DiagnosticResult> targetDiagnosticResultOptional =
                    diagnosticResultRepository.findById(diagnosticResultId);
            Optional<DiseaseName> targetDiseaseNameOptional = diseaseNameRepository.findById(diseaseNameId);
            Optional<TreatmentProgram> targetTreatmentProgramOptional =
                    treatmentProgramRepository.findById(treatmentProgramId);

            if (targetAdmissionOptional.isEmpty()
                    || targetCaseCheckIdOptional.isEmpty()
                    || targetDiagnosticResultOptional.isEmpty()
                    || targetDiseaseNameOptional.isEmpty()
                    || targetTreatmentProgramOptional.isEmpty()) {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            } else {
                List<MedicalCase> targetMedicalCaseList = medicalCaseRepository.findAll().stream()
                        .filter(medicalCase -> (Objects.equals(
                                                medicalCase
                                                        .getMedicalCaseAdmission()
                                                        .getAdmissionId(),
                                                admissionId)
                                        || Objects.equals(
                                                medicalCase
                                                        .getMedicalCaseCaseCheck()
                                                        .getCaseCheckId(),
                                                caseCheckId)
                                        || Objects.equals(
                                                medicalCase
                                                        .getMedicalCaseDiagnosticResult()
                                                        .getDiagnosticResultId(),
                                                diagnosticResultId)
                                        || Objects.equals(
                                                medicalCase
                                                        .getMedicalCaseTreatmentProgram()
                                                        .getTreatmentProgramId(),
                                                treatmentProgramId))
                                && !Objects.equals(medicalCase.getMedicalCaseId(), medicalCaseId))
                        .collect(Collectors.toList());

                if (Objects.equals(targetMedicalCaseList.size(), 0)) {
                    MedicalCase targetMedicalCase = targetMedicalCaseOptional.get();
                    targetMedicalCase.setMedicalCaseDiseaseName(targetDiseaseNameOptional.get());
                    targetMedicalCase.setMedicalCaseAdmission(targetAdmissionOptional.get());
                    targetMedicalCase.setMedicalCaseCaseCheck(targetCaseCheckIdOptional.get());
                    targetMedicalCase.setMedicalCaseDiagnosticResult(targetDiagnosticResultOptional.get());
                    targetMedicalCase.setMedicalCaseTreatmentProgram(targetTreatmentProgramOptional.get());

                    MedicalCase updatedMedicalCase = medicalCaseRepository.saveAndFlush(targetMedicalCase);

                    return ResponseHelper.constructSuccessResponse(updatedMedicalCase);
                } else {
                    return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
                }
            }
        }
    }

    public JSONObject deleteExam(int medicalCaseId) {
        Optional<MedicalCase> targetMedicalCaseOptional = medicalCaseRepository.findById(medicalCaseId);

        if (targetMedicalCaseOptional.isEmpty()) {
            return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
        } else {
            medicalCaseRepository.deleteById(medicalCaseId);

            if (medicalCaseRepository.findById(medicalCaseId).isEmpty()) {
                return ResponseHelper.constructSuccessResponse(targetMedicalCaseOptional.get());
            } else {
                return ResponseHelper.constructFailedResponse(ResponseHelper.requestErrorCode);
            }
        }
    }
}
