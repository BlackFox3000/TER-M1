package mybootapp.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import mybootapp.model.status.StatusA;
import mybootapp.model.user.Teacher;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
@Data
@Getter
@NoArgsConstructor
@Table(name = "assignments")
public class Assignment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, name = "name")
    @NotEmpty(message = "A name is required")
    String name;

    @Column(name = "teachers")
    public ArrayList<Teacher> teachers;

    @Column(name = "repositories")
    public ArrayList<Repository> repositories;

    @Column(nullable = false)
    public StatusA statusA;

    public Assignment(String name,ArrayList<Teacher> teachers, ArrayList<Repository> repositories){
        super();
        this.name = name;
        this.teachers = teachers;
        this.repositories = repositories;
        //this.statusA = StatusA.
    }

}
