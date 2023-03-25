package pet.hospital.backend.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.hospital.backend.system.entity.Charge;

public interface ChargeRepository extends JpaRepository<Charge, Integer> {}
