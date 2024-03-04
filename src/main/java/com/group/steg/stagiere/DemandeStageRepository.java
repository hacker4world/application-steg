package com.group.steg.stagiere;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeStageRepository extends JpaRepository<DemandeStage, Integer> {
    public DemandeStage findByCompte(int compte);
}
