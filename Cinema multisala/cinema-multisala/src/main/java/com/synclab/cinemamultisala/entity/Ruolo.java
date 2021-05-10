package com.synclab.cinemamultisala.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ruolo")
public class Ruolo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // per l'autoincremento automatico
	@Column(name = "id")
	private int id;
	
	@Column(name = "nome_ruolo")
	private String nomeRuolo;
	
	public Ruolo() {
		
	}

	public Ruolo(String nomeRuolo) {
		this.nomeRuolo = nomeRuolo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeRuolo() {
		return nomeRuolo;
	}

	public void setNomeRuolo(String nomeRuolo) {
		this.nomeRuolo = nomeRuolo;
	}

	@Override
	public String toString() {
		return "Id: " + id + ", nome ruolo: " + nomeRuolo;
	}
	
	
	
	
}
