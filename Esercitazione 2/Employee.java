public class Employee extends Person {
	
	// Attributi
	private int annoDiAssunzione;
	private int stipendio;
	
	
	
	// Costruttori
	public Employee(String surname, String name, String taxCode, String city, int annoDiAssunzione, int stipendio) {
		super(surname, name, taxCode, city);
		setAnnoDiAssunzione(annoDiAssunzione);
		setStipendio(stipendio);
	}
	
	
	
	// Metodi
	public int getAnnoDiAssunzione() {
		return annoDiAssunzione;
	}
	
	public int getStipendio() {
		return stipendio;
	}
	
	public void setAnnoDiAssunzione(int annoDiAssunzione) {
		this.annoDiAssunzione = annoDiAssunzione;
	}
	
	public void setStipendio(int stipendio) {
		this.stipendio = stipendio;
	}
	
	public boolean gainsMore(Employee impiegato) {
		if (this.getStipendio() > impiegato.getStipendio())
			return true;
		else
			return false;
	}
	
	@ Override
	public void visualize() {
		System.out.print("Cognome: " + getSurname());
		System.out.print(", nome: " + getName());
		System.out.print(", CF: " + getTaxCode());
		System.out.print(", citta': " + getCity());
		System.out.print(", anno di assunzione: " + getAnnoDiAssunzione());
		System.out.println(", stipendio: " + getStipendio());
	}
}