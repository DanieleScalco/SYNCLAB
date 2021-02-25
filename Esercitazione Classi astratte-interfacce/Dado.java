public class Dado extends OggettoLanciabile {
	
	// Costruttore
	public Dado(int numeroValoriPossibili) {
		super(numeroValoriPossibili);
	}
	
	// Metodi
	@ Override
	public void lancia() {
		int numeroEstratto;
		numeroEstratto = (int) (Math.random() * getNumeroValoriPossibili() + 1);
		System.out.println("E' uscito " + numeroEstratto);
	}
}