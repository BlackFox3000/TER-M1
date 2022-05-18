package mybootapp.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import mybootapp.model.user.Student;

import javax.persistence.*;
import java.util.ArrayList;

@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
@Data
@Getter
@NoArgsConstructor
@Table(name = "studentslists")
public class StudentList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, name = "list")
    public ArrayList<Student> studentList;

    public StudentList(ArrayList<Student> studentList){
        super();
        this.studentList = studentList;
    }
}
