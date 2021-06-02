package com.synclab.cinemamultisala.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Base64;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "film")
public class Film {

	// Necessario per chiavi multiattributo
	@EmbeddedId
	private FilmId filmId;
	
	@Column(name = "descrizione")
	private String descrizione;
	
	@Column(name = "cast")
	private String cast;
	
	@Lob
	@Column(name = "immagine")
	private byte[] immagine;
	
	@Column(name = "regista")
	private String regista;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "sala")
	private Sala sala;
	
	// Le prenotazioni non servono, ma è stato aggiunto perchè altrimenti dava errore
	// se si elimina un film con delle prenotazioni associate
	@OneToMany(mappedBy = "film", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
	private List<Prenotazione> prenotazioni;
	
	public Film() {
		
	}

	public Film(FilmId filmId, String descrizione, String cast, byte[] immagine, String regista, Sala sala) {
		this.filmId = filmId;
		this.descrizione = descrizione;
		this.cast = cast;
		this.immagine = immagine;
		this.regista = regista;
		this.sala = sala;
	}
	
	public Film(String titolo, LocalDate data, LocalTime ora, String descrizione, String cast, byte[] immagine, String regista, Sala sala) {
		this(new FilmId(titolo, data, ora), descrizione, cast, immagine, regista, sala);
	}
	
	public Film(Film film){
		this(film.getFilmId(), film.getDescrizione(), film.getCast(), film.getImmagine(), film.getRegista(), film.getSala());
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
	
	// Trasforma i byte in una stringa per poterla passare al model e visualizzarla
	public String imageFromByteToString() {
		String stringa = null;
		stringa = Base64.getEncoder().encodeToString(immagine);
		
		return stringa;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	@Override
	public String toString() {
		return filmId.toString() + ", descrizione: " + descrizione + ", cast: " + cast + ", immagine: " +
				immagine + ", regista: " + regista + ", sala: " + sala;
	}
	
	
	
	
	
}
