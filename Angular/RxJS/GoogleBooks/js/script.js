"use strict";
// File typescript che genererà dinamicamente il javascript nella cartella js
// tsc --watch index.ts --out js/script.js
function getBooks(bookTitle) {
    var from = rxjs.from; // Anche se typescript non riconosce l'oggetto rxjs l'html usando il js lo vedrà
    var _a = rxjs.operators, map = _a.map, switchMap = _a.switchMap, tap = _a.tap, filter = _a.filter;
    var apiUrl = 'https://www.googleapis.com/books/v1/volumes?q=';
    var p = fetch(apiUrl + bookTitle).then(function (res) { return res.json(); });
    return from(p) // Ritorniamo l'observable
        .pipe(tap(function (data) { return showTotal(data.items.length); }), switchMap(function (data) { return from(data.items || []); }), // Se si fanno troppe richieste non restituisce nulla, quindi bisogna gestire
    filter(function (ele) { return ele.volumeInfo.imageLinks !== undefined; }), // Non prendo i libri senza immagine
    map(function (ele) {
        var book = {
            title: ele.volumeInfo.title,
            categories: ele.volumeInfo.categories,
            authors: ele.volumeInfo.authors,
            description: ele.volumeInfo.description,
            thumbnail: ele.volumeInfo.imageLinks.thumbnail
        };
        return book;
    }), tap(function (book) { return console.log(book); }));
}
function showTotal(totalItems) {
    var found = document.querySelector('#found');
    // Controllo che l'elemento esista
    if (found) {
        found.innerHTML = totalItems.toString(); // Svuoto il contenuto
    }
}
function displayBook(book) {
    // Con la notazione ${oggetto} posso accedere ai dati di un oggetto
    // ${book.description || ''} se non c'è la descrizione lascia vuoto
    // alt+96 per virgoletta per inserire elemento su più righe
    var bookTpl = "<div class=\"card shadow-sm\">\n\t\t<img src=\"" + book.thumbnail + "\" title=\"" + book.title + "\" alt=\"" + book.title + "\">\n\t\t\n\t\t<div class=\"card-body\">\n\t\t\t<h5>" + book.title + "</h5>\n\t\t\t<p class=\"card-text\">" + (book.description || '') + "</p>\n\t\t\t<div class=\"d-flex justify-content-between align-items-center\">\n\t\t\t\t<div class=\"btn-group\">\n\t\t\t\t\t<button type=\"button\" class=\"btn btn-sm btn-outline-secondary\">View</button>\n\t\t\t\t\t<button type=\"button\" class=\"btn btn-sm btn-outline-secondary\">Edit</button>\n\t\t\t\t</div>\n\t\t\t\t<small class=\"text-muted\">9 mins</small>\n\t\t\t</div>\n\t\t</div>\n\t</div>";
    var div = document.createElement('div');
    div.setAttribute('class', 'col');
    div.innerHTML = bookTpl;
    var books = document.querySelector('#books');
    // Controllo che l'elemento esista
    if (books) {
        books.appendChild(div);
    }
}
function cleanBooks() {
    var books = document.querySelector('#books');
    // Controllo che l'elemento esista
    if (books) {
        books.innerHTML = ''; // Svuoto il contenuto
    }
}
function searchBooks() {
    var searchEle = document.querySelector('#search');
    var fromEvent = rxjs.fromEvent; // Import fromEvent che crea un observable da un evento
    var _a = rxjs.operators, filter = _a.filter, map = _a.map, switchMap = _a.switchMap, debounceTime = _a.debounceTime, tap = _a.tap;
    if (searchEle) {
        // Diciamo quale elemento trasformare in un observable e che evento considerare
        fromEvent(searchEle, 'keyup')
            .pipe(map(function (ele) { return ele.target.value; }), // ele è un event, ma metto any per evitare errori
        filter(function (ele) { return ele.length > 2; }), debounceTime(1000), // Impostiamo un delay di 1s
        tap(function () { return cleanBooks(); }), switchMap(function (ele) { return getBooks(ele); }) // Cambiamo da stream di stringhe a quello di libri
        )
            .subscribe(function (book) { return displayBook(book); });
    }
}
function searchButtonClicked() {
    var books = document.querySelector('#search');
    // Controllo che l'elemento esista
    if (books) {
        getBooks(books.value).subscribe(function (book) { return displayBook(book); });
    }
}
searchBooks();
