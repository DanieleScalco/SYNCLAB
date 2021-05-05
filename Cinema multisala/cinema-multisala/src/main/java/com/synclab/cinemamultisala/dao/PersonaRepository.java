package com.synclab.cinemamultisala.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.synclab.cinemamultisala.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, String> {
	
	@Query(value="SELECT * FROM Persona p WHERE p.mail = ?1", nativeQuery=true)
	public Persona findByMail(String mail);
}
