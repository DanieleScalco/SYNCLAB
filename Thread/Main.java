package Thread;

public class Main {
	
	public static void main(String[] args) {
		Cassetto c = new Cassetto();
		Genitore g = new Genitore(c);
		Figlio f = new Figlio(c);
		
		g.start();
		f.start();
		try {
			g.join();
			f.join();
		} catch (InterruptedException e) {
			System.out.println("Problema di join: " + e.getMessage());
		}
		System.out.println("Fine programma");
	}
	
}
