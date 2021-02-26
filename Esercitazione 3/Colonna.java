package Esercitazione3;

public class Colonna {
	
	private Bevanda bevanda;
	private int numeroLattine;
	private String tipoBevanda;
	private int numeroColonna;
	

	public Colonna(Bevanda bevanda, int numeroLattine, int numeroColonna) {
		setBevanda(bevanda);
		setNumeroLattine(numeroLattine);
		setNumeroColonna(numeroColonna);
		setTipoBevanda(bevanda.getNome());
	}
	
	public Colonna(int numeroColonna) {
		setBevanda(null);
		setNumeroLattine(0);
		setTipoBevanda(null);
		setNumeroColonna(numeroColonna);
	}
	public int getNumeroColonna() {
		return numeroColonna;
	}

	public void setNumeroColonna(int numeroColonna) {
		this.numeroColonna = numeroColonna;
	}
	
	public Bevanda getBevanda() {
		return bevanda;
	}

	public void setBevanda(Bevanda bevanda) {
		this.bevanda = bevanda;
	}

	public int getNumeroLattine() {
		return numeroLattine;
	}

	public void setNumeroLattine(int numeroLattine) {
		this.numeroLattine = numeroLattine;
	}

	public String getTipoBevanda() {
		return tipoBevanda;
	}

	public void setTipoBevanda(String tipoBevanda) {
		this.tipoBevanda = tipoBevanda;
	}
	
	public boolean isVuota() {
		if (bevanda == null)
			return true;
		else
			return false;
	}
	
	public void svuotaColonna() {
		setBevanda(null);
		setTipoBevanda(null);
		setNumeroLattine(0);
	}
}
