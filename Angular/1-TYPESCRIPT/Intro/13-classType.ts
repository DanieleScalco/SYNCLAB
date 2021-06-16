export {};

class MyLogger {

	log(msg: string) : void {
		console.log(msg);
	}

	generateId() : number {
		return Math.round(Math.random() * 10000000);
	}
}

// Un'interface può estendere una classe!!!, prendendo la signature
// dei suoi metodi e i suoi attributi
interface MyLog extends MyLogger {
	email: string

	// Ha anche i metodi log() e generateId()
}

class MyMailLogger implements MyLog {
	
	// Componente esclusiva di MyLog
	email: string;
	
	// Componente di MyLog presa da MyLogger
	log() {

	}
	generateId(): number {
		return 1;
	}
	
}

// Le classi sono dei tipi
let mailLog: MyMailLogger;

function logData(logger: MyMailLogger) {
	return logger.generateId();
}

mailLog = new MyMailLogger();
console.log(logData(mailLog));