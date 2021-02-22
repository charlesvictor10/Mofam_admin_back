package com.mofam.dao;

import com.mofam.entities.Departement;
import com.mofam.entities.Ville;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VilleRepository extends JpaRepository<Ville, Long> {
    public Ville findByNom(String nom);
    public List<Ville> findByDepartement(Departement departement);
}
