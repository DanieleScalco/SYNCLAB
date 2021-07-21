export {};

// TYPESCRIPT verifica i tipi
// let è una variabile che vale solo all'interno dello scope a differenza di var

// Valori booleani
var isFinished: boolean;

// Valori stringhe
let myName: string; // Di default si ha una variabile dell'oggetto globale chiamata "name"
myName = '5';

// Valori numerici
let age: number;
age = 50;

// Array
let array: number[];
array = [1, 2];

// Si possono passare pure oggetti generici (es: T). Due notazioni per dichiarare un array
let array2: Array<string> = ["Hello", "World"];
console.log(array2);

// Object
let obj: object;
obj = {
	"nome": 'oggetto',
	"cognome": 'pippo',
};

console.log(obj);