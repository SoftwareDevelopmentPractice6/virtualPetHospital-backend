package pet.hospital.backend.medicalRecordManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.hospital.backend.medicalRecordManagement.entity.DiseaseName;

public interface DiseaseNameRepository extends JpaRepository<DiseaseName, Integer> {}
