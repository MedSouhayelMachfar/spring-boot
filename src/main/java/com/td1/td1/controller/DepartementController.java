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

import com.td1.td1.entity.Departement;
import com.td1.td1.service.DepartementService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Departement")
@RestController
@RequestMapping("/api/v1/departements")
public class DepartementController {
    @Autowired
    DepartementService departementService;

    @GetMapping()
    public List<Departement> getAllDepartements() {
        return departementService.retrieveAllDepartements();
    }

    @PostMapping()
    public Departement createDepartement(@RequestBody Departement departement) {
        return departementService.addDepartement(departement);
    }

    @GetMapping("/{id}")
	public Departement getDepartementById(@PathVariable(value = "id") Long idDepartement) {
		return departementService.retrieveDepartement(idDepartement);
	}

	@PutMapping("/{id}")
	public Departement updateDepartement(@PathVariable(value = "id") Long idDepartement, @RequestBody Departement DepartementDetails) {
		Departement updatedDepartement = departementService.updateDepartement(idDepartement, DepartementDetails);
		return updatedDepartement;
	}
}
