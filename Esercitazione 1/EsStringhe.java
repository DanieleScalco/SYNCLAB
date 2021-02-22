import java.util.Scanner;
import java.util.LinkedList;


public class EsStringhe {
	public static Scanner tastiera = new Scanner(System.in);
	
	public static void main(String[] args) {
		String stringa;
		LinkedList<String> lista = new LinkedList<String>();
		boolean finito = false;
		
		/* 1 Scrivere un programma / metodo che data una stringa in input
		la stampi al contrario. Per esempio, se si immette la stringa
		"Viva Java", il programma stampa "avaJ aviV"*/
		System.out.println("Inserisci una stringa: ");
		stringa = tastiera.nextLine();
		System.out.println("Ecco la tua stringa scritta la contrario:");
		stampaAlContrario(stringa);
		
		/* 2  Scrivere un programma / metodo che data una stringa in input
		ne stampi le sole vocali. Per esempio, se si immette la stringa
		"Viva Java", il programma stampa "iaaa".*/
		System.out.println("\n");
		System.out.println("Inserisci una stringa: ");
		stringa = tastiera.nextLine();
		System.out.println("Ecco le vocali contenute nell stringa:");
		stampaVocali(stringa);
		
		/* 3 Scrivere un programma / metodo che data una sequenza di
		stringhe, conclusa dalla stringa vuota, stampi la somma delle
		lunghezze delle stringhe che iniziano con una lettera maiuscola.
		Per esempio, se si immettono le stringhe "Albero", "foglia",
		"Radici", "Ramo", "fiore" (e poi "" per finire), il programma
		stampa 16. */
		System.out.println("\n");
		System.out.println("Inserisci una serie di stringhe, termina con \"\"");
		
		while (!finito) {
			stringa = tastiera.nextLine();
			if (!stringa.equals(""))
				lista.add(stringa);
			else
				finito = true;
		}
		
		System.out.println("La somma delle lunghezze delle stringhe che iniziano con una maiuscola e':");
		sommaLunghezzeMaiuscola(lista);
	}
	
	
	public static void stampaAlContrario(String s) {
		
		for (int i = s.length() - 1; i >= 0; i--) {
			System.out.print(s.charAt(i));
		}
		
		System.out.println();
	}
	
	
	public static void stampaVocali(String s) {
		String carattere = ""; 
		
		for (int i = 0; i < s.length(); i++) {
			
			carattere += s.charAt(i);
			
			if (carattere.equalsIgnoreCase("A") || carattere.equalsIgnoreCase("E") ||
				carattere.equalsIgnoreCase("I") || carattere.equalsIgnoreCase("O") ||
				carattere.equalsIgnoreCase("U"))
				System.out.print(carattere);
			
			carattere = "";
		}
	}
	
	
	public static void sommaLunghezzeMaiuscola(LinkedList<String> lista) {
		int somma = 0;
		
		for (String s : lista) {
			
			int  x = s.charAt(0);
			
			if (x >= 65 && x <= 90)
				somma += s.length();
		}
		
		System.out.println(somma);
	}
	
	
	
	
	
	
}