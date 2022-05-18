package mybootapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import mybootapp.model.status.StatusW;
import mybootapp.model.user.Teacher;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;

@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
@Data
@Getter
@NoArgsConstructor
@Table(name = "works")
public class Work implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, name = "title")
    @NotEmpty(message = "Title is required")
    String title;

    @Column(nullable = false, name = "subjects")
    @NotEmpty(message = "One subject at least is required")
    ArrayList<Subject> subjects;

    @Column(name = "commentary")
    public String commentary;

    @Column(nullable = false)
    public StatusW statusW;

    @Column(name = "canceledTeachers")
    ArrayList<Teacher> canceledTeachers;

    public Work(String title, ArrayList<Subject> subjects){
        super();
        this.title = title;
        this.subjects = subjects;
        this.commentary = "";
        this.statusW = StatusW.DELIVERED;
        this.canceledTeachers = new ArrayList<>();
    }
}
