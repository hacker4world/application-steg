package com.group.steg.compte;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.group.steg.compte.dao.LoginDao;
import com.group.steg.compte.dao.LoginResponseDao;
import com.group.steg.compte.dao.SignupDao;

@Service
public class CompteService {

    private final CompteRepository compteRepository;

    public CompteService(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    public ResponseEntity<LoginResponseDao> login(LoginDao loginData) {
        // verify if account exists
        Compte compte = this.compteRepository.findByEmail(loginData.email);
        if (compte == null) {
            return new ResponseEntity<LoginResponseDao>(new LoginResponseDao("compte n'existe pas"), HttpStatus.NOT_FOUND);
        } else {
            if (!compte.getMotdepasse().equals(loginData.password)) {
                return new ResponseEntity<LoginResponseDao>(new LoginResponseDao("Mot de passe incorrect"), HttpStatus.UNAUTHORIZED);
            } else {
                return new ResponseEntity<LoginResponseDao>(new LoginResponseDao("connexion reussie", compte.getIdcompte(), compte.getNom(), compte.getPrenom(), compte.getEmail(), compte.getRole()), HttpStatus.OK);
            }
        }
    }

    public ResponseEntity<LoginResponseDao> signup(SignupDao signupData) {
        Compte compte = this.compteRepository.findByEmail(signupData.email);
        if (compte != null) {
            return new ResponseEntity<LoginResponseDao>(new LoginResponseDao("adresse email deja utilise"), HttpStatus.UNAUTHORIZED);
        } else {
            Compte nouveauCompte = new Compte(signupData.nom, signupData.prenom, signupData.email, signupData.password, "utilisateur");
            Compte c = this.compteRepository.save(nouveauCompte);
            return new ResponseEntity<LoginResponseDao>(new LoginResponseDao("connexion reussie", c.getIdcompte(), c.getNom(), c.getPrenom(), c.getEmail(), "utilisateur"), HttpStatus.OK);
        }
    }
}