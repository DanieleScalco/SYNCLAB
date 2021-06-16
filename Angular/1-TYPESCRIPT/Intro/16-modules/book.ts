// Un modulo è un file javascript il cui contenuto è isolato
// Non influenza il global scope di javascript

// Export indica che un'altro file lo può importare (variabile, funzione, classe)
// Se non si specifica cosa prendere dall'import di default verrà importato quello con default
// Una sola cosa di default
export default class Book {
	title: string
	author: string
	content: string
	year: number
}

export const Categories = [
	'SHORT STORIES',
	'SCI-FI',
	'SPY STORIES'
]