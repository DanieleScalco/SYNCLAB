"use strict";
// Un modulo è un file javascript il cui contenuto è isolato
// Non influenza il global scope di javascript
Object.defineProperty(exports, "__esModule", { value: true });
exports.Categories = void 0;
// Export indica che un'altro file lo può importare (variabile, funzione, classe)
// Se non si specifica cosa prendere dall'import di default verrà importato questo
// Una sola cosa di default
var Book = /** @class */ (function () {
    function Book() {
    }
    return Book;
}());
exports.default = Book;
exports.Categories = [
    'SHORT STORIES',
    'SCI-FI',
    'SPY STORIES'
];
