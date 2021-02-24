import java.util.Date;

public class ProdottoAlimentare extends Prodotto {
	
	// Attributi
	private Date dataDiScadenza;
	
	// Costruttori
	public ProdottoAlimentare(String descrizione, double prezzoUnitario, Date data) {
		super(descrizione, prezzoUnitario);
		setDataDiScadenza(data);
	}
	
	// Metodi
	public Date getDataDiScadenza() {
		return dataDiScadenza;
	}
	
	public void setDataDiScadenza(Date data) {
		dataDiScadenza = data;
	}
	
	@ Override
	public String toString() {
		return super.toString() + ", data di scadenza: " + getDataDiScadenza();
	}
	
	@ Override
	public void applicaSconto() {
		long dataAttualeMillis = System.currentTimeMillis();
		long dataScadenzaMillis = getDataDiScadenza().getTime();
		long divarioDateMillis = dataScadenzaMillis - dataAttualeMillis;
		long giorni = divarioDateMillis / 1000 / 60 / 60 / 24;
		
		if (giorni <= 10) {
			double ventiPerCento = getPrezzoUnitario() / 100 * 20;
			setPrezzoUnitario(getPrezzoUnitario() - ventiPerCento);
		}
		
	}
	
	
	
	
	
	
	
	
}
