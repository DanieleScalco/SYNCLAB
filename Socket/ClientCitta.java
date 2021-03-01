package Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;


public class ClientCitta {

	Socket client;
	
	int numeroPorta;
	
	DataInputStream in;
	DataOutputStream out;
	
	public ClientCitta(int numeroPorta) {
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
		System.out.println("In attesa di risposta dal server...");
		String message = null;
		try {
			message = in.readLine();
			while (message != null) {
				System.out.println(message);
				message = in.readLine();
			}
			
		} catch (IOException e) {
			System.out.println("Problema in ricezione: " + e.getMessage());
		}
		
	}
	
	public void invia() {
		
		String messaggio;
		Scanner tastiera = new Scanner(System.in);
				
		try {
			System.out.println("Scrivi il nome della tua citta per il server");
			messaggio = tastiera.nextLine();
			out.writeBytes(messaggio + "\n");
			
			System.out.println("Scrivi le condizioni meteo attuali della tua citta");
			messaggio = tastiera.nextLine();
			out.writeBytes(messaggio + "\n");
			
		} catch (IOException e) {
			System.out.println("Problema nell'invio: " + e.getMessage());
		}
		System.out.println("Messagio inviato:");
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
		ClientCitta c = new ClientCitta(6000);
		
		System.out.println("Inizio comunicazione");
		c.invia();
		c.ricevi();
		c.disconnetti();
		
		
	}
}
