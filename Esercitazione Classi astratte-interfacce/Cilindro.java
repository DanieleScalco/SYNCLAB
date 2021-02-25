public class Cilindro extends OggettoTridimensionale {
	
	// Attributi
	private double raggio;
	
	// Costruttore
	public Cilindro(double altezza, double raggio) {
		super(altezza);
		setRaggio(raggio);
	}
	
	// Metodi
	public double getRaggio() {
		return raggio;
	}
	
	public void setRaggio(double raggio) {
		this.raggio = raggio;
	}
	
	@ Override
	public double calcolaArea() {
		return Math.PI * raggio * raggio;
	}
	
	@ Override
	public double calcolaVolume() {
		return calcolaArea() * getAltezza();
	}
	
	public void stampaVolume() {
		System.out.println(calcolaVolume());
	}
	
	
}
