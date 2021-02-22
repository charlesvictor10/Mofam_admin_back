package com.mofam.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Photos implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
     * Liste des attributs de la classe Photo
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_photo;
    private String nom_photo;
    private String type;
    @Lob
    private byte[] data;
    /**
     * Relation entre photos et produits 
     */
    @OneToOne
    @JoinColumn(name="produit_id")
    private Produits produits;

    /**
     * Constructeur par défaut
     */
    public Photos() {
    }

    /**
     * Constructeur avec paramètres
     */
    public Photos(String nom_photo, String type, byte[] data, Produits produits) {
		super();
		this.nom_photo = nom_photo;
		this.type = type;
		this.data = data;
		this.produits = produits;
	}
        
	public Photos(String nom_photo, String type, byte[] data) {
		super();
		this.nom_photo = nom_photo;
		this.type = type;
		this.data = data;
	}

	/**
     * Génération des getter et setter
     */
    public Long getId_photo() {
        return id_photo;
    }

	public void setId_photo(Long id_photo) {
        this.id_photo = id_photo;
    }

    public String getNom_photo() {
        return nom_photo;
    }

    public void setNom_photo(String nom_photo) {
        this.nom_photo = nom_photo;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Produits getProduits() {
		return produits;
	}

	public void setProduits(Produits produits) {
		this.produits = produits;
	}
}
