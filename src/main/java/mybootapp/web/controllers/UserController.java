package mybootapp.web.controllers;

import mybootapp.model.Repository;
import mybootapp.model.Subject;
import mybootapp.model.Work;
import mybootapp.model.user.Teacher;
import mybootapp.model.user.UserApp;
import mybootapp.repo.SubjectRepository;
import mybootapp.repo.WorkRepository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import mybootapp.web.service.UserService;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService us;

    @Autowired
    WorkRepository wr;

    @Autowired
    SubjectRepository sr;

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

    private static final List<Subject> subjects = Arrays.asList(
            new Subject("Biologie"),
            new Subject("Mathématique"),
            new Subject("Informatique"));

    protected final Log logger = LogFactory.getLog(getClass());

//    @Autowired()
//    User user1;
//
//    @ModelAttribute("user")
//    public User newUser() {
//        return user1;
//    }
//
//    @RequestMapping(value = "/show")
//    public String show() {
//        logger.info("show user " + user1);
//        return "user";
//    }
//
//    @RequestMapping(value = "/login")
//    public String login() {
//        logger.info("login user " + user1);
//        user1.setName("It's me");
//        return "user";
//    }
//
//    @RequestMapping(value = "/logout")
//    public String logout() {
//        logger.info("logout user " + user1);
//        user1.setName("Anonymous");
//        return "user";
//    }



    @RequestMapping(value = {"/connectStudent" }, method = RequestMethod.POST)
    String connectStudent(Model model){
        System.out.println("connexion en cours");
        return us.connection();
    }

    @RequestMapping(value = {"/connectTeacher" }, method = RequestMethod.POST)
    String connectTeacher(Model model){
        System.out.println("connexion en cours");
        return "/teacher/space";
    }

    @RequestMapping(value = {"/connectAdmin" }, method = RequestMethod.POST)
    String connectAdmin(Model model){
        System.out.println("connexion en cours");
        return "/admin/space";
    }

    // TODO: 30/05/2022 ajouter permission : connecter en tant qu'étudiant
    @RequestMapping(value = {"/student/space" })
    ModelAndView studentSpace(Model model){
        Teacher teacher = new Teacher(sr.findAll());
        List<Repository> repositories1 = new ArrayList<>();
        Repository repository = new Repository("Maths",sr.findAll(),teacher);
        System.out.println("Load space student :"+works.size()+" - "+works.get(1).getTitle());
        ModelAndView modelAndView = new ModelAndView("student/space", "works",wr.findAll());
        modelAndView.addObject("repositories", repositories1);
        return modelAndView;
    }

    // TODO: 30/05/2022 ajouter permission : connecter en tant que professeur
    @RequestMapping(value = {"/teacher/space" })
    ModelAndView teacherSpace(Model model){
        System.out.println("connexion en cours 2");
        Work work1 = new Work("1er proj",subjects);
        Work work2 = new Work("2nd projet",subjects);
        Work work3 = new Work("le refusé",subjects);
        work1.setId(456465L);
        work2.setId(44442577465L);
        work3.setId(58L);

        List<Work> worksNews = Arrays.asList(work1, work2);
        List<Work> worksWait = Arrays.asList(work3, work1);
        List<Work> worksEnd  = Arrays.asList(work2, work3);

        ModelAndView modelAndView = new ModelAndView("/teacher/space","worksNews",worksNews);
        modelAndView.addObject("worksWait",worksWait);
        modelAndView.addObject("worksEnd",worksEnd);

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
