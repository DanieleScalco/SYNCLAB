import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../classes/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-user-data',
  templateUrl: './user-data.component.html',
  styleUrls: ['./user-data.component.css']
})
export class UserDataComponent implements OnInit {

  public user: User;
  public title: string = 'User Detail';

  constructor(private route: ActivatedRoute, private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    this.user = new User();
    this.route.params.subscribe(
      (p) => {
        this.userService.getUser(+p.id).subscribe(
          res => {
            this.user = res.data;
          }
        );  // Necessario + per cast a numero
      }
    );
  }

  backToUsers() {
    this.router.navigate(['users']);
  }

}
