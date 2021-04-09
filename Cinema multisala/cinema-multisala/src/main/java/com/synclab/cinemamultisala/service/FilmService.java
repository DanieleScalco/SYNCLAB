package com.synclab.cinemamultisala.service;

import java.util.List;

import com.synclab.cinemamultisala.entity.Film;
import com.synclab.cinemamultisala.entity.FilmId;


public interface FilmService {

	public List<Film> getFilms();
	
	public Film getFilm(FilmId filmId);
	
	public void salvaFilm(Film film);
	
	public void eliminaFilm(FilmId filmId);
}
