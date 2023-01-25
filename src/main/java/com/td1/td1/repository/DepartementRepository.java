package com.td1.td1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.td1.td1.entity.Departement;

@Repository
public interface DepartementRepository  extends JpaRepository<Departement, Long>{
    @Modifying
    @Query(value = "INSERT into departement_etudiants VALUES(?2, ?1)", nativeQuery = true)
    public void assignEtudiantToDepartement(Long etudiantId, Long departementId) ;
}
