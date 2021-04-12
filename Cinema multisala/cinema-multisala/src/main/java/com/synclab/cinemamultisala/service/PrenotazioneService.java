package com.synclab.cinemamultisala.service;

import java.util.List;

import com.synclab.cinemamultisala.entity.Prenotazione;

public interface PrenotazioneService {

	public List<Prenotazione> getPrenotazioni();
	
	public Prenotazione getPrenotazione(int id);
	
	public void salvaPrenotazione(Prenotazione prenotazione);
	
	public void eliminaPrenotazione(int id);
}
