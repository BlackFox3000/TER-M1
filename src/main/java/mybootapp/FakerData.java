package mybootapp;

import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import mybootapp.model.Repository;
import mybootapp.model.StudentList;
import mybootapp.model.Subject;
import mybootapp.model.Work;
import mybootapp.model.status.StatusR;
import mybootapp.model.status.StatusW;
import mybootapp.model.user.*;
import mybootapp.repo.RepoRepository;
import mybootapp.repo.SubjectRepository;
import mybootapp.repo.WorkRepository;
import mybootapp.web.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.*;
import java.util.function.Function;

@FieldDefaults(level= AccessLevel.PRIVATE)
public class FakerData {

    Faker faker = new Faker();

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
    SubjectRepository sr = new SubjectRepository() {
        @Override
        public List<Subject> findByNameLike(String name) {
            return null;
        }

        @Override
        public List<Subject> findAll() {
            return null;
        }

        @Override
        public List<Subject> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<Subject> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public <S extends Subject> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends Subject> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends Subject> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<Subject> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Subject getOne(Long aLong) {
            return null;
        }

        @Override
        public Subject getById(Long aLong) {
            return null;
        }

        @Override
        public <S extends Subject> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends Subject> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<Subject> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Subject> S save(S entity) {
            return null;
        }

        @Override
        public Optional<Subject> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(Subject entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends Subject> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends Subject> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends Subject> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Subject> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Subject> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends Subject, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };
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
    WorkRepository wr = new WorkRepository() {
        @Override
        public List<Work> findByTitleLike(String title) {
            return null;
        }

        @Override
        public List<Work> findByStatusWLike(StatusW statusW) {
            return null;
        }

        @Override
        public List<Work> findAll() {
            return null;
        }

        @Override
        public List<Work> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<Work> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public <S extends Work> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends Work> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends Work> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<Work> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Work getOne(Long aLong) {
            return null;
        }

        @Override
        public Work getById(Long aLong) {
            return null;
        }

        @Override
        public <S extends Work> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends Work> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<Work> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Work> S save(S entity) {
            return null;
        }

        @Override
        public Optional<Work> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(Work entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends Work> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends Work> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends Work> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Work> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Work> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends Work, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };
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
    StudentService ss = new StudentService();
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
    RepoRepository rr = new RepoRepository() {
        @Override
        public List<Repository> findByNameLike(String name) {
            return null;
        }

        @Override
        public List<Repository> findByTeacherOwnerLike(Teacher teacher) {
            return null;
        }

        @Override
        public List<Repository> findByStatusRLike(StatusR statusR) {
            return null;
        }

        @Override
        public List<Repository> findByEndDateAfter(Date date) {
            return null;
        }

        @Override
        public List<Repository> findByEndDateBefore(Date date) {
            return null;
        }

        @Override
        public List<Repository> findAll() {
            return null;
        }

        @Override
        public List<Repository> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<Repository> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public <S extends Repository> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends Repository> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends Repository> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<Repository> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Repository getOne(Long aLong) {
            return null;
        }

        @Override
        public Repository getById(Long aLong) {
            return null;
        }

        @Override
        public <S extends Repository> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends Repository> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<Repository> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Repository> S save(S entity) {
            return null;
        }

        @Override
        public Optional<Repository> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(Repository entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends Repository> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends Repository> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends Repository> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Repository> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Repository> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends Repository, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };
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

    FakerData(){
        initializeAdmins();
        initializeSubjects();
        initializeStudents();
        initializeTeachers();
    }
}
