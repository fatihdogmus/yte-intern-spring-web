package yte.intern.springweb.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yte.intern.springweb.controllers.dto.User;

import javax.validation.Valid;

@RestController
public class ValidationController {

    @PostMapping("/user")
    public void userValidation(@RequestBody @Valid User user) {
        System.out.println(user);
    }
}
