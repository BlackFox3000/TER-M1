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

@FieldDefaults(level= AccessLevel.PRIVATE)
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


    public Teacher(List<Subject> subjects){
        super();
        this.subjects = subjects;
        this.supportedWorks = new ArrayList<>();
        this.repositories = new ArrayList<>();
        this.studentLists = new ArrayList<>();
    }

    public void createRepository(String name, ArrayList<Subject> subjects){
        //mettre le nouveau repo dans la bdd
        Repository repo = new Repository(name,subjects,this);
        repositories.add(repo);
    }

    public void commentWork(String message, Work work){
        work.setCommentary(work.getCommentary() + message);
    }

    public void attributeWorks(Repository repo){
        //appeller l'algo principal
    }
}
