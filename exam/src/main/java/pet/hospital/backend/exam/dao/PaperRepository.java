package pet.hospital.backend.exam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.hospital.backend.exam.entity.Paper;

public interface PaperRepository extends JpaRepository<Paper, Integer> {}
