public class ProdottoNonAlimentare extends Prodotto {
	
	// Attributi
	private String materialePrincipale;
	
	// Costruttori
	public ProdottoNonAlimentare(String descrizione, double prezzoUnitario, String materialePrincipale) {
		super(descrizione, prezzoUnitario);
		setMaterialePrincipale(materialePrincipale);
	}
	
	// Metodi
	public String getMaterialePrincipale() {
		return materialePrincipale;
	}
	
	public void setMaterialePrincipale(String materiale) {
		materialePrincipale = materiale;
	}
	
	@ Override
	public String toString() {
		return super.toString() + ", materiale principale: " + getMaterialePrincipale();
	}
	
	@ Override
	public void applicaSconto() {
		
		if (getMaterialePrincipale(). equals("carta") || getMaterialePrincipale().equals("vetro") || getMaterialePrincipale().equals("plastica")) {
			double dieciPerCento = getPrezzoUnitario() / 100 * 10;
			setPrezzoUnitario(getPrezzoUnitario() - dieciPerCento);
		}
		
	}

}