package com.synclab.cinemamultisala.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synclab.cinemamultisala.dao.PrenotazioneRepository;
import com.synclab.cinemamultisala.entity.Prenotazione;

@Service
public class PrenotazioneServiceImpl implements PrenotazioneService {

	@Autowired
	private PrenotazioneRepository prenotazioneRepository;
	
	@Override
	public List<Prenotazione> getPrenotazioni() {
		return prenotazioneRepository.findAll();
	}

	@Override
	public Prenotazione getPrenotazione(int id) {
		Optional<Prenotazione> result = prenotazioneRepository.findById(id);
		
		Prenotazione prenotazione = null;
		if (result.isPresent()) {
			prenotazione = result.get();
		} else {
			throw new RuntimeException("Prenotazione non trovata per id - " + id);
		}
		
		return prenotazione;
	}

	@Override
	public void salvaPrenotazione(Prenotazione prenotazione) {
		prenotazioneRepository.save(prenotazione);
	}

	@Override
	public void eliminaPrenotazione(int id) {
		prenotazioneRepository.deleteById(id);
	}
	
	@Override
	public List<Prenotazione> getPrenotazioniInSala(int numeroSala, LocalDate data, LocalTime ora) {
		
		List<Prenotazione> prenotazioni = prenotazioneRepository.findAll();
		List<Prenotazione> prenotazioniInSala = new ArrayList<Prenotazione>();
		
		for (Prenotazione p: prenotazioni) {
			if (p.isInSala(numeroSala) && p.getFilm().getFilmId().getData().equals(data) && p.getFilm().getFilmId().getOraInizio().equals(ora))
				prenotazioniInSala.add(p);
		}
		
		return prenotazioniInSala;
	}
	
	

}
