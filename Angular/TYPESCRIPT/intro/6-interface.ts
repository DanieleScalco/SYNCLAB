// Posso definire un'interfaccia per riusare del codice
interface IUser {
	lastname: string,
	firstname: string
}

function showUser(user: {lastname: string, firstname: string}) {
	console.log(user.firstname + ', ' + user.lastname);
}

// Posso riutilizzare un'interfaccia in questo modo
function showUserWithInterface(user: IUser) {
	console.log(user.firstname + ', ' + user.lastname);
}

// E' indifferente l'ordine dei campi dell'oggetto
// E' necessario che TUTTI i campi ci siano quando si richiama la funzione, altrimenti dà errore
showUser({lastname: 'Arias', firstname: 'Hidran'});
showUserWithInterface({lastname: 'Arias', firstname: 'Hidran'});


// Interface con proprietà non tutte obbligatorie
interface IUser2 {
	lastname: string,
	firstname: string,
	address?: string	// Col punto di domanda indico che il dato è opzionale
}

function showUser2(user: IUser2) {
	console.log(user.firstname + ', ' + user.lastname);
}
showUser2({lastname: 'Arias', firstname: 'Hidran'});


interface IUser3 {
	lastname: string,
	firstname: string,
	address?: string,
	[propName: string]: any	// Necessario quando si ricevono oggetti con più proprietà
							// Si usa per evitare gli errori quando si ritirano oggetti
							// da altre parti e questi magari vengono aggiornati con nuovi attributi
}

let user3 : IUser3;
// Gli dò un campo in più e lo accetta
user3 = {lastname: 'Scalco', firstname: 'Daniele', address: 'Via Udine, 1', pelato: false};
console.log(user3);
