public class Audio extends ElementoMultimediale implements Riproducibile {
	
	// Attributi
	private int volume;
	private int durata;
	
	// Costruttore
	public Audio(String titolo, int volume, int durata) {
		super(titolo);
		setVolume(volume);
		setDurata(durata);
	}
	
	// Metodi
	public int getVolume() {
		return volume;
	}
	
	public void setVolume(int volume) {
		if (volume < 1)
			volume = 1;
		this.volume = volume;
	}
	
	public int getDurata() {
		return durata;
	}
	
	public void setDurata(int durata) {
		if (durata < 1)
			durata = 1;
		this.durata = durata;
	}
	
	public void weaker() {
		if (volume > 1)
			volume--;
	}
	
	public void louder() {
		volume++;
	}
	
	public void play() {
		String s = "";
		s += this.getTitolo();
		for (int i = 0; i < getVolume(); i++) {
			s += "!";
		}
		
		for (int i = 0; i < getDurata(); i++) {
			System.out.println(s);
		}
	}
	
	@ Override
	public void esegui() {
		play();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}