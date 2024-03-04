package com.group.steg.groupe.Dao;

import java.util.ArrayList;

import com.group.steg.groupe.Groupe;

public class GroupeResponse {
    public String message;
    public Groupe groupe;
    public ArrayList<Groupe> groupes;

    public GroupeResponse(String message) {
        this.message = message;
    }

    public GroupeResponse(String message, Groupe groupe) {
        this.message = message;
        this.groupe = groupe;
    }

    public GroupeResponse(String message, ArrayList<Groupe> groupes) {
        this.message = message;
        this.groupes = groupes;
    }

}
