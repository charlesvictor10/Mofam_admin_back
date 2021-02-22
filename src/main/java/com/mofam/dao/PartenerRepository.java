package com.mofam.dao;

import com.mofam.entities.Partener;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartenerRepository extends JpaRepository<Partener,Long> {
    public Partener findByNom(String nom);
}
