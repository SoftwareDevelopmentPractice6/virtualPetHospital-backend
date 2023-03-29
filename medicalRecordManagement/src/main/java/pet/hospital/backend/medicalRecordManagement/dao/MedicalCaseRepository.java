package pet.hospital.backend.medicalRecordManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.hospital.backend.medicalRecordManagement.entity.MedicalCase;

public interface MedicalCaseRepository extends JpaRepository<MedicalCase, Integer> {}
