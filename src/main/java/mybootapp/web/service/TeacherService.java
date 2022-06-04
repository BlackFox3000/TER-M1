package mybootapp.web.service;

import mybootapp.Algo;
import mybootapp.model.Repository;
import mybootapp.model.StudentList;
import mybootapp.model.Subject;
import mybootapp.model.Work;
import mybootapp.model.user.Teacher;
import mybootapp.repo.RepoRepository;
import mybootapp.repo.StudentListRepository;
import mybootapp.repo.SubjectRepository;
import mybootapp.repo.WorkRepository;
import mybootapp.repo.user.TeacherRepository;
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
public class TeacherService {

    @Autowired
    TeacherRepository tr = new TeacherRepository() {
        @Override
        public List<Teacher> findAll() {
            return null;
        }

        @Override
        public List<Teacher> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<Teacher> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public <S extends Teacher> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends Teacher> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends Teacher> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<Teacher> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Teacher getOne(Long aLong) {
            return null;
        }

        @Override
        public Teacher getById(Long aLong) {
            return null;
        }

        @Override
        public <S extends Teacher> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends Teacher> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<Teacher> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Teacher> S save(S entity) {
            return null;
        }

        @Override
        public Optional<Teacher> findById(Long aLong) {
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
        public void delete(Teacher entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends Teacher> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends Teacher> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends Teacher> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Teacher> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Teacher> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends Teacher, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };

    @Autowired
    RepoRepository rr;

    public void save(Teacher teacher) {tr.save(teacher);}

    public void delete(Teacher teacher) {
        tr.delete(teacher);
    }

    public void deleteAll() {
        tr.deleteAll();
    }

    public void createRepository(Repository repo){
        rr.save(repo);
        if(!repo.getTeacherOwner().getRepositories().contains(repo)) {
            repo.getTeacherOwner().getRepositories().add(repo);
        }
    }

    public void commentWork(String message, Work work){
        work.setCommentary(work.getCommentary() + message);
    }

    public void attributeWorks(Repository repo, ArrayList<Teacher> teachers){
        Algo algo = new Algo();
        algo.assignementFromRepository(repo, teachers);
    }
}