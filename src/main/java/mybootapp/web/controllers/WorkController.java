package mybootapp.web.controllers;

import mybootapp.model.Work;
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


    @RequestMapping(value = {"/workList" }, method = RequestMethod.GET)
    String printWorks(Model model){

        model.addAttribute("works", works);

        return "workList";
    }

}
