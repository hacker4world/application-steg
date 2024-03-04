package com.group.steg.groupe;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Groupe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGroupe;
    
    private String nom;
    private int numMembres;

    public Groupe() {
    }

    public Groupe(String nom, int numMembres) {
        this.nom = nom;
        this.numMembres = numMembres;
    }


    public int getIdGroupe() {
        return this.idGroupe;
    }

    public void setIdGroupe(int idGroupe) {
        this.idGroupe = idGroupe;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumMembres() {
        return this.numMembres;
    }

    public void setNumMembres(int numMembres) {
        this.numMembres = numMembres;
    }

    

}
