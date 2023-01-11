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

import com.td1.td1.entity.Universite;
import com.td1.td1.service.UniversiteService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Universite")
@RestController
@RequestMapping("/api/v1/universite")
public class UniversiteController {
    @Autowired
    UniversiteService universiteService;

    @GetMapping()
    public List<Universite> getAllUniversites() {
        return universiteService.retrieveAllUniversites();
    }

    @PostMapping()
    public Universite createUniversite(@RequestBody Universite Universite) {
        return universiteService.addUniversite(Universite);
    }

    @GetMapping("/{id}")
	public Universite getUniversiteById(@PathVariable(value = "id") Long idUniversite) {
		return universiteService.retrieveUniversite(idUniversite);
	}

	@PutMapping("/{id}")
	public Universite updateUniversite(@PathVariable(value = "id") Long idUniversite, @RequestBody Universite universiteDetails) {
		Universite updatedUniversite = universiteService.updateUniversite(idUniversite, universiteDetails);
		return updatedUniversite;
	}
}
