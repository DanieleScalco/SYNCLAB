import java.util.Scanner;

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
		int rispostaUtente;
		int puntiOttenuti = 0;
		int rispostaCorrettaInt = Integer.parseInt(this.getRispostaCorretta());
		
		System.out.println(this.getDomanda());
		do {
			rispostaUtente = -1;
			System.out.println("Inserisci il numero della risposta:");
			rispostaUtente = tastiera.nextInt();
		} while (rispostaUtente <= 0 || rispostaUtente > rispostaCorrettaInt);
		if (Integer.parseInt(this.getRispostaCorretta()) == rispostaUtente)
			puntiOttenuti += getPunteggio();
		
		return puntiOttenuti;
	}
}