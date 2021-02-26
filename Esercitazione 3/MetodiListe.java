package Esercitazione3;

import java.util.*;


public class MetodiListe {
	
	/*
	 * Esercizio 1

Realizzare il metodo static LinkedList<Integer> creaRandom(int n, int max) che genera una lista costituita da n valori interi random tra 0 e max-1. 
Suggerimento : Per la generazione dei valori casuali far riferimento alla classe java.util.Random ed in particolare al metodo nextInt(int). In alternativa si può usare il metodo Math.random() che però restituisce un valore double tra 0 e 1 che andrà opportunamente scalato e convertito ad intero.
Parte 2
Realizzare il metodo static void stampa(Iterator<Integer> i) che stampa gli elementi dell’iteratore nella forma <elem1>,<elem2>,…., <elemN>
Parte 3
Realizzare il metodo static void provaEx1() che, utilizzando i metodi appena creati, crei un vettore di 20 elementi random (sia ordinato che non) e li stampa. Questo metodo andrà poi chiamato dal main per i test di correttezza.
Riassunto :
ripetere gli esercizi utilizzando l’ArrayList al posto della LinkedList. 
Quali metodi devono essere modificati?

Esercizio 2
Realizzare il metodo static LinkedList<Integer> creaRandomCrescente(int n) che genera una lista collegata costituita da n valori random crescenti.
Suggerimento: il primo valore della lista viene generato casualmente (ad es nell’intervallo 0-100); i
valori successivi si ottengono sommando al corrispondente valore della cella precedente un nuovo
valore random intero (ad es. con intervallo 0-100).

Parte 2
Realizzare un metodo static LinkedList<Integer> parseString(LinkedList<String> a) che ritorna una lista  Collegata di interi ottenuti applicando il metodo Integer.parseInt(…) agli elementi dell’iteratore passato come parametro.

a. Per il test generare una lista di stringhe opportuna con almeno 10 elementi
b. Individuare almeno un input in cui il metodo genera una eccezione
3. Realizzare il metodo static void provaEx2() per il test dei metodi



Esercizio 3 
1. Realizzare il metodo static LinkedList<Integer> mergeOrdinato(Iterator<Integer> a, Iterator<Integer> b) che effettua il merge ordinato degli elementi dei due iteratori, ritornando il risultato in una lista collegata.
In particolare il merge di due liste ordinate (qui rappresentate dai corrispondenti iteratori, da assumere
come già ordinati) restituisce una nuova lista ordinata contente tutti gli elementi appartenenti alle due liste
di input.

2. Realizzare il metodo static void provaEx3() che crea due liste random ordinate e restituisce il merge
ordinato delle due. Il risultato così ottenuto dovrà essere stampata, insieme ai corrispondenti vettori di input.

Esercizio 4 
1. Realizzare il metodo static LinkedList<LinkedList<Integer> insiemeDiInsiemi(int n) che costruisce una lista di liste così definita:

a. Il primo elemento della lista contiene una lista con il solo valore 0;
b. Il secondo elemento contiene una lista con gli elementi 0 e 1
c. Il terzo contiene una lista con gli elementi 0,1,2
d. … e così via fino ad n-1

2. Realizzare il metodo static void stampa(LinkedList <LinkedList<Integer>> a) in grado di stampare il contenuto della lista

	 */
	public static void main(String[] args) {
		provaEx1();
		provaEx2();
		provaEx3();
		provaEx4();
	}
	
	public static LinkedList<Integer> creaRandom(int n, int max) {
		LinkedList<Integer> lista = new LinkedList<Integer>();
		
		for (int i = 0; i < n; i++) {
			lista.add((int) (Math.random() * max));
		}
		return lista;
	}
	
