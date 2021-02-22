package com.mofam.dao;

import com.mofam.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Long> {
    public Region findByNom(String nom);
}
