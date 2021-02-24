import java.util.Scanner;
import java.util.Date;

public class ListaSpesa {
	
	/* 1 Il gestore di un negozio associa a tutti i suoi Prodotti un codice a barre
	univoco, una descrizione sintetica del prodotto e il suo prezzo unitario. Realizzare una classe Prodotti con le opportune variabili d'istanza e metodi get.
	Aggiungere alla classe Prodotti un metodo applicaSconto che modifica il prezzo
	del prodotto diminuendolo del 5%. Aggiungere alla classe Prodotti
	un'implementazione specifica dei metodi ereditati dalla classe Object.
	Il gestore del negozio vuole fare una distinzione tra i prodotti Alimentari e
	quelli Non Alimentari . Ai prodotti Alimentari viene infatti associata una data
	di scadenza (si veda la classe Data), mentre a quelli Non Alimentari il materiale
	principale di cui sono fatti. Realizzare le sottoclassi Alimentari e
	NonAlimentari estendendo opportunamente la classe Prodotti.
	Modificare le due sottoclassi dell'esercizio specializzando il metodo
	applicaSconto in modo che nel caso dei prodotti Alimentari venga applicato uno
	sconto del 20% se la data di scadenza è a meno di 10 giorni dalla data attuale
	(si usi il metodo getDifference della classe Data), mentre nel caso dei prodotti
	Non Alimentari venga applicato uno sconto del 10% se il prodotto è composto da
	un materiale riciclabile (carta, vetro o plastica).
	Realizzare una classe ListaSpesa che chieda all'utente di inserire i prodotti
	acquistati e calcoli il totale della spesa applicando gli opportuni sconti se
	il cliente ha la tessera fedeltà.
	*/
	public static void main(String[] args) {
		int numeroProdottiAlimentari, numeroProdottiNonAlimentari, anno, giorno, mese;
		Scanner tastiera = new Scanner(System.in);
		String descrizione, materialePrincipale, input;
		double prezzoUnitario;
		boolean tessera;
		
		System.out.println("Inserisci il numero di prodotti alimentari che hai acquistato");
		numeroProdottiAlimentari = tastiera.nextInt();
		System.out.println("Inserisci il numero di prodotti non alimentari che hai acquistato");
		numeroProdottiNonAlimentari = tastiera.nextInt();
		
		Prodotto[] prodottiAcquistati = new Prodotto[numeroProdottiAlimentari + numeroProdottiNonAlimentari];
		
		System.out.println("Prima inserisci i dati dei prodotti alimentari, poi di quelli non alimentari");
		for (int i = 0; i < numeroProdottiAlimentari + numeroProdottiNonAlimentari; i++) {
			
			System.out.println("Inserisci descrizione:");
			descrizione = tastiera.nextLine();
			descrizione = tastiera.nextLine();
			System.out.println("Inserisci prezzo unitario:");
			prezzoUnitario = tastiera.nextDouble();
			
			if (i < numeroProdottiAlimentari) {
				
				// Inserisce prodotto alimentare
				System.out.println("Inserisci anno della data di scadenza:");
				anno = tastiera.nextInt() - 1900;
				System.out.println("Inserisci numero mese della data di scadenza:");
				mese = tastiera.nextInt() -  1;
				System.out.println("Inserisci giorno della data di scadenza:");
				giorno = tastiera.nextInt();
				System.out.println(anno + " " + mese + " " + giorno);
			
				prodottiAcquistati[i] = new ProdottoAlimentare(descrizione, prezzoUnitario, new Date(anno, mese, giorno));
				
			} else {
				
				// Inserisce prodotto non alimentare
				System.out.println("Inserisci materiale principale:");
				materialePrincipale = tastiera.next();
				prodottiAcquistati[i] = new ProdottoNonAlimentare(descrizione, prezzoUnitario, materialePrincipale);
				
			}
			
		}
		
		System.out.println("Hai la tessera fedelta'? [S/N]");
		input = tastiera.next();
		if (input.equalsIgnoreCase("S"))
			tessera = true;
		else
			tessera = false;
		
		System.out.println("Ecco i prodotti che hai acquistato con eventuali sconti applicati:");
		for (int i = 0; i < numeroProdottiAlimentari + numeroProdottiNonAlimentari; i++) {
			if (tessera)
				prodottiAcquistati[i].applicaSconto();
			System.out.println(prodottiAcquistati[i]);
		}
	}
}