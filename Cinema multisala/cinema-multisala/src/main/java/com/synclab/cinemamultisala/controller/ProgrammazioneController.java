package com.synclab.cinemamultisala.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.synclab.cinemamultisala.entity.Film;
import com.synclab.cinemamultisala.entity.Orario;
import com.synclab.cinemamultisala.service.FilmService;

@Controller
@RequestMapping("/programmazione")
public class ProgrammazioneController {

	private Logger myLogger = Logger.getLogger(ProgrammazioneController.class.getName());

	@Autowired
	private FilmService filmService;
	
	@GetMapping("mostraProgrammazione")
	public String mostraProgrammazione(Model model) {
		
		LocalDate dataAttuale = LocalDate.now();
		LocalDate dataAttualePiu7 = dataAttuale.plusDays(7);
		
		// Prendiamo tutti i film disponibili di qui a 7 giorni
		// Si considera che tutti i film in programmazione siano quelli dalla data attuale
		// a 7 giorni dopo
		List<Film> listaSingoliFilm =  filmService.getFilmsFromDayToDay(dataAttuale, dataAttualePiu7);
		List<String> listaTitoli = new ArrayList<String>();
		
		for (Film f: listaSingoliFilm) {
			listaTitoli.add(f.getFilmId().getTitolo());
		}
		
		List<Film> films = new ArrayList<Film>();
		List<List<Orario>> orari = new ArrayList<List<Orario>>();
		for (String titolo: listaTitoli) {
			List<Film> listaFilm = filmService.getFilmFromDayToDay(titolo, dataAttuale, dataAttualePiu7);
	
			// Prendo il primo dei film giusto per avere i dati descrittivi (tutto eccetto data e ora)
			Film film = listaFilm.get(0);
			
			// Ciclo su tutti i film per prendere tutti gli orari e i giorni
			List<Orario> listaOrari = new ArrayList<Orario>();
			for (Film filmTmp: listaFilm) {
				Orario orarioTmp = new Orario(filmTmp.getFilmId().getData(), filmTmp.getFilmId().getOraInizio());
				listaOrari.add(orarioTmp);
			}
			
			films.add(film);
			orari.add(listaOrari);
		}
		
		model.addAttribute("listaFilm", films);
		model.addAttribute("listaOrari", orari);
		
		return "programmazione";
	}
}
