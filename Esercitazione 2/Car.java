public class Car extends Vehicle {
	
	// Attributi
	private String tipologia;
	
	// Costruttori
	public Car(String targa, String marca, String modello, String tipologia) {
		super(targa, marca, modello);
		setTipologia(tipologia);
	}
	
	// Metodi
	public String getTipologia() {
		return tipologia;
	}
	
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
}