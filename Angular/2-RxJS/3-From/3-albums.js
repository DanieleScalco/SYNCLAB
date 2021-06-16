const apiUrl = 'https://jsonplaceholder.typicode.com/albums';

// Se ci sono problemi nel server potrebbe non aver caricato il file nuovo!

// Notazione senza require() poichè si sta usando il codice nel browser!!!
const { from, of } = rxjs;
const { switchMap, map } = rxjs.operators;
// const fetch = require('node-fetch');	// Libreria fetch nativa nel browser, non bisogna importarla

const promise = fetch(apiUrl)
				.then(body => body.json());
const obs = from(promise);	// Crea un'observable

// Qui i dati sono tutti in un array
obs.subscribe({
	next: resData => updateTotal(resData.length)
});

obs.pipe(
	switchMap(resData => from(resData)), // Trasformo lo stream da un array di oggetti ad uno stream degli oggetti
	map(album => album.title)
).subscribe({
	next: title => createAlbumList(title)
});


function createAlbumList(title) {
	const ul = document.querySelector('#albums');
	if (ul) {
		const li = document.createElement('li');
		li.textContent = title;
		ul.appendChild(li);
	}
}

function updateTotal(total) {
	const span = document.querySelector('#total');
	span.textContent = total;
}