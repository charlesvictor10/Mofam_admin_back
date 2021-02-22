package com.mofam.service;

import com.mofam.entities.Categorie;
import com.mofam.entities.Logos;
import com.mofam.entities.Photos;
import com.mofam.entities.Produits;
import com.mofam.entities.SousCategorie;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IProduitMetier {
    /**
     * Gestion des catégories
     */
    public Categorie ajouterCategorie(Categorie cat);
    public List<Categorie> listeCategorie();
    public ResponseEntity<Categorie> editerCategorie(Long id);
    public ResponseEntity<Categorie> modifierCategorie(Long id, Categorie cat);
    public void supprimerCategorie(Long id);

    /**
     * Gestion des sous catégories
     */
    public SousCategorie ajouterSousCategorie(SousCategorie sousCategorie);
    public List<SousCategorie> listeSousCategorie();
    public List<SousCategorie> listeParCategorie(Categorie cat);
    public ResponseEntity<SousCategorie> editerSousCategorie(Long id);
    public ResponseEntity<SousCategorie> modifierSousCategorie(Long id, SousCategorie souscat);
    public void supprimerSousCategorie(Long id);

    /**
     * Gestion des produits
     */
    public Produits ajouterProduit(Produits produits);
    public List<Produits> listeProduits();
    public List<Produits> listeParSousCategorie(SousCategorie sousCat);
    public ResponseEntity<Produits> editerProduit(Long id);
    public ResponseEntity<Produits> modifierProduit(Long id, Produits prod);
    public void supprimerProduit(Long id);
    
    /**
     * Gestion des photos
     */
    public Photos savePhoto(Photos photos);
    public Photos editerPhoto(Long id);
    public void upload(MultipartFile file, Long id) throws Exception;
    public List<Photos> listePhotos();
    public void supprimerPhoto(Long id);
    
    public Logos saveLogo(Logos logos);
    public Logos editerLogo(Long id);
    public void uploadLogo(MultipartFile file, Long id) throws Exception;
    public List<Logos> listeLogos();
    public void supprimerLogo(Long id);
}
