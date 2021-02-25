public class Parallelepipedo extends OggettoTridimensionale {
	
	// Attributi
	private double b;
	private double h;
	
	// Costruttore
	public Parallelepipedo(double altezza, double b, double h) {
		super(altezza);
		setB(b);
		setH(h);
	}
	
	public double getB() {
		return b;
	}
	
	public void setB(double b) {
		this.b = b;
	}
	
	public double getH() {
		return h;
	}
	
	public void setH(double h) {
		this.h = h;
	}
	
	@ Override
	public double calcolaArea() {
		return b * h;
	}
	
	@ Override
	public double calcolaVolume() {
		return calcolaArea() * getAltezza();
	}
	
	@ Override
	public void stampaVolume() {
		System.out.println(calcolaVolume());
	}
}