package mybootapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
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
@Table(name = "repositories")
public class Repository implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, name = "name")
    @NotEmpty(message = "Name is required")
    String name;

    @Column(nullable = false, name = "subjects")
    @NotEmpty(message = "One subject at least is required")
    public ArrayList<String> subjects;

    @Column(name = "works")
    public ArrayList<Work> works;

    @Column(nullable = false, name = "teacherOwner")
    @NotEmpty(message = "Teacher Owner is required")
    Teacher teacherOwner;

    @Column(nullable = false, name="isClosed")
    public boolean isClosed;

    public Repository(String name, ArrayList<String> subjects, Teacher teacherOwner){
         this.name = name;
         this.subjects = subjects;
         this.teacherOwner = teacherOwner;
    }

}
