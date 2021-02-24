import java.util.Scanner;

/* 2 Un Elemento Multimediale è una Immagine, un Filmato o una registrazione Audio
identificato da un titolo (una stringa non vuota).
Un elemento è riproducibile se ha una durata (un valore positivo di tipo int) e un
metodo play().
Una registrazione Audio è riproducibile e ha associato anche un volume (un valore
positivo di tipo int) e i metodi weaker() e louder() per regolarlo. 
Se riprodotta, ripete per un numero di volte pari alla durata la stampa del titol
concatenato a una sequenza di punti esclamativi di lunghezza pari al volume (una
stampa per riga).
Un Filmato è riproducibile e ha associato un volume regolabile analogo a quello
delle registrazioni audio e anche una luminosità (un valore positivo di tipo int) e
i metodi brighter() e darker() per regolarla. 
Se riprodotto, ripete per un numero di volte pari alla durata la stampa del titolo
concatenato a una sequenza di punti esclamativi di lunghezza pari al volume e poi a
una sequenza di asterischi di lunghezza pari alla luminosità (una stampa per riga).
Una Immagine non è riproducibile, ma ha una luminosità regolabile analoga a quella
dei filmati e un metodo show() che stampa il titolo concatenato a una sequenza di
asterischi di lunghezza pari alla luminosità.
Eseguire un oggetto multimediale significa invocarne il metodo show() se è
un'immagine o il metodo play() se è riproducibile.

Organizzare opportunamente con classi astratte, interfacce e classi concrete il
codice di un lettore multimediale che memorizza 5 elementi (creati con valori letti
da tastiera) in un array e poi chiede ripetutamente all'utente quale oggetto eseguire
(leggendo un intero da 1 a 5 oppure 0 per finire) e dopo ogni esecuzione fornisce la
possibilità di regolarne eventuali parametri (volume / luminosità).
*/

public class LettoreMultimediale {
	private static Scanner tastiera = new Scanner(System.in);
	
	public static void main(String[] args) {
		ElementoMultimediale[] arrayElementi = new ElementoMultimediale[3];
		
		for (int i = 0; i < arrayElementi.length; i++) {
			arrayElementi[i] = inserisciElementoMultimediale();
		}
		
		/* Controllo sia tutto salvato correttamente
		for (int i = 0; i < arrayElementi.length; i++) {
			arrayElementi[i].esegui();
		}
		*/
		
		riproduci(arrayElementi);
		
	}
	
	public static ElementoMultimediale inserisciElementoMultimediale() {
		System.out.println("Che tipo di elemento multimediale vuoi inserire?");
		System.out.println("1) Immagine");
		System.out.println("2) Audio");
		System.out.println("3) Filmato");
		
		int risposta, luminosita = 0, volume = 0, durata = 0;
		String titolo = "";
		boolean finito = false;
		ElementoMultimediale e = new Immagine("Errore", 1);
		
		while (!finito) {
			System.out.println("Inserisci 1, 2 o 3");
			risposta = tastiera.nextInt();
			switch (risposta) {
				case (1):
					titolo = inserisciTitolo();
					luminosita = inserisciLuminosita();
					e = new Immagine(titolo, luminosita);
					finito = true;
					break;
				case (2):
					titolo = inserisciTitolo();
					volume = inserisciVolume();
					durata = inserisciDurata();
					e = new Audio(titolo, volume, durata);
					finito = true;
					break;
				case (3):
					titolo = inserisciTitolo();
					volume = inserisciVolume();
					durata =inserisciDurata();
					luminosita = inserisciLuminosita();
					e = new Filmato(titolo, volume, durata, luminosita);
					finito = true;
					break;
				default:
					System.out.println("Inserisci 1, 2 o 3");
					break;
			}
		}
		return e;
	}
	
	public static String inserisciTitolo() {
		String titolo = "";
		titolo = tastiera.nextLine();

		while (titolo.equals("")) {
			System.out.println("Inserisci il titolo:");
			titolo = tastiera.nextLine();
		}
		return titolo;
	}
	
	public static int inserisciLuminosita() {
		int luminosita = 0;
		while (luminosita == 0) {
			System.out.println("Inserisci luminosita:");
			luminosita = tastiera.nextInt();
		}
		return luminosita;
	}
	
	public static int inserisciVolume() {
		int volume = 0;
		while (volume == 0) {
			System.out.println("Inserisci volume:");
			volume = tastiera.nextInt();
		}
		return volume;
	}
	
	public static int inserisciDurata() {
		int durata = 0;
		while (durata == 0) {
			System.out.println("Inserisci durata:");
			durata = tastiera.nextInt();
		}
		return durata;
	}
	
	public static void riproduci(ElementoMultimediale[] array) {
		boolean finito = false;
		int numero;
		String risposta;
		
		while (!finito) {
			System.out.println("Quale elemento multimediale vuoi riprodurre?");
			System.out.println("Inserisci un numero da 1 a 5 (0 per terminare)");
			numero = tastiera.nextInt();
			switch (numero) {
				case (0):
					finito = true;
					break;
				case (1):
				case (2):
				case (3):
				case (4):				
				case (5):				
					array[numero - 1].esegui();
					System.out.println("Vuoi regolare le impostazioni dell'elemento multimediale? [S/N]");
					risposta = tastiera.nextLine();
					risposta = tastiera.nextLine();
					if (risposta.equalsIgnoreCase("S"))
						array[numero - 1] = regola(array[numero - 1]);
					break;
				default:
					System.out.println("Inserisci un numero da 1 a 5 (0 per terminare)");
					break;		
			}
		}
	}
	
	public static ElementoMultimediale regola(ElementoMultimediale e) {
		int valore = -1;
		boolean finito = false;
		
		if (e instanceof Immagine) {
			Immagine i = (Immagine) e;
			while (!finito) {
				System.out.println("1) Aumenta luminosita");
				System.out.println("2) Diminuisci luminosita");
				valore = tastiera.nextInt();
				if (valore == 1) {
					i.brighter();
					finito = true;
				}
				else {
					i.darker();
					finito = true;
				}
			}
			
			return i; 
			
		} else if (e instanceof Audio) {
			Audio a = (Audio) e;
			while (!finito) {
				System.out.println("1) Aumenta volume");
				System.out.println("2) Diminuisci volume");
				valore = tastiera.nextInt();
				if (valore == 1) {
					a.louder();
					finito = true;
				}
				else {
					a.weaker();
					finito = true;
				}
			}
			
			return a;
			
		} else if (e instanceof Filmato) {
			Filmato f = (Filmato) e;
			while (!finito) {
				System.out.println("1) Aumenta volume");
				System.out.println("2) Diminuisci volume");
				valore = tastiera.nextInt();
				if (valore == 1) {
					f.louder();
					finito = true;
				}
				else {
					f.weaker();
					finito = true;
				}
			}
			finito = false;
			while (!finito) {
				System.out.println("1) Aumenta luminosita");
				System.out.println("2) Diminuisci luminosita");
				valore = tastiera.nextInt();
				if (valore == 1) {
					f.brighter();
					finito = true;
				}
				else {
					f.darker();
					finito = true;
				}
			}
			
			return f;
			
		} else
			System.out.println("Errore");
			
		return null;
	}
	
	
	
	
	
	
	
	
	
	
}