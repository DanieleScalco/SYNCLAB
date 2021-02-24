public class TestGarage {
	
	/* 4 Scrivere una classe Garage che prevede solo un metodo repair() che
	utilizza veicoli (come definiti nell’esercizio precedente). Tale metodo
	prende un veicolo come parametro, ne cambia (se necessario) il valore
	della variabile booleana che descrive lo stato di guasto e restituisce
	come risultato il prezzo dell’intervento. Il prezzo deve variare a
	seconda che il veicolo fosse guasto o meno, e a seconda della tipologia
	di veicolo. Per testare le classi, scrivere un programma TestGarage che
	crea un certo numero di veicoli e un oggetto di tipo Garage, e usa il
	metodo repair() varie volte su oggetti diversi (guasti o meno)
	stampando i prezzi ottenuti.

	*/
	public static void main(String[] args) {
		Garage g = new Garage();
		Vehicle[] veicoli = new Vehicle[5];
		veicoli[0] = new Car("FA134CK", "Ford", "Fiesta", "SUV");
		veicoli[1] = new Car("GA238HL", "Ford", "Fiesta", "utilitaria");
		veicoli[2] = new Motocycle("PA438HI", "Ducati", "Desmosedici", 1000);
		veicoli[3] = new Motocycle("PA123NI", "Honda", "CBR", 1000);
		veicoli[4] = new Motocycle("HJA453NO", "Ducati", "Hypermotard", 800);
		
		veicoli[0].setGuasto(true);
		veicoli[4].setGuasto(true);
		
		for(Vehicle v: veicoli) {
			int costo = g.repair(v);
			System.out.println("Prezzo riparazione " + v.getTarga() + ": " + costo);
		}
	}
}