package mybootapp.repo;

import mybootapp.model.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface RepoRepository extends JpaRepository<Repository, Long> {

}
