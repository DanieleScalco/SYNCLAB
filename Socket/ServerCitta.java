package Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import Esercitazione3.MetodiListe;


public class ServerCitta {
	
	ServerSocket server;
	Socket client;
	
	int numeroPorta;
	
	DataInputStream in;
	DataOutputStream out;
	
	Citta[] citta;
	
	String cittaInviata;
	String meteoCittaInviata;
	
	public ServerCitta(int numeroPorta) {
		try {
			server = new ServerSocket(numeroPorta);
			System.out.println("In attesa di connessione col client...");
			this.numeroPorta = numeroPorta;
			
			citta = new Citta[5];
			citta[0] = new Citta("Gallarate", "Sole");
			citta[1] = new Citta("Busto Arsizio", "Pioggia");
			citta[2] = new Citta("Milano", "Nuvoloso");
			citta[3] = new Citta("Aosta", "Neve");
			citta[4] = new Citta("Atlantide", "Uragano");
		} catch (IOException e) {
			System.out.println("Errore creazione socket: " + e.getMessage());
		}	
	}
	
	public void connetti() {
		try {
			client = server.accept();
			
			System.out.println("Connessione effettuata");
			
			in = new DataInputStream(client.getInputStream());
			out = new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			System.out.println("Problema di connessione: "+ e.getMessage());		}
		
	}
	
	public void ricevi() {
		System.out.println("In attesa di un messaggio dal client...");
		
		try {
			cittaInviata = in.readLine();
			meteoCittaInviata = in.readLine();
		} catch (IOException e) {
			System.out.println("Problema in ricezione: " + e.getMessage());
		}
		
	}
	
	public void invia() {
		String risposta = "";
		try {
			for (int i = 0; i < citta.length; i++) {
				if (!citta[i].getNome().equalsIgnoreCase(cittaInviata)) {
					risposta += citta[i].getNome() + " " + citta[i].getMeteo() + "\n";
				} else {
					citta[i].setMeteo(meteoCittaInviata);
				}
			}
			out.writeBytes(risposta);
			System.out.println("Messaggio inviato");
		} catch (IOException e) {
			System.out.println("Problema nell'invio: " + e.getMessage());
		}
		
	}
	
	public void disconnetti() {
		if (client != null)
			try {
				client.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		if (in != null)
			try {
				in.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		if (out != null)
			try {
				out.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		System.out.println("Disconnesso");
	}
	
	public static void main(String[] args) {
		ServerCitta s = new ServerCitta(6000);
		String messaggioRicevuto = null;
		
		while (true) {
			System.out.println("In attesa di un client...");
			s.connetti();
			s.ricevi();
			s.invia();
			s.disconnetti();
		}
	}
	
	
}
