export {};

class AnimalBase {
	name: string

	constructor(name: string) {
		this.name = name;
	}

	move(distance: number) {
		console.log('I am moving ' + distance);
	}
	getName() : string {
		return this.name;
	}
}

// Se una classe figlia non ha costruttore chiama il costruttore
// del padre
class Bird extends AnimalBase {
	place: string	// Se un valore non viene inizializzato è undefined

	// Si può impostare un valore di default
	constructor(name: string, place: string = 'Sea') {
		super(name);	// Dev'essere chiamato come prima istruzione
		this.place = place;
	}
	getPlace() : string {
		return this.place;
	}

	setPlace(place: string) : void {
		this.place = place;
	}

	// Come fare l'override
	move(distance: number) {
		// super.move(distance); // Richiamo il metodo del padre
		console.log('I am flying ' + distance);
	}
}

let dove = new Bird('Dove');
console.log(dove.getName());
console.log(dove.getPlace());
dove.move(50);
