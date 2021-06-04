"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var MathCalc = /** @class */ (function () {
    function MathCalc() {
    }
    MathCalc.calcCirclePerimeter = function (r) {
        return 2 * MathCalc.PI * r;
    };
    MathCalc.prototype.calcEuroToDollar = function (euro) {
        return MathCalc.rate * euro;
    };
    // Le variabili statiche non fanno parte dell'oggetto, ma della classe
    MathCalc.PI = 3.1459;
    MathCalc.rate = 1.12;
    return MathCalc;
}());
var calc = new MathCalc();
// calc.PI	Non si può fare, PI è proprietà della classe, non del singolo oggetto
console.log(MathCalc.PI);
console.log(MathCalc.calcCirclePerimeter(2));
console.log('120 euro sono ' + calc.calcEuroToDollar(120) + ' dollars');
