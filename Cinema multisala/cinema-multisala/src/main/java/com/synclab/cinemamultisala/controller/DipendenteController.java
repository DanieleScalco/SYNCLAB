package com.synclab.cinemamultisala.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.synclab.cinemamultisala.entity.Film;
import com.synclab.cinemamultisala.entity.FilmId;
import com.synclab.cinemamultisala.entity.Orario;
import com.synclab.cinemamultisala.service.FilmService;

@Controller
@RequestMapping("/dipendente")
public class DipendenteController {
	
	private Logger myLogger = Logger.getLogger(DipendenteController.class.getName());

	@Autowired
	FilmService filmService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		// Elimina gli spazi bianchi multipli all'inizio e alla fine e converte in null se solo spazi bianchi
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/aggiungiFilm")
	public String aggiungiFilm(Model model) {
		
		Film film = new Film();
		model.addAttribute("film", film);
		
		return "form-film";
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
		ra.addFlashAttribute("filmEliminato", "\"" + titolo + "\" è stato eliminato completamente dal database");
		
		return "redirect:/programmazione/mostraProgrammazione";
	}
	
	@GetMapping("/eliminaOrario")
	public String eliminaOrario(@RequestParam("titolo") String titolo, @RequestParam("data") String data, @RequestParam("ora") String ora, RedirectAttributes ra) {
		 
        // Converting 'dd-MMM-yyyy' String format to LocalDate
        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(data, formatterData);
        DateTimeFormatter formatterOra = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime localTime = LocalTime.parse(ora, formatterOra);
        
        filmService.eliminaFilm(new FilmId(titolo, localDate, localTime));
        ra.addFlashAttribute("filmEliminato", "Orario eliminato correttamente");
        		
		return "redirect:/programmazione/mostraProgrammazione";
	}	
	
	@GetMapping("/formModificaFilm")
	public String formModificaFilm(@RequestParam("titolo") String titolo, Model model) {
		
		myLogger.info("Film: " + titolo);
		
		LocalDate dataAttuale = LocalDate.now();
		LocalDate dataAttualePiu7 = dataAttuale.plusDays(7);
		List<Film> films = filmService.getFilmFromDayToDay(titolo, dataAttuale, dataAttualePiu7);
		
		model.addAttribute("titolo", films.get(0).getFilmId().getTitolo());
		model.addAttribute("regista", films.get(0).getRegista());
		model.addAttribute("cast", films.get(0).getCast());
		model.addAttribute("descrizione", films.get(0).getDescrizione());
		model.addAttribute("immagine", films.get(0).imageFromByteToString());
		
		List<Orario> orari = new ArrayList<Orario>();
		for (Film f : films) {
			orari.add(new Orario(f.getFilmId().getData(), f.getFilmId().getOraInizio()));
		}
		
		String orariString = "";
		for (Orario tmpOrario: orari) {
			orariString += tmpOrario + " ";
		}
		
		myLogger.info("Orari: " + orariString);
		
		return "modifica-film";
	}
	
	@PostMapping("/modificaFilm")
	public String modificaFilm(@RequestParam("titolo") String titolo, @RequestParam("newTitolo") String newTitolo,
								@RequestParam("regista") String regista, @RequestParam("newRegista") String newRegista,
								@RequestParam("cast") String cast, @RequestParam("newCast") String newCast,
								@RequestParam("descrizione") String descrizione, @RequestParam("newDescrizione") String newDescrizione,
								@RequestParam("img") MultipartFile file, RedirectAttributes ra) {
				
		LocalDate dataAttuale = LocalDate.now();
		LocalDate dataAttualePiu7 = dataAttuale.plusDays(7);
		/*
		myLogger.info("titolo: " + titolo);
		myLogger.info("newTitolo: " + newTitolo);
		myLogger.info("cast: " + cast);
		myLogger.info("newCast: " + newCast);
		myLogger.info("descrizione: " + descrizione);
		myLogger.info("newDescrizione: " + newDescrizione);
		*/
		
		// Attualmente contiene i film non aggiornati, andando avanti terrà i dati sempre più aggiornati
		List<Film> listaFilm = filmService.getFilmFromDayToDay(titolo, dataAttuale, dataAttualePiu7);
		
		// Se il titolo è diverso essendo chiave primaria elimino prendo tutti i film e ne creo una copia con
		// titolo diverso, elimino quello vecchio e salvo quello nuovo
		if (!titolo.equals(newTitolo)) {
			for (Film film : listaFilm) {
				Film filmAggiornato = new Film(newTitolo, film.getFilmId().getData(),film.getFilmId().getOraInizio(),
												descrizione, cast, film.getImmagine(), regista);
				filmService.eliminaFilm(film.getFilmId());
				filmService.salvaFilm(filmAggiornato);
			}
			listaFilm = filmService.getFilmFromDayToDay(newTitolo, dataAttuale, dataAttualePiu7);
		}
		
		// Aggiorno cast nella listaFilm
		if (!cast.equals(newCast)) {
			for (Film film : listaFilm) {
				film.setCast(newCast);
			}
		}
		
		// Aggiorno regista nella listaFilm
		if (!regista.equals(newRegista)) {
			for (Film film : listaFilm) {
				film.setRegista(newRegista);
			}
		}
		
		// Aggiorno descrizione nella listaFilm
		if (!descrizione.equals(newDescrizione)) {
			for (Film film : listaFilm) {
				film.setDescrizione(newDescrizione);
			}
		}
		
		// Aggiorno immagine
		if (!file.isEmpty()) {
			for (Film film : listaFilm) {
				try {
					film.setImmagine(file.getBytes());
				} catch (IOException e) {
					myLogger.info("Errore caricamento immagine");
				}
			}
		}
		
		// Salvataggio listaFilm contente tutti gli aggiornamenti
		for (Film film : listaFilm) {
			filmService.salvaFilm(film);
		}
		
		ra.addFlashAttribute("filmModificato", "I dati del film sono stati aggiornati correttamente");
		
		return "redirect:/programmazione/mostraProgrammazione";
	}
	
	@GetMapping("/formOrario")
	public String formOrario(@RequestParam("titolo") String titolo, Model model) {
		
		model.addAttribute("titolo", titolo);
		
		return "form-orario";
	}
	
	@PostMapping("/aggiungiOrario")
	public String aggiungiOrario(@RequestParam("titolo") String titolo, @RequestParam("data") String data, @RequestParam("ora") String ora, RedirectAttributes ra) {
		
		DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter formatterOra = DateTimeFormatter.ofPattern("HH:mm");
		LocalDate date = LocalDate.parse(data, formatterData);
		LocalTime time = LocalTime.parse(ora, formatterOra);
		
		LocalDate dataAttuale = LocalDate.now();
		LocalDate dataAttualePiu7 = dataAttuale.plusDays(7);
		
		Film film = filmService.getFilmFromDayToDay(titolo, dataAttuale, dataAttualePiu7).get(0);
		Film nuovoFilm = new Film(film);
		nuovoFilm.getFilmId().setData(date);
		nuovoFilm.getFilmId().setOraInizio(time);
		
		filmService.salvaFilm(nuovoFilm);
		
		// Non funziona passare come flashAttribute
		ra.addAttribute("titolo", titolo);
		
		ra.addFlashAttribute("dataAggiunta", "Data aggiunta correttamente");
		
		
		return "redirect:/dipendente/formOrario";
	}
}
