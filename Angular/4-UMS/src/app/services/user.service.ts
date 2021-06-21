import { UserInterface } from './../interfaces/userInterface';
// NomeServizioSingolare.service.ts (se più parole usare '-')

import { Injectable } from "@angular/core";
import { User } from "../classes/user";

// Decoratore che indica ad Angular che questo servizio può avere dipendenze ed essere inittato
@Injectable()
export class UserService {
  
	users: Array<User> = [	// Array di oggetti JSON (Javascript Object Notation)
		{
			id: 1,
			name: 'Hidran1',
			lastname: 'Arias1',
			email: 'hidran@gmail.com',
			fiscalcode: 'ABCDEFG12345',
			province: 'Torino',
			phone: '123456789',
			age: 47
		},
		{
			id: 2,
			name: 'Hidran2',
			lastname: 'Arias2',
			email: 'hidran@gmail.com',
			fiscalcode: 'ABCDEFG12345',
			province: 'Torino',
			phone: '123456789',
			age: 47
		},
		{
			id: 3,
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

	getUser(id: number): User {
		let user = this.users.find(user => user.id === id);
		if (user)
			return user;
		else
			throw new Error('Id utente non trovato');
	}

	deleteUser(user: User) {
		let index = this.users.indexOf(user);
		if (index >= 0)	// Altrimenti non esiste
			this.users.splice(index, 1); // Elimina un elemento a partire dall'indice
	}

	updateUser(user: UserInterface) {
		const idx = this.users.findIndex((v) => v.id === user.id); // Ritorna il primo elemento che rispetta la condizione
		if (idx !== -1)
			this.users[idx] = user;
	}

	createUser(user: UserInterface) {
		user.id = this.users.length + 1;
		this.users.splice(0, 0, user);
	}
	
}