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
public class Examine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "examine_id", nullable = false)
    int examineId;

    @Column(name = "examine_name")
    String examineName;

    @Column(name = "examine_price")
    double examinePrice;
}
