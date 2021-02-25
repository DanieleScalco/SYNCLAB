public abstract class OggettoTridimensionale {
	
	// Attributi
	private double altezza;
	
	// Costruttore
	public OggettoTridimensionale(double altezza) {
		setAltezza(altezza);
	}
	
	// Metodi
	public double getAltezza() {
		return altezza;
	}
	
	public void setAltezza(double altezza) {
		this.altezza = altezza;
	}
	
	public abstract double calcolaArea();
	
	public abstract double calcolaVolume();
	
	public abstract void stampaVolume();
	
	
}
