package Esercitazione3;

import java.util.Scanner;

/*
 * Esercizio 1: Tipi di Bevande
Il distributore di bevande è in grado di erogare alcuni tipi di bevande; ogni bevanda è caratterizzata da un codice, nome ed un prezzo.
Ad esempio:
Codice	Bevanda	Prezzo
A	Acqua	0.20
B	Coca	0.30
C	Birra	1.00

Il metodo aggiungiBevanda() permette di aggiungere la descrizione di una bevanda.
Il distributore permette di conoscere, dato il codice, il prezzo e il nome della bevanda tramite i metodi getPrice() e getName() rispettivamente.
Quando si richiede un codice corrispondente ad una bevanda non disponibile, viene generata un’eccezione di BevandaNonValida.
Esercizio 2: Credito
Il distributore può essere utilizzato con delle tessere di credito. Ogni tessera è caratterizzata da un codice (un numero intero) e da un credito disponibile. I crediti vengono definiti tramite il metodo caricaTessera(). In qualsiasi istante è possibile conoscere il credito residuo di una tessera tramite il metodo leggiCredito() che riceve come parametro il codice della tessera; in caso di codice di tessera non valido viene restituita un’eccezione di TesseraNonValida.

Esempio di tessere:
Codice	Credito
12 	5.5
21 	10.0
99 	0.75


Esercizio 3: Approvvigionamento Distributore.
Il distributore è costituito da quattro colonne in cui sono disposte le lattine delle bevande. Ogni colonna contiene un unico tipo di bevanda ed è caratterizzata dal numero di lattine contenute e dal tipo di bevanda che contiene. In partenza tutte le colonne sono vuote. 
Quando viene ricaricato il distributore viene assegnato ad ogni colonna un tipo di bevanda ed il numero di lattine presenti; a questo scopo si usa il metodo aggiornaColonna() che riceve come parametro il numero della colonna, il tipo di bevanda e il numero di lattine presenti nella colonna.

Le colonne sono numerate a partire da 1.
Esempio:
Numero
Colonna	Nome
Bibita	Lattine
1	Acqua	40
2	Coca 	1
3	Birra 	50
4	Acqua 	50

Dato un codice di una bibita (es. “A”) è possibile sapere quante lattine sono disponibili tramite il metodo lattineDisponibili(). Il metodo somma tutte le lattine disponibili in tutte le colonne che contengono il tipo di bevanda data.

Esercizio 4: Erogazione
Il distributore eroga le bevande specificando il codice della bevanda e il codice della tessera con cui pagare. Se i codici (di bevanda e di tessera) sono validi, il credito residuo della tessera è almeno pari al prezzo della bevanda ed esiste almeno una lattina disponibile per la bevanda selezionata, il distributore decrementa il credito residuo della tessera del prezzo della bevanda, e riduce il numero di lattine disponibili nella colonna che le contiene.
L’erogazione viene fatta tramite il metodo eroga() che restituisce il numero della colonna da cui viene prelevata la lattina.
Se il credito residuo della tessera non è sufficiente il distributore segnala l’errore generando un’eccezione di CreditoInsufficiente.
Se non ci sono lattine disponibili in nessuna colonna il metodo genera un’eccezione di BevandaEsaurita

 */
public class EsercizioBevande {
	
	public static void main(String[] args) {
		Distributore d = new Distributore(4);
		Scanner tastiera = new Scanner(System.in);
		int codice, codiceTessera;
		
		while (true) {
			System.out.println("\n");
			d.mostraBevande();
			System.out.println("\n\nCosa vuoi fare?");
			System.out.println("1) Aggiungi bevanda");
			System.out.println("2) Acquista bevanda");
			System.out.println("3) Leggi credito nella tessera");
			System.out.println("4) Aggiungi tessera");
			System.out.println("5) Carica tessera");
			System.out.println("6) Carica bevanda");
			System.out.println("7) Lattine disponibili");
			System.out.println("[Inserisci un qualsiasi altro numero per uscire]");

			codice = tastiera.nextInt();
			switch (codice) {
				case(1):
					
					d.aggiungiBevanda();
					break;
				case(2):
					
					try {
						d.acquistaBevanda();
					} catch (BevandaNonValidaException e) {
						System.out.println(e.getMessage());
					} catch (BevandaEsauritaException e) {
						System.out.println(e.getMessage());
					} catch (CreditoInsufficienteException e) {
						System.out.println(e.getMessage());
					}
					break;
				case(3):
					
					try {
					
						d.leggiCredito();
					} catch (TesseraNonValidaException e) {
						System.out.println(e.getMessage());
					}
					break;
				case(4):
					
					System.out.println("Inserisci codice tessera da salvare:");
					codiceTessera = tastiera.nextInt();
					d.getListaTessere().add(new Tessera(codiceTessera, 0));
					System.out.println("Tessera aggiunta correttamente");
					break;
				case(5):
		
					System.out.println("Inserisci il codice della tessera da caricare:");
					codiceTessera = tastiera.nextInt();
					Tessera tmp = d.getTessera(codiceTessera);
					if (tmp == null)
						System.out.println("Tessera non ancora memorizzata");
					else {
						double credito;
						System.out.println("Credito attualmente presente: " + tmp.getCredito() + "€");
						System.out.println("Inserisci il credito che vuoi caricare");
						credito = tastiera.nextDouble();
						tmp.caricaTessera(credito);
						System.out.println("Ricarica effettuata, credito attuale: " + tmp.getCredito() + "€");

					}
					break;
				case(6):
					System.out.println("Inserisci numero colonna da ricaricare");
					int numeroColonna;
					numeroColonna = tastiera.nextInt();
					if (numeroColonna < 1 || numeroColonna > d.getListaColonne().size()) {
						System.out.println("Codice inesistente");
					} else {
						Colonna col = null;
						for (Colonna c : d.getListaColonne()) {
							if (c.getNumeroColonna() == numeroColonna)
								col = c;
						}
						if (col.getBevanda() == null)
								System.out.println("La colonna e' vuota");
						else {
							System.out.println("Quante lattine vuoi caricare?");
							int quantita;
							quantita = tastiera.nextInt() + col.getNumeroLattine();
							
							d.aggiornaColonna(numeroColonna, col.getTipoBevanda(), col.getBevanda().getPrezzo(), quantita);
						}
					}
					break;
				case(7):
					System.out.println("Inserisci codice bevanda di cui vuoi sapere la disponibilita':");
					String cod;
					cod = tastiera.nextLine();
					cod = tastiera.nextLine();
					System.out.println("Sono disponibili " + d.lattineDisponibili(cod) + " lattine");
					break;
				default:
					System.exit(0);
			}

		}
	}
}
