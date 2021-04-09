package com.synclab.cinemamultisala.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.synclab.cinemamultisala.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, String> {
	
	// Dichiarare una propria query
	@Query("select p from Persona p where p.mail like ?1%")
	public Persona findByName(String name);
}
