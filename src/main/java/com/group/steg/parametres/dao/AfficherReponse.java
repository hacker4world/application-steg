package com.group.steg.parametres.dao;

import com.group.steg.parametres.Parametre;

public class AfficherReponse {
    public String message;
    public Parametre parametre;

    public AfficherReponse(String message) {
        this.message = message;
    }

    public AfficherReponse(String message, Parametre parametre) {
        this.message = message;
        this.parametre = parametre;
    }

}