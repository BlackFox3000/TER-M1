package mybootapp.web.controllers;

import mybootapp.model.Repository;
import mybootapp.model.Work;
import mybootapp.model.user.Student;
import mybootapp.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StudentController {

    @Autowired
    StudentService ss;

    public void uploadWork(Student student, Repository repo, Work work){
        student.getPersonnalWorks().add(work);
        repo.getWorks().add(work);
    }
}
