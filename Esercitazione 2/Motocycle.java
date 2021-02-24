public class Motocycle extends Vehicle {
	
	// Attributi
	private int cilindrata;
	
	// Costruttori
	public Motocycle(String targa, String marca, String modello, int cilindrata) {
		super(targa, marca, modello);
		setCilindrata(cilindrata);
	}
	
	// Metodi
	public int getCilindrata() {
		return cilindrata;
	}
	
	public void setCilindrata(int cilindrata) {
		this.cilindrata = cilindrata;
	}
}