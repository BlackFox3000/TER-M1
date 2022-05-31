package mybootapp.repo.user;

import mybootapp.model.Work;
import mybootapp.model.user.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByPersonnalWorksLike(Work work);
}
