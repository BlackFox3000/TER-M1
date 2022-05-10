package mybootapp.model.user;

import lombok.*;
import mybootapp.model.Repository;
import mybootapp.model.Work;


import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
@Data
@Getter
public class Student extends User {

    @Column(name = "personnalWorks")
    public ArrayList<Work> personnalWorks;

    public Student(){
        super();
        this.personnalWorks = new ArrayList<>();
    }

    public void uploadWork(Repository repo, Work work){
        repo.works.add(work);
        personnalWorks.add(work);
    }
}
