import { Router } from '@angular/router';
import { AuthService } from './../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { Form, NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private auth: AuthService, private router: Router) { }

  ngOnInit(): void {
  }

  signIn(form: NgForm) {
    if (!form.valid) {
      return;
    }
    let result = this.auth.signIn(form.value.email, form.value.password);
    if (result) {
      this.router.navigate(['']);
    }
  }

}
