package ba.ecogo.grocerymonitor.model;

import ba.ecogo.grocerymonitor.model.base.BaseModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "registration")
public class Registration extends BaseModel {

    @Column(name = "name", nullable = false, length = 60)
    private String name;

    @Size(min = 6, max = 60)
    @Column(name = "password", nullable = false, length = 60)
    private String password;

    @Email
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "privilege", nullable = false, updatable = false)
    private UUID privilege = UUID.fromString("00000000-0000-0000-0000-000000000000");

    public Registration setPassword(String password) {
        String bCryptedPassword = !password.startsWith("$2a$") && !password.isBlank() ? new BCryptPasswordEncoder().encode(password) : password;
        this.password = (!password.isBlank()) ? bCryptedPassword : null;
        return this;
    }

}
