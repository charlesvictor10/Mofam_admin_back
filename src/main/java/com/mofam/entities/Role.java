package com.mofam.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
     * Liste des attributs de la classe role
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nom_role")
    private String nom;
    private String description;

    /**
     * Constructeur par défaut
     */
    public Role() {
    }

    /**
     * Constructeur avec paramètres
     */
    public Role(String nom, String description){
        this.nom = nom;
        this.description = description;
    }

    public Role(String nom){
        this.nom = nom;
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
    
    public String getNom() {
        return nom;
    }

	public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
