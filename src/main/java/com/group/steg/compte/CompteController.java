package com.group.steg.compte;

import org.springframework.web.bind.annotation.RestController;

import com.group.steg.compte.dao.LoginDao;
import com.group.steg.compte.dao.LoginResponseDao;
import com.group.steg.compte.dao.SignupDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/compte")
@CrossOrigin(origins = "https://benevolent-narwhal-87df15.netlify.app")
public class CompteController {

    private final CompteService compteService;

    @Autowired
    public CompteController(CompteService compteService) {
        this.compteService = compteService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDao> signin(@RequestBody LoginDao loginData) {
        return this.compteService.login(loginData);
    }

    @PostMapping("/signup")
    public ResponseEntity<LoginResponseDao> signup(@RequestBody SignupDao signupData) {
        return this.compteService.signup(signupData);
    }
}