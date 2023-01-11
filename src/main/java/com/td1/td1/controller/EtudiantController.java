package com.td1.td1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.td1.td1.entity.Etudiant;
import com.td1.td1.service.EtudiantService;

import io.swagger.v3.oas.annotations.tags.Tag;
@Tag(name = "Etudiant")
@RestController
@RequestMapping("/api/v1/etudiants")
public class EtudiantController {
	@Autowired
	EtudiantService etudiantService;

	@GetMapping()
	public List<Etudiant> getAllEtudiants() {
		return etudiantService.retrieveAllEtudiants();
	}

	@PostMapping()
	public ResponseEntity<Etudiant> createEtudiant(@RequestBody Etudiant etudiant) {
		 Etudiant createdEtudiant = etudiantService.addEtudiant(etudiant);
		 return ResponseEntity.status(HttpStatus.CREATED).body(createdEtudiant);
	}

	@GetMapping("/{id}")
	public Etudiant getEtudiantById(@PathVariable(value = "id") Long idEtudiant) {
		return etudiantService.retrieveEtudiant(idEtudiant);
	}

	@PutMapping("/{id}")
	public Etudiant updateEtudiant(@PathVariable(value = "id") Long idEtudiant, @RequestBody Etudiant etudiantDetails) {
		Etudiant updatedEtudiant = etudiantService.updateEtudiant(idEtudiant, etudiantDetails);
		return updatedEtudiant;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteEtudiant(@PathVariable(value = "id") Long idEtudiant) {
		etudiantService.removeEtudiant(idEtudiant);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}