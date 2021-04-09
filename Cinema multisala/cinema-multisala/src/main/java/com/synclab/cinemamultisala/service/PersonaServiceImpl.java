package com.synclab.cinemamultisala.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synclab.cinemamultisala.dao.PersonaRepository;
import com.synclab.cinemamultisala.entity.Persona;

@Service
public class PersonaServiceImpl implements PersonaService{

	@Autowired
	private PersonaRepository personaRepository;
	
	@Override
	public List<Persona> getPersone() {
		return personaRepository.findAll();
	}

	@Override
	public Persona getPersona(String mail) {
		Optional<Persona> result = personaRepository.findById(mail);
		
		Persona persona = null;
		if (result.isPresent()) {
			persona = result.get();
		} else {
			throw new RuntimeException("Persona non trovata per id - " + mail);
		}
		
		return persona;
	}

	@Override
	public void salvaPersona(Persona persona) {
		personaRepository.save(persona);
	}

	@Override
	public void eliminaPersona(String mail) {
		personaRepository.deleteById(mail);		
	}
	
	@Override
	public Persona findByName(String name) {
		return personaRepository.findByName(name);
	}

}
