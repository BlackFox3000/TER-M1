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
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@Transactional
public class TeacherService {

    @Autowired
    TeacherRepository tr;

    @Autowired
    RepoRepository rr;

    public void save(Teacher teacher) {tr.save(teacher);}

    public void delete(Teacher teacher) {
        tr.delete(teacher);
    }

    public void deleteAll() {
        tr.deleteAll();
    }

    public void createRepository(Repository repo){
        rr.save(repo);
        if(!repo.getTeacherOwner().getRepositories().contains(repo)) {
            repo.getTeacherOwner().getRepositories().add(repo);
        }
    }

    public void commentWork(String message, Work work){
        work.setCommentary(work.getCommentary() + message);
    }

    public void attributeWorks(Repository repo, ArrayList<Teacher> teachers){
        Algo algo = new Algo();
        algo.assignementFromRepository(repo, teachers);
    }
}