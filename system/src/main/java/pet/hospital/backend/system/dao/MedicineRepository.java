package pet.hospital.backend.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.hospital.backend.system.entity.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Integer> {}
