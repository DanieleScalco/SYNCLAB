public class Person {
	
	// Attributi
	private String surname;
	private String name;
	private String taxCode;
	private String city;
	
	
	
	// Costruttori
	public Person() {
		this(null, null, null, null);
	}
	
	public Person(String surname, String name, String taxCode, String city) {
		setSurname(surname);
		setName(name);
		setTaxCode(taxCode);
		setCity(city);
	}
	
	
	
	// Altri metodi
	public String getSurname() {
		return surname;
	}
	
	public String getName() {
		return name;
	}
	
	public String getTaxCode() {
		return taxCode;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public int bornYear() {
		String anno;
		int annoDiNascita = 0;
		
		anno = taxCode.substring(6, 8);
		annoDiNascita = Integer.parseInt(anno);
		
		// Non ho capito se c'è un modo per capire se ad esempio
		// 00 indichi 1900 oppure 2000 come anno di nascita.
		annoDiNascita += 1900;
		
		return annoDiNascita;
	}
	
	public void visualize() {
		System.out.print("Cognome: " + getSurname());
		System.out.print(", nome: " + getName());
		System.out.print(", CF: " + getTaxCode());
		System.out.println(", citta': " + getCity());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}