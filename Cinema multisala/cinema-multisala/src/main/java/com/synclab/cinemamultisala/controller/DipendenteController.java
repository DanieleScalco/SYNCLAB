package com.synclab.cinemamultisala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dipendente")
public class DipendenteController {

	 @GetMapping("/aggiungiFilm")
	 public String aggiungiFilm() {
		 return "aggiunta-film";
	 }
}
