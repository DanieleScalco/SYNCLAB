package com.synclab.cinemamultisala.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
import com.synclab.cinemamultisala.entity.OrarioSala;
import com.synclab.cinemamultisala.entity.Sala;
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
		
		List<Sala> listaSale = filmService.getSale();
		model.addAttribute("listaSale", listaSale);
		
		return "form-film";
	}
	 
	@PostMapping("/processFilm")
	public String processFilm(@ModelAttribute("film") Film film, @RequestParam("img") MultipartFile file, Model model, RedirectAttributes ra, BindingResult bindingResult) {
		
		boolean filmDaAggiungere = true;
		
		if (filmService.existsById(film.getFilmId())) {
			ra.addFlashAttribute("filmGiaEsistente", "Film già presente nel database in quell'orario");
		} else {
			
			filmDaAggiungere = possibileInserireFilmInSala(film, film.getSala().getNumeroSala());

			if (filmDaAggiungere) {
				
				try {
					film.setImmagine(file.getBytes());
				} catch (IOException e) {
					myLogger.info("Errore caricamento immagine");
				}
				
				filmService.salvaFilm(film);;
				ra.addFlashAttribute("filmSalvato", "Film aggiunto correttamente!");
				
			} else {
				
				List<String> problemaOrario = new ArrayList<>();
				problemaOrario.add("Impossibile aggiungere il film, ci devono essere almeno due ore di distacco tra un film e l'altro nella stessa sala");
				problemaOrario.add("Cambia orario oppure la sala");
				ra.addFlashAttribute("problemaOrario", problemaOrario);
			}
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
		
		List<OrarioSala> orari = new ArrayList<OrarioSala>();
		for (Film f : films) {
			orari.add(new OrarioSala(f.getFilmId().getData(), f.getFilmId().getOraInizio(), f.getSala().getNumeroSala()));
		}
		
		String orariString = "";
		for (OrarioSala tmpOrario: orari) {
			orariString += tmpOrario + " ";
		}
		
		
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
		
		// Attualmente contiene i film non aggiornati, andando avanti terrà i dati sempre più aggiornati
		List<Film> listaFilm = filmService.getFilmFromDayToDay(titolo, dataAttuale, dataAttualePiu7);
		
		// Se il titolo è diverso essendo chiave primaria elimino prendo tutti i film e ne creo una copia con
		// titolo diverso, elimino quello vecchio e salvo quello nuovo
		if (!titolo.equals(newTitolo)) {
			for (Film film : listaFilm) {
				Film filmAggiornato = new Film(newTitolo, film.getFilmId().getData(),film.getFilmId().getOraInizio(),
												descrizione, cast, film.getImmagine(), regista, film.getSala());
				filmService.eliminaFilm(film.getFilmId());
				filmService.salvaFilm(filmAggiornato);
			}
			// Recupero i film col nuovo titolo appena salvati
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
		
		List<Sala> listaSale = filmService.getSale();
		model.addAttribute("listaSale", listaSale);
		
		return "form-orario";
	}
	
	@PostMapping("/aggiungiOrario")
	public String aggiungiOrario(@RequestParam("titolo") String titolo, @RequestParam("data") String data,
								@RequestParam("ora") String ora, @RequestParam("sala") int numeroSala,  RedirectAttributes ra) {
		
		DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter formatterOra = DateTimeFormatter.ofPattern("HH:mm");
		LocalDate date = LocalDate.parse(data, formatterData);
		LocalTime time = LocalTime.parse(ora, formatterOra);
		
		Sala sala = filmService.getSala(numeroSala);
		
		LocalDate dataAttuale = LocalDate.now();
		LocalDate dataAttualePiu7 = dataAttuale.plusDays(7);
		
		Film film = filmService.getFilmFromDayToDay(titolo, dataAttuale, dataAttualePiu7).get(0);
		Film nuovoFilm = new Film(film);
		nuovoFilm.getFilmId().setData(date);
		nuovoFilm.getFilmId().setOraInizio(time);
		nuovoFilm.setSala(sala);
		
		
		boolean filmDaAggiungere = possibileInserireFilmInSala(nuovoFilm, numeroSala);
		
		if (filmDaAggiungere) {
			filmService.salvaFilm(nuovoFilm);
			ra.addFlashAttribute("dataAggiunta", "Orario aggiunto correttamente");
		} else {
			List<String> problemaOrario = new ArrayList<>();
			problemaOrario.add("Impossibile aggiungere il film, ci devono essere almeno due ore di distacco tra un film e l'altro nella stessa sala");
			problemaOrario.add("Cambia orario oppure la sala");
			ra.addFlashAttribute("problemaOrario", problemaOrario);
		}
		
		// Non funziona passare come flashAttribute
		ra.addAttribute("titolo", titolo);
		
		return "redirect:/dipendente/formOrario";
	}
	
	public boolean possibileInserireFilmInSala(Film film, int numeroSala) {
		
		// Controllo i film presenti nella stessa sala
		List<Film> filmInSala = filmService.getFilmInSala(numeroSala);
		
		// Controllo che l'orario che si vuole aggiungere disti di almeno due ore da quelli già presenti
		for (Film f : filmInSala) {
			
			// Se hanno la stessa data controlla gli orari
			if (f.getFilmId().getData().equals(film.getFilmId().getData())) {
				
				long differenzaInOre = f.getFilmId().getOraInizio().until(film.getFilmId().getOraInizio(), ChronoUnit.HOURS);
				
				if (Math.abs(differenzaInOre) < 2) {
					return false;
				} 
			}
		}
		
		return true;
	}
}
