package pet.hospital.backend.medicalRecordManagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class DiseaseName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "disease_name_id", nullable = false)
    int diseaseNameId;

    @Column(name = "content")
    String diseaseNameContent;

    @Column(name = "photo")
    String diseaseNamePhoto;

    @Column(name = "video")
    String diseaseNameVideo;

    @Column(name = "category")
    String diseaseNameCategory;
}
