package com.synclab.cinemamultisala.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.synclab.cinemamultisala.entity.Persona;
import com.synclab.cinemamultisala.persona.CrmPersona;

public interface PersonaService extends UserDetailsService {
	
	public List<Persona> getPersone();
	
	public Persona getPersona(String mail);
	
	public void salvaPersona(Persona persona);
	
	public void registra(CrmPersona persona);

	public void eliminaPersona(String mail);
	
	boolean esiste(String mail);
}
