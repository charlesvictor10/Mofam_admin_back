package com.mofam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mofam.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie,Long> {
    public Categorie findByLibelle(String libelle);
}
