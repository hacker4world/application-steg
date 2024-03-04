package com.group.steg.stagiere.dao;

import java.util.ArrayList;

import org.hibernate.mapping.List;
import com.group.steg.stagiere.DemandeStage;


public class AfficherdemandeReponse {
    public String message;
    public ArrayList<DemandeStage> demandes;

    public AfficherdemandeReponse(String message) {
        this.message = message;
    }


    public AfficherdemandeReponse(String message, ArrayList<DemandeStage> demandes) {
        this.message = message;
        this.demandes = demandes;
    }


}
