import { Component, Input, OnInit } from '@angular/core';
import { Form, FormsModule } from '@angular/forms';
import { User } from '../classes/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit {
  
  private userCopy: User;
  private _user: User;

  @Input() set user(user: User) {
    this._user = user;
    this.userCopy = Object.assign({}, user);
  }
  get user() {
    return this._user;
  }
  
  constructor(private userService: UserService) { }

  ngOnInit(): void {
    
  }

  saveUser() {
    const userCopia: User = Object.assign({}, this.user);

    if (this.user.id > 0) {
      // L'utente è già esistente e lo devo soltanto modificare
      this.userService.updateUser(userCopia);
    } else {
      this.userService.createUser(userCopia);
    }
  }

  resetForm(form: any) {
    if (this.user.id === 0) {

      // Se l'utente è nuovo ripopolo
      this.user = new User();
    } else {

      // Altrimenti resetto l'utente
      this.user = this.userCopy;
      // form.reset(); // Svuota tutti i campi
    }
  }

}
