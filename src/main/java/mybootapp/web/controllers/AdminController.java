package mybootapp.web.controllers;

import mybootapp.FakerData;
import mybootapp.model.Assignment;
import mybootapp.model.Repository;
import mybootapp.model.Subject;
import mybootapp.model.Work;
import mybootapp.model.user.Role;
import mybootapp.model.user.Student;
import mybootapp.model.user.Teacher;
import mybootapp.model.user.UserApp;
import mybootapp.repo.SubjectRepository;
import mybootapp.repo.WorkRepository;
import mybootapp.repo.user.UserAppRepository;
import mybootapp.web.service.AdminService;
//import mybootapp.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    //FakerData fakerData = new FakerData();

    @RequestMapping(value = {"/faker" })
    void addFaker(Model model){
        FakerData fakerData = new FakerData();
    }

    @Autowired
    AdminService as;

    @Autowired
    UserAppRepository us;

    @Autowired
    SubjectRepository ss;

    @Autowired
    WorkRepository wr;

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
    ModelAndView manageAdmin(Model model){
        System.out.println("connexion en cours");
        UserApp admin1 = new UserApp("Marcel", "Pagnol", "mail@mail","password", Role.ADMIN);
        UserApp admin2 = new UserApp("Henri", "Casei", "mail@mail","password", Role.ADMIN);
        admin1.setId(484L);admin1.setId(8L);
        List<UserApp> users = Arrays.asList(admin1,admin2);
        //var users = us.findByRoleLike(Role.ADMIN);
        return new ModelAndView("admin/Users/manageAdmin","users",users);
    }

    @RequestMapping(value = {"/manageTeacher" })
    ModelAndView manageTeacher(Model model){
        System.out.println("connexion en cours: manageTeacher");
        UserApp teacher1 = new UserApp("Marcel", "Pagnol", "mail@mail","password", Role.TEACHER);
        UserApp teacher2 = new UserApp("Henri", "Casei", "mail@mail","password", Role.TEACHER);
        teacher1.setTeacher( new Teacher(subjects) );
        teacher1.setId(484L);
        teacher2.setTeacher( new Teacher(subjects) );
        teacher2.setId(25L);

        Repository repository = new Repository("mon premier depot", List.of(subjects.get(0)),teacher1.getTeacher());
        Work work1 = new Work("le refusé",subjects);
        work1.setId(456465L);
        Work work2 = new Work("accept",subjects);
        work2.setId(35L);
        repository.setWorks(List.of(work1));
        repository.setId(1L);
        teacher1.getTeacher().setRepositories(List.of(repository));
        teacher1.getTeacher().setSupportedWorks(List.of(work2));
        // -- test : End TL --
        return new ModelAndView("admin/Users/manageTeacher","users",Arrays.asList(teacher1,teacher2));
    }

    @RequestMapping(value = {"/manageStudent" })
    ModelAndView manageStudent(Model model){
        System.out.println("connexion en cours: manageStudent");
        Work work1 = new Work("1er proj",subjects);
        Work work2 = new Work("2nd projet",subjects);
        Work work3 = new Work("le refusé",subjects);
        work1.setId(456465L);
        work2.setId(44442577465L);
        work3.setId(58L);

        UserApp student1 = new UserApp("Marcel", "Pagnol", "mail@mail","password", Role.STUDENT);
        UserApp student2 = new UserApp("Henri", "Casei", "mail@mail","password", Role.STUDENT);
        student1.setStudent( new Student(Arrays.asList(work1, work2 )) );
        student1.setId(484L);
        student2.setStudent( new Student(List.of(work3)) );
        student2.setId(25L);
        return new ModelAndView("admin/Users/manageStudent","users",Arrays.asList(student1,student2));
    }

    @RequestMapping(value = {"/editAdmin" },method = RequestMethod.GET)
    @ResponseBody
    ModelAndView editAdmin(Model model,@RequestParam("id") Long id){

        System.out.println("connexion en cours: editAdmin");
        UserApp admin1 = new UserApp("Marcel", "Pagnol", "mail@mail","password", Role.ADMIN);
        admin1.setId(484L);
        return new ModelAndView("admin/Users/editAdmin","user",admin1);
    }

    @RequestMapping(value = {"/editTeacher" },method = RequestMethod.GET)
    @ResponseBody
    ModelAndView editTeacher(Model model,@RequestParam("id") Long id){
        UserApp teacher1 = new UserApp("Henri", "Casei", "mail@mail","password", Role.TEACHER);
        teacher1.setTeacher( new Teacher(subjects) );
        Repository repository = new Repository("mon premier depot", List.of(subjects.get(0)),teacher1.getTeacher());
        Work work1 = new Work("le refusé",subjects);
        work1.setId(456465L);
        Work work2 = new Work("accept",subjects);
        work1.setId(35L);
        repository.setWorks(List.of(work1));
        teacher1.getTeacher().setRepositories(List.of(repository));
        teacher1.setId(484L);
        teacher1.getTeacher().setSupportedWorks(List.of(work2));
        System.out.println("connexion en cours: editTeacher");
        ModelAndView modelAndView = new ModelAndView("admin/Users/editTeacher","user",teacher1);
        modelAndView.addObject("subjects",subjects);
        return modelAndView;
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
        sr.saveAll(subjects);
        return new ModelAndView("admin/subject/createSubject", "subjects",sr.findAll());
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
    ModelAndView manageWork(Model model){
        System.out.println("connexion en cours: manageWork");
        /*Work work1 = new Work("1er proj",subjects);
        Work work2 = new Work("2nd projet",subjects);
        Work work3 = new Work("le refusé",subjects);
        work1.setId(456465L);
        work2.setId(44442577465L);
        work3.setId(58L);
        List<Work> works = Arrays.asList(work1,work2,work3);*/
        FakerData fakerData = new FakerData();
        //List<Work> works = wr.findAll();
        return new ModelAndView( "admin/work/manageWork","works",wr.findAll());
    }

    @RequestMapping(value = {"/manageRepository" })
    ModelAndView manageRepository(Model model){
        System.out.println("connexion en cours: manageRepository");
        UserApp user1 = new UserApp("Marc", "Malin", "mail@mail","password", Role.TEACHER);
        UserApp user2 = new UserApp("Oceae", "Baneux", "mail@mail","password", Role.TEACHER);
        Teacher teacher1 = new Teacher(subjects);
        Teacher teacher2 = new Teacher(subjects);
        teacher1.setId(52L);
        teacher2.setId(8L);
        user1.setTeacher( teacher1 );
        user1.setId(263L);
        user2.setTeacher( teacher2 );
        user2.setId(25L);
        Repository repository1 = new Repository("mon test",subjects,user1.getTeacher());
        Repository repository2 = new Repository("mon second",subjects,user2.getTeacher());
        repository2.setId(25468468468L);
        repository1.setId(146854685L);
        List<Repository> repositories = Arrays.asList(repository1, repository2);
        return new ModelAndView("admin/repository/manageRepository","repositories",repositories);
    }

    @RequestMapping(value = {"/manageAssignement" })
    ModelAndView manageAssignement(Model model){



        System.out.println("connexion en cours: manageAsssignement");
        // -- test :Repository List --
        Repository repository1 = new Repository("mon test",subjects,null);
        Repository repository2 = new Repository("mon second",subjects,null);
        repository2.setId(25468468468L);
        repository1.setId(146854685L);
        List<Repository> repositories = Arrays.asList(repository1, repository2);
        // -- test : End RL --

        // -- test :Teacher List--
        UserApp teacher1 = new UserApp("Marcel", "Pagnol", "mail@mail","password", Role.TEACHER);
        UserApp teacher2 = new UserApp("Henri", "Casei", "mail@mail","password", Role.TEACHER);
        UserApp teacher3 = new UserApp("Marc", "Malin", "mail@mail","password", Role.TEACHER);
        UserApp teacher4 = new UserApp("Oceae", "Baneux", "mail@mail","password", Role.TEACHER);
        teacher1.setTeacher( new Teacher(subjects) );
        teacher1.setId(263L);
        teacher2.setTeacher( new Teacher(subjects) );
        teacher2.setId(25L);
        teacher3.setTeacher( new Teacher(subjects) );
        teacher3.setId(484L);
        teacher4.setTeacher( new Teacher(subjects) );
        teacher4.setId(72L);

        // -- test : End TL --

        // -- test : Work List--
        Work work1 = new Work("1er proj",subjects);
        Work work2 = new Work("2nd projet",subjects);
        Work work3 = new Work("le refusé",subjects);
        work1.setId(456465L);
        work2.setId(44442577465L);
        work3.setId(58L);
        work1.setCanceledTeachers(List.of(teacher1.getTeacher()));

        teacher1.getTeacher().setSupportedWorks(List.of(work3));
        teacher1.getTeacher().setSupportedWorks(List.of(work3));
        teacher1.getTeacher().setSupportedWorks(List.of(work3));

        List<Work> works = Arrays.asList(work1,work2,work3);
        // -- test : End WL --

        Assignment assignment = new Assignment(
                "super name",
                Arrays.asList(teacher1.getTeacher(),teacher2.getTeacher(),teacher3.getTeacher(),teacher4.getTeacher()),
                repositories
        );

        assignment.setId(54L);
        return new ModelAndView("admin/assignement/manageAssignement","assignements",List.of(assignment));
    }

    @RequestMapping(value = {"/detailAssignement" })
    ModelAndView detailAssignement(Model model){

        System.out.println("connexion en cours: detailAssignement");

        ModelAndView modelAndView = new ModelAndView("admin/assignement/detailAssignement");

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
        UserApp teacher3 = new UserApp("Marc", "Malin", "mail@mail","password", Role.TEACHER);
        UserApp teacher4 = new UserApp("Oceae", "Baneux", "mail@mail","password", Role.TEACHER);
        teacher1.setTeacher( new Teacher(subjects) );
        teacher1.setId(263L);
        teacher2.setTeacher( new Teacher(subjects) );
        teacher2.setId(25L);
        teacher3.setTeacher( new Teacher(subjects) );
        teacher3.setId(484L);
        teacher4.setTeacher( new Teacher(subjects) );
        teacher4.setId(72L);

        // -- test : End TL --
        modelAndView.addObject("teachers",Arrays.asList(teacher1,teacher2,teacher3,teacher4));

        // -- test : Work List--
        Work work1 = new Work("1er proj",subjects);
        Work work2 = new Work("2nd projet",subjects);
        Work work3 = new Work("le refusé",subjects);
        work1.setId(456465L);
        work2.setId(44442577465L);
        work3.setId(58L);
        work1.setCanceledTeachers(List.of(teacher1.getTeacher()));

        teacher1.getTeacher().setSupportedWorks(List.of(work3));
        teacher1.getTeacher().setSupportedWorks(List.of(work3));
        teacher1.getTeacher().setSupportedWorks(List.of(work3));

        List<Work> works = Arrays.asList(work1,work2,work3);
        // -- test : End WL --

        modelAndView.addObject("works",works);

        return modelAndView;
    }

    @RequestMapping(value = {"/editRepository" })
    ModelAndView editRepository(Model model){
        System.out.println("connexion en cours: editRepository");
        UserApp user1 = new UserApp("Marc", "Malin", "mail@mail","password", Role.TEACHER);
        Teacher teacher1 = new Teacher(subjects);
        teacher1.setId(52L);
        user1.setTeacher( teacher1 );
        user1.setId(263L);
        Repository repository1 = new Repository("mon test",subjects,user1.getTeacher());
        repository1.setId(146854685L);
        ModelAndView modelAndView = new ModelAndView("admin/repository/editRepository","repository",repository1);
        modelAndView.addObject("subjects",subjects);
        return modelAndView;
    }

    @RequestMapping(value = {"/editSubject" })
    ModelAndView editSubject(Model model){
        System.out.println("connexion en cours: editRepository");
        Subject subject = new Subject("test-name");       return new ModelAndView("admin/subject/editSubject","subject",subject);
    }

    @RequestMapping(value = {"/editWork" })
    ModelAndView editWork(Model model){
        System.out.println("connexion en cours: editRepository");
        Work work = new Work("name title",subjects);
        return new ModelAndView("admin/work/editWork","work",work);
    }

    @Autowired
    SubjectRepository sr;

    @RequestMapping(value = {"/createSubject" },method = RequestMethod.POST)
    String createSubject(Model model,@RequestParam("name") String name){

        Subject subject = new Subject(name);
        sr.save(subject);

        return "admin/space";
    }

    @Autowired
    SubjectRepository sr;


    @PostMapping("/createSubject")
    String createSubject(@RequestBody String name){

        Subject subject = new Subject(name);
        sr.save(subject);

        return "admin/space";
    }
}
