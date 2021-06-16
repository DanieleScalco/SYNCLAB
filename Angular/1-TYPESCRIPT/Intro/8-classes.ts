export {};

// Classi
class Animal {

	name: string

	constructor(name: string) {

		this.name = name
	}

	getName() {
		return this.name
	}
}

let animale: Animal;
animale = new Animal('Pluto');
console.log(animale.getName());