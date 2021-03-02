package Thread;

public class Genitore extends Thread{

	private Cassetto cassetto;
	
	public Genitore(Cassetto cassetto) {
		setCassetto(cassetto);		
	}
	
	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				cassetto.metti(50);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("Run Genitore(): " + e.getMessage());
		}
		System.out.println("Fine genitore");

	}

	public Cassetto getCassetto() {
		return cassetto;
	}

	public void setCassetto(Cassetto cassetto) {
		this.cassetto = cassetto;
	}
	
	
	
}
