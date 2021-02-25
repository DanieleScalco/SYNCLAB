public class Es1 {
	
	/* 1 Esercizio 1

	Realizzare un programma che sia in grado di valutare il volume di oggetti
	tridimensionali come cilindri e parallelepipedi basandosi sul valore della loro
	area e dell'altezza. Delegare i metodi comuni, come il calcolo e la stampa del
	volume ad una classe astratta.
*/
	public static void main(String[] args) {
		OggettoTridimensionale o1 = new Cilindro(2.0, 1.0);
		OggettoTridimensionale o2 = new Parallelepipedo(2.0, 3.0, 4.0);
		
		o1.stampaVolume();
		o2.stampaVolume();
	}
}