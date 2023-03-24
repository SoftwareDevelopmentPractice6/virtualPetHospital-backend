package pet.hospital.backend.medicalRecordManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.hospital.backend.medicalRecordManagement.entity.Admission;

public interface AdmissionRepository extends JpaRepository<Admission, Integer> {}
