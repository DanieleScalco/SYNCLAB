// from() è un metodo che ci permette di creare un observable da uno stream di dati (es: array, evento, promise)

const { from } = require('rxjs');
const { filter, map, tap } = require('rxjs/operators');

// Se errore del tipo: 'map is not defined' probabilmente non è stato importanto l'elemento
from([1, 2, 3, 4, 5, 6, 7, 8, 9]).pipe(
	filter(number => number % 2 === 0),	// filter seleziona quali elementi prendere
	tap(ele => console.log('tap = ' + ele)), // tap non ritorna nulla, ci permette di chiamare funzioni senza modificare nulla
	map(number => number * number) // map modifica l'elemento
)
.subscribe({
	next: ele => console.log(ele)
});