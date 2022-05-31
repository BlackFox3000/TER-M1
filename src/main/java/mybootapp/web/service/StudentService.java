package mybootapp.web.service;

import mybootapp.model.Repository;
import mybootapp.model.Work;
import mybootapp.model.user.Student;
import mybootapp.repo.WorkRepository;
import mybootapp.repo.user.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentService {

    @Autowired
    StudentRepository str;

    @Autowired
    WorkRepository wr;


    public void save(Student student){
        List<Work> works = student.getPersonnalWorks();

        wr.saveAll(works);

        str.save(student);
    }

    public void delete(Student student) {
        str.deleteById(student.getId());
    }

    public void deleteAll(){
        str.deleteAll();
    }

    public void update(Student student){
        str.deleteById(student.getId());
        save(student);
    }

    public void uploadWork(Student student, Repository repo, Work work){
        student.getPersonnalWorks().add(work);
        repo.getWorks().add(work);
    }
}
