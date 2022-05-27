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
public class UserApp implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String firstname;

    String lastname;

    @Basic(optional = false)
    @NotEmpty(message = "Mail is required")
    String email;

    @Basic(optional = false)
    @NotEmpty(message = "Password is required")
    String password;

    @Basic(optional = false)
    Role role;

    public UserApp(String email, String password, Role role){
        super();
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public UserApp(String firstname, String lastname,String email, String password, Role role){
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.role = role;
    }


}
