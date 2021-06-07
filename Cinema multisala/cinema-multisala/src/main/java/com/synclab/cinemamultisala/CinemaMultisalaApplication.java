package com.synclab.cinemamultisala;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* Equivale a :
 *  @Configuration
 *  @EnableAutoConfiguration
 *  @ComponentScan
 */
@SpringBootApplication
public class CinemaMultisalaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaMultisalaApplication.class, args);
	}

}
