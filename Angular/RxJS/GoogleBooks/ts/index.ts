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
			switchMap((data: GoogleBook) => from(data.items)),
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
		.subscribe((data: GoogleBook) => data);
}

getBooks('game of 3 thrones');

