package com.synclab.cinemamultisala.entity;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FilmId implements Serializable{

	@Column(name="titolo")
	private String titolo;
	
	@Column(name="data")
	private Date data;
	
	@Column(name="ora_inizio")
	private LocalTime oraInizio;
	
	public FilmId() {
		
	}

	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	public LocalTime getOraInizio() {
		return oraInizio;
	}


	public void setOraInizio(LocalTime oraInizio) {
		this.oraInizio = oraInizio;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((oraInizio == null) ? 0 : oraInizio.hashCode());
		result = prime * result + ((titolo == null) ? 0 : titolo.hashCode());
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
		FilmId other = (FilmId) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (oraInizio == null) {
			if (other.oraInizio != null)
				return false;
		} else if (!oraInizio.equals(other.oraInizio))
			return false;
		if (titolo == null) {
			if (other.titolo != null)
				return false;
		} else if (!titolo.equals(other.titolo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Titolo: " + titolo + ", data: " + data + ", orario di inizio: " + oraInizio;
	}
	
	
}
