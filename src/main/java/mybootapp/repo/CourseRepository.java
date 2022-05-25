package mybootapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mybootapp.model.Course;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

	List<Course> findByName(String name);

	List<Course> findByNameLike(String name);

}
