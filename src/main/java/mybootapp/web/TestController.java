package mybootapp.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/hellotest")
    public String helloWorld(){
        return "Hello World from Spring Boot";
    }
}
