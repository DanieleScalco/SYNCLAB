public class Divisione extends OperazioneAstratta implements Operazione {
	
	public Divisione(double x, double y) {
		super(x, y);
	}
	
	@ Override
	public double eseguiOperazione() {
		double risultato = 0;
		try {
			risultato = x / y;
		} catch (ArithmeticException e) {
			System.out.println("Divisione per zero non valida");
		}
		return risultato;
	}
}