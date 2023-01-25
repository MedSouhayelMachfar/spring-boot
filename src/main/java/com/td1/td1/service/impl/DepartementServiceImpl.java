package com.td1.td1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.td1.td1.entity.Departement;
import com.td1.td1.entity.Etudiant;
import com.td1.td1.entity.Universite;
import com.td1.td1.exception.ResourceNotFoundException;
import com.td1.td1.repository.DepartementRepository;
import com.td1.td1.repository.EtudiantRepository;
import com.td1.td1.repository.UniversiteRepository;
import com.td1.td1.service.DepartementService;

@Service
public class DepartementServiceImpl implements DepartementService{
    @Autowired
    DepartementRepository departementRepository;
    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    UniversiteRepository universiteRepository;

    @Override
    public List<Departement> retrieveAllDepartements() {
        return departementRepository.findAll();
    }

    @Override
    public Departement addDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement updateDepartement(Long idDepart, Departement d) {
        Departement departement = departementRepository.findById(idDepart)
				.orElseThrow(() -> new ResourceNotFoundException("Departement", "idDepart", idDepart));

		departement.setNomDepart(d.getNomDepart());

		Departement updatedDepartement = departementRepository.save(departement);
		return updatedDepartement;
    }

    @Override
    public Departement retrieveDepartement(Long idDepart) {
        return departementRepository.findById(idDepart).orElseThrow(() -> new ResourceNotFoundException("departement", "idDepart", idDepart));
        
    }

    @Override
    public void assignEtudiantToDepartement(Long etudiantId, Long departementId) {
        Departement departement = this.retrieveDepartement(departementId);
        Etudiant etudiant = etudiantRepository.findById(etudiantId).orElseThrow(() -> new ResourceNotFoundException("Etudiant", "idEtudiant", etudiantId));
        departement.getEtudiants().add(etudiant);
        this.addDepartement(departement);
    }

    @Override
    public void assignUniversiteToDepartement(Long idUniversite, Long idDepartement) {
        Departement departement = this.retrieveDepartement(idDepartement);
        Universite universite = universiteRepository.findById(idUniversite).orElseThrow(() -> new ResourceNotFoundException("Univercite", "idUniversite", idUniversite));
        departement.setUniversite(universite);
    }
    
}
