package com.synclab.cinemamultisala.entity;

import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="film")
public class Film {

	@EmbeddedId
	private FilmId filmId;
	
	@Column(name="descrizione")
	private String descrizione;
	
	@Column(name="cast")
	private String cast;
	
	@Lob
	@Column(name="immagine")
	private byte[] immagine;
	
	@Column(name="regista")
	private String regista;
	
	public Film() {
		
	}

	public Film(FilmId filmId, String descrizione, String cast, byte[] immagine, String regista) {
		this.filmId = filmId;
		this.descrizione = descrizione;
		this.cast = cast;
		this.immagine = immagine;
		this.regista = regista;
	}

	public FilmId getFilmId() {
		return filmId;
	}

	public void setFilmId(FilmId filmId) {
		this.filmId = filmId;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public byte[] getImmagine() {
		return immagine;
	}

	public void setImmagine(byte[] immagine) {
		this.immagine = immagine;
	}

	public String getRegista() {
		return regista;
	}

	public void setRegista(String regista) {
		this.regista = regista;
	}
	
	public String imageFromByteToString() {
		String stringa = null;
		stringa = Base64.getEncoder().encodeToString(immagine);
		
		return stringa;
	}

	@Override
	public String toString() {
		return filmId.toString() + ", descrizione: " + descrizione + ", cast: " + cast + ", immagine: " +
				immagine + ", regista: " + regista;
	}
	
	
	
	
	
}
