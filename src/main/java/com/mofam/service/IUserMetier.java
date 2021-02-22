package com.mofam.service;

import org.springframework.http.ResponseEntity;

import com.mofam.entities.Departement;
import com.mofam.entities.Region;
import com.mofam.entities.Utilisateur;
import com.mofam.entities.Ville;

import java.util.List;

public interface IUserMetier {
	/**
     * Gestion des utilisateurs
     */
	public List<Utilisateur> listeUtilisateur();
	public void supprimerUtilisateur(Long id);
	
    /**
     * Gestion des regions
     */
    public Region ajouterRegion(Region region);
    public List<Region> listeRegions();
    public ResponseEntity<Region> editerRegion(Long id);
    public ResponseEntity<Region> modifierRegion(Long id, Region reg);
    public void supprimerRegion(Long id);

    /**
     * Gestion des départements
     */
    public Departement ajouterDepartement(Departement departement);
    public List<Departement> listeDepartement();
    public List<Departement> listeParRegion(Region region);
    public ResponseEntity<Departement> editerDepartement(Long id);
    public ResponseEntity<Departement> modifierDepartement(Long id, Departement dep);
    public void supprimerDepartement(Long id);

    /**
     * Gestion des villes
     */
    public Ville ajouterVille(Ville ville);
    public List<Ville> listeVilles();
    public List<Ville> listeParDepartement(Departement departement);
    public ResponseEntity<Ville> editerVille(Long id);
    public ResponseEntity<Ville> modifierVille(Long id, Ville vil);
    public void supprimerVille(Long id);
}
