package com.synclab.cinemamultisala.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.synclab.cinemamultisala.entity.Film;
import com.synclab.cinemamultisala.entity.FilmId;
import com.synclab.cinemamultisala.entity.Persona;

public interface FilmRepository extends JpaRepository<Film, FilmId> {
	
	// Trova tutti i film differenti in programmazione questa settimana
	@Query(value="SELECT * FROM Film f WHERE f.data >= ?1 AND f.data <= ?2 GROUP BY f.titolo", nativeQuery=true)
	public List<Film> getFilmsFromDayToDay(LocalDate daData, LocalDate aData);
	
	// Trova tutti i film con un certo titolo in programmazione questa settimana
	@Query(value="SELECT * FROM Film f WHERE f.data >= ?2 AND f.data <= ?3 AND f.titolo = ?1", nativeQuery=true)
	public List<Film> getFilmFromDayToDay(String titolo, LocalDate daData, LocalDate aData);
}
