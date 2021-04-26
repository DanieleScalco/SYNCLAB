package com.synclab.cinemamultisala.persona;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.synclab.cinemamultisala.validation.FieldMatch;
import com.synclab.cinemamultisala.validation.ValidEmail;



@FieldMatch.List({
    @FieldMatch(first = "password", second = "matchingPassword", message = "The password fields must match")
})
public class CrmPersona {

	@ValidEmail
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String mail;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String password;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
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

}
