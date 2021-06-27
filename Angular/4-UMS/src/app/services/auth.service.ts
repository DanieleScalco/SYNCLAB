import { User } from './../classes/user';
import { Injectable, Output, EventEmitter } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private isUserLogged = true;
  @Output() userSignedIn = new EventEmitter<User>();
  @Output() userSignedUp = new EventEmitter<User>();
  @Output() userLogout = new EventEmitter();

  constructor() { }

  isUserLoggedIn() {
    this.isUserLogged =  !!localStorage.getItem('token'); // '!!' trasforma il valore in booleano
    return this.isUserLogged;
  }

  // Durante la signin la navbar non viene ricaricata, c'è bisogno degli eventi per farlo
  signIn(email: string, password: string) {

    // La localStorage è asincrona. I parametri messi si possono vedere dall'F12 in Application/LocalStorage
    // Il token rimane anche se si ricarica la pagina
    localStorage.setItem('token', email);
    
    let user = new User();
    user.name = 'Test';
    user.email = email;
    this.userSignedIn.emit(user);

    return true;
  }

  signUp(username: string, email: string, password: string) {
    localStorage.setItem('token', email);

    let user = new User();
    user.name = username;
    user.email = email;
    this.userSignedUp.emit(user);

    return true;
  }

  logout() {
    localStorage.removeItem('token');

    this.userLogout.emit();

    this.isUserLogged = false;
  }
}
