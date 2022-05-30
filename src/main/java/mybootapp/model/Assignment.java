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
import java.util.List;

@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
@Data
@Getter
@NoArgsConstructor
public class Assignment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Basic(optional = false)
    @NotEmpty(message = "A name is required")
    String name;

    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.LAZY)
    public List<Teacher> teachers;

    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.LAZY)
    public List<Repository> repositories;

    @Basic(optional = false)
    public StatusA statusA;

    public Assignment(String name,List<Teacher> teachers, List<Repository> repositories){
        super();
        this.name = name;
        this.teachers = teachers;
        this.repositories = repositories;
        this.statusA = StatusA.COMPLETED;
    }

}
