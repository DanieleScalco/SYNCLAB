package Socket;

public class Citta {
	
	private String nome;
	private String meteo;
	
	public Citta(String nome, String meteo) {
		setMeteo(meteo);
		setNome(nome);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMeteo() {
		return meteo;
	}

	public void setMeteo(String meteo) {
		this.meteo = meteo;
	}

	
}
