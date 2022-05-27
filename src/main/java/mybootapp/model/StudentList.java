package mybootapp.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import mybootapp.model.user.Student;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
@Data
@Getter
@NoArgsConstructor
public class StudentList implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Basic(optional = false)
    String name;

    @JoinColumn
    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.LAZY)
    public List<Student> studentList;

    public StudentList(List<Student> studentList){
        super();
        this.studentList = studentList;
    }
}
