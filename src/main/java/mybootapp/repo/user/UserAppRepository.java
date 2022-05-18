package mybootapp.repo.user;

import mybootapp.model.user.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAppRepository extends JpaRepository<UserApp, Long> {
    UserApp findByEmailLike(String name);

}
