package com.mofam.controller;

import com.mofam.entities.Acheteur;
import com.mofam.entities.Commande;
import com.mofam.entities.CommandePrestataire;
import com.mofam.entities.Partener;
import com.mofam.entities.Prestataire;
import com.mofam.entities.ProduitCommande;
import com.mofam.service.ICommandeMetierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.validation.Valid;
import java.util.List;

@RestController
public class CommandeController {
    @Autowired
    private ICommandeMetierImpl iCommandeMetier;
    
    @PostConstruct
    public void initialisation() {
    	System.out.println("Création commande controller");
    }
    
    @GetMapping(value = "/admin/listeCommande")
    public List<Commande> listeCommande(){
        return iCommandeMetier.listeCommandeClients();
    }
        
    @GetMapping(value = "/admin/listeProduitCommande")
    public List<ProduitCommande> listeProduitCommande(){
        return iCommandeMetier.listeProduitsCommande();
    }
    
    @GetMapping(value = "/admin/editerCommande/{code}")
    public ResponseEntity<Commande> editeCommande(@PathVariable(value = "code") String code) {
    	return iCommandeMetier.editerCommande(code);
    }
    
    @PutMapping(value = "/admin/updateCommande/{code}")
    public ResponseEntity<Commande> updateCommande(@PathVariable(value = "code") String code, @RequestBody Commande com) {
    	return iCommandeMetier.modifierCommande(code, com);
    }
    
    @PostMapping(value = "/admin/newCommande")
    public CommandePrestataire ajouterCommande(@Valid @RequestBody CommandePrestataire commandePrestataire) {
    	return iCommandeMetier.ajouterCommande(commandePrestataire);
    }
    
    @DeleteMapping(value = "/admin/deleteCommande/{code}")
    public void deleteCommande(@PathVariable(value = "code") String code) {
    	iCommandeMetier.supprimerCommande(code);
    }
    
    @DeleteMapping(value = "/admin/deleteProduitCommande/{id}")
    public void deleteCommande(@PathVariable(value = "id") Long id) {
    	iCommandeMetier.supprimerProduitCommande(id);
    }
    
    @GetMapping(value = "/admin/listeCommandePrestataire")
    public List<CommandePrestataire> listeCommandePrestataire(){
    	return iCommandeMetier.listeCommandePrestataires();
    }
    
    @GetMapping(value = "/admin/listeCommandeParPrestataire")
    public List<CommandePrestataire> listeCommandeParPrestataire(Prestataire prestataire){
    	return iCommandeMetier.listeCommandeParPrestataire(prestataire);
    }
    
    @PostMapping(value = "/admin/newPartener")
    public Partener ajouterPartenaire(@Valid @RequestBody Partener partener) {
        return iCommandeMetier.ajouterPartenaire(partener);
    }

    @GetMapping(value = "/admin/listePartener")
    public List<Partener> listePartenaire(){
        return iCommandeMetier.listePartener();
    }

    @DeleteMapping(value = "/admin/deletePartener/{id}")
    public void deletePartenaire(@PathVariable(value = "id") Long id){
        iCommandeMetier.supprimerPartener(id);
    }
    
    @PostMapping(value = "/admin/newAcheteur")
    public Acheteur ajouterAcheteur(@Valid @RequestBody Acheteur acheteur) {
    	return iCommandeMetier.ajouterAcheteur(acheteur);
    }
    
    @GetMapping(value = "/admin/listeAcheteur")
    public List<Acheteur> listeAcheteurs(){
    	return iCommandeMetier.listeAcheteurs();
    }
    
    @DeleteMapping(value = "/admin/deleteAcheteur")
    public void deleteAcheteur(@PathVariable(value = "id") Long id) {
    	iCommandeMetier.supprimerAcheteur(id);
    }
    
    @PostMapping(value = "/admin/newPrestataire")
    public Prestataire ajouterPrestataire(@Valid @RequestBody Prestataire prestataire) {
    	return iCommandeMetier.ajouterPrestataire(prestataire);
    }
    
    @GetMapping(value = "/admin/listePrestataire")
    public List<Prestataire> listePrestataires(){
    	return iCommandeMetier.listePrestataires();
    }
    
    @DeleteMapping(value = "/admin/deletePrestataire/{id}")
    public void deletePrestataire(@PathVariable(value = "id") Long id) {
    	iCommandeMetier.supprimerPrestataire(id);
    }
    
    @PreDestroy
    public void destruction() {
    	System.out.println("Destruction commande controller");
    }
}
