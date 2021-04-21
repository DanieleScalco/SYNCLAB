package com.synclab.cinemamultisala.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.synclab.cinemamultisala.entity.Film;
import com.synclab.cinemamultisala.entity.FilmId;


public interface FilmService {

	public List<Film> getFilms();
	
	public Film getFilm(FilmId filmId);
	
	public void salvaFilm(Film film);
	
	public void eliminaFilm(FilmId filmId);
		
	public List<Film> getFilmsFromDayToDay(LocalDate daData, LocalDate aData);

	public List<Film> getFilmFromDayToDay(String titolo, LocalDate daData, LocalDate aData);

}
