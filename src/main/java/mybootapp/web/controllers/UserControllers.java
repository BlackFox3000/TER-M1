package mybootapp.web.controllers;

import mybootapp.model.Repository;
import mybootapp.model.Subject;
import mybootapp.model.Work;
import mybootapp.model.user.Teacher;
import mybootapp.model.user.UserApp;
import mybootapp.web.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserControllers {

    @Autowired
    UserService us;

    private static final UserApp user = new UserApp();
    private static final Subject bio = new Subject("Biologie");
    private static final Subject math = new Subject("Mathématique");
    private static final Subject info = new Subject("Informatique");
    private static final Subject orga = new Subject("Organique");
    private static final List<Work> works =  Arrays.asList(
            new Work( "premier sujet", (List<Subject>) List.of(bio)),
            new Work("second sujet", (List<Subject>) Arrays.asList(math,orga)),
            new Work("troisième sujet", (List<Subject>) List.of(info)));
    private static final Teacher teacher = new Teacher((List<Subject>) List.of(bio,orga,math,info));
    private static final List<Repository> repositories = Arrays.asList(
            new Repository("rapport bio",(List<Subject>) List.of(bio),teacher),
            new Repository("exam bio",(List<Subject>) List.of(bio,orga),teacher),
            new Repository("rapport math",(List<Subject>) List.of(math,info),teacher));

    @RequestMapping(value = {"/connectStudent" }, method = RequestMethod.POST)
    String connectStudent(Model model){
        System.out.println("connexion en court");
        return us.connection();
    }

    @RequestMapping(value = {"/connectTeacher" }, method = RequestMethod.POST)
    String connectTeacher(Model model){
        System.out.println("connexion en court");
        return "/teacher/space";
    }

    @RequestMapping(value = {"/connectAdmin" }, method = RequestMethod.POST)
    String connectAdmin(Model model){
        System.out.println("connexion en court");
        return "/admin/space";
    }

    // TODO: 30/05/2022 ajouter permission : connecter en tant qu'étudiant
    @RequestMapping(value = {"/student/space" })
    ModelAndView studentSpace(Model model){
        System.out.println("Load space student :"+works.size()+" - "+works.get(1).getTitle());
        ModelAndView modelAndView = new ModelAndView("student/space", "works",works);
        modelAndView.addObject("repositories", repositories);
        return modelAndView;
    }

    // TODO: 30/05/2022 ajouter permission : connecter en tant que professeur
    @RequestMapping(value = {"/teacher/space" })
    ModelAndView teacherSpace(Model model){
        System.out.println("Load space student :"+works.size()+" - "+works.get(1).getTitle());
        ModelAndView modelAndView = new ModelAndView("teacher/space", "works",works);
        modelAndView.addObject("repositories", repositories);
        return modelAndView;
    }

    // TODO: 30/05/2022 ajouter permission : connecter en tant qu'administrateur
    @RequestMapping(value = {"/admin/space" })
    ModelAndView adminSpace(Model model){
        System.out.println("Load space student :"+works.size()+" - "+works.get(1).getTitle());
        ModelAndView modelAndView = new ModelAndView("admin/space", "works",works);
        modelAndView.addObject("repositories", repositories);
        return modelAndView;
    }

}
