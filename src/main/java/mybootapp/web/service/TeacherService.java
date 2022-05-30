package mybootapp.web.service;

import mybootapp.Algo;
import mybootapp.model.Repository;
import mybootapp.model.StudentList;
import mybootapp.model.Subject;
import mybootapp.model.Work;
import mybootapp.model.user.Teacher;
import mybootapp.repo.RepoRepository;
import mybootapp.repo.StudentListRepository;
import mybootapp.repo.SubjectRepository;
import mybootapp.repo.WorkRepository;
import mybootapp.repo.user.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TeacherService {

    @Autowired
    TeacherRepository tr;

    @Autowired
    SubjectRepository sr;

    @Autowired
    WorkRepository wr;

    @Autowired
    RepoRepository rr;

    @Autowired
    StudentListRepository slr;

    public void save(Teacher teacher) {
        List<Subject> subjects = teacher.getSubjects();
        List<Work> works = teacher.getSupportedWorks();
        List<Repository> repositories = teacher.getRepositories();
        List<StudentList> studentLists = teacher.getStudentLists();

        sr.saveAll(subjects);
        wr.saveAll(works);
        rr.saveAll(repositories);
        slr.saveAll(studentLists);

        tr.save(teacher);
    }

    public void delete(Teacher teacher) {
        tr.delete(teacher);
    }

    public void deleteAll() {
        tr.deleteAll();
    }

    public void update(Teacher teacher){
        tr.deleteById(teacher.getId());
        save(teacher);
    }

    public void createRepository(String name, ArrayList<Subject> subjects,Teacher teacherOwner){
        Repository repo = new Repository(name,subjects,teacherOwner);
        rr.save(repo);
        teacherOwner.getRepositories().add(repo);
    }

    public void commentWork(String message, Work work){
        work.setCommentary(work.getCommentary() + message);
    }

    public void attributeWorks(Repository repo, ArrayList<Teacher> teachers){
        Algo algo = new Algo();
        algo.assignementFromRepository(repo, teachers);
    }
}