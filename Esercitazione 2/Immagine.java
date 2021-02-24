public class Immagine extends ElementoMultimediale {
	
	// Attributi
	private int luminosita;
	
	// Costruttore
	public Immagine(String titolo, int luminosita) {
		super(titolo);
		setLuminosita(luminosita);
	}
	
	// Metodi
	public int getLuminosita() {
		return luminosita;
	}
	
	public void setLuminosita(int luminosita) {
		if (luminosita < 1)
			luminosita = 1;
		this.luminosita = luminosita;
	}
	
	public void brighter() {
		luminosita++;
	}
	
	public void darker() {
		if (luminosita > 1)
			luminosita--;
	}
	
	public void show() {
		System.out.print(this.getTitolo());
		for (int i = 0; i < getLuminosita(); i++) {
			System.out.print("*");
		}
		System.out.println();
	}
	
	@ Override
	public void esegui() {
		show();
	}
	
}