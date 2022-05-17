package mybootapp.repo;

import mybootapp.model.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoRepository extends JpaRepository<Repository, Long> {

}
