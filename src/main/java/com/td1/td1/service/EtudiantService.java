package com.td1.td1.service;

import java.util.List;

import com.td1.td1.entity.Etudiant;
import com.td1.td1.entity.Option;

public interface EtudiantService {
    List<Etudiant> retrieveAllEtudiants();

    Etudiant addEtudiant(Etudiant e);

    Etudiant updateEtudiant(Long idEtudiant, Etudiant e);

    Etudiant retrieveEtudiant(Long idEtudiant);

    void removeEtudiant(Long idEtudiant);

    List<Etudiant> findByOp(Option op);
}
