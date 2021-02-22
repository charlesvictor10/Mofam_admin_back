package com.mofam.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Produits implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
     * Liste des attributs de la classe Produit
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_produit;
    @Column(length = 250, nullable = false, unique = true)
    private String designation;
    private String description;
    private double prix;
    private int quantite;
    private int etat;
    private Date date_commande;
    private String proprietaire;
    /**
     * Relation entre produits et Ville
     */
    @ManyToOne
    @JoinColumn(name="ville_id")
    private Ville ville;
    /**
     * Relation entre produits et sous categorie
     */
    @ManyToOne
    @JoinColumn(name="sous_categorie_id")
    private SousCategorie sousCategorie;
   
    /**
     * Constructeur par défaut
     */
    public Produits() {
    }

    /**
     * Constructeur avec paramètres
     */
    public Produits(String designation, String description, double prix, int quantite, int etat, Date date_commande, SousCategorie sousCategorie) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.etat = etat;
		this.date_commande = date_commande;
		this.sousCategorie = sousCategorie;
	}
    
    public Produits(Long id_produit, String designation, String description, double prix, int quantite, int etat,
			Date date_commande, String proprietaire) {
		super();
		this.id_produit = id_produit;
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.etat = etat;
		this.date_commande = date_commande;
		this.proprietaire = proprietaire;
	}
	    
    public Produits(String designation, String description, double prix, int quantite, int etat, Date date_commande,
			String proprietaire, Ville ville, SousCategorie sousCategorie) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.etat = etat;
		this.date_commande = date_commande;
		this.proprietaire = proprietaire;
		this.sousCategorie = sousCategorie;
	}

	/**
     * Génération des getter et setter
     */
	public Long getId_produit() {
		return id_produit;
	}

	public void setId_produit(Long id_produit) {
		this.id_produit = id_produit;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public Date getDate_commande() {
		return date_commande;
	}

	public void setDate_commande(Date date_commande) {
		this.date_commande = date_commande;
	}
		
	public String getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public SousCategorie getSousCategorie() {
		return sousCategorie;
	}

	public void setSousCategorie(SousCategorie sousCategorie) {
		this.sousCategorie = sousCategorie;
	}
}
