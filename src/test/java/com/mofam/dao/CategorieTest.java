package com.mofam.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mofam.entities.Categorie;

class CategorieTest {
	@Autowired
	private CategorieRepository categorieRepository;
		
	@Test
	@DisplayName("ajouterCategorie")
	void testAddCategorie() {
		Categorie cat = new Categorie();
		cat.setLibelle("Fruits");
		categorieRepository.save(cat);
	}
}
