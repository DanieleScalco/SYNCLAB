public class Divisione extends OperazioneAstratta implements Operazione {
	
	public Divisione(double x, double y) {
		super(x, y);
	}
	
	@ Override
	public double eseguiOperazione() {
		if (y == 0)
			return 0.123456789;
		return x / y;
	}
}