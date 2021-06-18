import { UserService } from './services/user.service';
import { UsersComponent } from './users/users.component';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import { UserDetailComponent } from './user-detail/user-detail.component';
import { FormsModule } from '@angular/forms';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { NavComponent } from './nav/nav.component';
import { RouterModule, Routes } from '@angular/router';
import { UserDataComponent } from './user-data/user-data.component'; // Per usare le rotte

// Elenco di rotte
const routes: Routes = [
  {
    path: 'users',
    component: UsersComponent
  },
  {
    path: '', // Niente '/' perchè il 'base href' dell'index.html già la contiene
    redirectTo: 'users',
    pathMatch: 'full',  // Per direzionare deve combaciare perfettamente
  },
  {
    path: 'users/new',
    component: UserDetailComponent
  },
  {
    path: 'users/:id/edit', // i ':' indicano un parametro
    component: UserDetailComponent
  },
  {
    path: 'users/:id', // i ':' indicano un parametro
    component: UserDataComponent
  }
]

@NgModule({
  declarations: [ // Dichiarazioni dei componenti utilizzati
    AppComponent,
    UsersComponent,
    UserComponent,
    UserDetailComponent,
    NavComponent,
    UserDataComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,  // Necessaria per le direttive per il mapping delle form
    FontAwesomeModule, // Da mettere per usare Font Awesome
    // Per usare le rotte (da passare come parametro). forRoot() indica come radice, forChild() come sottorotte
    RouterModule.forRoot(routes)
  ],
  providers: [
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
