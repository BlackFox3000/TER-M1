package mybootapp.model.user;

import lombok.*;
import lombok.experimental.FieldDefaults;
import mybootapp.model.Repository;
import mybootapp.model.Work;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Data
@Getter
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.LAZY)
    public List<Work> personnalWorks;

    public Student(){
        super();
        this.personnalWorks = new ArrayList<>();
    }

    public Student(List<Work> works){
        super();
        this.personnalWorks = works;
    }
}
