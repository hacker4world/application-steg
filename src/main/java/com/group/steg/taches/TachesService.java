package com.group.steg.taches;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.group.steg.taches.dao.AfficherTachesReponse;
import com.group.steg.taches.dao.AjouterTacheDao;
import com.group.steg.taches.dao.SupprimerTacheDao;

@Service
public class TachesService {

    private final TachesRepository tachesRepository;

    @Autowired
    public TachesService(TachesRepository tachesRepository) {
        this.tachesRepository = tachesRepository;
    }

    public ResponseEntity afficherTaches(int idGroupe) {
        ArrayList<Tache> taches = (ArrayList<Tache>) this.tachesRepository.findByIdGroupe(idGroupe);
        return new ResponseEntity(new AfficherTachesReponse("liste des taches affiche", taches), HttpStatus.OK);
    }

    public Tache ajouterTache(AjouterTacheDao tache) {
        Tache nouveauTache = new Tache(tache.idGroupe, tache.description, tache.dateLimite);
        this.tachesRepository.save(nouveauTache);
        return nouveauTache;
    }

    public ResponseEntity supprimerTache(int idTache) {
        this.tachesRepository.deleteById(idTache);
        return new ResponseEntity(new AfficherTachesReponse("tache efface"), HttpStatus.OK);
    }

}
