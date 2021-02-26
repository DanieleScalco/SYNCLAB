package Esercitazione3;

public class BevandaNonValidaException extends Exception{
	public BevandaNonValidaException() {
		super("Codice bevanda non presente nel distributore");
	}
}
