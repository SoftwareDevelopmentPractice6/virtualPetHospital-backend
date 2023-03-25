package pet.hospital.backend.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.hospital.backend.system.entity.Archive;

public interface ArchiveRepository extends JpaRepository<Archive, Integer> {}
