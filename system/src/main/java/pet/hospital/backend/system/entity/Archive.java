package pet.hospital.backend.system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Archive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "archive_id", nullable = false)
    int archiveId;

    @Column(name = "store_time")
    Date storeTime;

    @Column(name = "disease_type")
    String diseaseType;

    @Column(name = "pet_type")
    String petType;

    @Column(name = "func_video")
    String funcVideo;

    @Column(name = "pet_sex")
    char petSex;

    @Column(name = "owner_tel")
    char ownerTel;
}
