package com.synclab.cinemamultisala.controller;

import java.time.LocalDate;
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

import net.bytebuddy.asm.Advice.Local;

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
		
		LocalDate dataAttuale = LocalDate.now();
		LocalDate dataAttualePiu7 = dataAttuale.plusDays(7);
		
		// Prendiamo tutti i film disponibili di qui a 7 giorni
		List<Film> listaFilm =  filmService.getFilmsFromDayToDay(dataAttuale, dataAttualePiu7);
		model.addAttribute("listaFilm", listaFilm);
		
		return "homepage";
	}
	
	
		
		
		
		
		
	
		
	
	
	
	
}
