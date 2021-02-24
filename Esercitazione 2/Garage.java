public class Garage {
	
	public int repair(Vehicle veicolo) {
		int costo = 500;
		if (veicolo.isGuasto()) {
			veicolo.setGuasto(false);
			costo += 1000;
		}
		
		Car tmp = new Car("", "", "", "");
		if (veicolo.getClass() == tmp.getClass()) {
			tmp = (Car) veicolo;
			switch (tmp.getTipologia()) {
				case("SUV"):
					costo += 300;
					break;
				case("station wagon"):
					costo += 100;
					break;
				default:
					costo += 50;
					break;
			}
		}
		
		return costo;
	}
}