package yte.intern.springweb.course;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CourseController {

    @RequestMapping("/course/{courseNumber}")
    public void courses(@PathVariable Integer courseNumber,
                        @RequestParam String name,
                        @RequestParam String instructor) {

        System.out.println("%d %s %s".formatted(courseNumber, name, instructor));

    }

    @GetMapping("/courses")
    @ResponseBody
    public Course getCourse() {
        return new Course("Hebele",15L,"Hübele");
    }
}
