package com.group.steg.groupe;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.group.steg.groupe.Dao.AjouterStagiereDao;
import com.group.steg.groupe.Dao.CreerGroupeDao;
import com.group.steg.groupe.Dao.EffacerGroupeDao;
import com.group.steg.groupe.Dao.GroupeResponse;
import com.group.steg.groupe.Dao.ModifierNomGroupeDao;
import com.group.steg.membre.Membre;
import com.group.steg.parametres.dao.AfficherGroupeDao;
import com.group.steg.stagiere.dao.EffacerStagiereDao;

@RestController
@RequestMapping("/groupes")
@CrossOrigin(origins = "https://benevolent-narwhal-87df15.netlify.app")
public class GroupeController {
    
    private final GroupeService groupeService;

    @Autowired
    public GroupeController(GroupeService groupeService) {
        this.groupeService = groupeService;
    }

    @GetMapping("/afficher")
    public ArrayList<Groupe> afficherGroupe() {
        return this.groupeService.afficherGroupes();
    }

    @GetMapping("/afficher/membres")
    public ArrayList<Membre> afficherMembres(@RequestParam("id") int idGroupe) {
        return this.groupeService.afficherMembres(idGroupe);
    }

    @PutMapping("/creer")
    public Groupe creerGroupe(@RequestBody CreerGroupeDao groupeData) {
        return this.groupeService.creerGroupe(groupeData);
    }

    @PostMapping("/modifier-nom")
    public GroupeResponse modifierNomGroupe(@RequestBody ModifierNomGroupeDao groupe) {
        return this.groupeService.modifierGroupe(groupe.idGroupe, groupe.nom);
    }

    @PutMapping("/ajouter-stagiere")
    public GroupeResponse ajouterStagiereAuGroupe(@RequestBody AjouterStagiereDao stagiere) {
        return this.groupeService.ajouterStagiereAuGroupe(stagiere);
    }

    @DeleteMapping("/effacer-stagiere")
    public GroupeResponse effacerStagiereDuGroupe(@RequestParam("id") int idStagiere) {
        return this.groupeService.effacerStagiereDuGroupe(idStagiere);
    }

    @DeleteMapping("/effacer")
    public GroupeResponse effacerGroupe(@RequestParam("id") int idGroupe) {
        return this.groupeService.effacerGroupe(idGroupe);
    }

}
