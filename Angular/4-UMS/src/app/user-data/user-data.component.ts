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

    
    this.route.paramMap.subscribe(
      (p) => {

        let idUserS;
        let idUserN: number;
        idUserS = p.get('id');
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

  backToUsers() {
    this.router.navigate(['users']);
  }

}
