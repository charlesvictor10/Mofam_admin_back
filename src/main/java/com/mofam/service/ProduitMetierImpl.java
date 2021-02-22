package com.mofam.service;

import com.mofam.Exception.*;
import com.mofam.dao.CategorieRepository;
import com.mofam.dao.LogoRepository;
import com.mofam.dao.PhotosRepository;
import com.mofam.dao.ProduitsRepository;
import com.mofam.dao.SousCategorieRepository;
import com.mofam.entities.Categorie;
import com.mofam.entities.Logos;
import com.mofam.entities.Photos;
import com.mofam.entities.Produits;
import com.mofam.entities.SousCategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Transactional
public class ProduitMetierImpl implements IProduitMetier {
    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private SousCategorieRepository sousCategorieRepository;
    @Autowired
    private ProduitsRepository produitsRepository;  
    @Autowired
    private PhotosRepository photosRepository;
    @Autowired
    private LogoRepository logoRepository;
    
    @PostConstruct
    public void initialisation() {
    	System.out.println("Création produit métier");
    }
            
    @Override
    public Categorie ajouterCategorie(Categorie cat) {
    	Categorie categorie = categorieRepository.findByLibelle(cat.getLibelle());
        if(categorie != null){
            throw new BadRequestException("Catégorie déjà enregistrée");
        } else {
            return categorieRepository.save(cat);
        }
    }

    @Override
    public List<Categorie> listeCategorie() {
        return categorieRepository.findAll();
    }

    @Override
    public ResponseEntity<Categorie> editerCategorie(Long id) {
    	Categorie categorie = categorieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Catégorie"," introuvable ou inexistante",id));
        return ResponseEntity.ok().body(categorie);
    }

    @Override
    public ResponseEntity<Categorie> modifierCategorie(Long id, Categorie cat) {
    	Categorie categorie = categorieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Catégorie"," introuvable ou inexistante",id));
        categorie.setLibelle(cat.getLibelle());
        final Categorie updateCategorie = categorieRepository.save(categorie);
        return ResponseEntity.ok(updateCategorie);
    }

    @Override
    public void supprimerCategorie(Long id) {
    	Categorie categorie = categorieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Catégorie"," introuvable ou inexistante",id));
        categorieRepository.deleteById(categorie.getId_cat());
    }

    @Override
    public SousCategorie ajouterSousCategorie(SousCategorie sousCat) {
        SousCategorie sousCategorie = sousCategorieRepository.findByLibelle(sousCat.getLibelle());
        if(sousCategorie != null){
            throw new BadRequestException("Sous catégorie déjà enregistrée");
        } else {
            return sousCategorieRepository.save(sousCat);
        }
    }

    @Override
    public List<SousCategorie> listeSousCategorie() {
        return sousCategorieRepository.findAll();
    }

    @Override
    public List<SousCategorie> listeParCategorie(Categorie cat) {
    	Categorie categorie = categorieRepository.findById(cat.getId_cat())
                .orElseThrow(() -> new ResourceNotFoundException("Catégorie"," introuvable ou inexistante",cat.getId_cat()));
        return sousCategorieRepository.findByCategorie(categorie);
    }

    @Override
    public ResponseEntity<SousCategorie> editerSousCategorie(Long id) {
        SousCategorie sousCategorie = sousCategorieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sous catégorie"," introuvable ou inexistante",id));
        return ResponseEntity.ok().body(sousCategorie);
    }

    @Override
    public ResponseEntity<SousCategorie> modifierSousCategorie(Long id, SousCategorie sousCat) {
        SousCategorie sousCategorie = sousCategorieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sous catégorie"," introuvable ou inexistante",id));
        sousCategorie.setLibelle(sousCat.getLibelle());
        sousCategorie.setCategorie(sousCat.getCategorie());
        final SousCategorie updateSousCategorie = sousCategorieRepository.save(sousCategorie);
        return ResponseEntity.ok(updateSousCategorie);
    }

