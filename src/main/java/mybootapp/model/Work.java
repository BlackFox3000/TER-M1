package mybootapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import mybootapp.model.status.StatusW;
import mybootapp.model.user.Student;
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
@ToString(exclude = "canceledTeachers")
public class Work implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Basic(optional = false)
    @NotEmpty(message = "Title is required")
    String title;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.LAZY)
    @NotEmpty(message = "One subject at least is required")
    List<Subject> subjects;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.LAZY)
    Student studentOwner;

    @Basic
    public String commentary;

    @Basic(optional = false)
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

    public Work(String title, List<Subject> subjects, Student studentOwner){
        super();
        this.title = title;
        this.subjects = subjects;
        this.studentOwner = studentOwner;
        this.commentary = "";
        this.statusW = StatusW.DELIVERED;
        this.canceledTeachers = new ArrayList<>();
    }

    public Work(){
        super();
        this.commentary = "";
        this.statusW = StatusW.DELIVERED;
        this.canceledTeachers = new ArrayList<>();
    }


}
