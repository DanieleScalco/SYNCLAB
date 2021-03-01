package IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.naming.ldap.PagedResultsResponseControl;

public class TestIO {
	
	public static void main(String[] args) {
		
		FileOutputStream fos = null;
		PrintWriter p = null;
		String nomeFile = "Prova.txt";
		/*
		try {
			fos = new FileOutputStream(nomeFile);
			p = new PrintWriter(fos, true);
			p.println(("TITOLO FILE DI PROVA\n\nContenuto file di prova"));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		leggiFile(nomeFile);
		System.out.println("Il file ha " + contaParole(nomeFile) + " parole");
		
		try {
			fos = new FileOutputStream("double.txt");
			p = new PrintWriter(fos, true);
			p.print(0.2);
			p.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		leggiFile("double.txt");
		
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		FileInputStream fis = null;
		try {
			fos = new FileOutputStream("Impiegato");
			oos = new ObjectOutputStream(fos);
			Impiegato i = new Impiegato("Daniele", "Scalco", "1234");
			Impiegato i2 = new Impiegato("Daniele", "Clone", "12345");
			oos.writeObject(i);
			oos.writeObject(i2);
			fis = new FileInputStream("Impiegato");
			ois = new ObjectInputStream(fis);
			Impiegato tmp = (Impiegato) ois.readObject();
			System.out.println(tmp);
			tmp = (Impiegato) ois.readObject();
			System.out.println(tmp);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		*/
		
		try {
			copiaFile();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void leggiFile(String nomeFile) {

		FileInputStream in = null;
		try {
			in = new FileInputStream(nomeFile);
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader d = new BufferedReader(isr);
			// BufferedReader d = new BufferedReader(new InputStreamReader(new FileInputStream(nomeFile)));
			boolean finito = false;
			while (!finito) {
				String s = d.readLine();
				if (s == null) {
					finito = true;
				} else {
					System.out.println(s);
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static int contaParole(String nomeFile) {
		int totale = 0;
		File file = new File(nomeFile);
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNext()) {
				String parola = scanner.next();
				totale++;
				System.out.println(parola);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		return totale;
	}
	

	public static void copiaFile() throws FileNotFoundException, IOException {
		File originale = new File("Sfondo Zed.jpg");
		File copia = new File("Sfondo Zed (1).jpg");
		InputStream in = new FileInputStream(originale);
		OutputStream out = new FileOutputStream(copia);
		byte[] buffer = new byte[1024];
		int len;
		len = in.read(buffer);
		
		while (len > 0) {
			out.write(buffer, 0, len);
			len = in.read(buffer);
        }
		
		in.close();
		out.close();
   }
		
	
	
}
