package com.td1.td1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.td1.td1.entity.Departement;
import com.td1.td1.exception.ResourceNotFoundException;
import com.td1.td1.repository.DepartementRepository;
import com.td1.td1.service.DepartementService;

@Service
public class DepartementServiceImpl implements DepartementService{
    @Autowired
    DepartementRepository departementRepository;

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
    
}
