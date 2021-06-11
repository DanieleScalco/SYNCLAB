// File typescript che genererà dinamicamente il javascript nella cartella js
// tsc --watch index.ts --out js/script.js

declare const rxjs: any; // Per non dare errori su rxjs


interface GoogleBook {
	totalItems: number
	kind: string
	items: []
}

interface BookThumbnails {
	smallThumbnail: string
	thumbnail: string
}

interface BookItem {
	volumeInfo: VolumeInfo
	id: string
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

function getBooks(bookTitle: string) {
	const apiUrl = 'https://www.googleapis.com/books/v1/volumes?q=';
	const { from } = rxjs;	// Anche se typescript non riconosce l'oggetto rxjs l'html usando il js lo vedrà
	const { map, switchMap, tap} = rxjs.operators;

	const p = fetch(apiUrl + bookTitle).then(res => res.json());

	from(p)
		.pipe(
			switchMap((data: GoogleBook) => from(data.items || [])), // Se si fanno troppe richieste non restituisce nulla, quindi bisogna gestire
			map((ele: BookItem) => {
				const book: Book = {
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
		.subscribe((book: Book) => displayBook(book));
}
let i = 0;
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

	//Logging
	console.log(book);
	
}

function searchBooks() {
	const searchEle = document.querySelector('#search');
	if (searchEle) {
		
	}
}
getBooks('game of 3 thrones');

