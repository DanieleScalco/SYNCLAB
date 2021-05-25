package com.synclab.cinemamultisala.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
@RequestMapping("/prenotazione")
public class PrenotazioneController {

	private Logger myLogger = Logger.getLogger(PrenotazioneController.class.getName());

	@Autowired
	PrenotazioneService prenotazioneService;
	
	@Autowired
	FilmService filmService;
	
	@Autowired
	PersonaService personaService;
	
	@Autowired
	PostoASedereService postoASedereService;

	@GetMapping("prenota")
	public String prenota(@RequestParam("numeroSala") String sala, @RequestParam("titolo") String titolo,
							@RequestParam("data") String data, @RequestParam("ora") String ora, Model model) {
		
		int numeroSala = Integer.parseInt(sala);
		
		DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(data, formatterData);
        DateTimeFormatter formatterOra = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime localTime = LocalTime.parse(ora, formatterOra);
        
        /*
		myLogger.info("numeroSala: " + numeroSala);
		myLogger.info("titolo: " + titolo);
		myLogger.info("data: " + data);
		myLogger.info("ora: " + ora);*/
		
		List<Prenotazione> prenotazioni = prenotazioneService.getPrenotazioniInSala(numeroSala, localDate, localTime);
		
		for (Prenotazione p : prenotazioni) {
			myLogger.info("Prenotazione: " + p);
			List<PostoASedere> posti = p.getPostiASedere();
			for (PostoASedere tmpPosto: posti) {
				if (tmpPosto.getIdPosto().getFila().equals("A") && tmpPosto.getIdPosto().getNumeroPosto() == 1)
					model.addAttribute("A1", true);
				if (tmpPosto.getIdPosto().getFila().equals("A") && tmpPosto.getIdPosto().getNumeroPosto() == 2)
					model.addAttribute("A2", true);
				if (tmpPosto.getIdPosto().getFila().equals("B") && tmpPosto.getIdPosto().getNumeroPosto() == 1)
					model.addAttribute("B1", true);
				if (tmpPosto.getIdPosto().getFila().equals("B") && tmpPosto.getIdPosto().getNumeroPosto() == 2)
					model.addAttribute("B2", true);
			}
		}
		
		model.addAttribute("numeroSala", numeroSala);
		model.addAttribute("data", data);
		model.addAttribute("ora", ora);
		model.addAttribute("titolo", titolo);
		
		return "sala";
	}

	@GetMapping("/esitoPrenotazione")
	public String esitoPrenotazione(@RequestParam("posti") String[] posti, @RequestParam("titolo") String titolo,
									@RequestParam("data") String data, @RequestParam("ora") String ora,
									@RequestParam("numeroSala") String numeroSala, Model model) {
		
		// I posti selezionati sono per forza liberi dato che quelli prenotati non sono selezionabili
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String mail = authentication.getName();
		Persona persona = personaService.getPersona(mail);
		myLogger.info("Mail: " + persona.getMail());
		
		DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(data, formatterData);
        DateTimeFormatter formatterOra = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime localTime = LocalTime.parse(ora, formatterOra);
        
		Film film = filmService.getFilm(new FilmId(titolo, localDate, localTime));
		myLogger.info("Film:" + film.getFilmId());
		
		List<PostoASedere> postiASedere = new ArrayList<PostoASedere>();
		for (int i = 0; i < posti.length; i++) {
			String fila = posti[i].substring(0, 1);
			int numeroPosto = Integer.parseInt(posti[i].substring(1, 2));
			int sala = Integer.parseInt(numeroSala);
			PostoASedere posto = postoASedereService.getPosto(new IdPosto(fila, numeroPosto, sala));
			postiASedere.add(posto);
			myLogger.info("Posto: " + posto);
		}
		
		Prenotazione prenotazione = new Prenotazione(persona, film, postiASedere);
		model.addAttribute("prenotazione", prenotazione);
		myLogger.info("Prenotazione: " + prenotazione);
		
		prenotazioneService.salvaPrenotazione(prenotazione);
		
		return "esito-prenotazione";
	}
}