	public static ArrayList<Integer> creaRandomArrayList(int n, int max) {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) {
			lista.add((int) (Math.random() * max));
		}
		return lista;
	}
	
	public static <T> void stampaLista(List<T> s) {
		for (T e: s) {
			System.out.print(e + " ");
		}
		System.out.println();
	}
	
	public static void stampa(Iterator<Integer> i) {
		while (i.hasNext()) {
			System.out.print("<" + i.next() + ">");
			if (i.hasNext())
				System.out.print(",");
		}
		System.out.println();
	} 
	
	public static void provaEx1() {
		System.out.println("Ex1");
		System.out.println("LinkedList:");
		LinkedList<Integer> l1 = creaRandom(20, 100);		
		Iterator<Integer> it = l1.iterator();
		stampa(it);
		
		System.out.println();
		System.out.println("LinkedList ordinata:");
		l1 = ordinaLista(l1);
		it = l1.iterator();
		stampa(it);
		
		System.out.println();
		System.out.println("ArrayList:");
		ArrayList<Integer> l2 = creaRandomArrayList(20, 100);		
		it = l2.iterator();
		stampa(it);
	}
	
	public static LinkedList<Integer> ordinaLista(LinkedList<Integer> lista) {
		LinkedList<Integer> listaOrdinata = new LinkedList<Integer>();
		
		while (!lista.isEmpty()) {
			int min = Integer.MAX_VALUE;
			for (int i: lista) {
				if (i < min) {
					min = i;
				}
			}
			lista.removeFirstOccurrence(min);
			listaOrdinata.add(min);
		}
		return listaOrdinata;
			
	}
	
	public static LinkedList<Integer> creaRandomCrescente(int n) {
		LinkedList<Integer> lista = new LinkedList<Integer>();
		int ultimoValore = 0, nuovoValore = 0;
		boolean valoreValido;
		
		for (int i = 0; i < n; i++) {
			valoreValido = false;
			nuovoValore = (int) (Math.random() * 10) + ultimoValore;
			lista.add(nuovoValore);
			ultimoValore = nuovoValore;
		}
		return lista;
	}
	
	public static void provaEx2() {
		System.out.println("Ex2");

		LinkedList<Integer> l1 = creaRandomCrescente(10);
		Iterator<Integer> it = l1.iterator();
		stampa(it);
		
		System.out.println();
		LinkedList<String> l2 = new LinkedList<String>();
		l2.add("12");
		l2.add("126");
		l2.add("129");
		l2.add("1826");
		l2.add("102");
		l2.add("1926");
		l2.add("142");
		l2.add("3126");
		l2.add("612");
		l2.add("126");
		
		LinkedList<Integer> l3 = null;
		try {
			l3 = parseString(l2);
		} catch (NumberFormatException e) {
			System.out.println("Stringa non convertibile in intero");
		}
		it = l3.iterator();
		stampa(it);
		
		
	}
	
	public static LinkedList<Integer> parseString(LinkedList<String> a) {
		LinkedList<Integer> lista = new LinkedList<Integer>();
		for (String s: a) {
			lista.add(Integer.parseInt(s));
		}
		return lista;
	}
	
	public static LinkedList<Integer> mergeOrdinato(Iterator<Integer> a, Iterator<Integer> b) {
		LinkedList<Integer> lista = new LinkedList<Integer>();
		Integer elemA, elemB;
		boolean inseritoA = false, inseritoB = false, finito = false; 
		
		if (a.hasNext())
			elemA = a.next();
		else
			elemA = null;
		if (b.hasNext())
			elemB = b.next();
		else
			elemB = null;
		
		while (elemA != null && elemB != null) {
			if (elemA < elemB) {
				lista.add(elemA);
				if (a.hasNext())
					elemA = a.next();
				else
					elemA = null;
			} else {
				lista.add(elemB);
				if (b.hasNext())
					elemB = b.next();
				else
					elemB = null;
			}
		}
		if (elemA == null) {
			while (elemB != null) {
				lista.add(elemB);
				if (b.hasNext())
					elemB = b.next();
				else
					elemB = null;
			}
		}
		if (elemB == null) {
			while (elemA != null) {
				lista.add(elemA);
				if (a.hasNext())
					elemA = a.next();
				else
					elemA = null;
			}
		}
		return lista;
	}
	
	public static void provaEx3() {
		System.out.println("Ex3");

		LinkedList<Integer> l1 = creaRandomCrescente(5);
		Iterator<Integer> it = l1.iterator();
		stampa(it);
		LinkedList<Integer> l2 = creaRandomCrescente(5);
		it = l2.iterator();
		stampa(it);
		
		LinkedList<Integer> l3 = mergeOrdinato(l1.iterator(), l2.iterator());
		it = l3.iterator();
		stampa(it);
	}
	
	public static LinkedList<LinkedList<Integer>> insiemeDiInsiemi(int n) {
		if (n < 0)
			return null;
		LinkedList<LinkedList<Integer>> lista = new LinkedList<LinkedList<Integer>>();
		
		for (int i = 1; i < n; i++) {
			LinkedList<Integer> l = new LinkedList<Integer>();
			lista.add(l);
			for (int j = 0; j < i; j++) {
				l.add(j);
			}
		}
		return lista;
	}
	
	public static void stampa(LinkedList <LinkedList<Integer>> a) {
		int n = 1;
		for (LinkedList<Integer> l: a) {
			System.out.print("Elemento " + n + "[");
			n++;
			for (int i: l) {
				System.out.print(i + " ");
			}
			System.out.println("]");
		}
	}
	
	public static void provaEx4() {
		System.out.println("Ex4");

		LinkedList<LinkedList<Integer>> lista = insiemeDiInsiemi(5);
		stampa(lista);
	}
}
