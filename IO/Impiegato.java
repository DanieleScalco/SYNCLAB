package IO;

import java.io.Serializable;

public class Impiegato implements Serializable{

	String nome;
	String cognome;
	String matricola;
	
	public Impiegato(String nome, String cognome, String matricola) {
		setNome(nome);
		setCognome(cognome);
		setMatricola(matricola);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	
	@ Override
	public String toString() {
		return "Nome: " + nome + ", cognome: " + cognome + ", matricola: " + matricola;
	}
}
