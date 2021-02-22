package com.mofam.service;

import com.mofam.Exception.BadRequestException;
import com.mofam.Exception.ResourceNotFoundException;
import com.mofam.dao.*;
import com.mofam.entities.Acheteur;
import com.mofam.entities.Commande;
import com.mofam.entities.CommandePrestataire;
import com.mofam.entities.EtatCommandeEnum;
import com.mofam.entities.Partener;
import com.mofam.entities.Prestataire;
import com.mofam.entities.ProduitCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Transactional
public class ICommandeMetierImpl implements ICommandeMetier {
    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private CommandePrestataireRepository commandePrestataireRepository;
    @Autowired
    private ProduitCommandeRepository produitCommandeRepository;
    @Autowired
    private AcheteurRepository acheteurRepository;
    @Autowired
    private PartenerRepository partenerRepository;
    @Autowired
    private PrestataireRepository prestataireRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @PostConstruct
    public void initialisation() {
    	System.out.println("Création commande métier");
    }
    
    @Override
    public List<Commande> listeCommandeClients(){
    	return commandeRepository.findAll();
    }
    
    @Override
    public List<ProduitCommande> listeProduitsCommande(){
    	return produitCommandeRepository.findAll();
    }
    
    @Override
    public ResponseEntity<Commande> editerCommande(String code){
    	Commande commande = commandeRepository.findByCode(code);
    	if(commande == null) {
    		throw new ResourceNotFoundException("Commande"," introuvable ou inexistante",code);
    	} else {
    		return ResponseEntity.ok().body(commande);
    	}
    }
    
    @Override
    public ResponseEntity<Commande> modifierCommande(String code, Commande com) {
    	Commande commande = commandeRepository.findByCode(code);
    	commande.setEtat(com.getEtat());
    	final Commande updateCommande = commandeRepository.save(commande);
    	return ResponseEntity.ok(updateCommande);
    }
    
    @Override
	public void supprimerCommande(String code) {
    	Commande commande = commandeRepository.findByCode(code);
    	if(commande == null) {
    		throw new ResourceNotFoundException("Commande"," introuvable ou inexistante",code);
    	} else {
    		commandeRepository.deleteById(code);
    	}
	}
    
    @Override
    public void supprimerProduitCommande(Long id) {
    	ProduitCommande produitCommande = produitCommandeRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("produit"," introuvable ou inexistante",id));
    	produitCommandeRepository.deleteById(produitCommande.getId_prod_com());
    }
    
    @Override
    public CommandePrestataire ajouterCommande(CommandePrestataire commandePrestataire) {
    	String etat = EtatCommandeEnum.Attente.toString();
    	// Génération d'un nombre aléatoire pour le code de la commande
    	double n = Math.random();
    	int id = (int)(n * 1000000);
    	String code = "BCP"+id;
    	
    	// Information sur la commande
    	commandePrestataire.setCode(code);
    	commandePrestataire.setDate_commande(new Date());
    	commandePrestataire.setEtat(etat);
    	// Sauvegarde de la commande
    	return commandePrestataireRepository.save(commandePrestataire);
    }
    
    @Override
    public List<CommandePrestataire> listeCommandePrestataires(){
    	return commandePrestataireRepository.findAll();
    }
    
    @Override
    public List<CommandePrestataire> listeCommandeParPrestataire(Prestataire prestataire){
    	return commandePrestataireRepository.findByPrestataire(prestataire);
    }
          
    @Override
    public Partener ajouterPartenaire(Partener partener) {
        Partener part = partenerRepository.findByNom(partener.getNom());
        if(part != null){
            throw new BadRequestException("Partener déjà enregistré");
        } else {
            return partenerRepository.save(partener);
        }
    }
    
    @Override
    public Acheteur ajouterAcheteur(Acheteur acheteur) {
    	if (acheteurRepository.existsByEmail(acheteur.getEmail())) {
            throw new BadRequestException("Cet adresse email est déjà utilisé.");
        }
    	Acheteur achete = new Acheteur();
    	achete.setActived(true);
    	achete.setPassword(passwordEncoder.encode(achete.getPassword()));
    	return acheteurRepository.save(achete);
    }

    @Override
    public List<Partener> listePartener() {
        return partenerRepository.findAll();
    }

    @Override
    public void supprimerPartener(Long id) {
        Partener partener = partenerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Partener"," introuvable ou inexistante",id));
        partenerRepository.deleteById(partener.getId_part());
    }

	@Override
	public List<Acheteur> listeAcheteurs() {
		return acheteurRepository.findAll();
	}

	@Override
	public void supprimerAcheteur(Long id) {
		Acheteur acheteur = acheteurRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Acheteur"," introuvable ou inexistante",id));
		acheteurRepository.deleteById(acheteur.getId_acheteur());
	}
	
	@Override
	public Prestataire ajouterPrestataire(Prestataire prestataire) {
		if (prestataireRepository.existsByEmail(prestataire.getEmail())) {
            throw new BadRequestException("Cet adresse email est déjà utilisé.");
        }
		return prestataireRepository.save(prestataire);
	}
	
	@Override
	public List<Prestataire> listePrestataires(){
		return prestataireRepository.findAll();
	}
	
	@Override
	public void supprimerPrestataire(Long id) {
		Prestataire prestataire = prestataireRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Prestataire"," introuvable ou inexistante",id));
		prestataireRepository.deleteById(prestataire.getId());
	}
	
	@PreDestroy
	public void destruction() {
		System.out.println("Destruction commande métier");
	}
}
