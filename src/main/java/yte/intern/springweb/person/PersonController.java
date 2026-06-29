package yte.intern.springweb.person;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @PostMapping("/person")
    public List<Person> increaseAge(@RequestBody List<Person> persons) {

        return persons.stream()
                .map(person -> new Person(person.name(), person.surname(), person.age() + 1))
                .toList();

    }
}
