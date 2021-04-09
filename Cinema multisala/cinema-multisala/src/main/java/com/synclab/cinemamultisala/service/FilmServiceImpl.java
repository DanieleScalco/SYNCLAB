package com.synclab.cinemamultisala.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synclab.cinemamultisala.dao.FilmRepository;
import com.synclab.cinemamultisala.entity.Film;
import com.synclab.cinemamultisala.entity.FilmId;

@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmRepository filmRepository;
	
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

}
