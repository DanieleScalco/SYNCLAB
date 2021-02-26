package Esercitazione3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Distributore {

	// Attributi
	private LinkedList<Colonna> listaColonne = new LinkedList<Colonna>();
	private LinkedList<Tessera> listaTessere = new LinkedList<Tessera>();
	
	// Costruttore
	public Distributore(int numeroColonne) {
		if (numeroColonne < 1)
			numeroColonne = 4;
		for (int i = 0; i < numeroColonne; i++)
			listaColonne.add(new Colonna(i + 1));
	}
	
	// Metodi
	public LinkedList<Tessera> getListaTessere() {
		return listaTessere;
	}
	
	public LinkedList<Colonna> getListaColonne() {
		return listaColonne;
	}

	public void aggiungiBevanda() {
		if (isPieno()) {
			System.out.println("Il distributore non ha colonne libere per nuove bevande");
			return;
		}	
		
		Scanner tastiera = new Scanner(System.in);
		String nuovaBevanda;
		double nuovoPrezzo;
		int numeroLattine;
		
		System.out.println("Inserisci il nome della bevanda che vuoi inserire:");
		nuovaBevanda = tastiera.nextLine();
		
		
		
		
		Iterator<Colonna> it;
		Colonna tmp;
		System.out.println("Inserisci il prezzo della nuova bevanda:");
		nuovoPrezzo = tastiera.nextDouble();
		System.out.println("Inserisci il numero di lattine da inserire:");
		numeroLattine = tastiera.nextInt();
		
		it = listaColonne.iterator();
		while (it.hasNext()) {
			tmp = it.next();
			if (tmp.getTipoBevanda() == null) {
				tmp.setBevanda(new Bevanda(nuovaBevanda, nuovoPrezzo));
				tmp.setNumeroLattine(0);
				tmp.setTipoBevanda(nuovaBevanda);
				tmp.setNumeroLattine(numeroLattine);
				return;
			}
		}
		
	}
	
	public void mostraBevande() {
		int i = 1;
		if (isVuoto())
			System.out.println("Il distributore non contiene bevande");
		else {
			for (Colonna c: listaColonne) {
				System.out.print("Colonna " + i + ": ");
				if (c.getBevanda() != null)
					System.out.println(c.getBevanda() + ", numero lattine: " + c.getNumeroLattine());
				else
					System.out.println("vuota");
				i++;
			}
		}
	}
	
	public int acquistaBevanda() throws BevandaNonValidaException, BevandaEsauritaException, CreditoInsufficienteException{
		String codiceBevanda;
		int codiceTessera;
		Scanner tastiera = new Scanner(System.in);
		
		System.out.println("Inserisci codice bevanda da acquistare:");
		codiceBevanda = tastiera.nextLine();
		
		for (Colonna c: listaColonne) {
			if (c.getBevanda() != null && c.getBevanda().getCodice().equalsIgnoreCase(codiceBevanda)) {
				if (c.getNumeroLattine() == 0) {
					throw new BevandaEsauritaException();
				} else {
					System.out.println("Inserisci codice tessera da usare per pagare:");
					codiceTessera = tastiera.nextInt();
					Tessera tmp = getTessera(codiceTessera);
					if (tmp == null)
						System.out.println("Tessera non ancora memorizzata");
					else {
						if (tmp.getCredito() < c.getBevanda().getPrezzo())
							throw new CreditoInsufficienteException();
						else {
							tmp.setCredito(tmp.getCredito() - c.getBevanda().getPrezzo());
							System.out.println("E' uscita " + c.getTipoBevanda() + " dal distributore");
							aggiornaColonna(c.getNumeroColonna(), c.getTipoBevanda(), c.getBevanda().getPrezzo(), c.getNumeroLattine() - 1);
						}
					}
				}
				
				return c.getNumeroColonna();
			}				
		}
		
		// Se si arriva qui non si ha inserito un codice bevanda valido
		throw new BevandaNonValidaException();
	}
	
	public void aggiornaColonna(int numeroColonna, String tipoBevanda, double prezzo, int numeroLattine) {
		if (numeroColonna > listaColonne.size() + 1)
			return;
		
		Iterator<Colonna> it = listaColonne.iterator();
		Colonna tmp = null;
		for (int i = 0; i < numeroColonna; i++) {
			tmp = it.next();
		}
		
		// Ora tmp punta alla colonna da aggiornare
		tmp.setBevanda(new Bevanda(tipoBevanda, prezzo));
		tmp.setTipoBevanda(tipoBevanda);
		tmp.setNumeroLattine(numeroLattine);
	}
	
	public int lattineDisponibili(String codice) {
		int totale = 0;
		for (Colonna c: listaColonne) {
			if (c.getBevanda() != null && c.getBevanda().getCodice().equals(codice))
				totale += c.getNumeroLattine();
		}
		return totale;
	}
	
	public boolean isPieno() {
		for (Colonna c: listaColonne) {
			if (c.getBevanda() == null)
				return false;
		}
		return true;
	}
	
	public boolean isVuoto() {
		for (Colonna c: listaColonne) {
			if (c.getBevanda() != null)
				return false;
		}
		return true;
	}
	
	// Se non c'è la tessera restituisce null
	public Tessera getTessera(int codice) {
		for (Tessera t: listaTessere) {
			if (t.getCodice() == codice)
				return t;
		}
		return null;
	}
	
	public void leggiCredito() throws TesseraNonValidaException {
		Scanner tastiera = new Scanner(System.in);
		int codice;
		
		System.out.println("Inserisci il codice della tessera:");
		codice = tastiera.nextInt();
		for (Tessera t: listaTessere) {
			if (codice == t.getCodice()) {
				System.out.println("Credito della tessera: " + t.getCredito() + "€");
				return;
			}
		}
		
		throw new TesseraNonValidaException("TESSERA NON PRESENTE");
	}
	
	public boolean esisteCodice(String codiceBevanda) {
		for (Colonna c: listaColonne) {
			if (c.getBevanda() != null && c.getBevanda().getCodice().equalsIgnoreCase(codiceBevanda))
				return true;
		}
		return false;
	}
	
	
}
