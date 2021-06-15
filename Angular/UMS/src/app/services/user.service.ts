// NomeServizioSingolare.service.ts (se più parole usare '-')

import { Injectable } from "@angular/core";
import { User } from "../interfaces/user";

// Decoratore che indica ad Angular che questo servizio può avere dipendenze
@Injectable()
export class UserService {
	users: Array<User> = [	// Array di oggetti JSON (Javascript Object Notation)
		{
			name: 'Hidran1',
			lastname: 'Arias1',
			email: 'hidran@gmail.com',
			fiscalcode: 'ABCDEFG12345',
			province: 'Torino',
			phone: '123456789',
			age: 47
		},
		{
			name: 'Hidran2',
			lastname: 'Arias2',
			email: 'hidran@gmail.com',
			fiscalcode: 'ABCDEFG12345',
			province: 'Torino',
			phone: '123456789',
			age: 47
		},
		{
			name: 'Hidran3',
			lastname: 'Arias3',
			email: 'hidran@gmail.com',
			fiscalcode: 'ABCDEFG12345',
			province: 'Torino',
			phone: '123456789',
			age: 47
		}
	];
	
	constructor() {

	}
	
	getUsers() {
		return this.users;
	}

	deleteUser(user: User) {
		let index = this.users.indexOf(user);
		if (index >= 0)	// Altrimenti non esiste
			this.users.splice(index, 1); // Elimina un elemento a partire dall'indice
	}
}