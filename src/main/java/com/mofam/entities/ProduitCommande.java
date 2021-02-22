package com.mofam.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class ProduitCommande implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
     * Liste des attributs de la classe Produit Commande
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_prod_com;
	@ManyToOne
	@JoinColumn(name = "code")
	private Commande commande;
	@ManyToOne
	@JoinColumn(name = "id_produit")
	private Produits produits;
    private Integer quantite;
   
    /**
     * Constructeur par défaut
     */
    public ProduitCommande() {
		super();
	}
    
    /**
     * Constructeur avec paramètres
     */
	public ProduitCommande(Commande commande, Produits produits, Integer quantite) {
		super();
		this.commande = commande;
		this.produits = produits;
		this.quantite = quantite;
	}

	/**
     * Génération des getters et setters
     */
	public Long getId_prod_com() {
		return id_prod_com;
	}

	public void setId_prod_com(Long id_prod_com) {
		this.id_prod_com = id_prod_com;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Produits getProduits() {
		return produits;
	}

	public void setProduits(Produits produits) {
		this.produits = produits;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}	
}
