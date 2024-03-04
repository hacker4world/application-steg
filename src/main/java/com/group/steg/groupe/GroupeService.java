package com.group.steg.groupe;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.steg.groupe.Dao.AfficherGroupe;
import com.group.steg.groupe.Dao.AjouterStagiereDao;
import com.group.steg.groupe.Dao.CreerGroupeDao;
import com.group.steg.groupe.Dao.GroupeResponse;
import com.group.steg.membre.Membre;
import com.group.steg.membre.MembreRepository;
import com.group.steg.stagiere.Stagiere;
import com.group.steg.stagiere.StagiereRepository;
import com.group.steg.stagiere.dao.EffacerStagiereDao;
import com.group.steg.taches.Tache;

@Service
public class GroupeService {
    
    private final GroupeRepository groupeRepository;
    private final StagiereRepository stagiereRepository;
    private final MembreRepository membreRepository;

    @Autowired
    public GroupeService(GroupeRepository groupeRepository, StagiereRepository stagiereRepository, MembreRepository membreRepository) {
        this.groupeRepository = groupeRepository;
        this.stagiereRepository = stagiereRepository;
        this.membreRepository = membreRepository;
    }

    public ArrayList<Groupe>  afficherGroupes() {
        ArrayList<Groupe> groupes = (ArrayList<Groupe>) this.groupeRepository.findAll();
        return groupes;
    }

    public ArrayList<Membre> afficherMembres(int idGroupe) {
        ArrayList<Membre> membres = this.membreRepository.findByIdGroupe(idGroupe);
        return membres;
    }

    public Groupe creerGroupe(CreerGroupeDao groupeData) {
        Groupe nouveauGroupe = new Groupe(groupeData.nom, groupeData.membres.size());
        this.groupeRepository.save(nouveauGroupe);
        groupeData.membres.forEach(membre -> {
            Membre nouveauMembre = new Membre(membre.getIdStagiere(), membre.getNom(), membre.getPrenom(), nouveauGroupe.getIdGroupe(), membre.getNumTel());
            this.membreRepository.save(nouveauMembre);
        });
        return nouveauGroupe;
    }

    public GroupeResponse modifierGroupe(int idGroupe, String nom) {
        this.groupeRepository.updateGroupeNom(nom, idGroupe);
        return new GroupeResponse("groupe a ete modifie");
    }

    public GroupeResponse ajouterStagiereAuGroupe(AjouterStagiereDao stagiere) {
        Membre membre = new Membre(stagiere.idStagiere, stagiere.nom, stagiere.prenom, stagiere.idGroupe, stagiere.numTel);
        this.membreRepository.save(membre);
        return new GroupeResponse("membre ajoute au groupe");
    }

    public GroupeResponse effacerStagiereDuGroupe(int idStagiere) {
        this.membreRepository.deleteById(idStagiere);
        return new GroupeResponse("membre efface de groupe");
    }

    public GroupeResponse effacerGroupe(int id) {
        this.groupeRepository.deleteById(id);
        this.membreRepository.deleteByIdGroupe(id);
        return new GroupeResponse("Groupe a ete supprimé");
    }

}