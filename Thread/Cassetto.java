package Thread;

public class Cassetto {
	
	private int soldi; 

	public Cassetto() {
		setSoldi(0);
	}

	public int getSoldi() {
		return soldi;
	}

	public void setSoldi(int soldi) {
		this.soldi = soldi;
	}
	
	public synchronized int prendi() {
		
		while (soldi <= 0) {
			try {
				System.out.println("Aspettando i soldi...");
				wait();
			} catch (InterruptedException e) {
				System.out.println("Errore in prendi: " + e.getMessage());
			}
		}
		
		int denaroPreso = soldi;
		setSoldi(0);
		System.out.println("Hai preso " + denaroPreso + "€ dal cassetto");
		System.out.println("Nel cassetto ci sono " + soldi + "€");
		
		return denaroPreso;
	}
	
	public synchronized void metti(int denaroMesso) {
		setSoldi(soldi + denaroMesso);
		System.out.println("Sono stati messi " + denaroMesso + "€ nel cassetto");
		System.out.println("Nel cassetto ci sono " + soldi + "€");
		notifyAll();
	}

}
