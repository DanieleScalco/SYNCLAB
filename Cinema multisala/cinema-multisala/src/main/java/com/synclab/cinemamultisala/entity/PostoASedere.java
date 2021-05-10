package com.synclab.cinemamultisala.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "posto_a_sedere")
public class PostoASedere {

	@EmbeddedId
	private IdPosto idPosto;
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "posti_prenotazione",
			joinColumns = {@JoinColumn(name = "fila"), @JoinColumn(name = "posto"), @JoinColumn(name = "sala")},
			inverseJoinColumns = @JoinColumn(name = "id_prenotazione"))
	private List<Prenotazione> prenotazioniAssociate;
	
	public PostoASedere() {

	}

	public List<Prenotazione> getPrenotazioniAssociate() {
		return prenotazioniAssociate;
	}

	public void setPrenotazioniAssociate(List<Prenotazione> prenotazioniAssociate) {
		this.prenotazioniAssociate = prenotazioniAssociate;
	}

	public PostoASedere(IdPosto idPosto) {
		this.idPosto = idPosto;
	}

	public IdPosto getIdPosto() {
		return idPosto;
	}

	public void setIdPosto(IdPosto idPosto) {
		this.idPosto = idPosto;
	}

	@Override
	public String toString() {
		return idPosto.toString();
	}
	
	
	
	
}
