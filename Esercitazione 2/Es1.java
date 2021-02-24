public class Es1 {
	
	/* 1 Creare una classe di nome Person con le variabili di istanza: surname, name, tax code e city di tipo stringa.

	La classe deve contenere un costruttore di default che inizializzi le variabili di istanza con NULL; un costruttore parametrico;
	
	i metodi set e get ed un metodo chiamato bornYear che a partire dal codice fiscale ricavi e restituisca l'anno di nascita di una persona. 

	Creare un'applicazione Java che istanzi un oggetto della classe Person e ne visualizzi in seguito nome, cognome ed anno di nascita.

	Costruire una sottoclasse di Person, chiamata Stagista, che contiene 2 variabili di istanza entrambe di tipo intero: 

	•	numberOfPresence, che registra il numero di ore di presenza
	•	idNumber (numero identificativo). 

	La sottoclasse deve contenere un costruttore parametrico ed i metodi set e get. 

	Creare tre oggetti di tipo Stagista memorizzarli in un array e visualizzare lo Stagista più giovane.

	*/
	public static void main(String[] args) {
		Person p1 = new Person("Scalco", "Daniele", "SCLDNL94H01L319E", "Gallarate");
		
		p1.visualize();
		
		Stagista[] array = new Stagista[3];
		Stagista s1 = new Stagista("Scalco", "Daniele", "SCLDNL94H01L319E", "Gallarate", 100, 1);
		Stagista s2 = new Stagista("Mario", "Rossi", "MRARSS13S08H501H", "Roma", 10, 2);
		Stagista s3 = new Stagista("Verdi", "Giuseppe", "VRDGPP80R10B293P", "Busseto", 150, 3);
		array[0] = s1;
		array[1] = s2;
		array[2] = s3;
		
		String cFPiuGiovane = "";
		int anno = -1;
		System.out.println("\nEcco i tre stagisti:");
		for(Stagista s : array) {
			System.out.println("Nome: " + s.getName() + ", cognome: " + s.getSurname() + ", anno di nascita: " + s.bornYear());
			if (s.bornYear() > anno) {
				anno = s.bornYear();
				cFPiuGiovane = s.getTaxCode();
			}
		}
		
		System.out.println("\nLo stagista piu' giovane e':");
		for(Stagista s : array) {
			if (s.getTaxCode().equals(cFPiuGiovane))
				s.visualize();
		}
		
	}
}