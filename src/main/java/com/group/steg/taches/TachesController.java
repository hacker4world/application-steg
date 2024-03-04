package com.group.steg.taches;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group.steg.taches.dao.AfficherTachesDao;
import com.group.steg.taches.dao.AjouterTacheDao;
import com.group.steg.taches.dao.SupprimerTacheDao;

@RestController
@RequestMapping("/taches")
@CrossOrigin(origins = "https://benevolent-narwhal-87df15.netlify.app")
public class TachesController {

    private final TachesService tachesService;

    @Autowired
    public TachesController(TachesService tachesService) {
        this.tachesService = tachesService;
    }

    @GetMapping("/afficher")
    public ResponseEntity afficherTaches(@RequestParam("id") int idGroupe) {
        return this.tachesService.afficherTaches(idGroupe);
    }

    @PutMapping("/ajouter")
    public Tache ajouterTache(@RequestBody AjouterTacheDao tache) {
        return this.tachesService.ajouterTache(tache);
    }

    @DeleteMapping("/supprimer")
    public ResponseEntity supprimerTache(@RequestParam("id") int tache) {
        return this.tachesService.supprimerTache(tache);
    }

}