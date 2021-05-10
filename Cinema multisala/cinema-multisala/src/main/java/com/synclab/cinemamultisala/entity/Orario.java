package com.synclab.cinemamultisala.entity;

import java.time.LocalDate;
import java.time.LocalTime;

// Classe di supporto per vedere tutti gli orari di un film in programmazione
public class Orario {
	
	private LocalDate data;
	private LocalTime ora;
	
	public Orario(LocalDate data, LocalTime ora) {
		this.data = data;
		this.ora = ora;
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
		return "Data: " + data + ", ora: " + ora;
	}
	
	
	
	
	
}
