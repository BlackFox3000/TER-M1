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
public class UserApp implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "firstname")
    String firstname;

    @Column(name = "lastname")
    String lastname;

    @Column(nullable = false, name = "mail")
    @NotEmpty(message = "Mail is required")
    String email;

    @Column(nullable = false, name = "password")
    @NotEmpty(message = "Password is required")
    String password;

    public UserApp(String email, String password){
        super();
        this.email = email;
        this.password = password;
    }
}
