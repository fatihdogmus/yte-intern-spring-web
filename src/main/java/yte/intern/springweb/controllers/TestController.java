package yte.intern.springweb.controllers;

import org.springframework.web.bind.annotation.*;
import yte.intern.springweb.controllers.dto.Student;

@RestController
public class TestController {

    @RequestMapping("/courses/{id}")
    public void courses(@PathVariable final Long id, @RequestParam final String name, @RequestParam final String instructor) {
        System.out.println(id + " " + name + " " + instructor);
    }

    @GetMapping("/student")
    public Student student() {
        return new Student("Fatih", 26L, "hebele@hubele.com");
    }
}
