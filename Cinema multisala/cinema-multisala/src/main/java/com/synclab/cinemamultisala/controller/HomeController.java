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
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.synclab.cinemamultisala.entity.Film;
import com.synclab.cinemamultisala.persona.CrmPersona;
import com.synclab.cinemamultisala.service.FilmService;
import com.synclab.cinemamultisala.service.PersonaService;


// Gestisce homepage, registrazione e login

@Controller
@RequestMapping("/homepage")
public class HomeController {
	
	private Logger myLogger = Logger.getLogger(HomeController.class.getName());

	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private FilmService filmService;
		
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		// Elimina gli spazi bianchi multipli all'inizio e alla fine e converte in null se solo spazi bianchi
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	
	@GetMapping("/home")
	public String homePage(Model model) {
		
		LocalDate dataAttuale = LocalDate.now();
		LocalDate dataAttualePiu7 = dataAttuale.plusDays(7);
		
		// Prendiamo tutti i film disponibili di qui a 7 giorni
		// Si considera che tutti i film in programmazione siano quelli dalla data attuale
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
	public String processRegistrationForm(@Valid @ModelAttribute("persona") CrmPersona persona,
											BindingResult theBindingResult, RedirectAttributes registrazioneAvvenuta) {
	// RedirectAttributes sono gli attributi passati al model quando si fa la redirect
		
		
		String mail = persona.getMail();
		
		// Controllo se utente già registrato
		if (personaService.esiste(mail)) {
			// A quale ModelAttribute è riferito, a quale campo e che errore mostrare 
			theBindingResult.addError(new FieldError("persona", "mail", "Account già registrato"));
		}
		
		// Controllo se le due password coincidono
		if (persona.getPassword() != null && persona.getMatchingPassword() != null) {
			if (!persona.getPassword().equals(persona.getMatchingPassword())) {
				theBindingResult.addError(new FieldError("persona", "password", "Le due password devono coincidere"));
				theBindingResult.addError(new FieldError("persona", "matchingPassword", "Le due password devono coincidere"));
			}
		}
		
		if (theBindingResult.hasErrors()){
			return "form-registrazione";
	    } else {
	        
	        // Salvataggio dell'utente nel db   						
	        personaService.registra(persona, null);
	        registrazioneAvvenuta.addFlashAttribute("registrazioneAvvenuta", "Registrazione avvenuta con successo!");
        }
        
        return "redirect:/homepage/home";  
	}
	
	@GetMapping("/login")
	public String login() {
		return "form-login";
	}
	
	@GetMapping("/accesso-negato")
	public String accessoNegato() {
		return "accesso-negato";
	}
	
		
		
		
		
		
	
		
	
	
	
	
}
