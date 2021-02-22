package com.mofam.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mofam.entities.CommandePrestataire;
import com.mofam.entities.Prestataire;

public interface CommandePrestataireRepository extends JpaRepository<CommandePrestataire, Long> {
	public List<CommandePrestataire> findByPrestataire(Prestataire prestataire);
}
