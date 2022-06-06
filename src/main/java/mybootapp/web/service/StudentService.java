package mybootapp.web.service;

import mybootapp.model.Repository;
import mybootapp.model.Work;
import mybootapp.model.user.Student;
import mybootapp.repo.WorkRepository;
import mybootapp.repo.user.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@Transactional
public class StudentService {

    @Autowired
    StudentRepository str;

    @Autowired
    WorkRepository wr;


    public void save(Student student){
        str.save(student);
    }

    public void delete(Student student) {
        str.deleteById(student.getId());
    }

    public void deleteAll(){
        str.deleteAll();
    }

    public void uploadWork(Student student, Repository repo, Work work){
        student.getPersonnalWorks().add(work);
        repo.getWorks().add(work);
    }
}
