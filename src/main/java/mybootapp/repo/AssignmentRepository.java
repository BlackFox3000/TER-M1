package mybootapp.repo;

import mybootapp.model.Assignment;
import mybootapp.model.status.StatusA;
import mybootapp.model.user.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import mybootapp.model.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    List<Assignment> findByNameLike(String name);
    //List<Assignment> findByTeachersLike(List<Teacher> teachers);
    //List<Assignment> findByRepositoriesLike(List<Repository> repositories);
    List<Assignment> findByStatusALike(StatusA statusA);
}
