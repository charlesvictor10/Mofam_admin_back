package com.mofam.controller;

import com.mofam.entities.Categorie;
import com.mofam.entities.Logos;
import com.mofam.entities.Photos;
import com.mofam.entities.Produits;
import com.mofam.entities.SousCategorie;
import com.mofam.service.ProduitMetierImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.validation.Valid;
import java.util.List;

@RestController
public class  ProduitController {
    @Autowired
    private ProduitMetierImpl produitMetier;
    
    @PostConstruct
    public void initialisation() {
    	System.out.println("Création produit controller");
    }

    @PostMapping(value = "/admin/newCategorie")
    public Categorie addCategorie(@Valid @RequestBody Categorie categorie){
        return produitMetier.ajouterCategorie(categorie);
    }

    @GetMapping({"/admin/listeCategorie"})
    public List<Categorie> categoriesList(){
        return produitMetier.listeCategorie();
    }

    @GetMapping(value = "/admin/editerCategorie/{id}")
    public ResponseEntity<Categorie> editeCategorie(@PathVariable(value = "id") Long id){
        return produitMetier.editerCategorie(id);
    }

    @PutMapping(value = "/admin/updateCategorie/{id}")
    public ResponseEntity<Categorie> updateCategorie(@PathVariable(value = "id") Long id, @RequestBody Categorie cat){
        return produitMetier.modifierCategorie(id, cat);
    }

    @DeleteMapping(value="/admin/deleteCategorie/{id}")
    public void deleteCategorie(@PathVariable(value = "id") Long id) {
        produitMetier.supprimerCategorie(id);
    }

    @PostMapping(value = "/admin/newSousCategorie")
    public SousCategorie ajouterSousCategorie(@Valid @RequestBody SousCategorie sousCategorie){
        return produitMetier.ajouterSousCategorie(sousCategorie);
    }

    @GetMapping(value = "/admin/listeSousCategorie")
    public List<SousCategorie> listeSousCategories(){
        return produitMetier.listeSousCategorie();
    }

    @GetMapping(value = "/admin/listeParCategorie")
    public List<SousCategorie> listeParCategories(Categorie categorie){
        return produitMetier.listeParCategorie(categorie);
    }

    @GetMapping(value = "/admin/editerSousCategorie/{id}")
    public ResponseEntity<SousCategorie> editeSousCategorie(@PathVariable(value = "id") Long id){
        return produitMetier.editerSousCategorie(id);
    }

    @PutMapping(value = "/admin/updateSousCategorie/{id}")
    public ResponseEntity<SousCategorie> updateSousCategorie(@PathVariable(value = "id") Long id, @RequestBody SousCategorie sousCat){
        return produitMetier.modifierSousCategorie(id, sousCat);
    }

    @DeleteMapping(value="/admin/deleteSousCategorie/{id}")
    public void deleteSousCategorie(@PathVariable(value = "id") Long id) {
        produitMetier.supprimerSousCategorie(id);
    }

    @PostMapping(value = "/admin/newProduit")
    public Produits ajouterProduit(@Valid @RequestBody Produits produits) {
        return produitMetier.ajouterProduit(produits);
    }

    @GetMapping(value = "/admin/listeProduit")
    public List<Produits> listeProduits(){
        return produitMetier.listeProduits();
    }

    @GetMapping(value = "/admin/listeParSousCategorie")
    public List<Produits> listeParSousCategories(SousCategorie sousCategorie){
        return produitMetier.listeParSousCategorie(sousCategorie);
    }

    @GetMapping(value = "/admin/editerProduit/{id}")
    public ResponseEntity<Produits> editeProduit(@PathVariable(value = "id") Long id){
        return produitMetier.editerProduit(id);
    }

    @PutMapping(value = "/admin/updateProduit/{id}")
    public ResponseEntity<Produits> updateProduit(@PathVariable(value = "id") Long id, @RequestBody Produits prod){
        return produitMetier.modifierProduit(id, prod);
    }

    @DeleteMapping(value="/admin/deleteProduit/{id}")
    public void deleteProduit(@PathVariable(value = "id") Long id) {
        produitMetier.supprimerProduit(id);
    }
   	
    @PostMapping(value = "/admin/newPhoto")
    public Photos savePhoto(@RequestBody Photos photos) {
    	return produitMetier.savePhoto(photos);
    }
    
    @GetMapping(value = "/admin/listePhoto")
    public List<Photos> listePhotos() {
      return produitMetier.listePhotos();
    }  
    
    @GetMapping(value = "/admin/editerPhoto/{id}")
    public Photos editePhoto(@PathVariable(value = "id") Long id){
        return produitMetier.editerPhoto(id);
    }
    
    @PostMapping(value = "/admin/uploadPhoto/{id}")
    public void upload(@RequestParam(name = "file") MultipartFile file, @PathVariable(value = "id") Long id) throws Exception {
    	produitMetier.upload(file, id);
    }
            
    @DeleteMapping(value="/admin/deletePhoto/{id}")
    public void deletePhoto(@PathVariable(value = "id") Long id) {
        produitMetier.supprimerPhoto(id);
    }
    
    @PostMapping(value = "/admin/newLogo")
    public Logos ajouterLogo(@Valid @RequestBody Logos logos) {
    	return produitMetier.saveLogo(logos);
    }
    
    @GetMapping(value = "/admin/listeLogo")
    public List<Logos> listeLogos() {
    	return produitMetier.listeLogos();
    }
    
    @GetMapping(value = "/admin/editerLogo/{id}")
    public Logos editeLogo(@PathVariable(value = "id") Long id){
        return produitMetier.editerLogo(id);
    }
    
    @PostMapping(value = "/admin/uploadLogo/{id}")
    public void uploadLogo(@RequestParam(name = "file") MultipartFile file, @PathVariable(value = "id") Long id) throws Exception {
    	produitMetier.uploadLogo(file,id);
    }
    
    @DeleteMapping(value="/admin/deleteLogo/{id}")
    public void deleteLogo(@PathVariable(value = "id") Long id) {
        produitMetier.supprimerLogo(id);
    }
    
    @PreDestroy
    public void destruction() {
    	System.out.println("Destruction produit controller");
    }
}
