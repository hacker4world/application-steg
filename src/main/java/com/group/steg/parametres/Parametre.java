package com.group.steg.parametres;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Parametre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idParametre;
    private int stageInitiation;
    private int stagesPerfectionnement;
    private int stagesPfe;

    public Parametre() {

    }

    public Parametre(int stageInitiation, int stagesPerfectionnement, int stagesPfe) {
        this.stageInitiation = stageInitiation;
        this.stagesPerfectionnement = stagesPerfectionnement;
        this.stagesPfe = stagesPfe;
    }



    public int getIdParametre() {
        return this.idParametre;
    }

    public void setIdParametre(int idParametre) {
        this.idParametre = idParametre;
    }

    public int getStageInitiation() {
        return this.stageInitiation;
    }

    public void setStageInitiation(int stageInitiation) {
        this.stageInitiation = stageInitiation;
    }

    public int getStagesPerfectionnement() {
        return this.stagesPerfectionnement;
    }

    public void setStagesPerfectionnement(int stagesPerfectionnement) {
        this.stagesPerfectionnement = stagesPerfectionnement;
    }

    public int getStagesPfe() {
        return this.stagesPfe;
    }

    public void setStagesPfe(int stagesPfe) {
        this.stagesPfe = stagesPfe;
    }



}
