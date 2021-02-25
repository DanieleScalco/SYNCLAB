public abstract class OggettoLanciabile {
	
	// Attributi
	private int numeroValoriPossibili; // Valore massimo ottenibile dal lancio
	
	// Costruttore
	public OggettoLanciabile(int numeroValoriPossibili) {
		setNumeroValoriPossibili(numeroValoriPossibili);
	}
	
	public int getNumeroValoriPossibili() {
		return numeroValoriPossibili;
	}
	
	public void setNumeroValoriPossibili(int numeroValoriPossibili) {
		this.numeroValoriPossibili = numeroValoriPossibili;
	}
	
	public abstract void lancia();
}