public class Prodotto {
	
	// Variabile statica per determinare codice a barre univoco
	private static int contatoreCodice= 1;
	
	// Attributi
	private int codiceABarre;
	private String descrizione;
	private double prezzoUnitario;
	
	// Costruttori
	public Prodotto(String descrizione, double prezzoUnitario) {
		setCodiceABarre();
		setDescrizione(descrizione);
		setPrezzoUnitario(prezzoUnitario);
	}
	
	// Metodi
	public int getCodiceABarre() {
		return codiceABarre;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public double getPrezzoUnitario() {
		return prezzoUnitario;
	}
	
	public void setCodiceABarre() {
		codiceABarre = contatoreCodice;
		contatoreCodice++;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public void setPrezzoUnitario(double prezzoUnitario) {
		this.prezzoUnitario = prezzoUnitario;
	}
	
	public void applicaSconto() {
		double cinquePerCento = getPrezzoUnitario() / 100 * 5;
		setPrezzoUnitario(getPrezzoUnitario() - cinquePerCento);
	}
	
	@ Override
	public String toString() {
		return "Codice a barre: " + getCodiceABarre() +
				", descrizione: " + getDescrizione() +
				", prezzo unitario: " + getPrezzoUnitario();
	}
	
	@ Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (this.getClass() != o.getClass())
			return false;
		else {
			Prodotto p = (Prodotto) o;
			if (p.getPrezzoUnitario() == this.getPrezzoUnitario() && p.getDescrizione() == this.getDescrizione())
				return true;
			else
				return false;
		}
	}
	
	
	
	
	
	
	
	
	

}