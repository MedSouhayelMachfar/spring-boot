package com.td1.td1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.td1.td1.entity.Equipe;

@Repository
public interface EquipeRepository  extends JpaRepository<Equipe, Long>{
    
}
