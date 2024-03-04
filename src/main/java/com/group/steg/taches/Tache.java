package com.group.steg.taches;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTache;
    private int idGroupe;
    private String description;
    private String dateLimite;

    public Tache() {
    }


    public Tache(int idGroupe, String description, String dateLimite) {
        this.idGroupe = idGroupe;
        this.description = description;
        this.dateLimite = dateLimite;
    }


    public int getIdTache() {
        return this.idTache;
    }

    public void setIdTache(int idTache) {
        this.idTache = idTache;
    }

    public int getIdGroupe() {
        return this.idGroupe;
    }

    public void setIdGroupe(int idGroupe) {
        this.idGroupe = idGroupe;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateLimite() {
        return this.dateLimite;
    }

    public void setDateLimite(String dateLimite) {
        this.dateLimite = dateLimite;
    }
    
}
