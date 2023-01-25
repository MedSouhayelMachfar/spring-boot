package com.td1.td1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.td1.td1.entity.Equipe;
import com.td1.td1.exception.ResourceNotFoundException;
import com.td1.td1.repository.EquipeRepository;
import com.td1.td1.service.EquipeService;

@Service
public class EquipeServiceImpl implements EquipeService{
    @Autowired
    EquipeRepository equipeRepository;

    @Override
    public List<Equipe> retrieveAllEquipes() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Long idEquipe, Equipe e) {
        Equipe equipe = equipeRepository.findById(idEquipe)
				.orElseThrow(() -> new ResourceNotFoundException("Equipe", "idEquipe", idEquipe));

        equipe.setNomEquipe(e.getNomEquipe());
        equipe.setNiveau(e.getNiveau());

		Equipe updatedEquipe = equipeRepository.save(equipe);
		return updatedEquipe;
    }

    @Override
    public Equipe retrieveEquipe(Long idEquipe) {
        return equipeRepository.findById(idEquipe).orElseThrow(() -> new ResourceNotFoundException("Equipe", "idEquipe", idEquipe));
    }

    @Override
    public void removeEquipe(Long idEquipe) {
        Equipe equipe = equipeRepository.findById(idEquipe).orElseThrow(() -> new ResourceNotFoundException("equipe", "idEquipe", idEquipe));
        equipeRepository.delete(equipe);
    }
    
}
