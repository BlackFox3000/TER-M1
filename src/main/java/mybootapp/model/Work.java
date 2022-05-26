package mybootapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import mybootapp.model.status.StatusW;
import mybootapp.model.user.Teacher;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
@Data
@Getter
@NoArgsConstructor
public class Work implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @NotEmpty(message = "Title is required")
    String title;


    @ManyToMany(cascade = CascadeType.ALL)
    @NotEmpty(message = "One subject at least is required")
    List<Subject> subjects;


    public String commentary;

    public StatusW statusW;

    @OneToMany
    List<Teacher> canceledTeachers;

    public Work(String title, List<Subject> subjects){
        super();
        this.title = title;
        this.subjects = subjects;
        this.commentary = "";
        this.statusW = StatusW.DELIVERED;
        this.canceledTeachers = new ArrayList<>();
    }
}
