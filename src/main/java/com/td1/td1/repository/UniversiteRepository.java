package com.td1.td1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.td1.td1.entity.Universite;

@Repository
public interface UniversiteRepository  extends JpaRepository<Universite, Long>{
    
}
