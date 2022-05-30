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

    @Basic
    String firstname;

    @Basic
    String lastname;

    @Basic(optional = false)
    @NotEmpty(message = "Mail is required")
    String email;

    @Basic(optional = false)
    @NotEmpty(message = "Password is required")
    String password;

    @Basic(optional = false)
    Role role;

    @OneToOne
    Admin admin;

    @OneToOne
    Teacher teacher;

    @OneToOne
    Student student;

    private void chooseRole(){
        if(role == Role.ADMIN){
            admin = new Admin();
        }
        else if(role == Role.TEACHER){
            teacher = new Teacher();
        }
        else if(role == Role.STUDENT){
            student = new Student();
        }
    }

    public UserApp(String email, String password, Role role){
        super();
        this.email = email;
        this.password = password;
        this.role = role;
        chooseRole();
    }

    public UserApp(String firstname, String lastname,String email, String password, Role role){
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.role = role;
        chooseRole();
    }

}
