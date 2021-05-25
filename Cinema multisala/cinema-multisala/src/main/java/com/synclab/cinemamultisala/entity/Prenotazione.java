package com.synclab.cinemamultisala.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prenotazione")
public class Prenotazione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "mail_prenotazione")
	private Persona persona;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumns({@JoinColumn(name = "film", referencedColumnName = "titolo"),
				  @JoinColumn(name = "data", referencedColumnName = "data"),
				  @JoinColumn(name = "orario", referencedColumnName = "ora_inizio"),
				})
	private Film film;
	
	/*
	 * Documentazione:
	 * Note that using @JoinTable or even @JoinColumn isn't required. JPA will generate the table and column
	 * names for us. However, the strategy JPA uses won't always match the naming conventions we use. So, we
	 * need the possibility to configure table and column names.
	 */
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "posti_prenotazione",
			joinColumns = @JoinColumn(name = "id_prenotazione"),
			inverseJoinColumns = {@JoinColumn(name = "fila"), @JoinColumn(name = "posto"), @JoinColumn(name = "sala")})
	private List<PostoASedere> postiASedere;
	
	public Prenotazione() {
		
	}
	
	
	public Prenotazione(Persona persona, Film film, List<PostoASedere> postiASedere) {
		this.persona = persona;
		this.film = film;
		this.postiASedere = postiASedere;
	}



	public List<PostoASedere> getPostiASedere() {
		return postiASedere;
	}

	public void setPostiASedere(List<PostoASedere> postiASedere) {
		this.postiASedere = postiASedere;
	}

	public void aggiungiPosto(PostoASedere posto) {
		if (this.postiASedere == null) {
			this.postiASedere = new ArrayList<PostoASedere>();
		}
		postiASedere.add(posto);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	@Override
	public String toString() {
		String toString = "Id: " + id + ", persona: " + persona.getMail() + ", film: " + film.getFilmId() + ", postiASedere: ";
		for(PostoASedere posto: postiASedere) {
			toString += posto + ", ";
		}
		return toString;
	}
	
	public boolean isInSala(int numeroSala) {
		
		for (PostoASedere p : postiASedere) {
			if (p.getIdPosto().getNumeroSala() == numeroSala)
				return true;
		}
		return false;
	}
	
	
	
	
	
	
	
}
