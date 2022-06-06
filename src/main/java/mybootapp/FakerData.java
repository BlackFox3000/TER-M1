package mybootapp;

import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import mybootapp.model.Repository;
import mybootapp.model.StudentList;
import mybootapp.model.Subject;
import mybootapp.model.Work;
import mybootapp.model.user.*;
import mybootapp.repo.RepoRepository;
import mybootapp.repo.SubjectRepository;
import mybootapp.repo.WorkRepository;
import mybootapp.web.service.AdminService;
import mybootapp.web.service.StudentService;
import mybootapp.web.service.TeacherService;
import mybootapp.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@FieldDefaults(level= AccessLevel.PRIVATE)
public class FakerData {

    public FakerData(){
        initializeAdmins();
        initializeSubjects();
        initializeStudents();
        initializeTeachers();
    }

    final Faker faker = new Faker();

    @Autowired
    UserService us = new UserService();
    public List<UserApp> users = new ArrayList<>();
    public List<Admin> admins = new ArrayList<>();

    public List<Subject> subjects = new ArrayList<>();

    public List<Work> works = new ArrayList<>();
    public List<Student> students = new ArrayList<>();

    //à voir plus tard
    //public List<StudentList> studentLists = new ArrayList<>();

    public List<Repository> repositories = new ArrayList<>();

    public List<Teacher> teachers = new ArrayList<>();

    //NOMBRE USERS = 9
    int nbAdmin = 2; int nbStudent = 5; int nbTeacher = 2;
    //APP HAS 3 SUBJECTS (code) / 2 STUDENTLISTS
    int nbStudentLists = 2;//à voir plus tard
    //EVERY WORK HAS 1 TO 3 SUBJECTS
    //EVERY STUDENT HAS 2 WORKS
    int nbWorkStudent = 2;
    //EVERY TEACHER GOT ALL SUBJECTS / 2 REPOS
    int nbRepoTeacher = 2;
    //EVERY REPOSITORY HAS 1 TO SUBJECTS

    @Autowired
    AdminService as = new AdminService();
    private void initializeAdmins(){
        for(int i = 0; i <nbAdmin; i++){

            int key = faker.number().randomDigit();

            Admin admin = new Admin(key);
            admins.add(admin);
            as.save(admin);

            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = getRandomMail()+"@gmail.com";
            String password = faker.funnyName().name();

            UserApp user = new UserApp(firstName,lastName,email,password, Role.ADMIN, admin,new Teacher(),new Student());
            users.add(user);
            us.save(user);
        }
    }

    @Autowired
    SubjectRepository sr;

    private void initializeSubjects(){

        Subject sub1 = new Subject("Maths");
        Subject sub2 = new Subject("Informatique");
        Subject sub3 = new Subject("Biologie");

        subjects.add(sub1);
        subjects.add(sub2);
        subjects.add(sub3);

        sr.save(sub1);
        sr.save(sub2);
        sr.save(sub3);
    }

    @Autowired
    WorkRepository wr;
    private List<Work> initializeWorks(){
        List<Work> workS = new ArrayList<>();
        int max = subjects.size();
        Random random = new Random();
        for(int i = 0; i< nbWorkStudent; i++){
            List<Subject> subjectS = new ArrayList<>();
            int nbSubject = 1 + random.nextInt(max - 1);
            Random r = new Random();
            for(int j = 0; j < nbSubject; j++){
                int whichOne = r.nextInt(max);
                subjectS.add(subjects.get(whichOne));
            }
            String company = faker.company().name();
            String title = "Rapport dans la société " + company;
            Work work = new Work(title,subjectS);

            workS.add(work);

            works.add(work);
            wr.save(work);
        }

        return workS;
    }

    @Autowired
    StudentService ss;
    private void initializeStudents(){
        for(int i = 0; i <nbStudent; i++){

            List<Work> workS = initializeWorks();

            Student student = new Student(workS);
            students.add(student);
            ss.save(student);

            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = getRandomMail()+"@gmail.com";
            String password = faker.funnyName().name();

            UserApp user = new UserApp(firstName,lastName,email,password, Role.STUDENT, new Admin(), new Teacher(),student);
            users.add(user);
            us.save(user);
        }
    }

    //à voir plus tard car - moins urgent pour les tests
    private List<StudentList> initializeStudentLists(){
        List<StudentList> studentListS = new ArrayList<>();
        for (int i = 0; i < 2; i ++){
            StudentList studentList;
        }
        List<Student> studentS;
        return studentListS;
    }

    @Autowired
    RepoRepository rr;
    private List<Repository> initializeRepositories(){
        List<Repository> repositorieS = new ArrayList<>();
        int max = subjects.size();
        Random random = new Random();
        for(int i = 0; i< nbRepoTeacher; i++){
            List<Subject> subjectS = new ArrayList<>();
            int nbSubject = 1 + random.nextInt(max - 1);
            Random r = new Random();
            for(int j = 0; j < nbSubject; j++){
                int whichOne = r.nextInt(max);
                subjectS.add(subjects.get(whichOne));
            }
            String name = "depot" + i;
            Repository repository = new Repository(name,subjectS,new Teacher());

            repositorieS.add(repository);

            repositories.add(repository);
            rr.save(repository);
        }

        return repositorieS;
    }

    @Autowired
    TeacherService ts = new TeacherService();
    private void initializeTeachers(){
        for(int i = 0; i <nbTeacher; i++){

            List<Repository> repositorieS = initializeRepositories();

            Teacher teacher = new Teacher(subjects,repositorieS);
            teachers.add(teacher);
            ts.save(teacher);

            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = getRandomMail();
            String password = faker.funnyName().name();

            UserApp user = new UserApp(firstName,lastName,email,password, Role.TEACHER, new Admin(), teacher, new Student());
            users.add(user);
            us.save(user);
        }
    }

    private String getRandomMail() {
        String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        while (sb.length() < 10) { // length of the random string.
            int index = (int) (r.nextFloat() * CHARS.length());
            sb.append(CHARS.charAt(index));
        }
        String mail = sb.toString();
        return mail+"@gmail.com";
    }
}
