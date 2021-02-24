public class Vehicle {
	
	
	// Attributi
	private String targa;
	private String marca;
	private String modello;
	private boolean guasto;
	
	// Costruttori
	public Vehicle(String targa, String marca, String modello) {
		setTarga(targa);
		setMarca(marca);
		setModello(modello);
		setGuasto(false);
	}
	
	// Metodi
	public String getTarga() {
		return targa;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public String getModello() {
		return modello;
	}
	
	public boolean isGuasto() {
		return guasto;
	}
	
	public void setTarga(String targa) {
		this.targa = targa;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public void setModello(String modello) {
		this.modello = modello;
	}
	
	public void setGuasto(boolean guasto) {
		this.guasto = guasto;
	}
	
	
	
	
	
	
	
	
	
}