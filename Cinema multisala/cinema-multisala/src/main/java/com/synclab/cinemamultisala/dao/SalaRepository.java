package com.synclab.cinemamultisala.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.synclab.cinemamultisala.entity.Sala;

public interface SalaRepository extends JpaRepository<Sala, Integer> {

	@Query(value = "SELECT * FROM sala s WHERE s.numero_sala = ?1", nativeQuery = true)
	public Sala findSalaByNumeroSala(int numeroSala);
	
}
