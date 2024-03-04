package com.group.steg.stagiere;

import java.util.ArrayList;
import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.group.steg.compte.Compte;
import com.group.steg.compte.CompteRepository;
import com.group.steg.stagiere.dao.AccepterDemandeDao;
import com.group.steg.stagiere.dao.AccepterDemandeReponse;
import com.group.steg.stagiere.dao.AfficherdemandeReponse;
import com.group.steg.stagiere.dao.CreerDemandeDao;
import com.group.steg.stagiere.dao.CreerDemandeReponse;
import com.group.steg.stagiere.dao.EffacerStagiereDao;
import com.group.steg.stagiere.dao.EffacerStagiereReponse;
import com.group.steg.stagiere.dao.NumeroDemandes;
import com.group.steg.stagiere.dao.StagieresReponseDao;

@Service
public class StagiereService {

    private final DemandeStageRepository demandeStageRepository;
    private final CompteRepository compteRepository;
    private final StagiereRepository stagiereRepository;

    @Autowired
    public StagiereService(DemandeStageRepository demandeStageRepository, CompteRepository compteRepository, StagiereRepository stagiereRepository) {
        this.demandeStageRepository = demandeStageRepository;
        this.compteRepository = compteRepository;
        this.stagiereRepository = stagiereRepository;
    }

    public ResponseEntity<CreerDemandeReponse> creerDemande(CreerDemandeDao demandeData) {
        Optional<Compte> compte = this.compteRepository.findById(demandeData.compte);
        if (compte.isPresent() == false) {
            return new ResponseEntity<CreerDemandeReponse>(new CreerDemandeReponse("compte n'existe pas"), HttpStatus.NOT_FOUND);
        }
        DemandeStage demandeExiste = this.demandeStageRepository.findByCompte(demandeData.compte);
        if (demandeExiste != null) {
            return new ResponseEntity<CreerDemandeReponse>(new CreerDemandeReponse("compte a deja applique pour un stage"), HttpStatus.BAD_REQUEST);
        }
        DemandeStage demande = new DemandeStage(demandeData.pieceIdentite, demandeData.codeIdentite, demandeData.niveauEtude, demandeData.typeStage, demandeData.numTel, demandeData.institut, demandeData.jours, demandeData.dateDebut, demandeData.dateFin, demandeData.gouvernorat, demandeData.diplome, demandeData.nationalite, demandeData.anne, demandeData.imageCinAvant, demandeData.imageCinAriere, demandeData.compte, demandeData.nom, demandeData.prenom, demandeData.specialite);
        this.demandeStageRepository.save(demande);
        // creer demande
        return new ResponseEntity<CreerDemandeReponse>(new CreerDemandeReponse("demande a ete cree") , HttpStatus.OK);
    }

    public ResponseEntity<AfficherdemandeReponse> demandes() {
        ArrayList<DemandeStage>  demandes = (ArrayList<DemandeStage>) this.demandeStageRepository.findAll();
        return new ResponseEntity<AfficherdemandeReponse>(new AfficherdemandeReponse("demandes ont ete recupere", demandes) , HttpStatus.OK);
    }

    public ResponseEntity accepterDemande(int idDemande) {
        Optional<DemandeStage> demande = this.demandeStageRepository.findById(idDemande);
        if (demande.isPresent() == false) {
            return new ResponseEntity(new AccepterDemandeReponse("id_demande invalide") , HttpStatus.BAD_REQUEST);
        }
        Optional<Compte> compte = this.compteRepository.findById(demande.get().getCompte());
        Compte c = compte.get();
        DemandeStage d = demande.get();
        Stagiere nouveauStagiere = new Stagiere(
            c.getNom(), c.getPrenom(), c.getEmail(), d.getPieceIdentite(), d.getCodeIdentite(), d.getNiveauEtude(), d.getTypeStage(), d.getNumTel(), d.getInstitut(), d.getJours(), d.getDateDebut(), d.getDateFin(), d.getGouvernorat(), d.getDiplome(), d.getNationalite(), d.getAnne(), d.getImageCinAvant(), d.getImageCinAriere(), d.getSpecialite()
        );
        this.stagiereRepository.save(nouveauStagiere);
        this.demandeStageRepository.deleteById(idDemande);
        return new ResponseEntity(new AccepterDemandeReponse("demande de stage a ete accepte") , HttpStatus.OK);
    }

    public ResponseEntity refuserDemande(int idDemande) {
        this.demandeStageRepository.deleteById(idDemande);
        return new ResponseEntity(new AfficherdemandeReponse("demande de stage refuse") , HttpStatus.OK);
    }

    public ResponseEntity stagieres() {
        ArrayList<Stagiere> stagieres = (ArrayList<Stagiere>) this.stagiereRepository.findAll();
        return new ResponseEntity(new StagieresReponseDao("liste des stagieres", stagieres), HttpStatus.OK);
    }

    public ResponseEntity effacerStagiere(int idStagiere) {
        Optional<Stagiere> stagiere = this.stagiereRepository.findById(idStagiere);
        if (stagiere.isPresent() == false) {
            return new ResponseEntity(new EffacerStagiereReponse("id_stagiere invalide"), HttpStatus.BAD_REQUEST);
        }
        this.stagiereRepository.deleteById(idStagiere);
        return new ResponseEntity(new EffacerStagiereReponse("stagiere efface"), HttpStatus.OK);
    }

    

}
