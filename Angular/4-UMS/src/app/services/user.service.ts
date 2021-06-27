import { HttpClient } from '@angular/common/http';
import { UserInterface } from './../interfaces/userInterface';
// NomeServizioSingolare.service.ts (se più parole usare '-')
// I servizi devono essere messi tra i providers nell app.module.ts

import { Injectable } from "@angular/core";
import { User } from "../classes/user";
import { Observable } from 'rxjs';

// Iterface per l'ottenimento dei dati dal progetto laravel
interface UsersResponse {
	data: User[];
	message: string;
	success: boolean;
}

interface UserResponse {
	data: User;
	message: string;
	success: boolean;
}

// Decoratore che indica ad Angular che questo servizio può avere dipendenze ed essere inittato
@Injectable()
export class UserService {
  
	// Array di oggetti JSON (Javascript Object Notation)
	users: Array<User> = [];
	private APIURL = 'http://localhost:8000/api/users';
	
	// Per fare richieste bisogna dichiarare HttpCLientModule
	constructor(private http: HttpClient) {

	}
	
	// Ottengo gli users dall'API
	getUsers() {
		return this.http.get<UsersResponse>(this.APIURL);
	}

	getUser(id: number) {
		
		return this.http.get<UserResponse>(this.APIURL + '/' + id);
		/*
		Metodo per prendere l'user quando si usava un array hardcoded e non l'api
		let user = this.users.find(user => user.id === id);
		if (user)
			return user;
		else
			throw new Error('Id utente non trovato');
		*/
	}

	deleteUser(user: User) {
		/*
		Prima dell'api
		let index = this.users.indexOf(user);
		if (index >= 0)	// Altrimenti non esiste
			this.users.splice(index, 1); // Elimina un elemento a partire dall'indice
		*/

		// Mettere il tipo UserResponse permette di avere poi l'autocompletamento
		return this.http.delete<UserResponse>(this.APIURL + '/' + user.id);
	}

	updateUser(user: UserInterface) {
		return this.http.patch<UserResponse>(this.APIURL + '/' + user.id, user);
		/*
		Vecchio metodo prima dell'api
		const idx = this.users.findIndex((v) => v.id === user.id); // Ritorna il primo elemento che rispetta la condizione
		if (idx !== -1)
			this.users[idx] = user;
		*/
	}

	createUser(user: UserInterface) {
		/*
		Prima dell'api
		user.id = this.users.length + 1;
		this.users.splice(0, 0, user);
		*/
		return this.http.post<UserResponse>(this.APIURL, user);
	}
	
}