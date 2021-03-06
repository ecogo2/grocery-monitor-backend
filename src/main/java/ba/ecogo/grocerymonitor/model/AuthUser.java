package ba.ecogo.grocerymonitor.model;

import ba.ecogo.grocerymonitor.model.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;


@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Entity
@Table(name = "app_user", uniqueConstraints = {@UniqueConstraint(name = "uc_user_name", columnNames = {"username"}),
                                               @UniqueConstraint(name = "uc_user_email", columnNames = {"email"})})
public class AuthUser extends BaseModel {

    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "password")
    private String password;

    @Email
    @Column(name = "email")
    private String email;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "privilege", referencedColumnName = "id")
    private Privilege privilege;

    public AuthUser(AuthUser authUser) {
        super();
        this.username = authUser.getUsername();
        this.password = authUser.getPassword();
        this.email = authUser.getEmail();
        this.privilege = authUser.getPrivilege();
    }

    public AuthUser(Registration registration, Privilege privilege) {
        super();
        this.username = registration.getName();
        this.password = registration.getPassword();
        this.email = registration.getEmail();
        this.privilege = privilege;
    }
}
