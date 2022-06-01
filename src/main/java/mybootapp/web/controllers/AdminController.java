package mybootapp.web.controllers;

import mybootapp.model.Subject;
import mybootapp.model.Work;
import mybootapp.web.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
        System.out.println("connexion en cours");
        return "admin/Users/createAdmin";
    }

    @RequestMapping(value = {"/addTeacher" })
    ModelAndView addTeacher(Model model){
        System.out.println("connexion en cours");
        ModelAndView modelAndView = new ModelAndView("admin/Users/createTeacher", "subjects",subjects);
        return modelAndView;
    }

    @RequestMapping(value = {"/addStudent" })
    String addStudent(Model model){
        System.out.println("connexion en cours");
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
        System.out.println("connexion en cours");
        return "admin/Users/manageTeacher";
    }

    @RequestMapping(value = {"/manageStudent" })
    String manageStudent(Model model){
        System.out.println("connexion en cours");
        return "admin/Users/manageStudent";
    }


    // Gestion autre
    @RequestMapping(value = {"/manageSubject" })
    String manageSubject(Model model){
        System.out.println("connexion en cours");
        return "admin/Users/manageSubject";
    }


    // Gestion projets
    @RequestMapping(value = {"/manageWork" })
    String manageWork(Model model){
        System.out.println("connexion en cours");
        return "admin/Users/manageWork";
    }

    @RequestMapping(value = {"/manageRepository" })
    String manageRepository(Model model){
        System.out.println("connexion en cours");
        return "manageRepository";
    }

    @RequestMapping(value = {"/manageAssignement" })
    String manageAssignement(Model model){
        System.out.println("connexion en cours");
        return "admin/Users/manageAssignement";
    }


}
