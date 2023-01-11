package com.td1.td1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.td1.td1.entity.Etudiant;
import com.td1.td1.exception.ResourceNotFoundException;
import com.td1.td1.repository.EtudiantRepository;
import com.td1.td1.service.EtudiantService;

@Service
public class EtudiantServiceImpl implements EtudiantService {
    @Autowired
    EtudiantRepository etudiantRepository;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return   etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Long idEtudiant, Etudiant e) {
        Etudiant etudiant = etudiantRepository.findById(idEtudiant)
				.orElseThrow(() -> new ResourceNotFoundException("Etudiant", "idEtudiant", idEtudiant));

		etudiant.setNomE(e.getNomE());
		etudiant.setPrenomE(e.getPrenomE());
		etudiant.setOp(e.getOp());

		Etudiant updatedEtudiant = etudiantRepository.save(etudiant);
		return updatedEtudiant;
    }

    @Override
    public Etudiant retrieveEtudiant(Long idEtudiant) {
        return etudiantRepository.findById(idEtudiant)
				.orElseThrow(() -> new ResourceNotFoundException("Etudiant", "idEtudiant", idEtudiant));
    }

    @Override
    public void removeEtudiant(Long idEtudiant) {
        Etudiant etudiant = etudiantRepository.findById(idEtudiant).orElseThrow(() -> new ResourceNotFoundException("Etudiant", "idEtudiant", idEtudiant));
		etudiantRepository.delete(etudiant);
    }
}
