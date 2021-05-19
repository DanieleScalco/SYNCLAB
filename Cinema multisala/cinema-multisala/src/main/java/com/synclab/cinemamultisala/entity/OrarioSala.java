package com.synclab.cinemamultisala.entity;

import java.time.LocalDate;
import java.time.LocalTime;

// Classe di supporto per vedere tutti gli orari di un film in programmazione
public class OrarioSala {
	
	private LocalDate data;
	private LocalTime ora;
	private int sala;
	
	public OrarioSala(LocalDate data, LocalTime ora, int sala) {
		this.data = data;
		this.ora = ora;
		this.sala = sala;
	}

	public int getSala() {
		return sala;
	}

	public void setSala(int sala) {
		this.sala = sala;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getOra() {
		return ora;
	}

	public void setOra(LocalTime ora) {
		this.ora = ora;
	}

	@Override
	public String toString() {
		return "Data: " + data + ", ora: " + ora + ", sala: " + sala;
	}
	
	
	
	
	
}
