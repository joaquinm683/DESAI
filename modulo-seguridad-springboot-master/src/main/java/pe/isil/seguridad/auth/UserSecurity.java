package pe.isil.seguridad.auth;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="auth_user", uniqueConstraints = @UniqueConstraint(name = "u_email", columnNames = "email"))
public class UserSecurity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name;
    private  String email;
    private String password;
    private Date createdAt;

    @PostPersist
    public void updateCreatedAt(){
        createdAt = new Date();
    }


}
