package com.td1.td1.service;

import java.util.List;

import com.td1.td1.entity.Universite;

public interface UniversiteService {
    List<Universite> retrieveAllUniversites();

    Universite addUniversite (Universite u);

    Universite updateUniversite (Long idUniversite, Universite u);
    
    Universite retrieveUniversite (Long idUniversite);
}
