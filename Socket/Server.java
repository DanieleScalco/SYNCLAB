package Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {
	
	ServerSocket server;
	Socket client;
	
	int numeroPorta;
	
	DataInputStream in;
	DataOutputStream out;
	
	public Server(int numeroPorta) {
		try {
			server = new ServerSocket(numeroPorta);
			System.out.println("In attesa di connessione col client...");
			
			client = server.accept();
			System.out.println("Connessione effettuata");
			this.numeroPorta = numeroPorta;
			
			in = new DataInputStream(client.getInputStream());
			out = new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			System.out.println("Errore creazione socket: " + e.getMessage());
		}	
	}
	
	public void ricevi() {
		System.out.println("In attesa di un messaggio dal client...");
		String message = null;
		try {
			message = in.readLine();
		} catch (IOException e) {
			System.out.println("Problema in ricezione: " + e.getMessage());
		}
		System.out.println("Il client ha inviato:");
		System.out.println(message);
	}
	
	public void invia() {
		System.out.println("Rispondi al client");
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
		Server s = new Server(5000);
		boolean finito = false;
		
		System.out.println("Inizio comunicazione");
		while (!finito) {
			s.ricevi();
			s.invia();
		}
	}
	
	
}
