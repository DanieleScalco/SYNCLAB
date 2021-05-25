package com.synclab.cinemamultisala.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class IdPosto implements Serializable {

	@Column(name = "fila")
	private String fila;
	
	@Column(name = "numero_posto")
	private int numeroPosto;
	
	@Column(name = "sala")
	private int sala;
	
	public IdPosto() {
		
	}

	public IdPosto(String fila, int numeroPosto, int sala) {
		this.fila = fila;
		this.numeroPosto = numeroPosto;
		this.sala = sala;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fila == null) ? 0 : fila.hashCode());
		result = prime * result + numeroPosto;
		result = prime * result + sala;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdPosto other = (IdPosto) obj;
		if (fila == null) {
			if (other.fila != null)
				return false;
		} else if (!fila.equals(other.fila))
			return false;
		if (numeroPosto != other.numeroPosto)
			return false;
		if (sala != other.sala)
			return false;
		return true;
	}

	public String getFila() {
		return fila;
	}

	public void setFila(String fila) {
		this.fila = fila;
	}

	public int getNumeroPosto() {
		return numeroPosto;
	}

	public void setNumeroPosto(int numeroPosto) {
		this.numeroPosto = numeroPosto;
	}

	public int getNumeroSala() {
		return sala;
	}

	public void setNumeroSala(int sala) {
		this.sala = sala;
	}

	@Override
	public String toString() {
		return "Fila: " + fila + ", numero posto: " + numeroPosto + ", id sala: " + sala;
	}
	
	
	
	
}
