import java.util.Scanner;
import java.util.InputMismatchException;

public class MultipleQuestion extends NumericQuestion {
	
	// Attributi
	private int numeroRisposte;
	
	// Costruttore
	public MultipleQuestion(String domanda, String rispostaCorretta, int punteggio, int numeroRisposte) {
		super(domanda, rispostaCorretta, punteggio);
		setNumeroRisposte(numeroRisposte);
	}
	
	// Metodi
	public int getNumeroRisposte() {
		return numeroRisposte;
	}
	
	public void setNumeroRisposte(int numeroRisposte) {
		this.numeroRisposte = numeroRisposte;
	}
	
	@ Override
	public int ask() {
		Scanner tastiera = new Scanner(System.in);
		int rispostaUtente = -1;
		int puntiOttenuti = 0;
		int rispostaCorrettaInt = Integer.parseInt(this.getRispostaCorretta());
		boolean inputValido = false;
		
		System.out.println(this.getDomanda());
		while (!inputValido) {
			try {
				rispostaUtente = -1;
				System.out.println("Inserisci il numero della risposta (1-" + getNumeroRisposte() + "):");
				rispostaUtente = tastiera.nextInt();
				if (rispostaUtente <= 0 || rispostaUtente > rispostaCorrettaInt)
					inputValido = false;
				else
					inputValido = true;
			} catch (InputMismatchException e) {
				System.out.println("Errore: inserisci un intero compreso tra 1 e " + getNumeroRisposte());
				tastiera.next();
			}
		}
		
		if (Integer.parseInt(this.getRispostaCorretta()) == rispostaUtente)
			puntiOttenuti += getPunteggio();
		
		return puntiOttenuti;
	}
}