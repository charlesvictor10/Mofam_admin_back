package com.mofam.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
     * Liste des attributs de la classe utilisateur
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
    private String email;
    private String prenom;
    private String nom;
    @JsonIgnore
    private String password;
    private boolean actived;
    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;
    private String providerId;
    /**
     * Relation entre utilisateur et role
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="utilisateur_role")
    private Collection<Role> roles = new ArrayList<Role>();
    
    /**
     * Constructeur par défaut
     */
    public Utilisateur() {
    }

    /**
     * Constructeur avec paramètres
     */
    public Utilisateur(String email, String password, String prenom, String nom) {
        this.email = email;
        this.password = password;
        this.prenom = prenom;
        this.nom = nom;
    }

    public Utilisateur(String email, String prenom, String nom) {
        this.email = email;
        this.prenom = prenom;
        this.nom = nom;
    }

    public Utilisateur(String email, String password){
        this.email = email;
        this.password = password;
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

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonSetter
	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

    public AuthProvider getProvider() {
       	return provider;
    }

	public void setProvider(AuthProvider provider) {
       	this.provider = provider;
    }

    public String getProviderId() {
       	return providerId;
    }

    public void setProviderId(String providerId) {
       	this.providerId = providerId;
    }
    
	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
}
