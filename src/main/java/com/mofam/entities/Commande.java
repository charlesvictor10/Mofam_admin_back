package com.mofam.entities;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
     * Liste des attributs de la classe Commande
     */
    @Id
    private String code;
    @Temporal(TemporalType.DATE)
    private Date date_commande;
    @Column(name = "montant_total")
    private double montant;
    private String etat;
    /**
     * Relation entre commande et acheteur
     */
    @ManyToOne
    @JoinColumn(name="id_acheteur")
    private Acheteur acheteur;
         
    /**
     * Constructeur par défaut
     */
    public Commande() {
    }

    /**
     * Constructeur avec paramètres
     */
    public Commande(String code,Date date_commande, double montant, String etat) {
        this.code = code;
        this.date_commande = date_commande;
        this.montant = montant;
        this.etat = etat;
    }

    /**
     * Génération des getter et setter
     */    	
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

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Acheteur getAcheteur() {
        return acheteur;
    }

    public void setAcheteur(Acheteur acheteur) {
        this.acheteur = acheteur;
    }
}
