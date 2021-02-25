public class Moltiplicazione extends OperazioneAstratta implements Operazione {
	
	public Moltiplicazione(double x, double y) {
		super(x, y);
	}
	
	@ Override
	public double eseguiOperazione() {
		return x * y;
	}
}