import java.util.LinkedList;
import java.util.Scanner;

public class EsCicli {
	public static Scanner tastiera = new Scanner(System.in);

	public static void main(String[] args) {
		LinkedList<Integer> lista = new LinkedList<Integer>();
		LinkedList<Integer> lista2 = new LinkedList<Integer>();
		
		lista.add(2);
		lista.add(4);
		lista.add(18);
		lista.add(10);
		lista.add(40);
		
		lista2.add(5);
		lista2.add(8);
		lista2.add(9);
		lista2.add(12);
		lista2.add(7);
		lista2.add(6);
		lista2.add(1);
		
		/* 1 Scrivere un programma / metodo che data una sequenza di
		interi stampi "Tutti positivi e pari" se i numeri inseriti sono
		tutti positivi e pari, altrimenti stampa "NO". Risolvere questo
		esercizio senza usare array.*/
		System.out.println("Lista di interi:");
		stampaLista(lista);
		System.out.println("Contiene tutti numeri positivi e pari?");
		positiviEPari(lista);
		
		/* 2 Scrivere un programma / metodo che data una sequenza di
		interi stampi la media di tutti i numeri inseriti che siano
		divisibili per tre. Per esempio, se si immettono i valori
		5, 8, 9, 12, 7, 6 ,1 il risultato stampato dovrà essere 9.
		Risolvere questo esercizio senza usare array.*/
		System.out.println("\n");
		System.out.println("Lista di interi:");
		stampaLista(lista2);
		mediaDivisibili3(lista2);
		
		/* 3  Scrivere un programma / metodo che chiede all’utente di
		inserire una sequenza di caratteri (chiedendo prima quanti
		caratteri voglia inserire) e li ristampa man mano che vengono
		inseriti. L’intero procedimento (chiedere quanti caratteri voglia
		inserire, leggere i caratteri e man mano stamparli) dovrà essere
		ripetuto 5 volte. Risolvere questo esercizio senza usare array.*/
		System.out.println("\n");		
		stampaCaratteri5();
	}
	
	
	public static void stampaLista(LinkedList<Integer> lista) {
		for (int i : lista) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	
	public static void positiviEPari(LinkedList<Integer> lista) {
		for (int i : lista) {
			if (i <= 0 || i % 2 == 1) {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("Tutti positivi e pari");
	}
	
	
	public static void mediaDivisibili3(LinkedList<Integer> lista) {
		int somma = 0;
		int numeroElementiDivisibili3 = 0;
		
		for (int i : lista) {
			if (i % 3 == 0) {
				somma += i;
				numeroElementiDivisibili3++;
			}
		}
		
		int media = somma / numeroElementiDivisibili3;
		System.out.println("La media di tutti i numeri inseriti divisibili per tre e': " + media);
	}
	
	
	public static void stampaCaratteri5() {
		int numeroCaratteri;
		char carattere;
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Quanti caratteri vuoi inserire?");
			numeroCaratteri = tastiera.nextInt();
			for (int j = 0; j < numeroCaratteri; j++) {
				System.out.println("Inserisci il carattere");
				carattere = tastiera.next().charAt(0);
				System.out.println(carattere);
			}
		}
	}
	

}