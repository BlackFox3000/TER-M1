package mybootapp.repo.user;

import mybootapp.model.user.Role;
import mybootapp.model.user.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAppRepository extends JpaRepository<UserApp, Long> {

    List<UserApp> findByFirstnameLike(String firstname);
    List<UserApp> findByLastnameLike(String lastname);
    List<UserApp> findByEmailLike(String name);
    List<UserApp> findByRoleLike(@Param("roles") Role role);
}
