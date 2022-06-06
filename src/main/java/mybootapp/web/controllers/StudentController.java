package mybootapp.web.controllers;

import mybootapp.model.Subject;
import mybootapp.model.Work;
import mybootapp.model.user.Role;
import mybootapp.model.user.Teacher;
import mybootapp.model.user.UserApp;
import mybootapp.repo.SubjectRepository;
import mybootapp.repo.WorkRepository;
import mybootapp.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService ss;

    @Autowired
    WorkRepository ws;
    @Autowired
    SubjectRepository sr;

    @RequestMapping(value = {"/space?space=student" },method = RequestMethod.POST)
    String createWork(Model model, @RequestParam("title") String title){
        List<Subject> sub = sr.findAll();
        Work work = new Work(title,sub);
        ws.save(work);
        return "student/space";
    }


}
