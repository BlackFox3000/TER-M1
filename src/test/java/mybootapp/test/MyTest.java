package mybootapp.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mybootapp.model.Subject;
import mybootapp.model.Work;
import mybootapp.model.user.Role;
import mybootapp.model.user.UserApp;
import mybootapp.repo.SubjectRepository;
import mybootapp.repo.WorkRepository;
import mybootapp.web.service.WorkService;
import org.hsqldb.rights.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import mybootapp.model.Course;
import mybootapp.repo.CourseRepository;
import mybootapp.Starter;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@SpringBootTest
@ContextConfiguration(classes = Starter.class)
public class MyTest {

	@Autowired
	CourseRepository cr;

	@Test
	public void testSave() {
		var c = cr.save(new Course("Test 1"));
		var c2 = cr.findById(c.getId());
		assertEquals(c2.get().getName(), "Test 1");
		System.err.printf("course id = %d\n", c.getId());
		cr.deleteAll();
	}

	@Autowired
	WorkRepository wr;

	@Test
	public void whenFindingWorkById_thenCorrect() {
		ArrayList<Subject> subjects = new ArrayList<>();
		subjects.add(new Subject("Maths"));
		wr.save(new Work("Mémoire sur le théorème de Pythagore", subjects));
		assertInstanceOf(Optional.class,wr.findById(1L));
		wr.deleteAll();
	}

	@Test
	public void whenFindingAllWorks_thenCorrect() {
		sr.deleteAll();
		ArrayList<Subject> subjects = new ArrayList<>();
		subjects.add(new Subject("Maths"));
		ArrayList<Subject> subjects2 = new ArrayList<>();
		subjects2.add(new Subject("Biologie"));
		wr.save(new Work("Mémoire sur Thalès", subjects));
		wr.save(new Work("Mémoire sur Gauss", subjects2));
		assertInstanceOf(List.class,wr.findAll());
		wr.deleteAll();
	}

	@Test
	public void whenSavingWork_thenCorrect() {
		List<Subject> subjects = new ArrayList<>();
		subjects.add(new Subject("Maths"));
		Work work = new Work("pythagore", subjects);
		wr.save(work);
		Work work2 = wr.findById(work.getId()).orElseGet(()
				-> new Work("thalès", subjects));
		assertEquals(work2.getTitle(),"pythagore");
		wr.deleteAll();
	}

	@Autowired
	SubjectRepository sr;

	@Test
	@Transactional
	public void whenSavingWork_thenCorrectandFindingSubject() {
		List<Subject> subjects = new ArrayList<>();
		Subject sub = new Subject("Maths");
		subjects.add(sub);
		Work work = new Work("pythagore", subjects);
		wr.save(work);
		Work work2 = wr.findById(work.getId()).orElseGet(()
				-> new Work("thalès", subjects));
		assertEquals(work2.getTitle(),"pythagore");
		Subject subTest = sr.findById(sub.getId()).orElseGet(()
				-> new Subject("Informatique"));;
		assertEquals(subTest.getName(),"Maths");
		sr.deleteAll();
		wr.deleteAll();
	}

	@Test
	@Transactional
	public void whenDeletingWork_thenCorrect() {
		List<Subject> subjects = new ArrayList<>();
		subjects.add(new Subject("Maths"));
		Work work = new Work("pythagore", subjects);
		wr.save(work);
		Work work2 = wr.findById(work.getId()).orElseGet(()
				-> new Work("thalès", subjects));
		assertEquals(work2.getTitle(),"pythagore");
		wr.deleteAll();
		work2 = wr.findById(work.getId()).orElseGet(()
				-> new Work("thalès", subjects));
		assertEquals(work2.getTitle(),"thalès");
		wr.deleteAll();
	}

	@Autowired
	WorkService ws;

	@Test
	public void workServiceWorking() {
		List<Subject> subjects = new ArrayList<>();
		subjects.add(new Subject("Maths"));
		Work work = new Work("pythagore", subjects);
		ws.save(work);
		Work work2 = wr.findById(work.getId()).orElseGet(()
				-> new Work("thalès", subjects));
		assertEquals(work2.getTitle(),"pythagore");
		ws.deleteAll();
	}

	@Test
	public void testUserAppTeacher(){
		UserApp user = new UserApp("tho.ni@yahoo.fr","dfdf", Role.TEACHER);

	}


}
