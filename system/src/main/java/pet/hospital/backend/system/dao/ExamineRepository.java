package pet.hospital.backend.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.hospital.backend.system.entity.Examine;

public interface ExamineRepository extends JpaRepository<Examine, Integer> {}
