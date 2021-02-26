package Esercitazione3;

public class TesseraNonValidaException extends Exception {
	public TesseraNonValidaException() {
		super("CODICE TESSERA ERRATO");
	}
	
	public TesseraNonValidaException(String message) {
		super(message);
	}
}