    @Override
    public void supprimerSousCategorie(Long id) {
        SousCategorie sousCategorie = sousCategorieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sous catégorie"," introuvable ou inexistante",id));
        sousCategorieRepository.deleteById(sousCategorie.getId_sous_cat());
    }

    @Override
    public Produits ajouterProduit(Produits produits) {
        return produitsRepository.save(produits);
    }

    @Override
    public List<Produits> listeProduits() {
        return produitsRepository.findAll();
    }

    @Override
    public List<Produits> listeParSousCategorie(SousCategorie sousCat) {
        SousCategorie sousCategorie = sousCategorieRepository.findById(sousCat.getId_sous_cat())
                .orElseThrow(() -> new ResourceNotFoundException("Sous catégorie"," introuvable ou inexistante",sousCat.getId_sous_cat()));
        return produitsRepository.findBySousCategorie(sousCategorie);
    }

    @Override
    public ResponseEntity<Produits> editerProduit(Long id) {
        Produits produits = produitsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produit"," introuvable ou inexistante",id));
        return ResponseEntity.ok().body(produits);
    }

    @Override
    public ResponseEntity<Produits> modifierProduit(Long id, Produits prod) {
        Produits produits = produitsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produit"," introuvable ou inexistante",id));
        produits.setDesignation(prod.getDesignation());
        produits.setPrix(prod.getPrix());
        produits.setQuantite(prod.getQuantite());
        produits.setProprietaire(prod.getProprietaire());
        produits.setDescription(prod.getDescription());
        produits.setSousCategorie(prod.getSousCategorie());
        produits.setVille(prod.getVille());
        produits.setEtat(prod.getEtat());
        final Produits updateProduit = produitsRepository.save(produits);
        return ResponseEntity.ok(updateProduit);
    }

    @Override
    public void supprimerProduit(Long id) {
        Produits produits = produitsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produit"," introuvable ou inexistante",id));
        produitsRepository.deleteById(produits.getId_produit());
    }
    	 
    @Override
    public Photos savePhoto(Photos photos){
    	return photosRepository.save(photos);
    }
    
    @Override
    public Photos editerPhoto(Long id) {
        Photos photos = photosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Photo"," introuvable ou inexistante",id));
        return photos;
    }
    
    @Override
    public void upload(MultipartFile file, Long id) throws Exception {
    	Photos photos = photosRepository.findById(id)
    			.orElseThrow(() -> new ResourceNotFoundException("Photo"," introuvable ou inexistante",id));
    	
    	String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    	photos.setNom_photo(fileName);
    	photos.setType(file.getContentType());
    	photos.setData(file.getBytes());
    	photosRepository.save(photos);
    }
    
	@Override
	public List<Photos> listePhotos() {
		return photosRepository.findAll();
	}
		
	@Override
	public void supprimerPhoto(Long id) {
		Photos photos = photosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Photo"," introuvable ou inexistante",id));
        photosRepository.deleteById(photos.getId_photo());
	}

	@Override
	public Logos saveLogo(Logos logos) {
		return logoRepository.save(logos);
	}

	@Override
	public List<Logos> listeLogos() {
		return logoRepository.findAll();
	}
	
	@Override
    public Logos editerLogo(Long id) {
        Logos logos = logoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Logo"," introuvable ou inexistante",id));
        return logos;
    }
    
    @Override
    public void uploadLogo(MultipartFile file, Long id) throws Exception {
    	Logos logos = logoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Logo"," introuvable ou inexistante",id));
    	
    	String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    	logos.setNom_logo(fileName);
    	logos.setType(file.getContentType());
    	logos.setData(file.getBytes());
    	logoRepository.save(logos);
    }

	@Override
	public void supprimerLogo(Long id) {
		Logos logos = logoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Logo"," introuvable ou inexistante",id));
        logoRepository.deleteById(logos.getId_logo());
	}
	
	@PreDestroy
    public void destruction() {
    	System.out.println("Destruction produit métier");
    }
}
