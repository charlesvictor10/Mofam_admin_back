package com.mofam.dao;

import com.mofam.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Boolean existsByNom(String nom);
    public Role findByNom(String nom);
}
