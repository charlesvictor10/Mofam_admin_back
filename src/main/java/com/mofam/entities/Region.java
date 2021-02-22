package com.mofam.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Collection;

@Entity
public class Region implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
     * Liste des attributs de la classe Region
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_region;
    @Column(name = "nom_region", length = 25, nullable = false, unique = true)
    private String nom;
    /**
     * Relation entre Region et Departement
     */
    @JsonIgnore
    @OneToMany(mappedBy="region")
    private Collection<Departement> departements;

    /**
     * Constructeur par défaut
     */
    public Region() {
    }

    /**
     * Constructeur avec paramètres
     */
    public Region(String nom){
        this.nom = nom;
    }

    /**
     * Génération des getter et setter
     */
    public Long getId_region() {
        return id_region;
    }

    public void setId_region(Long id_region) {
        this.id_region = id_region;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Collection<Departement> getDepartements() {
        return departements;
    }

    public void setDepartements(Collection<Departement> departements) {
        this.departements = departements;
    }
}
