package com.mofam.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Collection;

@Entity
public class Departement implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
     * Liste des attributs de la classe Departement
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_departement;
    @Column(name = "nom_departement", length = 35, nullable = false, unique = true)
    private String nom;
    /**
     * Relation entre Departement et Region
     */
    @JoinColumn(name = "id_region")
    @ManyToOne
    private Region region;
    /**
     * Relation entre Departement et Ville
     */
    @JsonIgnore
    @OneToMany(mappedBy="departement")
    private Collection<Ville> villes;

    /**
     * Constructeur par défaut
     */
    public Departement() {
    }

    /**
     * Constructeur avec paramètres
     */
    public Departement(String nom){
        this.nom = nom;
    }
    
    public Departement(String nom, Region region) {
		super();
		this.nom = nom;
		this.region = region;
	}

	/**
     * Génération des getter et setter
     */
    public Long getId_departement() {
        return id_departement;
    }

    public void setId_departement(Long id_departement) {
        this.id_departement = id_departement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Collection<Ville> getVilles() {
        return villes;
    }

    public void setVilles(Collection<Ville> villes) {
        this.villes = villes;
    }
}
