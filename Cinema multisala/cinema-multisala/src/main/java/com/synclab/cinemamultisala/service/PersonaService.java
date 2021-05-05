package com.synclab.cinemamultisala.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.synclab.cinemamultisala.entity.Persona;
import com.synclab.cinemamultisala.entity.Ruolo;
import com.synclab.cinemamultisala.persona.CrmPersona;

// Estendere UserDetailsService è necessario per l'autenticazione
public interface PersonaService extends UserDetailsService {
	
	public List<Persona> getPersone();
	
	public Persona getPersona(String mail);
	
	public void salvaPersona(Persona persona);
	
	public void registra(CrmPersona persona);

	public void eliminaPersona(String mail);
	
	boolean esiste(String mail);
	
	public List<Ruolo> getRuoli();
}
