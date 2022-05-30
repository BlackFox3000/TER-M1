package mybootapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import mybootapp.model.status.StatusR;
import mybootapp.model.user.Teacher;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
@Data
@Getter
@NoArgsConstructor
public class Repository implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotEmpty(message = "Name is required")
    String name;

    @NotEmpty(message = "One subject at least is required")
    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.LAZY)
    public List<Subject> subjects;

    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.LAZY)
    public List<Work> works;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.LAZY)
    @NotEmpty(message = "Teacher Owner is required")
    Teacher teacherOwner;

    @Basic(optional = false)
    StatusR statusR ;

    @Basic(optional = false)
    Date endDate;

    /**
     *
     * @param name
     * @param subjects
     * @param teacherOwner
     */
    public Repository(String name, List<Subject> subjects, Teacher teacherOwner){
        super();
        this.name = name;
        this.subjects = subjects;
        this.teacherOwner = teacherOwner;
        statusR = StatusR.OPEN;
    }

}
