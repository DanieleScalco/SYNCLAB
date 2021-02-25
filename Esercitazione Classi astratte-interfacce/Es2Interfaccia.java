public class Es2Interfaccia {
	
	/*
	2 Scrivere un programma che sia in grado di istanziare degli oggetti 'distributori
	di benzina' di cui sia nota la città, il proprietario, la capacità e la benzina
	attualmente contenuta nel distributore. Dell'oggetto Distributore, deve essere
	possibile simulare le operazioni di erogazione del carburante e dei corrispondenti
	incassi. Implementa una interfaccia Comparable, in modo da consentire il confronto
	tra 2 distributori in base alla capacità del serbatoio di carburante.
	*/
	public static void main(String[] args) {
		Distributore d1 = new Distributore("Gallarate", "Rossi", 1000, 500);
		Distributore d2 = new Distributore("Busto Arsizio", "Verdi", 800, 400);
		
		System.out.println(d1);
		System.out.println(d2);
		System.out.println("Vengono erogati 50l dal distributore di " + d1.getCitta());
		d1.eroga(50);
		System.out.println(d1);
		if (d1.compareTo(d2) > 0)
			System.out.println("Il distributore di " + d1.getCitta() + " ha maggior capacita di quello di " + d2.getCitta());
		else if (d1.compareTo(d2) == 0)
			System.out.println("Il distributore di " + d1.getCitta() + " ha la stessa capacita di quello di " + d2.getCitta());
		else
			System.out.println("Il distributore di " + d1.getCitta() + " ha meno capacita di quello di " + d2.getCitta());
			
		
	}
}