package com.synclab.cinemamultisala.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.synclab.cinemamultisala.entity.Film;
import com.synclab.cinemamultisala.entity.FilmId;
import com.synclab.cinemamultisala.service.FilmService;

@Controller
@RequestMapping("/scheda")
public class SchedeController {
	
	private Logger myLogger = Logger.getLogger(SchedeController.class.getName());
	
	@Autowired
	private FilmService filmService;

	@GetMapping("/mostraFilm")
	public String mostraFilm(@RequestParam("titoloFilm") String titoloFilm, Model model) {
		
		LocalDate dataAttuale = LocalDate.now();
		LocalDate dataAttualePiu7 = dataAttuale.plusDays(7);
		
		List<Film> listaFilm = filmService.getFilmFromDayToDay(titoloFilm, dataAttuale, dataAttualePiu7);
		
		model.addAttribute("listaFilm", listaFilm);
		
		return "scheda-film";
	} 

}
