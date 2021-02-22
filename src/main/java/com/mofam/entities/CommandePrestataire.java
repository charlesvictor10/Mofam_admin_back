package com.mofam.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CommandePrestataire implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
     * Liste des attributs de la classe Commande prestataire
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    @Temporal(TemporalType.DATE)
    private Date date_commande;
    private String etat;
    private Integer quantite;
    /**
     * Relation entre commande et produit
     */
    @ManyToOne
	@JoinColumn(name = "id_produit")
	private Produits produits;
    
    /**
     * Relation entre commande et acheteur
     */
    @ManyToOne
    @JoinColumn(name="id_acheteur")
    private Acheteur acheteur;
    /**
     * Relation entre commande et prestataire
     */
    @ManyToOne
    @JoinColumn(name="prestataire_id")
    private Prestataire prestataire;
    
    /**
     * Constructeur par défaut
     */
	public CommandePrestataire() {
		super();
	}

	/**
     * Constructeur avec paramètres
     */
	public CommandePrestataire(String code, Date date_commande, String etat, Integer quantite, Produits produits,
			Acheteur acheteur, Prestataire prestataire) {
		super();
		this.code = code;
		this.date_commande = date_commande;
		this.etat = etat;
		this.quantite = quantite;
		this.produits = produits;
		this.acheteur = acheteur;
		this.prestataire = prestataire;
	}

	/**
     * Génération des getter et setter
     */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDate_commande() {
		return date_commande;
	}

	public void setDate_commande(Date date_commande) {
		this.date_commande = date_commande;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Produits getProduits() {
		return produits;
	}

	public void setProduits(Produits produits) {
		this.produits = produits;
	}

	public Acheteur getAcheteur() {
		return acheteur;
	}

	public void setAcheteur(Acheteur acheteur) {
		this.acheteur = acheteur;
	}

	public Prestataire getPrestataire() {
		return prestataire;
	}

	public void setPrestataire(Prestataire prestataire) {
		this.prestataire = prestataire;
	}	
}
