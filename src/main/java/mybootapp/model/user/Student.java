package mybootapp.model.user;

import lombok.*;
import mybootapp.model.Repository;
import mybootapp.model.Work;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Getter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToMany
    public List<Work> personnalWorks;

    public Student(){
        super();
        this.personnalWorks = new ArrayList<>();
    }

    public void uploadWork(Repository repo, Work work){
        repo.works.add(work);
        personnalWorks.add(work);
    }
}
