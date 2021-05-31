"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
// Le tuple sono array di dati con tipi di dati conosciuti e la quantità non cambia
var parameters;
parameters = ['Hidran', 45];
function showData(params) {
    console.log(params[0] + ', ' + params[1]);
}
showData(parameters);
// Enumerazioni, per convenzione scritte in maiuscolo
// Guardare file.js per vedere come sono fatte
// Vengono enumerate da zero a sei di default
var DAYS;
(function (DAYS) {
    DAYS[DAYS["MON"] = 1] = "MON";
    DAYS[DAYS["TUE"] = 2] = "TUE";
    DAYS[DAYS["WED"] = 3] = "WED";
    DAYS[DAYS["THU"] = 4] = "THU";
    DAYS[DAYS["FRI"] = 5] = "FRI";
    DAYS[DAYS["SAT"] = 6] = "SAT";
    DAYS[DAYS["SUN"] = 7] = "SUN";
})(DAYS || (DAYS = {}));
function isWorkingDay(day) {
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
(function (DAYS) {
    DAYS[DAYS["OTT"] = 8] = "OTT";
    DAYS[DAYS["NON"] = 9] = "NON";
})(DAYS || (DAYS = {}));
console.log(DAYS[1]);
