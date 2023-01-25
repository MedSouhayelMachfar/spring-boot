package com.td1.td1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    public ResponseEntity<Departement> createDepartement(@RequestBody Departement departement) {
        Departement createdDepartement = departementService.addDepartement(departement);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdDepartement);
    }

    @GetMapping("/{id}")
	public Departement getDepartementById(@PathVariable(value = "id") Long idDepartement) {
		return departementService.retrieveDepartement(idDepartement);
	}

	@PutMapping("/{id}")
	public Departement updateDepartement(@PathVariable(value = "id") Long idDepartement, @RequestBody Departement departementDetails) {
		Departement updatedDepartement = departementService.updateDepartement(idDepartement, departementDetails);
		return updatedDepartement;
	}

    @PostMapping(value="/assignEtudiantToDepartement")
    public ResponseEntity<HttpStatus> assignEtudiantToDepartement(@RequestBody  AssignEtudiantToDepartementBody payload) {
        System.out.println(payload);
        departementService.assignEtudiantToDepartement(payload.etudiantId, payload.departementId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping(value = "/assignUniversiteToDepartement")
    public ResponseEntity<HttpStatus> assignUniversiteToDepartement(@RequestBody  AssignUniversiteToDepartementBody payload) {
        System.out.println(payload);
        departementService.assignUniversiteToDepartement(payload.idUniversite, payload.departementId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
// Types
class AssignEtudiantToDepartementBody {
    Long etudiantId;
    Long departementId; 
}

class AssignUniversiteToDepartementBody {
    Long idUniversite;
    Long departementId; 
}
