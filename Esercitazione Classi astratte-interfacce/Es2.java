public class Es2 {
	
	/* 2 Scrivere un programma che simuli il lancio di un dado e di una moneta 
	stampandone il risultato; con e senza l'utilizzo di una classe astratta che
	rappresenti i comportamenti comuni degli oggetti dado e moneta istanziati.
	*/
	public static void main(String[] args) {
		OggettoLanciabile o1 = new Dado(6);
		OggettoLanciabile o2 = new Moneta(2);
		
		for (int i = 0; i < 10; i++) {
			o1.lancia();
			o2.lancia();
		}
	}
}