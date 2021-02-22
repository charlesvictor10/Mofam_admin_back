package com.mofam.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Collection;

@Entity
public class Ville implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
     * Liste des attributs de la classe Ville
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ville;
    @Column(name = "nom_ville", length = 35, nullable = false, unique = true)
    private String nom;
    /**
     * Relation entre Ville et Departement
     */
    @JoinColumn(name = "id_departement")
    @ManyToOne
    private Departement departement;
    /**
     * Relation entre Ville et Acheteur
     */
    @JsonIgnore
    @OneToMany(mappedBy="ville")
    private Collection<Acheteur> acheteurs;
    /**
     * Relation entre Ville et Produit
     */
    @JsonIgnore
    @OneToMany(mappedBy="ville")
    private Collection<Produits> produits;

    /**
     * Constructeur par défaut
     */
    public Ville() {
    }

    /**
     * Constructeur avec paramètres
     */
    public Ville(String nom){
        this.nom = nom;
    }
    
    public Ville(String nom, Departement departement) {
		super();
		this.nom = nom;
		this.departement = departement;
	}

	/**
     * Génération des getter et setter
     */
    public Long getId_ville() {
        return id_ville;
    }

    public void setId_ville(Long id_ville) {
        this.id_ville = id_ville;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

	public Collection<Acheteur> getAcheteurs() {
		return acheteurs;
	}

	public void setAcheteurs(Collection<Acheteur> acheteurs) {
		this.acheteurs = acheteurs;
	}

	public Collection<Produits> getProduits() {
		return produits;
	}

	public void setProduits(Collection<Produits> produits) {
		this.produits = produits;
	}
}
