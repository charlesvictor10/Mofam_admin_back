package com.mofam.dao;

import com.mofam.entities.Acheteur;
//import com.mofam.entities.Utilisateur;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AcheteurRepository extends JpaRepository<Acheteur,Long> {
	Optional<Acheteur> findByEmail(String email);
	Acheteur findByEmailIgnoreCase(String email);
    Boolean existsByEmail(String email);
}
