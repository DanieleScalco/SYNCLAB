"use strict";
function showUser(user) {
    console.log(user.firstname + ', ' + user.lastname);
}
// Posso riutilizzare un'interfaccia in questo modo
function showUserWithInterface(user) {
    console.log(user.firstname + ', ' + user.lastname);
}
// E' indifferente l'ordine dei campi dell'oggetto
// E' necessario che TUTTI i campi ci siano quando si richiama la funzione, altrimenti dà errore
showUser({ lastname: 'Arias', firstname: 'Hidran' });
showUserWithInterface({ lastname: 'Arias', firstname: 'Hidran' });
function showUser2(user) {
    console.log(user.firstname + ', ' + user.lastname);
}
showUser2({ lastname: 'Arias', firstname: 'Hidran' });
var user3;
// Gli dò un campo in più e lo accetta
user3 = { lastname: 'Scalco', firstname: 'Daniele', address: 'Via Udine, 1', pelato: false };
console.log(user3);
