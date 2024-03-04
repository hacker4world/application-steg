package com.group.steg.taches.dao;

import java.util.ArrayList;

import com.group.steg.taches.Tache;

public class AfficherTachesReponse {
    public String message;
    public ArrayList<Tache> taches;

    public AfficherTachesReponse(String message) {
        this.message = message;
    }

    public AfficherTachesReponse(String message, ArrayList<Tache> taches) {
        this.message = message;
        this.taches = taches;
    }


}
