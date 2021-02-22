package com.mofam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mofam.entities.ProduitCommande;

public interface ProduitCommandeRepository extends JpaRepository<ProduitCommande, Long> {
	
}
