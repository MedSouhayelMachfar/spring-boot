package com.td1.td1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.td1.td1.entity.Equipe;
import com.td1.td1.service.EquipeService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Equipe")
@RestController
@RequestMapping("/api/v1/equipes")
public class EquipeController {
    @Autowired
    EquipeService equipeService;

    @GetMapping()
    public List<Equipe> getAllEquipes() {
        return equipeService.retrieveAllEquipes();
    }

    @PostMapping()
    public Equipe createEquipe(@RequestBody Equipe equipe) {
        return equipeService.addEquipe(equipe);
    }

    @GetMapping("/{id}")
	public Equipe getEquipeById(@PathVariable(value = "id") Long idEquipe) {
		return equipeService.retrieveEquipe(idEquipe);
	}

	@PutMapping("/{id}")
	public Equipe updateEquipe(@PathVariable(value = "id") Long idEquipe, @RequestBody Equipe equipeDetails) {
		Equipe updatedEquipe = equipeService.updateEquipe(idEquipe, equipeDetails);
		return updatedEquipe;
	}
}
