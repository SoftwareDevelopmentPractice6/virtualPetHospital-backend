package pet.hospital.backend.system.entity;

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
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_id", nullable = false)
    int medicineId;

    @Column(name = "medicine_name")
    String medicineName;

    @Column(name = "medicine_price")
    double medicinePrice;

    @Column(name = "manufacturer")
    String manufacturer;

    @Column(name = "class")
    String classes;

    @Column(name = "specification")
    String specification;

    @Column(name = "is_vaccine")
    int isVaccine;
}
