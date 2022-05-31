package mybootapp.repo;

import mybootapp.model.StudentList;
import mybootapp.model.user.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentListRepository extends JpaRepository<StudentList, Long> {

    List<StudentList> findByNameLike(String name);
    //List<StudentList> findByStudentListLike(List<Student> studentList);
}
