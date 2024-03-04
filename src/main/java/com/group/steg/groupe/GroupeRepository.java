package com.group.steg.groupe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Repository
public interface GroupeRepository extends JpaRepository<Groupe, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Groupe g set g.nom = ?1 WHERE g.idGroupe = ?2")
    void updateGroupeNom(String nom, int idGroupe);

    @Query("SELECT g FROM Groupe g WHERE g.idGroupe = :groupName")
    Optional<Groupe> findByIdGroupe(@Param("groupName") int groupName);

}
