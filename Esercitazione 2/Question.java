import java.util.Scanner;

public class Question {
	
	// Attributi
	private String domanda;
	private String rispostaCorretta;
	private int punteggio;
	
	// Costruttori
	public Question(String domanda, String rispostaCorretta, int punteggio) {
		setDomanda(domanda);
		setRispostaCorretta(rispostaCorretta);
		setPunteggio(punteggio);
	}
	
	
	// Metodi
	public String getDomanda() {
		return domanda;
	}
	
	public String getRispostaCorretta() {
		return rispostaCorretta;
	}
	
	public int getPunteggio() {
		return punteggio;
	}
	
	public void setDomanda(String domanda) {
		this.domanda = domanda;
	}
	
	public void setRispostaCorretta(String risposta) {
		rispostaCorretta = risposta;
	}
	
	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}
	
	public int ask() {
		Scanner tastiera = new Scanner(System.in);
		String rispostaUtente;
		int puntiOttenuti = 0;
		
		System.out.println(domanda);
		System.out.println("Inserisci la risposta:");
		rispostaUtente = tastiera.nextLine();
		if (rispostaCorretta.equalsIgnoreCase(rispostaUtente))
			puntiOttenuti += punteggio;
		
		return puntiOttenuti;
	}
	
}