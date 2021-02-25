import java.util.GregorianCalendar;
import java.util.Date;

public class Prova {
	
	public static void main (String[] args) {
		
		long dieciGiorniMillis = 24 * 60 * 60 * 1000 * 10;
		Date d = new Date(System.currentTimeMillis() + dieciGiorniMillis);
		Date d2 = new Date(System.currentTimeMillis());
		System.out.println(d < d2);
		
	}
	
	
}