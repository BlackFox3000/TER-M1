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
    AdminRepository ar = new AdminRepository() {
        @Override
        public List<Admin> findAll() {
            return null;
        }

        @Override
        public List<Admin> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<Admin> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public <S extends Admin> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends Admin> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends Admin> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<Admin> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Admin getOne(Long aLong) {
            return null;
        }

        @Override
        public Admin getById(Long aLong) {
            return null;
        }

        @Override
        public <S extends Admin> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends Admin> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<Admin> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Admin> S save(S entity) {
            return null;
        }

        @Override
        public Optional<Admin> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(Admin entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends Admin> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends Admin> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends Admin> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Admin> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Admin> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends Admin, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };

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
