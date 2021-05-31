export {};

// Le tuple sono array di dati con tipi di dati conosciuti e la quantità non cambia

let parameters:[string, number];

parameters = ['Hidran', 45];

function showData(params : [string, number]) {
	console.log(params[0] + ', ' + params[1]);
}

showData(parameters);

// Enumerazioni, per convenzione scritte in maiuscolo
// Guardare file.js per vedere come sono fatte

// Vengono enumerate da zero a sei di default
enum DAYS {
	MON = 1,	// Se si vuole modificare il valore di inizio
	TUE,
	WED,
	THU,
	FRI,
	SAT,
	SUN
}

function isWorkingDay( day : DAYS) {
	if (day === DAYS.SUN || day === DAYS.SAT)
		return true;
	else
		return false;
}

console.log(DAYS.SAT); // Se MON = 1, si ottiene 6
console.log(DAYS[6]);
console.log('Venerdì è un giorno lavorativo? ' + isWorkingDay(DAYS.FRI));
console.log('Sabato è un giorno lavorativo? ' + isWorkingDay(DAYS.SAT));
console.log('Posso passare chiave. ' + isWorkingDay(DAYS.SAT));
console.log('Oppure indice. ' + isWorkingDay(7));
console.log('Ma l\'indice può essere fuori!!!. ' + isWorkingDay(50) + '\nIl tipo sarà ' + DAYS[50]);

// E possibile aggiungere in seguito altri elementi all'enum
enum DAYS {
	OTT = 8,	// Mettere indice giusto per evitare la sovrascrizione
	NON
}

console.log(DAYS[1]);
