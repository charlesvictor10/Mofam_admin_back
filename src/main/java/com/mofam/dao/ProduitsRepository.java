package com.mofam.dao;

import com.mofam.entities.Produits;
import com.mofam.entities.SousCategorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitsRepository extends JpaRepository<Produits,Long> {
    public List<Produits> findBySousCategorie(SousCategorie sousCategorie);
}
