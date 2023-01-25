package com.td1.td1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.td1.td1.entity.Etudiant;
import com.td1.td1.entity.Option;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    @Query("SELECT e FROM Etudiant e WHERE e.op = ?1")
    List<Etudiant> findByOpLike(Option op);
}
