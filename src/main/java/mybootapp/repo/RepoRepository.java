package mybootapp.repo;

import mybootapp.model.Repository;
import mybootapp.model.Subject;
import mybootapp.model.Work;
import mybootapp.model.status.StatusR;
import mybootapp.model.user.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Repository
public interface RepoRepository extends JpaRepository<Repository, Long> {

    List<Repository> findByNameLike(String name);
    //List<Repository> findBySubjectsLike(List<Subject> subjects);
    //List<Repository> findByWorksLike(List<Work> works);
    List<Repository> findByTeacherOwnerLike(Teacher teacher);
    List<Repository> findByStatusRLike(StatusR statusR);
    List<Repository> findByEndDateAfter(Date date);
    List<Repository> findByEndDateBefore(Date date);

}
