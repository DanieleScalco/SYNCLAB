package com.synclab.cinemamultisala.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.synclab.cinemamultisala.dao.RuoloRepository;
import com.synclab.cinemamultisala.entity.Persona;
import com.synclab.cinemamultisala.entity.Ruolo;
import com.synclab.cinemamultisala.persona.CrmPersona;
import com.synclab.cinemamultisala.service.PersonaService;

import ch.qos.logback.classic.joran.ReconfigureOnChangeTaskListener;

@Controller
@RequestMapping("/amministratore")
public class AmministratoreController {

	private Logger myLogger = Logger.getLogger(AmministratoreController.class.getName());

	@Autowired
	PersonaService personaService;
	
	@Autowired
	RuoloRepository ruoloRepository;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		// Elimina gli spazi bianchi multipli all'inizio e alla fine e converte in null se solo spazi bianchi
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/listaPersone")
	public String listaPersone(Model model) {
		
		List<Persona> persone = personaService.getPersone();
		model.addAttribute("persone", persone);
		
		return "lista-persone";
	}
	
	@GetMapping("showFormForAdd")
	public String aggiungiPersona(Model model) {
		
		CrmPersona persona = new CrmPersona();
		model.addAttribute("persona", persona);
		
		return "form-aggiunta-persona";
	}
	
	@PostMapping("/salvaUtente")
	public String salvaUtente(@Valid @ModelAttribute("persona") CrmPersona persona, 
								BindingResult theBindingResult, @RequestParam(name="ruoli", required=false) String[] ruoli, RedirectAttributes ra) {

		if (ruoli == null) {
			theBindingResult.addError(new ObjectError("erroreRuolo", "Inserisci almeno un ruolo"));
			myLogger.info("Errore");
		}
		
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
			return "form-aggiunta-persona";//"redirect:/amministratore/showFormForAdd";
	    } else {
	        
	        // Salvataggio dell'utente nel db 
	    	Collection<Ruolo> listaRuoli = new ArrayList<Ruolo>();
	    	for (String r : ruoli) {
	    			Ruolo tmpRuolo = ruoloRepository.findRoleByName(r);
	    			listaRuoli.add(tmpRuolo);
	    	}
	    	
	        personaService.registra(persona, listaRuoli);
	        ra.addFlashAttribute("utenteAggiunto", "Registrazione avvenuta con successo!");
        }
		
		return "redirect:/amministratore/listaPersone";
	}
	
	@GetMapping("/showFormForUpdate")
	public String modificaUtente(@RequestParam("mail") String mail, Model model) {
		
		Persona persona = personaService.getPersona(mail);
		model.addAttribute("persona", persona);
		//model.addAttribute("mail", mail);
		
		Collection<Ruolo> ruoli = personaService.getRuoli();
		model.addAttribute("ruoli", ruoli);
		
		return "form-ruoli-persona";
	}
	
	@PostMapping("/modificaRuoli")
	public String modificaRuoli(@ModelAttribute("persona") Persona persona, RedirectAttributes ra) {
		
		if (persona.getRuoli().isEmpty()) {
			ra.addFlashAttribute("ruoloMancante", "Inserisci almeno un ruolo");
			String redirect = "redirect:/amministratore/showFormForUpdate";
			redirect += "?mail=" + persona.getMail();
			return redirect;
		}
		
		personaService.salvaPersona(persona);
		ra.addFlashAttribute("ruoliModificati", "Ruoli modificati correttamente");
		
		return "redirect:/amministratore/listaPersone";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("mail") String mail, Model model, RedirectAttributes ra) {
		
		personaService.eliminaPersona(mail);
		ra.addFlashAttribute("statoUtente", "Utente eliminato correttamente");
		
		return "redirect:/amministratore/listaPersone";
	}
}
