package Esercitazione3;

public class Bevanda implements Comparable<Bevanda>{
	
	private String codice; // Di due caratteri: iniziale bevanda e lunghezza nome bevanda
	private String nome;
	private double prezzo;
	
	public Bevanda(String nome, double prezzo) {
		setNome(nome);
		setPrezzo(prezzo);
		String codice = "";
		codice += nome.toUpperCase().charAt(0);
		codice += nome.length();
		setCodice(codice);
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	
	@ Override
	public String toString() {
		return "Codice: " + getCodice() + ", nome: " + getNome() + ", prezzo: " + getPrezzo() + "€";
	}

	@Override
	public int compareTo(Bevanda o) {
		return this.getNome().compareTo(o.getNome());
	}
}
