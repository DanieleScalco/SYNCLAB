import java.util.Scanner;

public class Es1_1 {
	public static Scanner tastiera = new Scanner(System.in);
	
	public static void main(String[] args) {
		int[] array = new int[10];
		String stringa;
		
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 10);
		}
		
		/* 1 dato un array di interi, popolato casualmente, ordinarlo in
		ordine crescente e stampare a video il risultato di tale
		ordinamento.*/
		System.out.println("Array di interi:");
		stampa(array);
		System.out.println("Array di interi ordinato:");
		ordina(array, 0, array.length - 1);
		stampa(array);
		
		/* 2 Scrivere un metodo che verifichi se una data stringa inserita
		in input è palindroma, tale metodo dovrà restituire un booleano.*/
		System.out.println("\n");
		System.out.println("Inserisci una stringa:");
		stringa = tastiera.next();
		System.out.println("La stringa e' palindroma? " + palindroma(stringa));
		
		/* 3 Scrivere un metodo che mostri i primi 50 numeri della serie
		di fibonacci (i primi due numeri di fibonacci sono 0 e 1 i
		successivi si calcolano come somma dei 2 precedenti).*/
		System.out.println("\n");
		System.out.println("Ecco i primi 50 numeri della serie di Fibonacci");
		fibonacci(50);
		
		/* 4 Data una matrice effettuare la trasposta della stessa.*/
		System.out.println("\n");
		int[][] matrice = new int[3][2];
		matrice[0][0] = 2;
		matrice[0][1] = 4;
		matrice[1][0] = 3;
		matrice[1][1] = 2;
		matrice[2][0] = 5;
		matrice[2][1] = 3;
		System.out.println("Matrice di interi:");
		stampaMatrice(matrice);
		System.out.println("La sua matrice trasposta e':");
		stampaMatrice(trasposta(matrice));
		
	}
	
	
	public static void stampa(int[] array) {
		for (int i = 0; i < array.length; i++) {
				System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	public static void stampaMatrice(int[][] matrice) {
		for (int r = 0; r < matrice.length; r++) {
			for (int c = 0; c < matrice[0].length; c++) {
				System.out.print(matrice[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	public static void ordina(int[] array, int left, int right) {
		if (left < right) {
			int center = (left + right) / 2;
			ordina(array, left, center);
			ordina(array, center + 1, right);
			merge(array, left, center, right);
		}
	}
	
	
	public static void merge(int[] array, int left, int center, int right) {
		int n1 = center - left + 1;
		int n2 = right - center;
		int[] l = new int[n1 + 1];
		int[] r = new int[n2 + 1];
		
		for (int i = 0; i < n1; i++) {
			l[i] = array[i + left];
		}
		
		for (int i = 0; i < n2; i++) {
			r[i] = array[center + i + 1];
		}
		
		l[n1] = Integer.MAX_VALUE;
		r[n2] = Integer.MAX_VALUE;
		
		int i = 0;
		int j = 0;
		for (int a = left; a <= right; a++) {
			if (l[i] <= r[j]) {
				array[a] = l[i];
				i++;
			} else {
				array[a] = r[j];
				j++;
			}
		}
	}
	
	
	public static boolean palindroma(String s) {
		for (int l = 0, r = s.length() - 1; l < r; l++, r--) {
			if (s.charAt(l) != s.charAt(r))
				return false;
		}
		return true;
	}
	
	
	public static void fibonacci(int n) {
		long[] fibonacci = new long[n];
		
		fibonacci[0] = 0;
		fibonacci[1] = 1;
		
		int precPrec = 0;
		int prec = 1;
		
		for (int i = 2; i < n; i++) {
			fibonacci[i] = fibonacci[precPrec] + fibonacci[prec];
			precPrec++;
			prec++;
		}
		
		for (int i = 0; i < n; i++) {
			System.out.print(fibonacci[i] + " ");
		}
		System.out.println();
	}
	
	public static int[][] trasposta(int[][] matrice) {
		int[][] matriceT = new int[matrice[0].length][matrice.length];
		
		for (int r = 0; r < matrice.length; r++) {
			for (int c = 0; c < matrice[0].length; c++) {
				matriceT[c][r] = matrice[r][c];
			}
		}
		
		return matriceT;
	}
	
	
	
	
	
	
	
	
	
}