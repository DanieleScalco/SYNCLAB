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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
		
		Date data = new Date();
		model.addAttribute("data", data);
		
		return "homepage";
	}
	
	// Mappatura per le prove col database
	// FARE CON DB VUOTO!
	@GetMapping("/provadb")
	public String provaDB(Model model) {
		
		// Creazione e aggiunta di persone
		Persona persona1 = new Persona("danieleScalco@hotmail.it", "password", "ADMIN");
		Persona persona2 = new Persona("giopava@hotmail.it", "password", "UTENTE");
		personaService.salvaPersona(persona1);
		personaService.salvaPersona(persona2);
		
		// Creazione e aggiunta di film (!!! Possibile modificare costruttore?)
		Film film1 = new Film(new FilmId("Avatar", LocalDate.of(2021, 12, 1), LocalTime.of(21, 0, 0)), "descrizione", "cast", "immagine", "regista");
		Film film2 = new Film(new FilmId("Avatar2", LocalDate.of(2021, 12, 1), LocalTime.of(21, 30, 0)), "descrizione", "cast", "immagine", "regista");
		filmService.salvaFilm(film1);
		filmService.salvaFilm(film2);
		
		// Creazione e aggiunta di posti
		PostoASedere posto1 = new PostoASedere(new IdPosto(1, 2, 3));
		PostoASedere posto2 = new PostoASedere(new IdPosto(1, 3, 3));
		postoASedereService.salvaPosto(posto1);
		postoASedereService.salvaPosto(posto2);
		
		// Creazione e aggiunta di una prenotazione
		Prenotazione prenotazione = new Prenotazione();
		Film film = filmService.getFilm(new FilmId("Avatar", LocalDate.of(2021, 12, 1), LocalTime.of(21, 0, 0)));
		prenotazione.setFilm(film);
		Persona persona = personaService.getPersona("danielescalco@hotmail.it");
		prenotazione.setPersona(persona);
		PostoASedere posto = postoASedereService.getPosto(new IdPosto(1, 2, 3));
		prenotazione.aggiungiPosto(posto);
		prenotazioneService.salvaPrenotazione(prenotazione);
		
		// Ritiro dati da tutte le tabelle per aggiungerli al model
		List<Persona> persone =  personaService.getPersone();
		model.addAttribute("persone", persone);
		
		List<Film> listaFilm =  filmService.getFilms();
		model.addAttribute("listaFilm", listaFilm);
		
		List<PostoASedere> posti = postoASedereService.getPosti();
		model.addAttribute("posti", posti);
		
		List<Prenotazione> listaPrenotazioni = prenotazioneService.getPrenotazioni();
		model.addAttribute("listaPrenotazioni", listaPrenotazioni);
		
		return "provadb";
	}
	
	
	
}
