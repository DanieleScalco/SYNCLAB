package com.synclab.cinemamultisala.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.synclab.cinemamultisala.controller.HomeController;
import com.synclab.cinemamultisala.dao.PersonaRepository;
import com.synclab.cinemamultisala.dao.RuoloRepository;
import com.synclab.cinemamultisala.entity.Persona;
import com.synclab.cinemamultisala.entity.Ruolo;
import com.synclab.cinemamultisala.persona.CrmPersona;

@Service
public class PersonaServiceImpl implements PersonaService{

	private Logger myLogger = Logger.getLogger(PersonaServiceImpl.class.getName());

	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private RuoloRepository ruoloRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
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
		persona.setPassword(bCryptPasswordEncoder.encode(persona.getPassword()));
		personaRepository.save(persona);
	}
	
	@Override
	public void registra(CrmPersona crmPersona) {
		Persona persona = new Persona();
		
		String passwordCriptata = bCryptPasswordEncoder.encode(crmPersona.getPassword());
		persona.setMail(crmPersona.getMail());
		persona.setPassword(passwordCriptata);
		
		// Di default si viene registrati come utenti
		persona.setRuoli(Arrays.asList(ruoloRepository.findRoleByName("UTENTE")));
		
		personaRepository.save(persona);

	}

	@Override
	public void eliminaPersona(String mail) {
		personaRepository.deleteById(mail);		
	}
	
	@Override
	public boolean esiste(String mail) {
		if (mail != null)
			return personaRepository.findById(mail).isPresent();
		else
			return false;
	}
	
	@Override
	public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
		/*
		 * Per stampare la stack trace e vedere tutti i metodi chiamanti
		 * 
		 * StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		 * for (StackTraceElement elem: stackTraceElements) {
		 * 		myLogger.info("Stack: " + elem);
		 *	}
		 */
		
		Persona persona = personaRepository.findByMail(mail);
		
		if (persona == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(persona.getMail(), persona.getPassword(),
				mapRolesToAuthorities(persona.getRuoli()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Ruolo> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNomeRuolo())).collect(Collectors.toList());
	}
	
	public List<Ruolo> getRuoli() {
		return ruoloRepository.findAll();
	}


}
