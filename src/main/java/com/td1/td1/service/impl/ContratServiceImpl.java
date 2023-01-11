package com.td1.td1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.td1.td1.entity.Contrat;
import com.td1.td1.exception.ResourceNotFoundException;
import com.td1.td1.repository.ContratRepository;
import com.td1.td1.service.ContratService;

@Service
public class ContratServiceImpl implements ContratService {
    @Autowired
    ContratRepository contratRepository;

    @Override
    public List<Contrat> retrieveAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat updateContrat(Long idContrat, Contrat ce) {
        Contrat contrat = contratRepository.findById(idContrat)
				.orElseThrow(() -> new ResourceNotFoundException("Contrat", "idContrat", idContrat));

		contrat.setArchive(ce.getArchive());
		contrat.setDateDebutContrat(ce.getDateDebutContrat());
		contrat.setDateFinContrat(ce.getDateFinContrat());
		contrat.setMontantContrat(ce.getMontantContrat());
		contrat.setSpecialite(ce.getSpecialite());

		Contrat updatedContrat = contratRepository.save(contrat);
		return updatedContrat;
    }

    @Override
    public Contrat addContrat(Contrat ce) {
        return contratRepository.save(ce);
    }

    @Override
    public Contrat retrieveContrat(Long idContrat) {
        return contratRepository.findById(idContrat)
                .orElseThrow(() -> new ResourceNotFoundException("Contrat", "idContrat", idContrat));
    }

    @Override
    public void removeContrat(Long idContrat) {
        Contrat contrat = contratRepository.findById(idContrat)
                .orElseThrow(() -> new ResourceNotFoundException("Contrat", "idContrat", idContrat));
        contratRepository.delete(contrat);
    }

}
