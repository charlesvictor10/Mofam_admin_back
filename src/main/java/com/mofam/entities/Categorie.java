package com.mofam.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Collection;

@Entity
public class Categorie implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
     * Liste des attributs de la classe categorie
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cat;
    @Column(name = "libelle_cat", length = 250, nullable = false, unique = true)
    private String libelle;
    /**
     * Relation entre categorie et sous categorie
     */
    @JsonIgnore
    @OneToMany(mappedBy="categorie")
    private Collection<SousCategorie> sousCategories;

    /**
     * Constructeur par défaut
     */
    public Categorie() {
    }

    /**
     * Constructeur avec paramètres
     */
    public Categorie(String libelle){
        this.libelle = libelle;
    }

    /**
     * Génération des getter et setter
     */
    public Long getId_cat() {
        return id_cat;
    }

    public void setId_cat(Long id_cat) {
        this.id_cat = id_cat;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Collection<SousCategorie> getSousCategories() {
        return sousCategories;
    }

    public void setSousCategories(Collection<SousCategorie> sousCategories) {
        this.sousCategories = sousCategories;
    }

	@Override
	public String toString() {
		return "Categorie [id_cat=" + id_cat + ", libelle=" + libelle + "]";
	}
}
