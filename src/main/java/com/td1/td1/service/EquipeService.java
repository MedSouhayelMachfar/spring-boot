package com.td1.td1.service;

import java.util.List;

import com.td1.td1.entity.Equipe;

public interface EquipeService {
    List<Equipe> retrieveAllEquipes();

    Equipe addEquipe(Equipe e); // ajouter l’équipe avec son détail

    Equipe updateEquipe (Long idEquipe, Equipe e);

    Equipe retrieveEquipe (Long idEquipe);
}
