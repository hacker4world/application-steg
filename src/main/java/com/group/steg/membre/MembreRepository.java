package com.group.steg.membre;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PreDestroy;
import jakarta.transaction.Transactional;

@Repository
public interface MembreRepository extends JpaRepository<Membre, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Membre m WHERE m.idStagiere = :idStagiaire AND m.idGroupe = :idGroupe")
    void deleteByIdStagiereAndIdGroupe(@Param("idStagiaire") int idStagiaire, @Param("idGroupe") int idGroupe);

    @Transactional
    @Modifying
    @Query("DELETE FROM Membre m WHERE m.idGroupe = :idGroupe")
    void deleteByIdGroupe(@Param("idGroupe") int idGroupe);

    ArrayList<Membre> findByIdGroupe(int idGroupe);

}
