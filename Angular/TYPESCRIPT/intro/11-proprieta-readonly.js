"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
// una proprietà readonly deve avere un valore quando si crea
// o quando si inizializza nel costruttore
// E' la versione utilizzata da Angular
var Car = /** @class */ (function () {
    // Si possono mettere degli attributi nel costruttore con i modificatori
    // Verranno automaticamente assegnati alla classe se non già presenti come attributi
    function Car(version, name, color) {
        this.name = name;
        this.color = color;
        this.version = '1.1';
        this.version = version;
    }
    /* Non si può modificare il valore di un attributo readonly
    setVersion(version: string) {
        this.version = version
    }
    */
    Car.prototype.getVersion = function () {
        return this.version;
    };
    Car.prototype.getName = function () {
        return this.name;
    };
    return Car;
}());
var car = new Car('2.1', 'Fiat 500', 'Rosso');
console.log(car.getVersion());
console.log(car.color);
console.log(car.getName());
