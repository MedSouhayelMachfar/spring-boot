package com.td1.td1.service;

import java.util.List;

import com.td1.td1.entity.Departement;

public interface DepartementService {
    List<Departement> retrieveAllDepartements();

    Departement addDepartement(Departement d);

    Departement updateDepartement(Long idDepart, Departement d);

    Departement retrieveDepartement(Long idDepart);
}
