"use strict";
// 1)Per importare alcuni elementi (classi, funzioni, ...)
// import {Book, Categories} from './16-modules/book'
// import, tra graffe che cosa voglio importare, from, nome file completo
// Il file da cui voglio importare deve aver esportato l'elemento che voglio con 'export'
// Il punto nel path indica dal path corrente
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
// 2)Per importare tutto
// import * as books from './16-modules/book'
// Dopo l'as c'è la variabile che contiene tutte le cose importate
// 3)Si importa l'elemento esportato di default dal modulo
var book_1 = __importDefault(require("./16-modules/book"));
var book = new book_1.default();
book.year = 2018;
book.title = 'My story';
book.content = 'Contenuto';
console.log(book);
//1)console.log(Categories);
//2)console.log(books) // Posso vedere tutto quello che ho importato
//2)let book2 = new books.Book(); // Utilizzo il Book importato da books
// Require.js è un gestore di moduli, node.js ce ne ha uno di default
