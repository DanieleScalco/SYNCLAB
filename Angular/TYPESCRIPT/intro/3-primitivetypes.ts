export {};

// TYPESCRIPT verifica i tipi

// Valori booleani
var isFinished: boolean;

// Valori stringhe
let myname: string; // Di default si ha una variabile dell'oggetto globale chiamata "name"
myname = '5';

// Valori numerici
let age: number;
age = 50;

// Array
let array: number[];
array = [1, 2];

// Si possono passare pure oggetti generici (es: T)
let array2: Array<string> = ["Hello", "World"];
console.log(array2);

// Object
let obj: object;
obj = {
	"nome": 'oggetto',
	"cognome": 'pippo',
};

console.log(obj);