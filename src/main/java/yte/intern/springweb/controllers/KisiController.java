package yte.intern.springweb.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import yte.intern.springweb.controllers.dto.Kisi;

import java.util.List;

@RestController
public class KisiController {

    @PostMapping("/kisiler")
    public List<Kisi> kisiler(@RequestBody List<Kisi> kisiler) {
        kisiler.forEach(kisi -> kisi.yasArtir());
        return kisiler;
    }
}
