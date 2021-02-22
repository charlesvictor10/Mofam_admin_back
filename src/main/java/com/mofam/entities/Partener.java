package com.mofam.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Partener implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
     * Liste des attributs de la classe partener
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_part;
    @Column(name = "nom_partenaire", nullable = false, unique = true)
    private String nom;
    @Column(name = "site_web", unique = true)
    private String site;
       
    /**
     * Constructeur par défaut
     */
    public Partener() {
    }

    /**
     * Constructeur avec paramètres
     */
    public Partener(String nom, String site){
        this.nom = nom;
        this.site = site;
    }

    /**
     * Génération des getter et setter
     */
    public Long getId_part() {
        return id_part;
    }

    public void setId_part(Long id_part) {
        this.id_part = id_part;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
