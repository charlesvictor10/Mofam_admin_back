package com.mofam.entities;

public enum RoleEnum {
    ADMIN(new Long(1), "ADMIN"),
	PRESTATAIRE(new Long(2), "PRESTATAIRE");

    private Long id;
    private String nom;

    RoleEnum(Long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
}
