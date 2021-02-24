public class TestEmployee {
	
	/* 2 Scrivere una classe Employee (dipendente) che estende la classe Person. 
	Ogni dipendente ha un proprio anno di assunzione e un proprio stipendio. Si
	definiscano costruttori e vari metodi get e set opportuni. Si ridefinisca
	inoltre il metodo visualize() opportunamente. 
	Si definisca inoltre un metodo gainsMore che prende come parametro un altro
	oggetto Employee e restituisce true se l’oggetto corrente ha uno stipendio
	maggiore di quello ricevuto come parametro, o false altrimenti. 
	Per testare la classe, scrivere un programma TestEmployee che crea tre oggetti
	della classe Employee e li visualizza in ordine di stipendio (usando il nuovo
	metodo per confrontare gli stipendi). 
	*/
	public static void main(String[] args) {
		Employee e1 = new Employee("Scalco", "Daniele", "SCLDNL94H01L319E", "Gallarate", 2021, 1300);
		Employee e2 = new Employee("Mario", "Rossi", "MRARSS13S08H501H", "Roma", 2001, 800);
		Employee e3 = new Employee("Verdi", "Giuseppe", "VRDGPP80R10B293P", "Busseto", 2000, 3300);
		
		Employee[] array = new Employee[3];
		
		array[0] = e1;
		array[1] = e2;
		array[2] = e3;
		
		// Ordino gli impiegati secondo il guadagno
		Employee tmp;
		for(int i = 0; i < array.length; i++) {
			for(int j = i + 1; j < array.length; j++) {
				if (array[i].gainsMore(array[j])) {
					tmp = array[j];
					array[j] = array[i];
					array[i] = tmp;
				}
			}
		}
		
		for(int i = 0; i < array.length; i++) {
			array[i].visualize();
		}
	}
}