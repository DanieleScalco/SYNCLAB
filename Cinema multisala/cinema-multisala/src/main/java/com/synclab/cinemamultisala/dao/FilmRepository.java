package com.synclab.cinemamultisala.dao;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.synclab.cinemamultisala.entity.Film;
import com.synclab.cinemamultisala.entity.FilmId;

public interface FilmRepository extends JpaRepository<Film, FilmId> {
	
	// Trova tutti i film differenti in programmazione questa settimana
	@Query(value = "SELECT * FROM Film f WHERE f.data >= ?1 AND f.data <= ?2 GROUP BY f.titolo", nativeQuery = true)
	public List<Film> getFilmsFromDayToDay(LocalDate daData, LocalDate aData);
	
	// Trova tutti i film con un certo titolo in programmazione questa settimana
	@Query(value = "SELECT * FROM Film f WHERE f.data >= ?2 AND f.data <= ?3 AND f.titolo = ?1", nativeQuery = true)
	public List<Film> getFilmFromDayToDay(String titolo, LocalDate daData, LocalDate aData);

	// Per modificare lo stato del database è necessario mettere @Modifying e mettere @Transactional non so perchè
	@Modifying
	@Transactional
	// Come chiamare un campo di un @EmbeddedId
	public void deleteByFilmIdTitolo(String titolo);

	@Query(value = "SELECT * FROM Film f WHERE f.sala = ?1", nativeQuery = true)
	public List<Film> getFilmInSala(int id);
}
