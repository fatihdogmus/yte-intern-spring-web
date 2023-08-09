package yte.intern.springweb.requestbody;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @PostMapping("/person")
    public List<Person> getPeople(@RequestBody List<Person> persons) {
        for (Person person : persons) {
            person.setYas(person.getYas() + 1);
        }

        return persons;
    }
}
