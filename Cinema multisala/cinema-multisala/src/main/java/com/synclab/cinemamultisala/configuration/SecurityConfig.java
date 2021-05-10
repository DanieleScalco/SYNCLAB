package com.synclab.cinemamultisala.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.synclab.cinemamultisala.service.PersonaService;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private PersonaService personaService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(personaService); // personaService extends UserDetailsService
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		/*
		 * Path possibili per antMatchers:
		 * /**	matcha tutti i path (i doppi asterischi indicano il livello corrente e tutti quelli sotto)	
		 */
		http.authorizeRequests()
			.antMatchers("/amministratore/**").hasAuthority("AMMINISTRATORE") // Si parte PER FORZA dal più ristretto:
			.antMatchers("/dipendente/**").hasAnyAuthority("DIPENDENTE", "AMMINISTRATORE")
			.antMatchers("/", "/homepage/**", "/scheda/**", "/programmazione/**").permitAll()
			.and()
			.formLogin()
				.loginPage("/homepage/login")
				.usernameParameter("mail")		// Per specificare il nome del campo usato se diverso da "username"
//				.passwordParameter(nomeParametroPasswordAlternativo) // Come sopra ma per "password"
				.permitAll()
			.and()
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // Per poter usare un link
				.permitAll()
			.and()
			.exceptionHandling()
				.accessDeniedPage("/homepage/accesso-negato");

	}	
	
	

	
}
