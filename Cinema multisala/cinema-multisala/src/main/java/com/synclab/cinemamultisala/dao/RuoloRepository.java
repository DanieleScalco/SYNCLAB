package com.synclab.cinemamultisala.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.synclab.cinemamultisala.entity.Ruolo;

public interface RuoloRepository extends JpaRepository<Ruolo, Integer> {

	@Query(value="SELECT * FROM ruolo r WHERE r.nome_ruolo = ?1", nativeQuery=true)
	public Ruolo findRoleByName(String nomeRuolo);
	
}
