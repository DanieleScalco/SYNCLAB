import { Component } from "@angular/core";

/*
	Per ogni component è utile creare una cartella dedicata contenente:
	-.ts
	-.html
	-.css
	Nome dei file dei component: nome.component.estensione
*/

// Una volta creato il componente bisogna dichiararlo nell'app.module.ts

// Bisogna impostare un decoratore per ogni component
@Component({
	selector: 'app-users',	// Per convenzione si inizia con 'app', se si vuole andare a capo usare alt+96
	// template se si hanno poche righe, se si ha una grande pagina usare 'templateUrl'
	templateUrl: './users.component.html',
	styleUrls: ['./users.component.css']	// Lista di fogli di stile da applicare al component
})
export class UsersComponent {	// Si usa lo stesso nome del file
	title = 'Users';	// Le variabili di un componente sono accessibili nel template di un coponente
	users = [	// Array di oggetti JSON (Javascript Object Notation)
		{
			name: 'Hidran1',
			lastname: 'Arias',
			email: 'hidran@gmail.com',
			fiscalcode: 'ABCDEFG12345',
			province: 'Torino',
			phone: '123456789',
			age: 47
		},
		{
			name: 'Hidran3',
			lastname: 'Arias',
			email: 'hidran@gmail.com',
			fiscalcode: 'ABCDEFG12345',
			province: 'Torino',
			phone: '123456789',
			age: 47
		},
		{
			name: 'Hidran3',
			lastname: 'Arias',
			email: 'hidran@gmail.com',
			fiscalcode: 'ABCDEFG12345',
			province: 'Torino',
			phone: '123456789',
			age: 47
		}
	]
}