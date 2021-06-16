const { from, of } = require('rxjs');
const { switchMap } = require('rxjs/operators');
const fetch = require('node-fetch');	// Libreria fetch è nativa nel browser

const apiUrl = 'https://jsonplaceholder.typicode.com/albums';

/*
	PROMISE: E’ come se nel programma che stiamo compilando
	inserissimo un segnaposto con la promessa di occuparlo il
	prima possibile con un dato ed in cambio il programma ci
	dia la possibilità di proseguire con le righe successive.
	Restituisce un solo dato.
	Affinchè si possa adottare il concetto di Promise in
	javascript è necessario adottare la notazione delle “Arrow
	function” o funzioni freccia.
	then() funzione chiamata quando la promise ha ottenuto i dati
*/


// CALLBACK: funzione passata come argomento ad un'altra funzione

// https://jsonplaceholder.typicode.com/

const promise = fetch(apiUrl)
				.then(body => body.json())
				//.then(res => console.log(res)); // Commentato perchè vogliamo lavorarci con from

console.log('End promise');

/* switchmap() operatore che trasforma lo stream
	of() operatore simile a from, ma non riceve un array, ma singoli parametri
	
	Es: 
	from([1, 2, 3])
	of(1, 2, 3)
	of(...[1, 2, 3])

	...[]	SPREAD OPERATOR: permette di ottenere una lista di parametri da un array (solo javascript)
*/

// Si può usare from per trasformare una promise in una sorgente di dati
from(promise).pipe(
	//switchMap(resData => from(resData)) // Trasforma lo stream da un array di oggetti ad un insieme di oggetti
	switchMap(resData => of(...resData))
).subscribe({
	next: res => console.log(res)
});
