public class Es3Interfaccia {
	
	/*
	3 Definire una interfaccia 'operazione' e le sue classi derivate( sub. div, mul)
	in modo che da ciascuna sia possibile eseguire la corrispondente operazione
	aritmetica (di addizione, divisione, moltiplicazione) istanziando un oggetto di
	classe 'operazione' e due operandi. Realizzare anche, una classe astratta che
	implementi le funzionalità comuni come la stampa a video del risultato
	*/
	public static void main(String[] args) {
		Operazione o1 = new Addizione(4, 2);
		Operazione o2 = new Divisione(4, 2);
		Operazione o3 = new Moltiplicazione(4, 2);
		
		System.out.println("Addizione: " + o1.eseguiOperazione());
		System.out.println("Divisione: " + o2.eseguiOperazione());
		System.out.println("Moltiplicazione: " + o3.eseguiOperazione());
	
	}
}