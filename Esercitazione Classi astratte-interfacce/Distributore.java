public class Distributore implements Comparable {
	
	// Attributi
	private String citta;
	private String proprietario;
	private int capacita;
	private int benzinaPresente;
	private double incasso;
	
	// Costruttore
	public Distributore(String citta, String proprietario, int capacita, int benzinaPresente) {
		setCitta(citta);
		setProprietario(proprietario);
		setCapacita(capacita);
		setBenzinaPresente(benzinaPresente);
		setIncasso(0);
	}
	
	//Metodi
	public String getCitta() {
		return citta;
	}
	
	public String getProprietario() {
		return proprietario;
	}
	
	public int getCapacita() {
		return capacita;
	}
	
	public int getBenzinaPresente() {
		return benzinaPresente;
	}
	
	public double getIncasso() {
		return incasso;
	}
	
	public void setCitta(String citta) {
		this.citta = citta;
	}
	
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	
	public void setCapacita(int capacita) {
		this.capacita = capacita;
	}
	
	public void setBenzinaPresente(int benzinaPresente) {
		if (benzinaPresente > capacita)
			benzinaPresente = capacita;
		this.benzinaPresente = benzinaPresente;
	}
	
	public void setIncasso(double incasso) {
		this.incasso = incasso;
	}
	
	public int compareTo(Distributore o) {
		if (this.getCapacita() > o.getCapacita())
			return 1;
		else if (this.getCapacita() == o.getCapacita())
			return 0;
		else
			return -1;
	}
	
	public void eroga(int quantitaErogata) {
		if (quantitaErogata > benzinaPresente)
			quantitaErogata = benzinaPresente; // Non si può erogare più di quanto ci sia
		setBenzinaPresente(benzinaPresente - quantitaErogata);
		setIncasso(incasso + quantitaErogata * 1.5);
	}
	
	public String toString() {
		return "Citta: " + citta + ", proprietario: " + proprietario + ", capacita: " + capacita + ", benzina presente: " + benzinaPresente + ", incasso giornaliero: " + incasso;
	}
	
	
	
	
	
	
	
}