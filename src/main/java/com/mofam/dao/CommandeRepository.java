package com.mofam.dao;

import com.mofam.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande,String> {
	public Commande findByCode(String code);
}
