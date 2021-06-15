import { User } from './../interfaces/user';
import { UserService } from '../services/user.service';
import { Component, EventEmitter, OnInit, Output } from "@angular/core";

/*
	Per ogni component è utile creare una cartella dedicata contenente:
	-.ts
	-.html
	-.css
	Nome dei file dei component: nome.component.estensione

	Un componente è una direttiva con il template
*/

// Una volta creato il componente bisogna dichiararlo nell'app.module.ts

// E' meglio seprarare i dati dal componente

// Bisogna impostare un decoratore per ogni component
@Component({
	selector: 'app-users',	// Per convenzione si inizia con 'app', se si vuole andare a capo usare alt+96
	// template se si hanno poche righe, se si ha una grande pagina usare 'templateUrl'
	templateUrl: './users.component.html',
	styleUrls: ['./users.component.css']	// Lista di fogli di stile da applicare al component
})
export class UsersComponent implements OnInit {	// Si usa lo stesso nome del file
	title = 'Users';	// Le variabili di un componente sono accessibili nel template del coponente tramite {{nomeVariabile}}
	users: User[] = [];
	@Output() updateUser = new EventEmitter<User>(); // Si può specificare il parametro in output dell'event

	// Dependency injection e in automatico crea una variabile col nome del parametro (se ha una visibilità)
	constructor (private service: UserService) {

	}

	// Metodo chiamato quando la classe viene istanziata
	ngOnInit(): void {
		this.users = this.service.getUsers();		
	}

	onDeleteUser(user: User) {
		this.service.deleteUser(user);
	}

	onSelectUser(user: User) {
		this.updateUser.emit(user);
	}
}