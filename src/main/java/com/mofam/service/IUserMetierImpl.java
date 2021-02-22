package com.mofam.service;

import com.mofam.Exception.BadRequestException;
import com.mofam.Exception.ResourceNotFoundException;
import com.mofam.dao.*;
import com.mofam.entities.Departement;
import com.mofam.entities.Region;
import com.mofam.entities.Utilisateur;
import com.mofam.entities.Ville;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Transactional
public class IUserMetierImpl implements IUserMetier {
	@Autowired
	private UtilisateurRepository utiliateurRepository;
    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private DepartementRepository departementRepository;
    @Autowired
    private VilleRepository villeRepository;
    
    @PostConstruct
    public void initialisation() {
    	System.out.println("Création user métier");
    }
    
    @Override
    public List<Utilisateur> listeUtilisateur(){
    	return utiliateurRepository.findAll();
    }
    
    @Override
    public void supprimerUtilisateur(Long id) {
    	 Utilisateur utilisateur = utiliateurRepository.findById(id)
                 .orElseThrow(() -> new ResourceNotFoundException("Utilisateur"," introuvable ou inexistante",id));
         utiliateurRepository.deleteById(utilisateur.getId());
    }
   
    @Override
    public Region ajouterRegion(Region region) {
        Region reg = regionRepository.findByNom(region.getNom());
        if(reg != null){
            throw new BadRequestException("Région déjà enregistrée");
        } else {
            return regionRepository.save(region);
        }
    }

    @Override
    public List<Region> listeRegions() {
        return regionRepository.findAll();
    }

    @Override
    public ResponseEntity<Region> editerRegion(Long id) {
        Region region = regionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Région"," introuvable ou inexistante",id));
        return ResponseEntity.ok().body(region);
    }

    @Override
    public ResponseEntity<Region> modifierRegion(Long id, Region reg) {
        Region region = regionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Région"," introuvable ou inexistante",id));
        region.setNom(reg.getNom());
        final Region updateRegion = regionRepository.save(region);
        return ResponseEntity.ok(updateRegion);
    }

    @Override
    public void supprimerRegion(Long id) {
        Region region = regionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Région"," introuvable ou inexistante",id));
        regionRepository.deleteById(region.getId_region());
    }

    @Override
    public Departement ajouterDepartement(Departement departement) {
        Departement dep = departementRepository.findByNom(departement.getNom());
        if(dep != null){
            throw new BadRequestException("Département déjà enreggistré");
        } else {
            return departementRepository.save(departement);
        }
    }

    @Override
    public List<Departement> listeDepartement() {
        return departementRepository.findAll();
    }

    @Override
    public List<Departement> listeParRegion(Region region) {
        return departementRepository.findByRegion(region);
    }

    @Override
    public ResponseEntity<Departement> editerDepartement(Long id) {
        Departement departement = departementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Département"," introuvable ou inexistante",id));
        return ResponseEntity.ok().body(departement);
    }

    @Override
    public ResponseEntity<Departement> modifierDepartement(Long id, Departement dep) {
        Departement departement = departementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Département"," introuvable ou inexistante",id));
        departement.setNom(dep.getNom());
        departement.setRegion(dep.getRegion());
        final Departement updateDepartement = departementRepository.save(departement);
        return ResponseEntity.ok(updateDepartement);
    }

    @Override
    public void supprimerDepartement(Long id) {
        Departement departement = departementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Département"," introuvable ou inexistante",id));
        departementRepository.deleteById(departement.getId_departement());
    }

    @Override
    public Ville ajouterVille(Ville ville) {
        Ville vil = villeRepository.findByNom(ville.getNom());
        if(vil != null){
            throw new BadRequestException("Ville déjà enregistée");
        } else {
            return villeRepository.save(ville);
        }
    }

    @Override
    public List<Ville> listeVilles() {
        return villeRepository.findAll();
    }

    @Override
    public List<Ville> listeParDepartement(Departement departement) {
        return villeRepository.findByDepartement(departement);
    }

    @Override
    public ResponseEntity<Ville> editerVille(Long id) {
        Ville ville = villeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ville"," introuvable ou inexistante",id));
        return ResponseEntity.ok().body(ville);
    }

    @Override
    public ResponseEntity<Ville> modifierVille(Long id, Ville vil) {
        Ville ville = villeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ville"," introuvable ou inexistante",id));
        ville.setNom(vil.getNom());
        ville.setDepartement(vil.getDepartement());
        final Ville updateVille = villeRepository.save(ville);
        return ResponseEntity.ok(updateVille);
    }

    @Override
    public void supprimerVille(Long id) {
        Ville ville = villeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ville"," introuvable ou inexistante",id));
        villeRepository.deleteById(ville.getId_ville());
    }
    
    @PreDestroy
    public void destruction() {
    	System.out.println("Destruction user métier");
    }
}
