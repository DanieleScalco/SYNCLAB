package Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	Socket client;
	
	int numeroPorta;
	
	DataInputStream in;
	DataOutputStream out;
	
	public Client(int numeroPorta) {
		System.out.println("Collegamento col server...");
		try {
			client = new Socket(InetAddress.getLocalHost(), numeroPorta);
			System.out.println("Collegamento col server riuscito");
			this.numeroPorta = numeroPorta;
			
			in = new DataInputStream(client.getInputStream());
			out = new DataOutputStream(client.getOutputStream());
			
		} catch (IOException e) {
			System.out.println("Errore creazione socket: " + e.getMessage());
		}
	}
	
	public void ricevi() {
		System.out.println("In attesa di un messaggio dal server...");
		String message = null;
		try {
			message = in.readLine();
		} catch (IOException e) {
			System.out.println("Problema in ricezione: " + e.getMessage());
		}
		System.out.println("Il server ha inviato:");
		System.out.println(message);
	}
	
	public void invia() {
		System.out.println("Scrivi un messaggio per il server");
		String message;
		Scanner tastiera = new Scanner(System.in);
		
		message = tastiera.nextLine();
		
		try {
			out.writeBytes(message + "\n");
		} catch (IOException e) {
			System.out.println("Problema nell'invio: " + e.getMessage());
		}
		System.out.println("Messagio inviato:");
	}
	
	public static void main(String[] args) {
		Client c = new Client(5000);
		boolean finito = false;
		
		System.out.println("Inizio comunicazione");
		while (!finito){
			c.invia();
			c.ricevi();
		} 
	}
}
