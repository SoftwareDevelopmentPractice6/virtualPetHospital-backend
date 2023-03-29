package pet.hospital.backend.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.hospital.backend.system.entity.Feature;

public interface FeatureRepository extends JpaRepository<Feature, Integer> {}
