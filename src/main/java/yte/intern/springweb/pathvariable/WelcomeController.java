package yte.intern.springweb.pathvariable;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome.html";
    }

    @RequestMapping("/courses/{courseNumber}")
    public void courses(@PathVariable Long courseNumber, @RequestParam String name, @RequestParam String instructor) {
        System.out.println(courseNumber + " " + name + " " + instructor);
    }
}
