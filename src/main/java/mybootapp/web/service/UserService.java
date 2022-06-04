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
    UserAppRepository ur = new UserAppRepository() {
        @Override
        public List<UserApp> findByFirstnameLike(String firstname) {
            return null;
        }

        @Override
        public List<UserApp> findByLastnameLike(String lastname) {
            return null;
        }

        @Override
        public List<UserApp> findByEmailLike(String name) {
            return null;
        }

        @Override
        public List<UserApp> findByRoleLike(Role role) {
            return null;
        }

        @Override
        public List<UserApp> findAll() {
            return null;
        }

        @Override
        public List<UserApp> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<UserApp> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public <S extends UserApp> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends UserApp> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends UserApp> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<UserApp> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public UserApp getOne(Long aLong) {
            return null;
        }

        @Override
        public UserApp getById(Long aLong) {
            return null;
        }

        @Override
        public <S extends UserApp> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends UserApp> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<UserApp> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends UserApp> S save(S entity) {
            return null;
        }

        @Override
        public Optional<UserApp> findById(Long aLong) {
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
        public void delete(UserApp entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends UserApp> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends UserApp> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends UserApp> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends UserApp> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends UserApp> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends UserApp, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };

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
