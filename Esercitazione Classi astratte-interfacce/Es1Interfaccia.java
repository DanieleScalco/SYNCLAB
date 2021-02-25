public class Es1Interfaccia {
	/*
	Scrivere un programma che dato un numero intero in ingresso vengano restituiti un
	oggetto rappresentativo del quadrato del numero dato e un oggetto rappresentativo
	del cubo del numero assegnato.
	Implementa l'algoritmo attraverso l'uso di una interfaccia comune. 

	*/
	public static void main(String[] args) {
		NumeroOttenuto o1 = new Quadrato();
		NumeroOttenuto o2 = new Cubo();
		
		o1.getNumero(3);
		o2.getNumero(3);
	}
}