package com.group.steg.stagiere;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StagiereRepository extends JpaRepository<Stagiere, Integer> {
    
}