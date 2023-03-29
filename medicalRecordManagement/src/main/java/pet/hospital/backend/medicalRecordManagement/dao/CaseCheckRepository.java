package pet.hospital.backend.medicalRecordManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.hospital.backend.medicalRecordManagement.entity.CaseCheck;

public interface CaseCheckRepository extends JpaRepository<CaseCheck, Integer> {}
