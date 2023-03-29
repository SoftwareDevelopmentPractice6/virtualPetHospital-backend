package pet.hospital.backend.exam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.hospital.backend.exam.entity.QuestionInPaper;

public interface QuestionInPaperRepository extends JpaRepository<QuestionInPaper, Integer> {}
