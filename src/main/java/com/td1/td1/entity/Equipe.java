package com.td1.td1.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Equipe")
@Getter @Setter @NoArgsConstructor
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEquipe")
    private Long idEquipe;
    private String nomEquipe;
    private Niveau niveau;

    @OneToOne
    private DetailEquipe detailEquipe;
    
    @ManyToMany(mappedBy = "equipes", cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants;
}
