package com.td1.td1.service;

import java.util.List;

import com.td1.td1.entity.Contrat;

public interface ContratService {
    List<Contrat> retrieveAllContrats();

    Contrat updateContrat(Long idContrat, Contrat ce);

    Contrat addContrat(Contrat ce);

    Contrat retrieveContrat(Long idContrat);

    void removeContrat(Long idContrat);
}
