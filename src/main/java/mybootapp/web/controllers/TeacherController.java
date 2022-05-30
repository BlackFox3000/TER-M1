package mybootapp.web.controllers;

import mybootapp.web.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TeacherController {

    @Autowired
    TeacherService ts;

    @RequestMapping(value = "/new-repository", method = RequestMethod.GET)
    String createRepositoryButton(Model model){
        return "new-repository";
    }

    @RequestMapping(value = "/new-repository", method = RequestMethod.GET)
    String attributeWorks(Model model){
        return "à voir";
    }
}
