package com.group.steg.parametres;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.group.steg.parametres.dao.AfficherReponse;
import com.group.steg.parametres.dao.ModifierParametreDao;

@Service
public class ParametreService {

    private final ParametreRepository parametreRepository;

    @Autowired
    public ParametreService(ParametreRepository parametreRepository) {
        this.parametreRepository = parametreRepository;
    }

    public ResponseEntity afficher() {
        ArrayList<Parametre> parametre = (ArrayList<Parametre>) this.parametreRepository.findAll();
        return new ResponseEntity(new AfficherReponse("parametres affiche", parametre.get(0)), HttpStatus.OK);
    }

    public ResponseEntity modifier(ModifierParametreDao parametres) {
        ArrayList<Parametre> p = (ArrayList<Parametre>) this.parametreRepository.findAll();
        Parametre nouveauParametre = new Parametre(parametres.stageInitiation, parametres.stagePerfectionnement, parametres.stagePfe);
        if (p.isEmpty() == false) {
            this.parametreRepository.deleteById(p.get(0).getIdParametre());
        }
        this.parametreRepository.save(nouveauParametre);
        return new ResponseEntity(new AfficherReponse("parametres modifie"), HttpStatus.OK);
    }

}
