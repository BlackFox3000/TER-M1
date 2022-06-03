package mybootapp.web.controllers;

import mybootapp.model.Repository;
import mybootapp.model.Subject;
import mybootapp.model.Work;
import mybootapp.model.user.Role;
import mybootapp.model.user.Teacher;
import mybootapp.model.user.UserApp;
import mybootapp.web.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService as;

    private static final List<Subject> subjects = Arrays.asList(
            new Subject("Biologie"),
            new Subject("Mathématique"),
            new Subject("Informatique"));

    // Gestion créations
    @RequestMapping(value = {"/addAdmin" })
    String addAdmin(Model model){
        System.out.println("connexion en cours: addAdmin");
        return "admin/Users/createAdmin";
    }

    @RequestMapping(value = {"/addTeacher" })
    ModelAndView addTeacher(Model model){
        System.out.println("connexion en cours: addTeacher");
        return new ModelAndView("admin/Users/createTeacher", "subjects",subjects);
    }

    @RequestMapping(value = {"/addStudent" })
    String addStudent(Model model){
        System.out.println("connexion en cours: addStudent");
        return "admin/Users/createStudent";
    }

    // Gestions utilisateurs
    @RequestMapping(value = {"/manageAdmin" })
    String manageAdmin(Model model){
        System.out.println("connexion en cours");
        return "admin/Users/manageAdmin";
    }

    @RequestMapping(value = {"/manageTeacher" })
    String manageTeacher(Model model){
        System.out.println("connexion en cours: manageTeacher");
        return "admin/Users/manageTeacher";
    }

    @RequestMapping(value = {"/manageStudent" })
    String manageStudent(Model model){
        System.out.println("connexion en cours: manageStudent");
        return "admin/Users/manageStudent";
    }


    // Gestion autre
    @RequestMapping(value = {"/manageSubject" })
    String manageSubject(Model model){
        System.out.println("connexion en cours: manageSubject");
        return "admin/Users/manageSubject";
    }

    @RequestMapping(value = {"/addSubject" })
    ModelAndView addSubject(Model model){
        System.out.println("connexion en cours: addSubject");
        return new ModelAndView("admin/subject/createSubject", "subjects",subjects);
    }


    // Gestion projets
    //TODO : à retirer tests, remplacer par une recherche des existants
    @RequestMapping(value = {"/addAssignement" })
    ModelAndView addAssignement(Model model){
        System.out.println("connexion en cours: addAssignement");

        ModelAndView modelAndView = new ModelAndView("admin/assignement/createAssignement", "subjects",subjects);

        // -- test :Repository List --
        Repository repository1 = new Repository("mon test",subjects,null);
        Repository repository2 = new Repository("mon second",subjects,null);
        repository2.setId(25468468468L);
        repository1.setId(146854685L);
        List<Repository> repositories = Arrays.asList(repository1, repository2);
        // -- test : End RL --
        modelAndView.addObject("repositories",repositories);

        // -- test :Teacher List--
        UserApp teacher1 = new UserApp("Marcel", "Pagnol", "mail@mail","password", Role.TEACHER);
        UserApp teacher2 = new UserApp("Henri", "Casei", "mail@mail","password", Role.TEACHER);
        teacher1.setTeacher( new Teacher(subjects) );
        teacher1.setId(484L);
        teacher2.setTeacher( new Teacher(subjects) );
        teacher2.setId(25L);
        // -- test : End TL --
        modelAndView.addObject("teachers",Arrays.asList(teacher1,teacher2));

        return modelAndView;
    }

    @RequestMapping(value = {"/createAssignement" },method = RequestMethod.GET)
    @ResponseBody
    ModelAndView createAssignement(Model model,@RequestParam("name") String name){

        System.out.println("connexion en cours: createAssignement");
        return new ModelAndView("admin/assignement/manageAssignement","name",name);
    }

    @RequestMapping(value = {"/manageWork" })
    String manageWork(Model model){
        System.out.println("connexion en cours: manageWork");
        return "admin/Users/manageWork";
    }

    @RequestMapping(value = {"/manageRepository" })
    String manageRepository(Model model){
        System.out.println("connexion en cours: manageRepository");
        return "manageRepository";
    }

    @RequestMapping(value = {"/manageAssignement" })
    String manageAssignement(Model model){
        System.out.println("connexion en cours: manageAsssignement");
        return "admin/Users/manageAssignement";
    }


}
