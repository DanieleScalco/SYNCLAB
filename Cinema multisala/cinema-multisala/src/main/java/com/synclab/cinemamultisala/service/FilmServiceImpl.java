package com.synclab.cinemamultisala.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synclab.cinemamultisala.dao.FilmRepository;
import com.synclab.cinemamultisala.dao.SalaRepository;
import com.synclab.cinemamultisala.entity.Film;
import com.synclab.cinemamultisala.entity.FilmId;
import com.synclab.cinemamultisala.entity.Sala;

@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
	private SalaRepository salaRepository;
	
	@Override
	public List<Film> getFilms() {
		return filmRepository.findAll();
	}

	@Override
	public Film getFilm(FilmId filmId) {
		Optional<Film> result = filmRepository.findById(filmId);
		
		Film film = null;
		if (result.isPresent()) {
			film = result.get();
		} else {
			throw new RuntimeException("Film non trovato per id - " + filmId);
		}
		
		return film;
	}

	@Override
	public void salvaFilm(Film film) {
		filmRepository.save(film);
	}

	@Override
	public void eliminaFilm(FilmId filmId) {
		filmRepository.deleteById(filmId);
	}

	public List<Film> getFilmsFromDayToDay(LocalDate daData, LocalDate aData) {
		return filmRepository.getFilmsFromDayToDay(daData, aData);
	}
	
	public List<Film> getFilmFromDayToDay(String titolo, LocalDate daData, LocalDate aData) {
		return filmRepository.getFilmFromDayToDay(titolo, daData, aData);
	}

	@Override
	public boolean existsById(FilmId filmId) {
		return filmRepository.existsById(filmId);
	}

	@Override
	public void eliminaFilm(String titolo) {
		filmRepository.deleteByFilmIdTitolo(titolo);
	}
	
	@Override
	public Sala getSala(int numeroSala) {
		return salaRepository.findSalaByNumeroSala(numeroSala);
	}
	
	@Override
	public List<Sala> getSale() {
		return salaRepository.findAll();
	}
	
	@Override
	public List<Film> getFilmInSala(int numeroSala) {
		
		List<Sala> sale = salaRepository.findAll();
		Sala sala = null;
		
		for (Sala s : sale)
			if (s.getNumeroSala() == numeroSala)
				sala = s;
		
		return filmRepository.getFilmInSala(sala.getId());
	}

	
}
