package com.mofam.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mofam.entities.Prestataire;

public interface PrestataireRepository extends JpaRepository<Prestataire, Long> {
	Optional<Prestataire> findByEmail(String email);
	Prestataire findByEmailIgnoreCase(String email);
    Boolean existsByEmail(String email);
}
