package com.mofam.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
public class Prestataire implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
     * Liste des attributs de la classe prestataire
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String matricule;
	private String prenom;
	private String nom;
	private String numero_cni;
	private Date dateRecrutement;
    private Date datePriseFonction;
    private String tel;
    @Email
    private String email;
    
	/**
     * Constructeur par défaut
     */
	public Prestataire() {
	}

	/**
     * Constructeur avec paramètres
     */
	public Prestataire(String matricule, String prenom, String nom, String numero_cni, Date dateRecrutement,
			Date datePriseFonction, String tel, String email) {
		super();
		this.matricule = matricule;
		this.prenom = prenom;
		this.nom = nom;
		this.numero_cni = numero_cni;
		this.dateRecrutement = dateRecrutement;
		this.datePriseFonction = datePriseFonction;
		this.tel = tel;
		this.email = email;
	}

	public Prestataire(String matricule, String prenom, String nom, String numero_cni, String tel, String email) {
		super();
		this.matricule = matricule;
		this.prenom = prenom;
		this.nom = nom;
		this.numero_cni = numero_cni;
		this.tel = tel;
		this.email = email;
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

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNumero_cni() {
		return numero_cni;
	}

	public void setNumero_cni(String numero_cni) {
		this.numero_cni = numero_cni;
	}

	public Date getDateRecrutement() {
		return dateRecrutement;
	}

	public void setDateRecrutement(Date dateRecrutement) {
		this.dateRecrutement = dateRecrutement;
	}

	public Date getDatePriseFonction() {
		return datePriseFonction;
	}

	public void setDatePriseFonction(Date datePriseFonction) {
		this.datePriseFonction = datePriseFonction;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
