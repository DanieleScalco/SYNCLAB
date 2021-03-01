package Socket;

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class ClientProva {
	
	Socket socket = null;
	
	int porta = 4000;
	
	DataInputStream in;
	DataOutputStream out;
	
	public ClientProva() {
		
		Socket server = null;
		try {
			System.out.println("Provo a connettermi al server");
			server = new Socket(InetAddress.getLocalHost(), porta);
			System.out.println("Connesso al server");
			
			in = new DataInputStream(server.getInputStream());
			out = new DataOutputStream(server.getOutputStream());
			
		} catch (IOException e) {
			System.out.println(e.getMessage());	
		}
	}
	
	public void scrivi() {
		System.out.println("Scrivi il tuo nome da inviare al server");
		String nome;
		Scanner tastiera = new Scanner(System.in);
		nome = tastiera.next();
		try {
			out.writeBytes(nome + "\n");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
	
	public void ricevi() {
		System.out.println("In attesa di risposta dal server");
		String s = "";
		try {
			s += in.readLine() + "\n";
			s += in.readLine() + "\n";
			s += in.readLine() + "\n";
		} catch (IOException e) {
			System.out.println(e.getMessage());;
		}
		System.out.println("Il server ha risposto: " + s);
	}
	
	public void close() {
		if (socket != null)
			try {
				socket.close();
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
		System.out.println("Socket chiusa correttamente");
	}
	public static void main(String[] args) {
		ClientProva c = new ClientProva();
		c.scrivi();
		c.ricevi();
		c.close();
	}
}