package com.td1.td1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.td1.td1.entity.Universite;
import com.td1.td1.exception.ResourceNotFoundException;
import com.td1.td1.repository.UniversiteRepository;
import com.td1.td1.service.UniversiteService;

@Service
public class UniversiteServiceImpl implements UniversiteService{
    @Autowired
    UniversiteRepository universiteRepository;

    @Override
    public List<Universite> retrieveAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Long idUniversite, Universite u) {
        Universite universite = universiteRepository.findById(idUniversite)
				.orElseThrow(() -> new ResourceNotFoundException("Universite", "idUniversite", idUniversite));

        universite.setNomUniv(u.getNomUniv());

		Universite updatedUniversite = universiteRepository.save(universite);
		return updatedUniversite;
    }

    @Override
    public Universite retrieveUniversite(Long idUniversite) {
        return universiteRepository.findById(idUniversite).orElseThrow(() -> new ResourceNotFoundException("Univercite", "idUniversite", idUniversite));
    }
    
}
