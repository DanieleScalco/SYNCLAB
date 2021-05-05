package com.synclab.cinemamultisala.controller;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.synclab.cinemamultisala.entity.Persona;
import com.synclab.cinemamultisala.entity.Ruolo;
import com.synclab.cinemamultisala.service.PersonaService;

@Controller
@RequestMapping("/amministratore")
public class AmministratoreController {

	private Logger myLogger = Logger.getLogger(AmministratoreController.class.getName());

	@Autowired
	PersonaService personaService;	
	
	@GetMapping("/listaPersone")
	public String listaPersone(Model model) {
		
		List<Persona> persone = personaService.getPersone();
		model.addAttribute("persone", persone);
		
		return "lista-persone";
	}
	
	@GetMapping("showFormForAdd")
	public String aggiungiPersona(Model model) {
		
		Persona persona = new Persona();
		model.addAttribute("persona", persona);
		
		Collection<Ruolo> ruoli = personaService.getRuoli();
		model.addAttribute("ruoli", ruoli);
		
		return "form-aggiunta-persona";
	}
	
	@PostMapping("/salvaUtente")
	public String salvaUtente(@ModelAttribute("persona") Persona persona, RedirectAttributes ra) {
		
		myLogger.info("Persona: " + persona);
		if (personaService.esiste(persona.getMail())) {
			ra.addFlashAttribute("statoUtente", "Utente modificato correttamente");
		} else {
			ra.addFlashAttribute("statoUtente", "Utente aggiunto correttamente");
		}
		personaService.salvaPersona(persona);
		
		return "redirect:/amministratore/listaPersone";
	}
}
