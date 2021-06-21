import { UserService } from '../services/user.service';
import { Component, EventEmitter, Input, OnInit } from '@angular/core';
import { Output } from '@angular/core';
import { User } from '../classes/user';
// Importare le icone che si vogliono dal corretto(!) package
import { faPencilAlt, faTrashAlt, faInfo } from '@fortawesome/free-solid-svg-icons';
import { Router } from '@angular/router';

@Component({
  // inputs: ['user: user-data'], // per dichiarare una variabile input o lo si fa qua o nella classe con @Input
  selector: 'tr[app-user]', // Questo permette di visualizzare correttamente la riga della tabella, 'app-user' diventa un attributo del tag 'tr'
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  
  // Input è un decoratore che indica che una variabile prende i dati dall'esterno
  // Gli si può passare un alias come parametro da usare all'esterno di questa classe
  @Input('user-data') user: User;
  @Output('onDeleteUser') userDeleted = new EventEmitter();  // Output è un decoratore per un evento in output
  @Output('onSelectUser') userSelected = new EventEmitter<User>(); // L'evento viene rilevato dal genitore

  // Creo attributi che contengono le icone
  updateIcon = faPencilAlt;
  deleteIcon = faTrashAlt;
  infoIcon = faInfo;

  // Route necessario per navigare
  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  
  }

  deleteUser() {
    // this.userService.deleteUser(this.user);
    this.userDeleted.emit(this.user); // Scateniamo un evento che qualcuno dovrà ascoltare (come un normale evento del DOM)
  }

  updateUser() {

    // Fa navigare in un'altra rotta
    this.router.navigate(['users', this.user.id, 'edit']);

    // Non credo serva più
    this.userSelected.emit(this.user);
  }

  showUserDetail() {
    this.router.navigate(['users', this.user.id]);
  }
}
