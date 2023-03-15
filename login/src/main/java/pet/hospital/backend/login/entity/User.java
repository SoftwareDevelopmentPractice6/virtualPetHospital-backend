package pet.hospital.backend.login.entity;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {
    public int user_id;

    public String user_name;

    public String password;

    public int authority;
}
