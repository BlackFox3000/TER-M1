package mybootapp.web.controllers;

import mybootapp.model.Subject;
import mybootapp.model.Work;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final List<Subject> subjects = Arrays.asList(
            new Subject("Biologie"),
            new Subject("Mathématique"),
            new Subject("Informatique"));

    // Gestion créations
    @RequestMapping(value = {"/addAdmin" })
    String addAdmin(Model model){
        System.out.println("connexion en court");
        return "createAdmin";
    }

    @RequestMapping(value = {"/addTeacher" })
    ModelAndView addTeacher(Model model){
        System.out.println("connexion en court");
        ModelAndView modelAndView = new ModelAndView("admin/createTeacher", "subjects",subjects);
        return modelAndView;
    }

    @RequestMapping(value = {"/addStudent" })
    String addStudent(Model model){
        System.out.println("connexion en court");
        return "createStudent";
    }

    // Gestions utilisateurs
    @RequestMapping(value = {"/manageAdmin" })
    String manageAdmin(Model model){
        System.out.println("connexion en court");
        return "manageAdmin";
    }

    @RequestMapping(value = {"/manageTeacher" })
    String manageTeacher(Model model){
        System.out.println("connexion en court");
        return "manageTeacher";
    }

    @RequestMapping(value = {"/manageStudent" })
    String manageStudent(Model model){
        System.out.println("connexion en court");
        return "manageStudent";
    }


    // Gestion autre
    @RequestMapping(value = {"/manageSubject" })
    String manageSubject(Model model){
        System.out.println("connexion en court");
        return "manageSubject";
    }


    // Gestion projets
    @RequestMapping(value = {"/manageWork" })
    String manageWork(Model model){
        System.out.println("connexion en court");
        return "manageWork";
    }

    @RequestMapping(value = {"/manageRepository" })
    String manageRepository(Model model){
        System.out.println("connexion en court");
        return "manageRepository";
    }

    @RequestMapping(value = {"/manageAssignement" })
    String manageAssignement(Model model){
        System.out.println("connexion en court");
        return "manageAssignement";
    }


}
