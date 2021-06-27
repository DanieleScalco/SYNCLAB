import { Router } from '@angular/router';
import { AuthService } from './../services/auth.service';
import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { User } from '../classes/user';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  @Output() onNewUser = new EventEmitter();
  public isUserLoggedIn = false;
  public username: string;

  constructor(private auth: AuthService, private router: Router) { 
    
    // Mi iscrivo all'evento di login
    auth.userSignedIn.subscribe(
      (user: User) => {
        this.username = user.name;
        this.isUserLoggedIn = true;
      }
    );

    auth.userLogout.subscribe(
      (user: User) => {
        this.username = '';
        this.isUserLoggedIn = false;
      }
    );

    auth.userSignedUp.subscribe(
      (user: User) => {
        this.username = user.name;
        this.isUserLoggedIn = true;
      }
    );
  }

  ngOnInit(): void {
    this.isUserLoggedIn = this.auth.isUserLoggedIn();
  }

  newUser() {
    this.onNewUser.emit();
  }

  logout(e: any) {
    e.preventDefault(); // Previene che si navighi verso href="#"
    this.auth.logout();
    this.router.navigate(['login']);
  }

  signIn(e: any) {
    e.preventDefault(); // Previene che si navighi verso href="#"
    this.router.navigate(['login']);
  }

  signUp(e: any) {
    e.preventDefault(); // Previene che si navighi verso href="#"
    this.router.navigate(['signup']);
  }

}
