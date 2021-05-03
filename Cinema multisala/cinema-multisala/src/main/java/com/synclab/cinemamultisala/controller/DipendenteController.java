package com.synclab.cinemamultisala.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.synclab.cinemamultisala.dao.FilmRepository;
import com.synclab.cinemamultisala.entity.Film;
import com.synclab.cinemamultisala.entity.FilmId;

@Controller
@RequestMapping("/dipendente")
public class DipendenteController {
	
	private Logger myLogger = Logger.getLogger(DipendenteController.class.getName());

	@Autowired
	FilmRepository filmRepository;

	@GetMapping("/aggiungiFilm")
	public String aggiungiFilm(Model model) {
		
		Film film = new Film();
		model.addAttribute("film", film);
		
		return "form-aggiunta-film";
	}
	 
	@PostMapping("/processFilm")
	public String processFilm(@ModelAttribute("film") Film film, Model model) {
		
		myLogger.info("Film già esistente? " + filmRepository.existsById(film.getFilmId()));
		myLogger.info("Data " + film.getFilmId().getData() + ", ora: " + film.getFilmId().getOraInizio());
		myLogger.info("Immagine " + film.getImmagine());
		// Aggiungere messaggio se film già esistente
		return "form-aggiunta-film";
	}
}
