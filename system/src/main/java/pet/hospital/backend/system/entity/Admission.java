package pet.hospital.backend.system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Admission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admission_id", nullable = false)
    int admissionId;

    @Column(name = "room_standard")
    String roomStandard;

    @Column(name = "care_level")
    String careLevel;

    @Column(name = "remark")
    String remark;

    @Column(name = "care_price")
    double carePrice;

    @ManyToOne
    @JoinColumn(name = "room_name", referencedColumnName = "room_name")
    Room admissionRoom;
}
