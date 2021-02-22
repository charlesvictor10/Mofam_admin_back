package com.mofam.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
public class Acheteur implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
     * Liste des attributs de la classe acheteur
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_acheteur;
    @Email
    private String email;
    private String prenom;
    private String nom;
    private String adresse;
    private String tel;
    private String password;
    private boolean actived;
    @Column(nullable = true)
    private String token;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateChangementMdp;
    
    /**
     * Relation entre acheteur et Ville
     */
    @ManyToOne
    @JoinColumn(name="ville_id")
    private Ville ville;
    /**
     * Relation entre acheteur et commande
     */
    @JsonIgnore
    @OneToMany(mappedBy="acheteur")
    private Collection<Commande> commandes;
    @Transient
    private String newPassword;
    @Transient
    private String confirmPassword;

    /**
     * Constructeur par défaut
     */
    public Acheteur() {
    }

    /**
     * Constructeur avec paramètres
     */
    public Acheteur(String email, String password, String prenom, String nom, String adresse, String tel, Ville ville) {
        this.email = email;
        this.password = password;
        this.prenom = prenom;
        this.nom = nom;
        this.adresse = adresse;
        this.tel = tel;
        this.ville = ville;
    }

    public Acheteur(String email, String prenom, String nom) {
        this.email = email;
        this.prenom = prenom;
        this.nom = nom;
    }

    public Acheteur(String email, String password){
        this.email = email;
        this.password = password;
    }

    /**
     * Génération des getter et setter
     */
	public Long getId_acheteur() {
		return id_acheteur;
	}

	public void setId_acheteur(Long id_acheteur) {
		this.id_acheteur = id_acheteur;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getDateChangementMdp() {
		return dateChangementMdp;
	}

	public void setDateChangementMdp(Date dateChangementMdp) {
		this.dateChangementMdp = dateChangementMdp;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public Collection<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Collection<Commande> commandes) {
		this.commandes = commandes;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}    
}
