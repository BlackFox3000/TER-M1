package mybootapp.model.user;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
@Data
@Getter
@NoArgsConstructor
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "firstname")
    String firstname;

    @Column(name = "lastname")
    String lastname;

    @Column(nullable = false, name = "mail")
    @NotEmpty(message = "Mail is required")
    String mail;

    @Column(nullable = false, name = "password")
    @NotEmpty(message = "Password is required")
    String password;

    public User(String mail, String password){
        super();
        this.mail = mail;
        this.password = password;
    }
}
