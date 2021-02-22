package com.mofam.dao;

import com.mofam.entities.Utilisateur;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    Optional<Utilisateur> findByEmail(String email);
    Utilisateur findByEmailIgnoreCase(String email);
    Boolean existsByEmail(String email);
}
