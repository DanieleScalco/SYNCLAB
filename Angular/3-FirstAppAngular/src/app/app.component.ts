import { Component } from '@angular/core';

// Decoratore
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  name = 'Daniele';
  surname = 'Scalco';
  title = 'FirstAppAngular';
}
