package mybootapp.web.service;

import mybootapp.model.user.Role;
import mybootapp.model.user.Teacher;
import mybootapp.model.user.UserApp;
import mybootapp.repo.RepoRepository;
import mybootapp.repo.user.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@Transactional
public class UserService {

    @Autowired
    UserAppRepository ur;

    public void save(UserApp user) {ur.save(user);}

    public void delete(UserApp user) {
        ur.delete(user);
    }

    public void deleteAll() {
        ur.deleteAll();
    }

    public String connection(){
        System.out.println("userService");
        return "/student/space";
    }

}
