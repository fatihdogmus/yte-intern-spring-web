package yte.intern.springweb.responsebody;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @GetMapping("/getCourse")
    public Course getCourse() {
        return new Course("CENG-122","Ahmet Oğuz Akyüz");
    }
}
