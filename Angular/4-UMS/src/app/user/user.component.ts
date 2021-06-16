import { UserService } from '../services/user.service';
import { Component, EventEmitter, Input, OnInit } from '@angular/core';
import { Output } from '@angular/core';
import { User } from '../classes/user';

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

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    
  }

  deleteUser() {
    // this.userService.deleteUser(this.user);
    this.userDeleted.emit(this.user); // Scateniamo un evento che qualcuno dovrà ascoltare (come un normale evento del DOM)
  }

  updateUser() {
    this.userSelected.emit(this.user);
  }
}
