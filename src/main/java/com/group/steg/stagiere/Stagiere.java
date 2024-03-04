package com.group.steg.stagiere;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Stagiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStagiere;
    private String nom;
    private String prenom;
    private String email;
    private String pieceIdentite;
    private String codeIdentite;
    private String niveauEtude;
    private String typeStage;
    private String numTel;
    private String institut;
    private Integer jours;
    private String dateDebut;
    private String dateFin;
    private String gouvernorat;
    private String diplome;
    private String nationalite;
    private String anne;
    private String imageCinAvant;
    private String imageCinAriere;
    private String specialite;

    public Stagiere() {
    }


    public Stagiere(String nom, String prenom, String email, String pieceIdentite, String codeIdentite, String niveauEtude, String typeStage, String numTel, String institut, Integer jours, String dateDebut, String dateFin, String gouvernorat, String diplome, String nationalite, String anne, String imageCinAvant, String imageCinAriere, String specialite) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.pieceIdentite = pieceIdentite;
        this.codeIdentite = codeIdentite;
        this.niveauEtude = niveauEtude;
        this.typeStage = typeStage;
        this.numTel = numTel;
        this.institut = institut;
        this.jours = jours;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.gouvernorat = gouvernorat;
        this.diplome = diplome;
        this.nationalite = nationalite;
        this.anne = anne;
        this.imageCinAvant = imageCinAvant;
        this.imageCinAriere = imageCinAriere;
        this.specialite = specialite;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPieceIdentite() {
        return this.pieceIdentite;
    }

    public void setPieceIdentite(String pieceIdentite) {
        this.pieceIdentite = pieceIdentite;
    }

    public String getCodeIdentite() {
        return this.codeIdentite;
    }

    public void setCodeIdentite(String codeIdentite) {
        this.codeIdentite = codeIdentite;
    }

    public String getNiveauEtude() {
        return this.niveauEtude;
    }

    public void setNiveauEtude(String niveauEtude) {
        this.niveauEtude = niveauEtude;
    }

    public String getTypeStage() {
        return this.typeStage;
    }

    public void setTypeStage(String typeStage) {
        this.typeStage = typeStage;
    }

    public String getNumTel() {
        return this.numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getInstitut() {
        return this.institut;
    }

    public void setInstitut(String institut) {
        this.institut = institut;
    }

    public Integer getJours() {
        return this.jours;
    }

    public void setJours(Integer jours) {
        this.jours = jours;
    }

    public String getDateDebut() {
        return this.dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return this.dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getGouvernorat() {
        return this.gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public String getDiplome() {
        return this.diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public String getNationalite() {
        return this.nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getAnne() {
        return this.anne;
    }

    public void setAnne(String anne) {
        this.anne = anne;
    }

    public String getImageCinAvant() {
        return this.imageCinAvant;
    }

    public void setImageCinAvant(String imageCinAvant) {
        this.imageCinAvant = imageCinAvant;
    }

    public String getImageCinAriere() {
        return this.imageCinAriere;
    }

    public void setImageCinAriere(String imageCinAriere) {
        this.imageCinAriere = imageCinAriere;
    }

    public String getSpecialite() {
        return this.specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
    
}
