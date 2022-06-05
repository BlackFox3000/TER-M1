package mybootapp.web.controllers;

import mybootapp.model.Repository;
import mybootapp.model.StudentList;
import mybootapp.model.Subject;
import mybootapp.model.Work;
import mybootapp.model.user.Role;
import mybootapp.model.user.Student;
import mybootapp.model.user.Teacher;
import mybootapp.model.user.UserApp;
import mybootapp.web.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService ts;

    private static final List<Subject> subjects = Arrays.asList(
            new Subject("Biologie"),
            new Subject("Mathématique"),
            new Subject("Informatique"));



    @RequestMapping(value = "/new-repository", method = RequestMethod.GET)
    String createRepositoryButton(Model model){
        return "new-repository";
    }

    @RequestMapping(value = {"/addRepository" })
    ModelAndView addRepository(Model model){
        System.out.println("connexion en cours: addRepository");
        UserApp user1 = new UserApp("Marc", "Malin", "mail@mail","password", Role.TEACHER);
        Teacher teacher1 = new Teacher(subjects);
        teacher1.setId(52L);
        user1.setTeacher( teacher1 );
        user1.setId(263L);
        Repository repository1 = new Repository("mon test",subjects,user1.getTeacher());
        repository1.setId(146854685L);
        ModelAndView modelAndView = new ModelAndView("/teacher/createRepository","repository",repository1);
        modelAndView.addObject("subjects",subjects);
        return modelAndView;
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
        return new ModelAndView("teacher/manageRepository","repositories",repositories);
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
        ModelAndView modelAndView = new ModelAndView("teacher/editRepository","repository",repository1);
        modelAndView.addObject("subjects",subjects);
        return modelAndView;
    }

    @RequestMapping(value = {"/detailRepository" })
    ModelAndView detailRepository(Model model){
        System.out.println("connexion en cours: detailRepository");
        UserApp user1 = new UserApp("Marc", "Malin", "mail@mail","password", Role.TEACHER);
        Teacher teacher1 = new Teacher(subjects);
        teacher1.setId(52L);
        user1.setTeacher( teacher1 );
        user1.setId(263L);
        Repository repository1 = new Repository("mon test",subjects,user1.getTeacher());
        repository1.setId(146854685L);
        Work work1 = new Work("premier",subjects);
        Work work2 = new Work("second",subjects);
        Work work3 = new Work("troisieme",subjects);
        repository1.setWorks(Arrays.asList(work1,work2,work3));
        return new ModelAndView("teacher/detailRepository","repository",repository1);
    }

    @RequestMapping(value = {"/manageStudentList" })
    ModelAndView manageStudentList(Model model){
        System.out.println("connexion en cours: manageStudentList");
        UserApp user1 = new UserApp("Marc", "Malin", "mail@mail","password", Role.STUDENT);
        UserApp user2 = new UserApp("Oceane", "Baneux", "mail@mail","password", Role.STUDENT);
        UserApp user3 = new UserApp("Baptiste", "envieux", "mail@mail","password", Role.STUDENT);
        UserApp user4 = new UserApp("Jean", "Grincheux", "mail@mail","password", Role.STUDENT);
        UserApp user5 = new UserApp("Manon", "Looping", "mail@mail","password", Role.STUDENT);
        UserApp user6 = new UserApp("Eva", "Diaz", "mail@mail","password", Role.STUDENT);

        List<Student> studentsList1 = Arrays.asList(user1.getStudent(),user2.getStudent(),user3.getStudent(),user4.getStudent(),user5.getStudent());
        List<Student> studentsList2 = Arrays.asList(user1.getStudent(),user2.getStudent(),user3.getStudent());
        List<Student> studentsList3 = Arrays.asList(user4.getStudent(),user5.getStudent());
        StudentList studentList1 = new StudentList(studentsList1);
        StudentList studentList2 = new StudentList(studentsList2);
        StudentList studentList3 = new StudentList(studentsList3);

        List<StudentList> studentLists = Arrays.asList(studentList1, studentList2, studentList3);
        ModelAndView modelAndView = new ModelAndView("teacher/manageStudentList","studentList",studentLists);
        modelAndView.addObject("subjects",subjects);
        return modelAndView;
    }

    @RequestMapping(value = {"/editStudentList" })
    ModelAndView editStudentList(Model model) {
        StudentList studentList = new StudentList(Arrays.asList(new Student(),new Student(),new Student()));
        return new ModelAndView("teacher/editRepository","studentList",studentList);
    }

    @RequestMapping(value = {"/addStudentList" })
    ModelAndView createStudentList(Model model){
        UserApp user1 = new UserApp("Marc", "Malin", "mail@mail","password", Role.STUDENT);
        UserApp user2 = new UserApp("Oceane", "Baneux", "mail@mail","password", Role.STUDENT);
        UserApp user3 = new UserApp("Baptiste", "envieux", "mail@mail","password", Role.STUDENT);
        UserApp user4 = new UserApp("Jean", "Grincheux", "mail@mail","password", Role.STUDENT);
        UserApp user5 = new UserApp("Manon", "Looping", "mail@mail","password", Role.STUDENT);
        user1.setId(1L);
        user1.setId(2L);
        user1.setId(3L);
        user1.setId(4L);
        user1.setId(5L);

        List<UserApp> students = Arrays.asList(user1,user2,user3,user4,user5);
        return new ModelAndView("teacher/createStudentList","students",students);
    }
}
