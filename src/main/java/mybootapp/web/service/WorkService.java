package mybootapp.web.service;

import mybootapp.model.Subject;
import mybootapp.model.Work;
import mybootapp.model.user.Teacher;
import mybootapp.repo.SubjectRepository;
import mybootapp.repo.WorkRepository;
import mybootapp.repo.user.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WorkService {

    @Autowired
    WorkRepository wr;

    @Autowired
    TeacherRepository tr;

    @Autowired
    SubjectRepository sr;

    public void save(Work work){wr.save(work);}

    public void delete(Work work) {
        wr.deleteById(work.getId());
    }

    public void deleteAll(){
        wr.deleteAll();
    }

}
