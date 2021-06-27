import { User } from './../classes/user';
import { UserService } from '../services/user.service';
import { Component, EventEmitter, OnInit, Output } from "@angular/core";

/*
	Per ogni component è utile creare una cartella dedicata contenente:
	-.ts
	-.html
	-.css
	Nome dei file dei component: nome.component.estensione
	(Si generano in automatico con 'ng generate component nomeComponent')

	Un componente è una direttiva con il template
*/

// Una volta creato il componente bisogna dichiararlo nell'app.module.ts

// E' meglio separare i dati dal componente

// Bisogna impostare un decoratore per ogni component
@Component({
	selector: 'app-users',	// Per convenzione si inizia con 'app', se si vuole andare a capo usare alt+96
	// template se si hanno poche righe, se si ha una grande pagina usare 'templateUrl'
	templateUrl: './users.component.html',
	styleUrls: ['./users.component.css']	// Lista di fogli di stile da applicare al component
})
export class UsersComponent implements OnInit {	// Si usa lo stesso nome del file
	title = 'Users';	// Le variabili di un componente sono accessibili nel template del componente tramite {{nomeVariabile}}
	users: User[] = [];
	@Output() updateUser = new EventEmitter<User>(); // Si può specificare il parametro in output dell'event (User)

	// Dependency injection avviene in automatico, crea una variabile col nome del parametro (se ha una visibilità)
	constructor (private service: UserService) {

	}

	// Metodo chiamato quando la classe viene istanziata
	ngOnInit(): void {
		this.service.getUsers().subscribe(
			(res: any) => {
				this.users = res['data'];	// o res.data
			}
		);		
	}

	onDeleteUser(user: User) {
		this.service.deleteUser(user).subscribe(
			res => {
				alert(res.message);
				this.service.getUsers().subscribe(res => {this.users = res.data});
			},
			(err: any) => {
				console.log(err);
			}
		);
	}

	onSelectUser(user: User) {
		// assign mette l'oggetto a destra in quello di sinistra e lo restituisce
		// Diamo una copia per evitare che modificando nel detail cambi nella tabella
		const userCopy: User = Object.assign({}, user);
		this.updateUser.emit(userCopy);
	}
}