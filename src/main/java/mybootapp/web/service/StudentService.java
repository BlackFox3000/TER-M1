package mybootapp.web.service;

import mybootapp.model.Repository;
import mybootapp.model.Work;
import mybootapp.model.user.Student;
import mybootapp.repo.WorkRepository;
import mybootapp.repo.user.StudentRepository;
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
public class StudentService {

    @Autowired
    StudentRepository str = new StudentRepository() {
        @Override
        public List<Student> findByPersonnalWorksLike(Work work) {
            return null;
        }

        @Override
        public List<Student> findAll() {
            return null;
        }

        @Override
        public List<Student> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<Student> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public <S extends Student> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends Student> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends Student> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<Student> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Student getOne(Long aLong) {
            return null;
        }

        @Override
        public Student getById(Long aLong) {
            return null;
        }

        @Override
        public <S extends Student> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends Student> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<Student> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Student> S save(S entity) {
            return null;
        }

        @Override
        public Optional<Student> findById(Long aLong) {
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
        public void delete(Student entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends Student> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends Student> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends Student> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Student> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Student> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends Student, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };

    @Autowired
    WorkRepository wr;


    public void save(Student student){
        str.save(student);
    }

    public void delete(Student student) {
        str.deleteById(student.getId());
    }

    public void deleteAll(){
        str.deleteAll();
    }

    public void uploadWork(Student student, Repository repo, Work work){
        student.getPersonnalWorks().add(work);
        repo.getWorks().add(work);
    }
}
