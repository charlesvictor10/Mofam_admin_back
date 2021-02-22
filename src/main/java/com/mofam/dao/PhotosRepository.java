package com.mofam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mofam.entities.Photos;

public interface PhotosRepository extends JpaRepository<Photos,Long> {
	@Query("update Photos p set p.type=:y where p.id_photo =:x")
	public int updatePhoto(@Param("y") String i, @Param("x") Long id);
}
