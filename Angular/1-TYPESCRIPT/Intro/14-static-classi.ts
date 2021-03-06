export {};

class MathCalc {

// Le variabili statiche non fanno parte dell'oggetto, ma della classe
	static readonly PI = 3.1459;
	static readonly rate = 1.12;
	
	static calcCirclePerimeter(r: number) {
		return 2 * MathCalc.PI * r;
	}

	calcEuroToDollar(euro: number) {
		return MathCalc.rate * euro;
	}
}

let calc = new MathCalc();
// calc.PI	Non si può fare, PI è proprietà della classe, non del singolo oggetto
console.log(MathCalc.PI);
console.log(MathCalc.calcCirclePerimeter(2));
console.log('120 euro sono ' + calc.calcEuroToDollar(120) + ' dollars');