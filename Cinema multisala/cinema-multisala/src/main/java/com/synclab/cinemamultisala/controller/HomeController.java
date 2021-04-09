package com.synclab.cinemamultisala.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.synclab.cinemamultisala.entity.Film;
import com.synclab.cinemamultisala.entity.Persona;
import com.synclab.cinemamultisala.entity.PostoASedere;
import com.synclab.cinemamultisala.service.FilmService;
import com.synclab.cinemamultisala.service.PersonaService;
import com.synclab.cinemamultisala.service.PostoASedereService;

@Controller
@RequestMapping("/homepage")
public class HomeController {
	
	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private PostoASedereService postoASedereService;
	
	@GetMapping("/home")
	public String homePage(Model model) {
		
		Date data = new Date();
		model.addAttribute("data", data);
		
		return "homepage";
	}
	
	@GetMapping("/provadb")
	public String provaDB(Model model) {
		
		List<Persona> persone =  personaService.getPersone();
		model.addAttribute("persone", persone);
		
		List<Film> listaFilm =  filmService.getFilms();
		model.addAttribute("listaFilm", listaFilm);
		
		List<PostoASedere> posti = postoASedereService.getPosti();
		model.addAttribute("posti", posti);
		
		return "provadb";
	}
	
}
