package com.mofam.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class Logos implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
     * Liste des attributs de la classe Logo
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_logo;
    private String nom_logo;
    private String type;
    @Lob
    private byte[] data;
    /**
     * Relation entre logo et partener
     */
    @OneToOne
    @JoinColumn(name="partener_id")
    private Partener partener;

    /**
     * Constructeur par défaut
     */
	public Logos() {
	}

	/**
     * Constructeur avec paramètres
     */
	public Logos(String nom_logo, String type, byte[] data, Partener partener) {
		super();
		this.nom_logo = nom_logo;
		this.type = type;
		this.data = data;
		this.partener = partener;
	}
	
	public Logos(String nom_logo, String type, byte[] data) {
		super();
		this.nom_logo = nom_logo;
		this.type = type;
		this.data = data;
	}

	/**
     * Génération des getter et setter
     */
	public Long getId_logo() {
		return id_logo;
	}

	public void setId_logo(Long id_logo) {
		this.id_logo = id_logo;
	}

	public String getNom_logo() {
		return nom_logo;
	}

	public void setNom_logo(String nom_logo) {
		this.nom_logo = nom_logo;
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

	public Partener getPartener() {
		return partener;
	}

	public void setPartener(Partener partener) {
		this.partener = partener;
	}
}
