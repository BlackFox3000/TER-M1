package mybootapp.web.service;

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

import java.util.List;

@Service
@Transactional
public class TeacherService {
/*
    @Autowired
    TeacherService tr;

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
        //delete();
        //save();
    }*/
}