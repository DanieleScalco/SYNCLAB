import { Component, Input, OnInit } from '@angular/core';
import { User } from '../classes/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit {
  @Input() user: User;
  
  constructor(private userService: UserService) { }

  ngOnInit(): void {

  }

  saveUser() {
    if (this.user.id > 0) {
      // L'utente è già esistente e lo devo soltanto modificare
      const userCopy: User = Object.assign({}, this.user);
      this.userService.updateUser(userCopy);
    }
  }

}
