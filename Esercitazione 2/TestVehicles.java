public class TestVehicles {
	
	/* 3 Scrivere una classe Vehicle (veicolo) che prevede una targa, una
	marca e un modello. La classe prevede anche una variabile booleana che
	descrive se il veicolo è guasto. Aggiungere un costruttore opportuno e
	vari metodi	get e set opportuni. Scrivere la classi Car e Motocycle che
	estendono la classe Vehicle. La classe Car prevede una stringa che ne
	descrive la	tipologia ("utilitaria","station wagon", "SUV",....) mentre
	la classe Motocycle prevede un numero che ne descrive la cilindrata
	(50, 125, ....). Per testare le classi, scrivere un programma
	TestVehicles che crea un array inizializzato con veicoli delle varie
	tipologie. Alcuni dei veicoli inseriti nell’array dovranno diventare
	guasti. Il programma deve stampare la lista delle targhe dei veicoli
	guasti. 
	*/
	public static void main(String[] args) {
		Vehicle[] veicoli = new Vehicle[5];
		veicoli[0] = new Car("FA134CK", "Ford", "Fiesta", "utilitaria");
		veicoli[1] = new Car("GA238HL", "Ford", "Fiesta", "utilitaria");
		veicoli[2] = new Motocycle("PA438HI", "Ducati", "Desmosedici", 1000);
		veicoli[3] = new Motocycle("PA123NI", "Honda", "CBR", 1000);
		veicoli[4] = new Motocycle("HJA453NO", "Ducati", "Hypermotard", 800);
		
		veicoli[0].setGuasto(true);
		veicoli[4].setGuasto(true);
		
		for(Vehicle v: veicoli) {
			if (!v.isGuasto()) {
				System.out.println(v.getTarga());
			}
		}
	}
}