import { Component, Input, OnInit } from '@angular/core';
import { Form, FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
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
  
  // ActivatedRoute è un servizio del routerModule per sapere la rotta attuale, Router serve per cambiare la rotta
  constructor(private userService: UserService, private route: ActivatedRoute, private router: Router) {
    
  }

  ngOnInit(): void {
    this.user = new User(); // meglio inizializzare il dato poichè la chiamata è asincrona

    this.route.paramMap.subscribe(
      (params) => {
        if (!params.get('id')) {
          return;
        } 
        
        let idUserS;
        let idUserN: number;
        idUserS = params.get('id');
        if (idUserS) {
          idUserN = +idUserS; // Con + si fa il cast a number
          this.userService.getUser(idUserN).subscribe(
            res => {
              this.user = res.data;
            }
          );
        }
      }
    );
  }

  updateUser() {
    // L'utente è già esistente e lo devo soltanto modificare
    this.userService.updateUser(/*userCopia*/this.user).subscribe(
      res => {
        alert(res.message);
        if (res.success) {
          this.router.navigate(['users']);
        }
      }
    );
  }

  createUser() {
    this.userService.createUser(/*userCopia*/this.user).subscribe(
      res => {
        alert(res.message);
        if (res.success) {
          this.router.navigate(['users']);
        }
      }
    );
  }
  
  saveUser() {
    //const userCopia: User = Object.assign({}, this.user);

    if (this.user.id > 0) {
      this.updateUser();
    } else {
      this.createUser();
    }

    //this.router.navigate(['users']);
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

  backToUsers() {
    this.router.navigate(['users']);
  }

}
