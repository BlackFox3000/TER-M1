package mybootapp.repo;

import mybootapp.model.StudentList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentListRepository extends JpaRepository<StudentList, Long> {
}
