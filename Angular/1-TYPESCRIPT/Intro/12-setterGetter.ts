export {};

class User {
	private _name: string // underscore per dire che è privata

	set name(name: string) {
		this._name = name.toUpperCase();
	}

	get name() {
		return this._name;
	}

}

let user = new User();
user.name = 'Hidran'	// Sto chiamando il setter, name è privato
console.log(user.name);