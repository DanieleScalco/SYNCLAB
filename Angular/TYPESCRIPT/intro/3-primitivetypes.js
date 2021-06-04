"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
// TYPESCRIPT verifica i tipi
// let è una variabile che vale solo all'interno dello scope a differenza di var
// Valori booleani
var isFinished;
// Valori stringhe
var myName; // Di default si ha una variabile dell'oggetto globale chiamata "name"
myName = '5';
// Valori numerici
var age;
age = 50;
// Array
var array;
array = [1, 2];
// Si possono passare pure oggetti generici (es: T)
var array2 = ["Hello", "World"];
console.log(array2);
// Object
var obj;
obj = {
    "nome": 'oggetto',
    "cognome": 'pippo',
};
console.log(obj);
