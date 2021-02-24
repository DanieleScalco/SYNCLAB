import java.util.Scanner;

public class QuestionYesNo extends Question {
	
	// Costruttori
	public QuestionYesNo(String domanda, String rispostaCorretta, int punteggio) {
		super(domanda, rispostaCorretta, punteggio);
	}
	
	// Metodi
	@ Override
	public void setRispostaCorretta(String risposta) {
		if (!(risposta.equalsIgnoreCase("S") || risposta.equalsIgnoreCase("N")))
			risposta = "S";
		super.setRispostaCorretta(risposta);
	}
	
	@ Override
	public int ask() {
		Scanner tastiera = new Scanner(System.in);
		String rispostaUtente;
		int puntiOttenuti = 0;
		
		System.out.println(this.getDomanda());
		do {
			System.out.println("Inserisci [S/N]:");
			rispostaUtente = tastiera.nextLine();
		} while (!(rispostaUtente.equalsIgnoreCase("S") || rispostaUtente.equalsIgnoreCase("N")));
		if (getRispostaCorretta().equalsIgnoreCase(rispostaUtente))
			puntiOttenuti += getPunteggio();
		
		return puntiOttenuti;
	}
}