"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
// Classi
var Animal = /** @class */ (function () {
    function Animal(name) {
        this.name = name;
    }
    Animal.prototype.getName = function () {
        return this.name;
    };
    return Animal;
}());
var animale;
animale = new Animal('Pluto');
console.log(animale.getName());
