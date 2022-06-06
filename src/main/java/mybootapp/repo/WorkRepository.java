package mybootapp.repo;

import mybootapp.model.Subject;
import mybootapp.model.Work;
import mybootapp.model.status.StatusW;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkRepository extends JpaRepository<Work, Long> {

    List<Work> findByTitleLike(String title);
    List<Work> findAll();
    List<Work> findByStatusWLike(StatusW statusW);

}
