package com.synclab.cinemamultisala.service;

import java.util.List;

import com.synclab.cinemamultisala.entity.Persona;

public interface PersonaService {
	
	public List<Persona> getPersone();
	
	public Persona getPersona(String mail);
	
	public void salvaPersona(Persona persona);
	
	public void eliminaPersona(String mail);
	// prova
	public Persona findByName(String name);
}
