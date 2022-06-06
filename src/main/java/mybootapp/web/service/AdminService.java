package mybootapp.web.service;

import mybootapp.Algo;
import mybootapp.model.Repository;
import mybootapp.model.user.Admin;
import mybootapp.model.user.Student;
import mybootapp.model.user.Teacher;
import mybootapp.repo.user.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@Transactional
public class AdminService {

    @Autowired
    AdminRepository ar;

    public void save(Admin admin){
        ar.save(admin);
    }

    public void delete(Admin admin) {
        ar.deleteById(admin.getId());
    }

    public void deleteAll(){
        ar.deleteAll();
    }
    public void addAdmin(String mail){
        //aller chercher l'utilisateur dans la bdd avec le mail et le passer en admin
    }

    public void deleteAdmin(String mail){

        //aller chercher l'admin dans la bdd avec le mail et le passer en prof
    }

    public void approveUser(String mail){

        //valide les privilèges de l'utilisateur avec la mail
    }

    public void attributeWorks(Repository repo, ArrayList<Teacher> teachers){
        Algo algo = new Algo();
        algo.assignementFromRepository(repo,teachers);
    }
}
