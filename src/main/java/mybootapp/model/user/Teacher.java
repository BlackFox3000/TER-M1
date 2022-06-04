package mybootapp.model.user;

import lombok.*;
import lombok.experimental.FieldDefaults;
import mybootapp.model.Repository;
import mybootapp.model.StudentList;
import mybootapp.model.Subject;
import mybootapp.model.Work;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Getter
@NoArgsConstructor
public class Teacher{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.LAZY)
    @NotEmpty(message = "One subject at least is required")
    List<Subject> subjects;

    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.LAZY)
    List<Work> supportedWorks;

    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.LAZY)
    List<Repository> repositories;

    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.LAZY)
    List<StudentList> studentLists;

    /**
     * @param subjects
     */
    public Teacher(List<Subject> subjects){
        super();
        this.subjects = subjects;
        this.supportedWorks = new ArrayList<>();
        this.repositories = new ArrayList<>();
        this.studentLists = new ArrayList<>();
    }

    public Teacher(List<Subject> subjects, List<Repository> repositories){
        super();
        this.subjects = subjects;
        this.supportedWorks = new ArrayList<>();
        this.repositories = repositories;
        this.studentLists = new ArrayList<>();
    }
}
