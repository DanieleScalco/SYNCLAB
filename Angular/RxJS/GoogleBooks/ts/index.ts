// File typescript che genererà dinamicamente il javascript nella cartella js
// tsc --watch index.ts --out js/script.js

declare const rxjs: any; // Per non dare errori su rxjs

// Interfacce varie degli elementi che si ottengono con AJAX
interface GoogleBook {
	totalItems: number
	kind: string
	items: []
}

interface BookThumbnails {
	smallThumbnail: string
	thumbnail: string
}

interface VolumeInfo {
	authors: []
	description: string
	imageLinks: BookThumbnails
	infoLink: string
	language: string
	previewLink: string
	title: string
	categories: []
}

interface Book {
	title: string
	description: string
	authors: []
	categories: []
	thumbnail: string
}

interface BookItem {
	volumeInfo: VolumeInfo
	id: string
}

function getBooks(bookTitle: string) {
	const { from } = rxjs;	// Anche se typescript non riconosce l'oggetto rxjs l'html usando il js lo vedrà
	const { map, switchMap, tap, filter} = rxjs.operators;
	const apiUrl = 'https://www.googleapis.com/books/v1/volumes?q=';

	const p = fetch(apiUrl + bookTitle).then(res => res.json());

	return from(p)	// Ritorniamo l'observable
		.pipe(
			tap((data: GoogleBook) => showTotal(data.items.length)),
			switchMap((data: GoogleBook) => from(data.items || [])), // Se si fanno troppe richieste non restituisce nulla, quindi bisogna gestire
			filter((ele: BookItem) => ele.volumeInfo.imageLinks !== undefined), // Non prendo i libri senza immagine
			map((ele: BookItem) => {
				const book: Book = {
					title: ele.volumeInfo.title,
					categories: ele.volumeInfo.categories,
					authors: ele.volumeInfo.authors,
					description: ele.volumeInfo.description,
					thumbnail: ele.volumeInfo.imageLinks.thumbnail
				};
				return book;
			}),
			tap((book: Book) => console.log(book))

		)
}

function showTotal(totalItems: number) {
	const found = document.querySelector('#found');
	// Controllo che l'elemento esista
	if (found) {
		found.innerHTML = totalItems.toString()	;	// Svuoto il contenuto
	}
}

function displayBook(book: Book) {
	
	// Con la notazione ${oggetto} posso accedere ai dati di un oggetto
	// ${book.description || ''} se non c'è la descrizione lascia vuoto

	// alt+96 per virgoletta per inserire elemento su più righe
	const bookTpl =
	`<div class="card shadow-sm">
		<img src="${book.thumbnail}" title="${book.title}" alt="${book.title}">
		
		<div class="card-body">
			<h5>${book.title}</h5>
			<p class="card-text">${book.description || ''}</p>
			<div class="d-flex justify-content-between align-items-center">
				<div class="btn-group">
					<button type="button" class="btn btn-sm btn-outline-secondary">View</button>
					<button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
				</div>
				<small class="text-muted">9 mins</small>
			</div>
		</div>
	</div>`;

	const div = document.createElement('div');
	div.setAttribute('class', 'col');
	div.innerHTML = bookTpl;
	
	const books = document.querySelector('#books');
	// Controllo che l'elemento esista
	if (books) {
		books.appendChild(div);
	}
	
}

function cleanBooks() {
	const books = document.querySelector('#books');
	// Controllo che l'elemento esista
	if (books) {
		books.innerHTML = '';	// Svuoto il contenuto
	}
}

function searchBooks() {
	const searchEle = document.querySelector('#search');
	const { fromEvent } = rxjs; // Import fromEvent che crea un observable da un evento
	const { filter, map, switchMap, debounceTime, tap } = rxjs.operators;

	if (searchEle) {
		// Diciamo quale elemento trasformare in un observable e che evento considerare
		fromEvent(searchEle, 'keyup')
			.pipe(
				map((ele: any) => ele.target.value),	// ele è un event, ma metto any per evitare errori
				filter((ele: string) => ele.length > 2),
				debounceTime(1000),	// Impostiamo un delay di 1s
				tap(() => cleanBooks()),
				switchMap((ele: string) => getBooks(ele)) // Cambiamo da stream di stringhe a quello di libri
			)
			.subscribe((book: Book) => displayBook(book));

	}
}

function searchButtonClicked() {
	const books: any = document.querySelector('#search');
	// Controllo che l'elemento esista
	if (books) {
		getBooks(books.value).subscribe((book: Book) => displayBook(book))
	}
}

searchBooks();

