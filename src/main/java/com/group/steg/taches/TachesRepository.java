package com.group.steg.taches;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TachesRepository extends JpaRepository<Tache, Integer> {
    public ArrayList<Tache> findByIdGroupe(int idGroupe);
}
