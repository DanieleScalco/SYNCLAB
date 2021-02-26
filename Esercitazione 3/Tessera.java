package Esercitazione3;

import java.util.Scanner;

import javax.swing.plaf.basic.DefaultMenuLayout;

public class Tessera {
	
	private int codice;
	private double credito;
	
	public Tessera(int codice, double credito) {
		setCodice(codice);
		setCredito(credito);
	}
	public int getCodice() {
		return codice;
	}
	public void setCodice(int codice) {
		this.codice = codice;
	}
	public double getCredito() {
		return credito;
	}
	public void setCredito(double credito) {
		this.credito = credito;
	}
	
	public void caricaTessera(double creditoCaricato) {
		setCredito(getCredito() + creditoCaricato);
	}
}
