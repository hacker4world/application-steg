package com.group.steg.stagiere;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group.steg.stagiere.dao.AccepterDemandeDao;
import com.group.steg.stagiere.dao.AfficherdemandeReponse;
import com.group.steg.stagiere.dao.CreerDemandeDao;
import com.group.steg.stagiere.dao.CreerDemandeReponse;
import com.group.steg.stagiere.dao.EffacerStagiereDao;
import com.group.steg.stagiere.dao.RefuserDemandeDao;

@RestController
@RequestMapping("/stagiere")
@CrossOrigin(origins = "https://benevolent-narwhal-87df15.netlify.app")
public class StagiereController {
    
    private final StagiereService stagiereService;

    @Autowired
    public StagiereController(StagiereService stagiereService) {
        this.stagiereService = stagiereService;
    }

    @PutMapping("/creer-demande")
    public ResponseEntity<CreerDemandeReponse> signin(@RequestBody CreerDemandeDao demandeData) {
        return this.stagiereService.creerDemande(demandeData);
    }

    @GetMapping("/demandes")
    public ResponseEntity<AfficherdemandeReponse> demandes() {
        return this.stagiereService.demandes();
    }

    @PutMapping("/demandes/accepter")
    public ResponseEntity accepterDemande(@RequestBody AccepterDemandeDao demande) {
        return this.stagiereService.accepterDemande(demande.idDemande);
    }

     @PostMapping("/demandes/refuser")
    public ResponseEntity refuserDemande(@RequestBody RefuserDemandeDao demande) {
        return this.stagiereService.refuserDemande(demande.idDemande);
    }

    @GetMapping("/stagieres")
    public ResponseEntity stagieres() {
        return this.stagiereService.stagieres();
    }

    @DeleteMapping("/effacer")
    public ResponseEntity effacerStagiere(@RequestParam("id") int idStagiere) {
        return this.stagiereService.effacerStagiere(idStagiere);
    }

}
