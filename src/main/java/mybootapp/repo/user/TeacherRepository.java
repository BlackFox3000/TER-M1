package mybootapp.repo.user;

import mybootapp.model.StudentList;
import mybootapp.model.Subject;
import mybootapp.model.Work;
import mybootapp.model.user.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import mybootapp.model.Repository;
import java.util.List;

@org.springframework.stereotype.Repository
public interface  TeacherRepository extends JpaRepository<Teacher, Long> {

    /*List<Teacher> findBySubjectLike(Subject subject);
    List<Teacher> findByWorkLike(Work work);
    List<Teacher> findByRepositoryLike(Repository repository);
    List<Teacher> findByStudentListLike(StudentList studentList);*/
}