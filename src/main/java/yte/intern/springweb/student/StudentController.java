package yte.intern.springweb.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/students")
    public Student getStudent() {
        return new Student("Hebele","Hübele",26L);
    }
}
