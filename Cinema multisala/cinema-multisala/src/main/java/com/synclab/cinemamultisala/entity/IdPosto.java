package com.synclab.cinemamultisala.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class IdPosto implements Serializable {

	@Column(name="numero_fila")
	private int numeroFila;
	
	@Column(name="numero_posto")
	private int numeroPosto;
	
	@Column(name="numero_sala")
	private int numeroSala;
	
	public IdPosto() {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numeroFila;
		result = prime * result + numeroPosto;
		result = prime * result + numeroSala;
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
		if (numeroFila != other.numeroFila)
			return false;
		if (numeroPosto != other.numeroPosto)
			return false;
		if (numeroSala != other.numeroSala)
			return false;
		return true;
	}

	public int getNumeroFila() {
		return numeroFila;
	}

	public void setNumeroFila(int numeroFila) {
		this.numeroFila = numeroFila;
	}

	public int getNumeroPosto() {
		return numeroPosto;
	}

	public void setNumeroPosto(int numeroPosto) {
		this.numeroPosto = numeroPosto;
	}

	public int getNumeroSala() {
		return numeroSala;
	}

	public void setNumeroSala(int numeroSala) {
		this.numeroSala = numeroSala;
	}
	
	
}
