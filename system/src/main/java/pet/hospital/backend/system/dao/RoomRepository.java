package pet.hospital.backend.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.hospital.backend.system.entity.Room;

public interface RoomRepository extends JpaRepository<Room, String> {}
