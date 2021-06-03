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
user.name = 'Hidran'
console.log(user.name);