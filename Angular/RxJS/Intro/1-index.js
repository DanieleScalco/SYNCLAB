const { range } = require("rxjs");
const { map, filter } = require("rxjs/operators");

// Stream: 1 - 2 - 3 - 4 - 5 - ...
range(1, 200)
  .pipe(
    filter(x => x % 2 === 1),	// Con filter si filtrano i dati dello stream (in questo caso si prendono i numeri dipsari)
    map(x => x + x)	// Agisce sul risultato di filter, sommando il numero a sè stesso
  )
  .subscribe(x => console.log(x)); // si applica sul risultato
