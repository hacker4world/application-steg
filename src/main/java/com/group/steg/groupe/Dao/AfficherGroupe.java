package com.group.steg.groupe.Dao;

import java.util.ArrayList;

import com.group.steg.groupe.Groupe;
import com.group.steg.membre.Membre;

public class AfficherGroupe {
    public String nom;
    public String num_membres;
    public int idGroupe;
    public ArrayList<Membre> membres;


    public AfficherGroupe(String nom, String num_membres, int idGroupe, ArrayList<Membre> membres) {
        this.nom = nom;
        this.num_membres = num_membres;
        this.idGroupe = idGroupe;
        this.membres = membres;
    }

}
