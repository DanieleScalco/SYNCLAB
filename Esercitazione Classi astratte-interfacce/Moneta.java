public class Moneta extends OggettoLanciabile {
	
	// Costruttore
	public Moneta(int numeroValoriPossibili) {
		super(numeroValoriPossibili);
	}
	
	//Metodi
	@ Override
	public void lancia() {
		int numeroEstratto;
		numeroEstratto = (int) (Math.random() * getNumeroValoriPossibili());
		if (numeroEstratto == 0)
			System.out.println("E' uscita testa");
		else
			System.out.println("E' uscita croce");
	}
	
}