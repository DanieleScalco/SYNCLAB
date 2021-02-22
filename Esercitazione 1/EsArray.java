public class EsArray {
	
	public static void main(String[] args) {
		int[] a10 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] a10random = new int[10];
		for (int i = 0; i < a10random.length; i++) {
			a10random[i] = (int) (Math.random() * 5);
		}
		String[] a5 = {"pappa", "Pippo", "casa", "java", "Daniele"};
		String[] b5 = {"ciccia", "torta", "Pippo", "basket", "Giorgia"};
		
		/* 1 Scrivere un programma / metodo che preveda un array di 10
		numeri interi contenente valori a piacere e ne stampa gli elementi
		secondo il seguente ordine: il primo, l’ultimo, il secondo, il
		penultimo, il terzo, il terz’ultimo, ecc. */
		System.out.println("Array di dieci elementi a piacere:");
		stampaArray(a10);
		System.out.println("Stampa dell'array alternando gli elementi dall'inizio con quelli dalla fine:");
		stampaPrimoUltimo(a10);
		
		/* 2 Scrivere un programma / metodo che preveda un array di 10 numeri
		interi contenente valori random. Tale programma dovrà stampare la
		dicitura "Pari e dispari uguali" se la somma dei numeri in
		posizioni pari dell’array è uguale alla somma dei numeri in
		posizioni dispari, altrimenti il programma dovrà stampare la
		dicitura "Pari e dispari diversi".*/
		System.out.println("\n");
		System.out.println("Array di dieci numeri interi casuali (da 0 a 4):");
		stampaArray(a10random);
		System.out.println("Confronto somma numeri in posizioni pari con numeri in posizioni dispari: ");
		pariDispari(a10random);
		
		/* 3 Scrivere un programma / metodo che preveda un array di 10
		numeri interi contenente valori random e che stampi la dicitura
		"Tre valori consecutivi uguali" contiene tre valori uguali in tre
		posizioni consecutive, qualora la condizione non dovesse essere
		verificata dovrà stampare "NO".*/
		System.out.println("\n");
		System.out.println("Array di dieci numeri interi casuali (da 0 a 4):");
		stampaArray(a10random);
		System.out.println("Controllo se hanno tre numeri consecutivi uguali: ");
		treValoriUguali(a10random);
		
		/* 4 Scrivere un programma / metodo che date due sequenze di
		stringhe, ciascuna di 5 elementi, stampi il messaggio "OK" se
		almeno una stringa della prima sequenza compare anche nella
		seconda, altrimenti sarà stampato il messaggio "KO". Qualora
		vengano trovate due stringhe uguali i confronti tra le sequenze
		devono essere interrotti.*/
		System.out.println("\n");
		System.out.println("Array di cinque stringhe a:");
		stampaArray(a5);
		System.out.println("Array di cinque stringhe b:");
		stampaArray(b5);
		System.out.println("Controllo se una stringa di a compare in b: ");
		contieneStringa(a5, b5);
	}
	
	
	
	public static void stampaArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static void stampaArray(String[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	
	
	public static void stampaPrimoUltimo(int[] array) {
		boolean finito = false;
		boolean flag = true;
		int inizio = 0;
		int fine = array.length - 1;
		
		while (inizio <= fine) {
			if (flag) {
				System.out.print(array[inizio] + " ");
				inizio++;
				flag = false;
			} else {
				System.out.print(array[fine] + " ");
				fine--;
				flag = true;
			}
		}
		
		System.out.println();
	}
	
	
	
	public static void pariDispari(int[] array) {
		int sommaPari = 0;
		int sommaDispari = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (i % 2 == 0)
				sommaPari += array[i];
			else
				sommaDispari += array[i];
		}
		
		if (sommaDispari == sommaPari)
			System.out.println("Pari e dispari uguali");
		else
			System.out.println("Pari e dispari diversi");
	}
	
	
	
	public static void treValoriUguali(int[] array) {
		int numeroValoriUgualiConsecutivi = 1;
		int maxValoriConsecutivi = 1;
		
		for (int i = 1; i < array.length; i++) {
			
			if (array[i] == array[i - 1]) {
				numeroValoriUgualiConsecutivi++;
				if (numeroValoriUgualiConsecutivi > maxValoriConsecutivi)
					maxValoriConsecutivi = numeroValoriUgualiConsecutivi;
			} else
				numeroValoriUgualiConsecutivi = 1;
		}
		
		if (maxValoriConsecutivi >= 3)
			System.out.println("Tre valori consecutivi uguali");
		else
			System.out.println("NO");
	}
	
	
	
	public static void contieneStringa(String[] arrayA, String[] arrayB) {
		
		for (int i = 0; i < arrayA.length; i++) {
			for (int j = 0; j < arrayB.length; j++) {
				
				if (arrayA[i].equals(arrayB[j])) {
					System.out.println("OK");
					return;
				}
			}
		}
		
		System.out.println("KO");
	}
	
	
	
	
	
	
	
	
}