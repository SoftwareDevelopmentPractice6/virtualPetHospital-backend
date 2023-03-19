package pet.hospital.backend.exam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.hospital.backend.exam.entity.StudentResult;

public interface StudentResultRepository extends JpaRepository<StudentResult, Integer> {}
