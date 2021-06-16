export {};

// una proprietà readonly deve avere un valore quando si crea
// o quando si inizializza nel costruttore
// E' la versione utilizzata da Angular
class Car {
	readonly version: string = '1.1'	

	// Si possono mettere degli attributi nel costruttore con i modificatori
	// Verranno automaticamente assegnati alla classe se non già presenti come attributi
	constructor(version: string, protected name: string, public color: string) {
		this.version = version
		this.name = name;
		this.color = color;
	}

	/* Non si può modificare il valore di un attributo readonly
	setVersion(version: string) {
		this.version = version
	}
	*/

	getVersion() {
		return this.version
	}

	getName() {
		return this.name
	}
}

let car = new Car('2.1', 'Fiat 500', 'Rosso')
console.log(car.getVersion());
console.log(car.color);
console.log(car.getName());