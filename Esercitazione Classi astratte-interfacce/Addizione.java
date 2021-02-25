public class Addizione extends OperazioneAstratta implements Operazione {
	
	public Addizione(double x, double y) {
		super(x, y);
	}
	
	@ Override
	public double eseguiOperazione() {
		return x + y;
	}
}