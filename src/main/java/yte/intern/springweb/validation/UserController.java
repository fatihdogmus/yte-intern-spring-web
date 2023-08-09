package yte.intern.springweb.validation;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/user")
    public void postUser(@Valid @RequestBody User user) {
        System.out.println("Hebele");
    }
}
