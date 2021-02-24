import java.util.Scanner;

public class NumericQuestion extends Question {
	
	// Costruttori
	public NumericQuestion(String domanda, String rispostaCorretta, int punteggio) {
		super(domanda, rispostaCorretta, punteggio);
	}
	
	// Metodi
	@ Override
	public void setRispostaCorretta(String risposta) {
		try {
			int i = Integer.parseInt(risposta);
			super.setRispostaCorretta(risposta);
		} catch (Exception e) {
			System.out.println("NumericQuestion necessita di un numero intero come risposta");
			System.exit(0);
		}
	}
	
	@ Override
	public int ask() {
		Scanner tastiera = new Scanner(System.in);
		int rispostaUtente;
		String rispostaUtenteS;
		int puntiOttenuti = 0;
		
		System.out.println(this.getDomanda());
		rispostaUtenteS = "";
		System.out.println("Inserisci un intero come risposta:");
		rispostaUtente = tastiera.nextInt();
		rispostaUtenteS += rispostaUtente;
		if (getRispostaCorretta().equalsIgnoreCase(rispostaUtenteS))
			puntiOttenuti += getPunteggio();
		
		return puntiOttenuti;
	}
}