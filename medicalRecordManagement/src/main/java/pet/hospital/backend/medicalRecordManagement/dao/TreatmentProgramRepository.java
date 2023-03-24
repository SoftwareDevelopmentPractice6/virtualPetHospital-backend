package pet.hospital.backend.medicalRecordManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.hospital.backend.medicalRecordManagement.entity.TreatmentProgram;

public interface TreatmentProgramRepository extends JpaRepository<TreatmentProgram, Integer> {}
