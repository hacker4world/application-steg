package com.group.steg.compte.dao;

public class LoginResponseDao {
    public String message;
    public int idCompte;
    public String nom;
    public String prenom;
    public String email;
    public String role;

    public LoginResponseDao() {
        
    }

    public LoginResponseDao(String message) {
        this.message = message;
    }

    public LoginResponseDao(String message, int idCompte, String nom, String prenom, String email, String role) {
        this.message = message;
        this.idCompte = idCompte;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.role = role;
    }



}