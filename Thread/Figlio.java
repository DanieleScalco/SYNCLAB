package Thread;

public class Figlio extends Thread {
	
	private Cassetto cassetto;
	
	public Figlio(Cassetto cassetto) {
		setCassetto(cassetto);
	}
	
	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				cassetto.prendi();
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			System.out.println("Run Genitore(): " + e.getMessage());
		}
		System.out.println("Fine figlio");
	}

	public Cassetto getCassetto() {
		return cassetto;
	}

	public void setCassetto(Cassetto cassetto) {
		this.cassetto = cassetto;
	}
}
