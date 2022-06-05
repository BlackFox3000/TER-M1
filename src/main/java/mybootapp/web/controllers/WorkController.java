package mybootapp.web.controllers;

import mybootapp.model.Subject;
import mybootapp.model.Work;
import mybootapp.repo.WorkRepository;
import mybootapp.web.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WorkController {

    @Autowired
    WorkService ws;

    @Autowired
    WorkRepository wr;

    private static List<Work> works = new ArrayList<>();

    static {
        Work work1 = new Work();
        work1.setTitle("pythagore");
        Work work2 = new Work();
        work2.setTitle("thalès");
        Work work3 = new Work();
        work3.setTitle("gauss");
        works.add(work1);
        works.add(work2);
        works.add(work3);
    }

    public void saveWork(){
        List<Subject> subjects = new ArrayList<>();
        Subject sub = new Subject("Biologie");
        Subject sub2 = new Subject("Maths");
        subjects.add(sub);
        subjects.add(sub2);
        for (Work work: works){
            work.setSubjects(subjects);
            ws.save(work);
        }
    }

    @RequestMapping(value = {"/workList" }, method = RequestMethod.GET)
    String printWorks(Model model){

        model.addAttribute("works", works);

        return "workList";
    }

    @RequestMapping(value = {"/workListBD" }, method = RequestMethod.GET)
    String printWorksBD(Model model){
        saveWork();
        List<Work> workBD = workBD = wr.findAll();
        model.addAttribute("works", workBD);

        return "workListBD";
    }

}
