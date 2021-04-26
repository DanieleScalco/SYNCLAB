package com.synclab.cinemamultisala.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="persona")
public class Persona {
	
	@Id
	@Column(name="mail")
	private String mail;
	
	@Column(name="password")
	private String password;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="persona", cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Prenotazione> prenotazioni;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "persona_ruolo", 
				joinColumns = @JoinColumn(name = "mail"), 
				inverseJoinColumns = @JoinColumn(name = "id_ruolo"))
	private Collection<Ruolo> ruoli;
	
	public Persona() {
		
	}

	public Persona(String mail, String password) {
		this.mail = mail;
		this.password = password;
	}
	
	

	public Persona(String mail, String password, Collection<Ruolo> ruoli) {
		this.mail = mail;
		this.password = password;
		this.ruoli = ruoli;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(List<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

	public Collection<Ruolo> getRuoli() {
		return ruoli;
	}

	public void setRuoli(Collection<Ruolo> ruoli) {
		this.ruoli = ruoli;
	}

	@Override
	public String toString() {
		return "Mail: " + mail + ", password: " + password + ", ruoli: " + ruoli;
	}
	
	
}
