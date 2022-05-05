package mybootapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;

@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
@Data
@Getter
@NoArgsConstructor
public class Teacher extends User{

    @Column(nullable = false, name = "subjects")
    @NotEmpty(message = "One subject at least is required")
    ArrayList<String> subjects;

    @Column(name = "supportedWorks")
    ArrayList<Work> supportedWorks;

    @Column(name = "repositories")
    ArrayList<Repository> repositories;

    public Teacher(ArrayList<String> subjects){
        this.subjects = subjects;
        this.supportedWorks = new ArrayList<>();
        this.repositories = new ArrayList<>();
    }

    public void createRepository(String name, ArrayList<String> subjects){
        //mettre le nouveau repo dans la bdd
        Repository repo = new Repository(name,subjects,this);
        repositories.add(repo);
    }

    public void commentWork(String message, Work work){
        work.setCommentary(work.getCommentary() + message);
    }

    public void attributerWorks(Repository repo){
        //appeller l'algo principal
    }
}
