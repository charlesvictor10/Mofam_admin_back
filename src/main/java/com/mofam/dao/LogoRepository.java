package com.mofam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mofam.entities.Logos;

public interface LogoRepository extends JpaRepository<Logos, Long> {
	@Query("update Logos l set l.type=:y where l.id_logo =:x")
	public int updateLogo(@Param("y") String i, @Param("x") Long id);
}
