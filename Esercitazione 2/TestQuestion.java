import java.util.Random;

public class TestQuestion {
	
	/* 5 Scrivere la classe Question i cui oggetti rappresentano domande di
	esami orali. Ogni quesito si compone di una domanda, di una risposta
	corretta e di un punteggio, e mette a disposizione un metodo ask() che
	stampa la domanda, legge la risposta dell’utente e restituisce il
	punteggio conseguito (0 se la risposta dell’utente `e sbagliata).
	Scrivere la classe QuestionYesNo che estende la classe Question in modo
	da rappresentare domande a cui possa essere risposto solo si o no.
	Sovrascrivere il metodo ask() in modo da garantire che l’utente risponda
	si o no (prima che venga restituito il punteggio conseguito). Scrivere
	la classe NumericQuestion che estende la classe Question in modo da
	rappresentare domande a cui possa essere risposto solo con un valore
	intero. Sovrascrivere il metodo ask() in modo da garantire che l’utente
	risponda con un valore intero (prima che venga restituito il punteggio
	conseguito). Scrivere la classe MultipleQuestion che estende la classe
	NumericQuestion in modo da rappresentare domande che offrono un certo
	numero di opzioni (prefissato) e alle quali possa essere risposto solo
	con un valore intero positivo minore o uguale al numero di opzioni
	disponibili. Sovrascrivere il metodo ask() in modo da garantire che
	l’utente risponda con un valore consentito (prima che venga restituito
	il punteggio conseguito). Scrivere il programma TestQuestion che riempie
	un array con quesiti di diversa natura e poi simula un’interrogazione
	calcolando il punteggio totale ottenuto. A scelta, l’interrogazione può
	essere fatta estraendo in modo casuale tre quesiti dall’array. 
	Per l’estrazione casuale usare il metodo nextInt(int n) della classe
	Random (importare java.util.Random). 

	*/
	public static void main(String[] args) {
		int punti = 0;
	
		Question[] quesiti = new Question[5];
		quesiti[0] = new Question("Qual'e' il monte piu' alto d'Italia?", "Monte Bianco", 1);
		quesiti[1] = new QuestionYesNo("L'America e' stata scoperta nel 1942?", "S", 1);
		quesiti[2] = new NumericQuestion("In che anno e' uscito il cartone del \"Re Leone\"?", "1994", 2);
		quesiti[3] = new MultipleQuestion("Che cos'e' una mucca?\n1) Un mammifero\n2) Un uccello\n3) Un rettile", "1", 1, 3);
		quesiti[4] = new NumericQuestion("Quanti protoni ha un elettrone?", "1", 1);
		
		Random r = new Random();
		for (int i = 0; i < 3; i++) {
			int numeroCasuale = r.nextInt(5);
			punti += quesiti[numeroCasuale].ask();
		}
		
		
		System.out.println("Hai fatto " + punti + " punti in totale");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}