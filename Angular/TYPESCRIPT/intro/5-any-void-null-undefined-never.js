"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
// e quindi non si possono usare gli stessi nomi
// 1)Se riceviamo dei dati che non sappiamo di che tipo siano possiamo usare any
var age = 45;
age = '45';
age = [];
// Array con dati di un qualunque tipo
var userData = [45, 'Hidran', 'Arias', { address: 'Torino' }];
userData = [4, 4];
// 2) void tipo vuoto, usato per funzioni che non ritornano dati
// Nelle funzioni, se si vuole, si può specificare il tipo di ritorno
function printName() {
    console.log('error');
}
// 3) never funzione che non ritorna mai niente (quindi può lanciare solo errori)
function returnNever() {
    throw new Error('Errore');
}
// 4) Undefined è il valore di una variabile finchè non le viene assegnato un valore
// 5) null è un valore 'vuoto' per una variabile
