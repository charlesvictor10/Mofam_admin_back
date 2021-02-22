package com.mofam.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class SousCategorie implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
     * Liste des attributs de la classe Sous categorie
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_sous_cat;
    @Column(name = "libelle_sous_cat", length = 250, nullable = false, unique = true)
    private String libelle;
    /**
     * Relation entre sous categorie et categorie
     */
    @ManyToOne
    @JoinColumn(name="categorie_id")
    private Categorie categorie;
    /**
     * Relation entre sous categorie et produits
     */
    @JsonIgnore
    @OneToMany(mappedBy="sousCategorie")
    private Collection<Produits> produits;

    /**
     * Constructeur par défaut
     */
    public SousCategorie() {
    }

    /**
     * Constructeur avec paramètres
     */
    public SousCategorie(String libelle){
        this.libelle = libelle;
    }

    public SousCategorie(String libelle, Categorie categorie) {
		super();
		this.libelle = libelle;
		this.categorie = categorie;
	}

	/**
     * Génération des getter et setter
     */
    public Long getId_sous_cat() {
        return id_sous_cat;
    }

    public void setId_sous_cat(Long id_sous_cat) {
        this.id_sous_cat = id_sous_cat;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Collection<Produits> getProduits() {
        return produits;
    }

    public void setProduits(Collection<Produits> produits) {
        this.produits = produits;
    }
}
