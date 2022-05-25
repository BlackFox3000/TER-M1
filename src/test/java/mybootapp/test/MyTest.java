package mybootapp.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mybootapp.model.Subject;
import mybootapp.model.Work;
import mybootapp.repo.SubjectRepository;
import mybootapp.repo.WorkRepository;
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
	}

	@Autowired
	WorkRepository wr;

	@Test
	public void whenFindingWorkById_thenCorrect() {
		ArrayList<Subject> subjects = new ArrayList<>();
		subjects.add(new Subject("Maths"));
		wr.save(new Work("Mémoire sur le théorème de Pythagore", subjects));
		assertInstanceOf(Optional.class,wr.findById(1L));
	}

	@Test
	public void whenFindingAllWorks_thenCorrect() {
		ArrayList<Subject> subjects = new ArrayList<>();
		subjects.add(new Subject("Maths"));
		ArrayList<Subject> subjects2 = new ArrayList<>();
		subjects2.add(new Subject("Biologie"));
		wr.save(new Work("Mémoire sur Thalès", subjects));
		wr.save(new Work("Mémoire sur Gauss", subjects2));
		assertInstanceOf(List.class,wr.findAll());
	}

	@Autowired
	SubjectRepository sr;

	@Test
	@Transactional
	public void whenSavingWork_thenCorrect() {
		ArrayList<Subject> subjects = new ArrayList<>();
		Subject sub = new Subject("Maths");
		sr.save(sub);
		subjects.add(sub);
		wr.save(new Work("pythagore", subjects));
		Work work = wr.findById(1L).orElseGet(()
				-> new Work("thalès", subjects));
		assertEquals(work.getTitle(),"pythagore");
	}
}
