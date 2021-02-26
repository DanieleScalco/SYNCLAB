package Esercitazione3;

public class CreditoInsufficienteException extends Exception{
	public CreditoInsufficienteException() {
		super("CREDITO INSUFFICIENTE, RICARICA LA CARTA E RIPROVA");
	}
}
