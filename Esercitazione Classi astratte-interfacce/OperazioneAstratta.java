public abstract class OperazioneAstratta {
	
	// Attributi
	protected double x;
	protected double y;
	protected double risultato;
	
	// Costruttore
	public OperazioneAstratta(double x, double y) {
		this.x = x;
		this.y = y;
		this.risultato = eseguiOperazione();
	}
	
	public abstract double eseguiOperazione();
	
	public void stampaRisultato() {
		System.out.println("Risultato: " + risultato);
	}
}