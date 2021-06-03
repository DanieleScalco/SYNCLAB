export {};

// Differenza abstract/interface, le interface non possono avere implementazioni
// Le classi astratte possono avere metodi implementati

// Ha almeno un metodo astratto
// Non si possono instanziare classi astratte
abstract class Logger {

	// Se c'è un metodo astratto la classe dev'essere astratta
	abstract log(msg: string) : void

	// Una classe astratta può avere metodi concreti implementati
	genereteId() : number {
		return Math.round(Math.random() * 10000000);
	}
}

interface Log {
	msg: string
	id: number

	getMessage() : string
}

class ConsoleLogger extends Logger implements Log {
	
	msg: string;
	id: number;

	getMessage(): string {
		throw new Error("Method not implemented.");
	}

	log(msg: string): void {
		console.log(msg)
	}

}

let Clog = new ConsoleLogger();
Clog.log('Logging to console');
console.log(Clog.genereteId());