package com.synclab.cinemamultisala.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.synclab.cinemamultisala.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, String> {
	
	@Query(value="SELECT * FROM persona p WHERE p.mail = ?1", nativeQuery=true)
	Persona findByMail(String mail);
}
