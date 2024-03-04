package com.group.steg.stagiere.dao;

import java.util.ArrayList;

import org.hibernate.mapping.List;

import com.group.steg.stagiere.Stagiere;

public class StagieresReponseDao {
    public String message;
    public ArrayList<Stagiere> stagieres;

    public StagieresReponseDao(String message, ArrayList<Stagiere> stagieres) {
        this.message = message;
        this.stagieres = stagieres;
    }
}