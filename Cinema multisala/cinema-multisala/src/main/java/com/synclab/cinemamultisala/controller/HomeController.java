package com.synclab.cinemamultisala.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.synclab.cinemamultisala.entity.Film;
import com.synclab.cinemamultisala.entity.FilmId;
import com.synclab.cinemamultisala.entity.IdPosto;
import com.synclab.cinemamultisala.entity.Persona;
import com.synclab.cinemamultisala.entity.PostoASedere;
import com.synclab.cinemamultisala.entity.Prenotazione;
import com.synclab.cinemamultisala.persona.CrmPersona;
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
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/home")
	public String homePage(Model model) {
		
		LocalDate dataAttuale = LocalDate.now();
		LocalDate dataAttualePiu7 = dataAttuale.plusDays(7);
		
		// Prendiamo tutti i film disponibili di qui a 7 giorni
		// Si considera che tutti i film in programmazione sono quelli dalla data attuale
		// a 7 giorni dopo
		List<Film> listaFilm =  filmService.getFilmsFromDayToDay(dataAttuale, dataAttualePiu7);
		model.addAttribute("listaFilm", listaFilm);
		
		return "homepage";
	}
	
	@GetMapping("/showRegistrazioneForm")
	public String showRegistrazioneForm(Model model) {
		
		CrmPersona persona = new CrmPersona();
		model.addAttribute("persona", persona);
		
		return "form-registrazione";
	}
	
	@PostMapping("/processRegistrazioneForm")
	public String processRegistrationForm(
				@Valid @ModelAttribute("crmUser") CrmPersona persona, 
				BindingResult theBindingResult, 
				Model model) {
		
		String mail = persona.getMail();
		
		// form validation
		if (theBindingResult.hasErrors()){
			return "form-registrazione";
	    }

		/*
		// check the database if user already exists
        Persona existing = personaService.findByName(mail);
        if (existing != null){
        	model.addAttribute("crmUser", new CrmPersona());
			model.addAttribute("erroreRegistrazione", "Mail già esistente");

        	return "form-registrazione";
        } else {
	        
	        // create user account        						
	        personaService.salvaPersona(persona);
	        myLogger.info("Registrazione Avvenuta");
        }
        */
        return "homepage";
        
	}
	
		
		
		
		
		
	
		
	
	
	
	
}
