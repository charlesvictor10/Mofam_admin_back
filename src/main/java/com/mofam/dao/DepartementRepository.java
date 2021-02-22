package com.mofam.dao;

import com.mofam.entities.Departement;
import com.mofam.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartementRepository extends JpaRepository<Departement, Long> {
    public Departement findByNom(String nom);
    public List<Departement> findByRegion(Region region);
}
