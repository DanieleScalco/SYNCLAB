public abstract class ElementoMultimediale {
	
	// Attributi
	private String titolo;
	
	// Costruttore
	public ElementoMultimediale(String titolo) {
		setTitolo(titolo);
	}
	
	// Metodi
	public String getTitolo() {
		return titolo;
	}
	
	public void setTitolo(String titolo) {
		if (titolo.equals(""))
			titolo = "Senza titolo";
		this.titolo = titolo;
	}
	
	public abstract void esegui();
}