package com.synclab.cinemamultisala.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.synclab.cinemamultisala.entity.Film;
import com.synclab.cinemamultisala.entity.FilmId;
import com.synclab.cinemamultisala.entity.IdPosto;
import com.synclab.cinemamultisala.entity.Persona;
import com.synclab.cinemamultisala.entity.PostoASedere;
import com.synclab.cinemamultisala.entity.Prenotazione;
import com.synclab.cinemamultisala.service.FilmService;
import com.synclab.cinemamultisala.service.PersonaService;
import com.synclab.cinemamultisala.service.PostoASedereService;
import com.synclab.cinemamultisala.service.PrenotazioneService;

@Controller
@RequestMapping("/homepage")
public class HomeController {
	
	private Logger myLogger = Logger.getLogger(HomeController.class.getName());

	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private PostoASedereService postoASedereService;
	
	@Autowired
	private PrenotazioneService prenotazioneService;
	
	@GetMapping("/home")
	public String homePage(Model model) {
		
		// Ritiro dati da tutte le tabelle per aggiungerli al model		
		List<Film> listaFilm =  filmService.getFilms();
		model.addAttribute("listaFilm", listaFilm);
		
		return "homepage";
	}
	
	
		
		
		
		
		
	
		
	
	
	
	
}
