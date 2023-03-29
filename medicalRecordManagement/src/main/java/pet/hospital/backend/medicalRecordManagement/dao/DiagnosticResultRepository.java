package pet.hospital.backend.medicalRecordManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.hospital.backend.medicalRecordManagement.entity.DiagnosticResult;

public interface DiagnosticResultRepository extends JpaRepository<DiagnosticResult, Integer> {}
