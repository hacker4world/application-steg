package com.group.steg.parametres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group.steg.parametres.dao.ModifierParametreDao;

@RestController
@RequestMapping("/parametre")
@CrossOrigin(origins = "https://benevolent-narwhal-87df15.netlify.app")
public class ParametresController {
    private final ParametreService parametreService;

    @Autowired
    public ParametresController(ParametreService parametreService) {
        this.parametreService = parametreService;
    }

    @GetMapping("/afficher")
    public ResponseEntity afficher() {
        return this.parametreService.afficher();
    }

    @PostMapping("/modifier")
    public ResponseEntity modifier(@RequestBody ModifierParametreDao parametres) {
        return this.parametreService.modifier(parametres);
    }

}
