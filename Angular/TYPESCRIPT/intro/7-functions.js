"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
function myFunction() {
}
var myFunc = function () {
};
myFunc();
// Nelle arrow function le graffe sono necessarie se ci sono più istruzioni
var myArrowFunc = function (e) { console.log(e); };
var myArrowFunc2 = function (e) { return e * 2; };
myArrowFunc('prova');
console.log(myArrowFunc2(3));
function func(x, y) {
}
var myFunc2;
// Abbiamo assegnato come tipo una funzione con due parametri string/number (il nome dei parametri non deve coincidere)
// e tipo di ritorno void
myFunc2 = func;
myFunc2 = function (nome, eta) {
    console.log(nome + ' ha ' + eta + ' anni');
};
myFunc2('Daniele', 27);
