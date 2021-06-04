export{};

function myFunction() {

}

let myFunc = function() {

}
myFunc();

// Nelle arrow function le graffe sono necessarie se ci sono più istruzioni
// funzione = (lista parametri) : tipoRitorno => {istruzioni}
let myArrowFunc = (e: any) => {console.log(e)}
let myArrowFunc2 = (e: number) : number => e*2;
// Si richiamano con l'operatore() con dentro i vari parametri
myArrowFunc('prova');
console.log(myArrowFunc2(3));


function func(x: string, y: number) : void {

}

let myFunc2 : (x: string, y: number) => void;
// Abbiamo assegnato come tipo una funzione con due parametri string e number (il nome dei parametri non deve coincidere)
// e tipo di ritorno void

myFunc2 = func;
myFunc2 = function(nome: string, eta: number) {
	console.log(nome + ' ha ' + eta + ' anni');
};

myFunc2('Daniele', 27);