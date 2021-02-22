package com.mofam.controller;

import com.mofam.entities.Departement;
import com.mofam.entities.Region;
import com.mofam.entities.Utilisateur;
import com.mofam.entities.Ville;
import com.mofam.service.IUserMetierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.validation.Valid;
import java.util.List;

@RestController
public class GestionController {
    @Autowired
    private IUserMetierImpl iUserMetier;
    
    @PostConstruct
    public void initialiation() {
    	System.out.println("Création user controller");
    }
    
    @GetMapping(value = "/admin/listeUtilisateur")
    public List<Utilisateur> listeUtilisateur(){
    	return iUserMetier.listeUtilisateur();
    }
    
    @DeleteMapping(value = "/admin/supprimerUtilisateur/{id}")
    public void supprimerUtilisateur(@PathVariable(value = "id") Long id) {
    	iUserMetier.supprimerUtilisateur(id);
    }

    @PostMapping(value = "/admin/newRegion")
    public Region ajouterRegion(@Valid @RequestBody Region region){
        return iUserMetier.ajouterRegion(region);
    }

    @GetMapping({"/user/listeRegion", "/admin/listeRegion"})
    public List<Region> listeRegions(){
        return iUserMetier.listeRegions();
    }

    @GetMapping("/admin/editerRegion/{id}")
    public ResponseEntity<Region> editeRegion(@PathVariable(value = "id") Long id){
        return iUserMetier.editerRegion(id);
    }

    @PutMapping(value = "/admin/modifierRegion/{id}")
    public ResponseEntity<Region> updateRegion(@PathVariable(value = "id") Long id, @RequestBody Region region){
        return iUserMetier.modifierRegion(id, region);
    }

    @DeleteMapping(value = "/admin/supprimerRegion/{id}")
    public void deleteRegion(@PathVariable(value = "id") Long id){
        iUserMetier.supprimerRegion(id);
    }

    @PostMapping(value = "/admin/newDepartement")
    public Departement ajouterDepartement(@Valid @RequestBody Departement departement){
        return iUserMetier.ajouterDepartement(departement);
    }

    @GetMapping(value = "/admin/listeDepartement")
    public List<Departement> listeDepartement(){
        return iUserMetier.listeDepartement();
    }

    @GetMapping(value = "/user/listeParRegion")
    public List<Departement> listeParRegion(Region region){
        return iUserMetier.listeParRegion(region);
    }

    @GetMapping(value = "/admin/editerDepartement/{id}")
    public ResponseEntity<Departement> editerDepartement(@PathVariable(value = "id") Long id){
        return iUserMetier.editerDepartement(id);
    }

    @PutMapping(value = "/admin/modifierDepartement/{id}")
    public ResponseEntity<Departement> updateDepartement(@PathVariable(value = "id") Long id, @RequestBody Departement departement){
        return iUserMetier.modifierDepartement(id, departement);
    }

    @DeleteMapping(value = "/admin/supprimerDepartement/{id}")
    public void deleteDepartement(@PathVariable(value = "id") Long id){
        iUserMetier.supprimerDepartement(id);
    }

    @PostMapping(value = "/admin/newVille")
    public Ville ajouterVille(@Valid @RequestBody Ville ville){
        return iUserMetier.ajouterVille(ville);
    }

    @GetMapping(value = "/admin/listeVille")
    public List<Ville> listeVille(){
        return iUserMetier.listeVilles();
    }

    @GetMapping(value = "/user/listeParDepartement")
    public List<Ville> listeParDepartement(Departement departement){
        return iUserMetier.listeParDepartement(departement);
    }

    @GetMapping(value = "/admin/editerVille/{id}")
    public ResponseEntity<Ville> editerVille(@PathVariable(value =  "id") Long id){
        return iUserMetier.editerVille(id);
    }

    @PutMapping(value = "/admin/modifierVille/{id}")
    public ResponseEntity<Ville> updateVille(@PathVariable(value =  "id") Long id, @RequestBody Ville ville){
        return iUserMetier.modifierVille(id, ville);
    }

    @DeleteMapping(value = "/admin/supprimerVille/{id}")
    public void deleteVille(@PathVariable(value = "id") Long id){
        iUserMetier.supprimerVille(id);
    }
    
    @PreDestroy
    public void destruction() {
    	System.out.println("Destruction user controller");
    }
}
