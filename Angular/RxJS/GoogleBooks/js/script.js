"use strict";
// File typescript che genererà dinamicamente il javascript nella cartella js
// tsc --watch index.ts --out js/script.js
function getBooks(bookTitle) {
    var apiUrl = 'https://www.googleapis.com/books/v1/volumes?q=';
    var from = rxjs.from; // Anche se typescript non riconosce l'oggetto rxjs l'html usando il js lo vedrà
    var _a = rxjs.operators, map = _a.map, switchMap = _a.switchMap, tap = _a.tap;
    var p = fetch(apiUrl + bookTitle).then(function (res) { return res.json(); });
    from(p)
        .pipe(switchMap(function (data) { return from(data.items); }), map(function (ele) {
        var book = {
            title: ele.volumeInfo.title,
            categories: ele.volumeInfo.categories,
            authors: ele.volumeInfo.authors,
            description: ele.volumeInfo.description,
            thumbnail: ele.volumeInfo.imageLinks.thumbnail
        };
        return book;
    }), tap(function (book) { return console.log(book); }))
        .subscribe(function (data) { return data; });
}
getBooks('game of 3 thrones');
