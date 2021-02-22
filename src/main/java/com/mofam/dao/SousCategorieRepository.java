package com.mofam.dao;

import com.mofam.entities.Categorie;
import com.mofam.entities.SousCategorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SousCategorieRepository extends JpaRepository<SousCategorie,Long> {
    public SousCategorie findByLibelle(String libelle);
    public List<SousCategorie> findByCategorie(Categorie cat);
}
