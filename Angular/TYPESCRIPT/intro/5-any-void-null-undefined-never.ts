export{};	// Usato perchè altrimenti le variabili di questo file hanno lo stesso scope degli altri
			// e quindi non si possono usare gli stessi nomi

// 1)Se riceviamo dei dati che non sappiamo di che tipo siano possiamo usare any

let age: any = 45;
age = '45';
age = [];

// Array con dati di un qualunque tipo
let userData: any[] = [45, 'Hidran', 'Arias', {address: 'Torino'}];
userData = [4, 4];


// 2) void tipo vuoto, usato per funzioni che non ritornano dati
function printName() : void {
	console.log('error');
}

// 3) never funzione che non ritorna mai niente
function returnNever() : never {
	throw new Error('Erroe');
}

// 4) Undefined è il valore di una variabile finchè non le fiene assegnato un valore
// 5) null è un valore 'vuoto' per una variabile
