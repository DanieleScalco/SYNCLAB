const { Observable } = require('rxjs'); // importato observable

const objs = new Observable(subscriber => {

	// Next, error e complete sono i tre metodi che si possono chiamare
	// Con next diamo il prossimo valore che l'osservatore riceverà quando farà la subscribe

	subscriber.next(1); // next() eseguito in maniera SINCORNA
	subscriber.next(2);
	
	// Due argomenti, 1-funzione che dice cosa fare, 2-tempo in ms dopo il quale chiamare la funzione precedente
	setTimeout(() => { subscriber.next(4); }, 4000); // next() eseguito in maniera ASINCRONA

	// subscriber.complete(); // Una volta chiamata la complete() i successivi next non verrano emessi
						   // Neanche quello col timeout
						   
	subscriber.next(3); // Non chiamato se dopo complete()
});

/* Ogni volta che viene chiama la subscribe con questo tipo di observable i valori verranno riemessi
subscribe riceve un oggetto con tre argomenti
	1 funzione che dice cosa fare con gli argomenti ricevuti
	2 funzione che dice cosa fare in caso di errore
	3 funzione che dice cosa fare quando è completato
*/
objs.subscribe({
	next: (v) => console.log(v),
	error: (error) => console.log(error),
	complete: () =>	console.log('values completed') // le tonde indicano che non c'è nessun parametro
});

console.log();

objs.subscribe({
	next: (v) => console.log('Subscribe2: ' + v),
	error: (error) => console.log(error),
	complete: () =>	console.log('Subscribe2 finished')
});