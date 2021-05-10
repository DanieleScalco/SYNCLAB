package com.synclab.cinemamultisala.controller;

import java.io.IOException;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.synclab.cinemamultisala.entity.Film;
import com.synclab.cinemamultisala.service.FilmService;

@Controller
@RequestMapping("/dipendente")
public class DipendenteController {
	
	private Logger myLogger = Logger.getLogger(DipendenteController.class.getName());

	@Autowired
	FilmService filmService;

	@GetMapping("/aggiungiFilm")
	public String aggiungiFilm(Model model) {
		
		Film film = new Film();
		model.addAttribute("film", film);
		
		return "form-aggiunta-film";
	}
	 
	@PostMapping("/processFilm")
	public String processFilm(@ModelAttribute("film") Film film, @RequestParam("img") MultipartFile file, Model model, RedirectAttributes ra) {
		
		if (filmService.existsById(film.getFilmId())) {
			ra.addFlashAttribute("filmGiaEsistente", "Film già presente nel database");
		} else {
			try {
				film.setImmagine(file.getBytes());
			} catch (IOException e) {
				myLogger.info("Errore caricamento immagine");
			}
			filmService.salvaFilm(film);;
			ra.addFlashAttribute("filmSalvato", "Film aggiunto correttamente!");
		}
		
		return "redirect:/dipendente/aggiungiFilm";
		
	}
	
	@GetMapping("/eliminaFilm")
	public String eliminaFilm(@RequestParam("titolo") String titolo, RedirectAttributes ra) {
		
		filmService.eliminaFilm(titolo);
		ra.addFlashAttribute("filmEliminato", "Film eliminati dal database");
		
		return "redirect:/programmazione/mostraProgrammazione";
	}
}
