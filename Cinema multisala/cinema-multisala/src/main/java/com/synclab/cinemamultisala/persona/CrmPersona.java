package com.synclab.cinemamultisala.persona;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class CrmPersona {

	@NotBlank(message = "Inserisci la mail")
	@Email(message = "Inserisci un indirizzo mail valido")
	private String mail;
	
	@NotBlank(message = "Inserisci la password")
	@Size(min = 8, message = "La password deve contenere almeno 8 caratteri")
	private String password;
	
	@NotBlank(message = "Reinserisci la password")
	@Size(min = 8, message = "La password deve contenere almeno 8 caratteri")
	private String matchingPassword;

	
	public CrmPersona() {

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Mail: " + mail + ", password: " + password + ", matchingPassword: " + matchingPassword;
	}
	
	

}
