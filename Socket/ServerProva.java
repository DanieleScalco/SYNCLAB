package Socket;

import java.net.*;
import java.util.Date;

import javax.print.attribute.standard.NumberOfDocuments;

import java.io.*;

public class ServerProva {
	
	ServerSocket server = null;
	Socket client = null;
	
	int porta = 4000;
	
	DataOutputStream out;
	DataInputStream in;
	
	static int numeroVisitatori = 0;
	
	public ServerProva() {
		try {
			System.out.println("Inizializzo il server");
			server = new ServerSocket(porta);
			System.out.println("Server in ascolto sulla porta " + server.getLocalPort() + " all'indirizzo " + server.getInetAddress());
			
			while (true) {
				System.out.println("In attesa di una richiesta di un client");
				client = server.accept();
				numeroVisitatori++;
				System.out.println("Connessione stabilita");
								
				in = new DataInputStream(client.getInputStream());
				out = new DataOutputStream(client.getOutputStream());
				
				attendiMessaggioClient();
			}
			

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void attendiMessaggioClient() {
		System.out.println("Attendendo messaggio dal client");
		try {
			String s = in.readLine();
			System.out.println("Ricevuto messaggio dal client");
			out.writeBytes("Ciao " + s + "\n");
			out.writeBytes("Data: " + new Date(System.currentTimeMillis()) + "\n");
			out.writeBytes("Sei il visitatore numero: " + numeroVisitatori + "\n");
			System.out.println("Messaggio spedito al client");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}	
	}
	
	
	
	
	public static void main(String[] args) {
		ServerProva s = new ServerProva();
	}
	
	 
}