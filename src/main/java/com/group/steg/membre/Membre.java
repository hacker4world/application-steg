package com.group.steg.membre;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Membre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMembre;
    private int idStagiere;
    private String nom;
    private String prenom;
    private int idGroupe;
    private String numTel;


    public Membre() {
    }


    public Membre(int idStagiere, int idGroupe) {
        this.idStagiere = idStagiere;
        this.idGroupe = idGroupe;
    }

    public Membre(int idStagiere, String nom, String prenom, int idGroupe, String numTel) {
        this.idStagiere = idStagiere;
        this.nom = nom;
        this.prenom = prenom;
        this.idGroupe = idGroupe;
        this.numTel = numTel;
    }


    public int getIdMembre() {
        return this.idMembre;
    }

    public void setIdMembre(int idMembre) {
        this.idMembre = idMembre;
    }

    public int getIdStagiere() {
        return this.idStagiere;
    }

    public void setIdStagiere(int idStagiere) {
        this.idStagiere = idStagiere;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumTel() {
        return this.numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

}
