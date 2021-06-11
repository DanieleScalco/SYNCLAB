"use strict";
// File typescript che genererà dinamicamente il javascript nella cartella js
// tsc --watch index.ts --out js/script.js
function getBooks(bookTitle) {
    var apiUrl = 'https://www.googleapis.com/books/v1/volumes?q=';
    var from = rxjs.from; // Anche se typescript non riconosce l'oggetto rxjs l'html usando il js lo vedrà
    var _a = rxjs.operators, map = _a.map, switchMap = _a.switchMap, tap = _a.tap;
    var p = fetch(apiUrl + bookTitle).then(function (res) { return res.json(); });
    from(p)
        .pipe(switchMap(function (data) { return from(data.items || []); }), // Se si fanno troppe richieste non restituisce nulla, quindi bisogna gestire
    map(function (ele) {
        var book = {
            title: ele.volumeInfo.title,
            categories: ele.volumeInfo.categories,
            authors: ele.volumeInfo.authors,
            description: ele.volumeInfo.description,
            thumbnail: ele.volumeInfo.imageLinks.thumbnail
        };
        return book;
    })
    //tap((book: Book) => console.log(book))
    )
        .subscribe(function (book) { return displayBook(book); });
}
var i = 0;
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
    //Logging
    console.log(book);
}
function searchBooks() {
    var searchEle = document.querySelector('#search');
    if (searchEle) {
    }
}
getBooks('game of 3 thrones');
