package com.mofam.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mofam.entities.Acheteur;
import com.mofam.entities.Commande;
import com.mofam.entities.CommandePrestataire;
import com.mofam.entities.Partener;
import com.mofam.entities.Prestataire;
import com.mofam.entities.ProduitCommande;

public interface ICommandeMetier {    
	/**
     * Gestion des commandes clients
     */
	public List<Commande> listeCommandeClients();
	public List<ProduitCommande> listeProduitsCommande();
	public ResponseEntity<Commande> editerCommande(String code);
	public ResponseEntity<Commande> modifierCommande(String code, Commande com);
	public void supprimerCommande(String code);
	public void supprimerProduitCommande(Long id);
	
	/**
     * Gestion des commandes créées par les prestataires
     */
	public CommandePrestataire ajouterCommande(CommandePrestataire commandePrestataire);
	public List<CommandePrestataire> listeCommandePrestataires();
	public List<CommandePrestataire> listeCommandeParPrestataire(Prestataire prestataire);
	
	/**
     * Gestion des clients
     */
    public Acheteur ajouterAcheteur(Acheteur acheteur);
    public List<Acheteur> listeAcheteurs();
    public void supprimerAcheteur(Long id);
    
    public Prestataire ajouterPrestataire(Prestataire prestataire);
    public List<Prestataire> listePrestataires();
    public void supprimerPrestataire(Long id);

    /**
     * Gestion des partenaires
     */
    public Partener ajouterPartenaire(Partener partener);
    public List<Partener> listePartener();
    public void supprimerPartener(Long id);
}
