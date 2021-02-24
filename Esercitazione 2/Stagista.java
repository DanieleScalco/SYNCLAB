public class Stagista extends Person {
	
	// Attributi
	private int numberOfPresence;
	private int idNumber;
	
	
	
	// Costruttori
	public Stagista(String surname, String name, String taxCode, String city, int numberOfPresence, int idNumber) {
		super(surname, name, taxCode, city);
		setNumberOfPresence(numberOfPresence);
		setIdNumber(idNumber);
	}
	
	
	
	// Metodi
	public int getNumberOfPresence() {
		return numberOfPresence;
	}
	
	public int getIdNumber() {
		return idNumber;
	}
	
	public void setNumberOfPresence(int numberOfPresence) {
		this.numberOfPresence = numberOfPresence;
	}
	
	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}
	
	
	
	
	
	
	
	
	
	
}