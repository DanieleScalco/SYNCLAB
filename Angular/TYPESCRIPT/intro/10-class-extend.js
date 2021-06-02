"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
Object.defineProperty(exports, "__esModule", { value: true });
var AnimalBase = /** @class */ (function () {
    function AnimalBase(name) {
        this.name = name;
    }
    AnimalBase.prototype.move = function (distance) {
        console.log('I am moving ' + distance);
    };
    AnimalBase.prototype.getName = function () {
        return this.name;
    };
    return AnimalBase;
}());
// Se una classe figlia non ha costruttore chiama il costruttore
// del padre
var Bird = /** @class */ (function (_super) {
    __extends(Bird, _super);
    // Si può impostare un valore di default
    function Bird(name, place) {
        if (place === void 0) { place = 'Sea'; }
        var _this = _super.call(this, name) || this;
        _this.place = place;
        return _this;
    }
    Bird.prototype.getPlace = function () {
        return this.place;
    };
    Bird.prototype.setPlace = function (place) {
        this.place = place;
    };
    // Come fare l'override
    Bird.prototype.move = function (distance) {
        // super.move(distance); // Richiamo il metodo del padre
        console.log('I am flying ' + distance);
    };
    return Bird;
}(AnimalBase));
var dove = new Bird('Dove');
console.log(dove.getName());
console.log(dove.getPlace());
dove.move(50);
