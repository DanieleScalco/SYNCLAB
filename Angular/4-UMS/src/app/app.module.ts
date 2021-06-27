import { AuthService } from './services/auth.service';
import { RoutingModuleModule } from './routing-module.module';
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
import { UserDataComponent } from './user-data/user-data.component'; // Per usare le rotte
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';



@NgModule({
  declarations: [ // Dichiarazioni dei componenti utilizzati
    AppComponent,
    UsersComponent,
    UserComponent,
    UserDetailComponent,
    NavComponent,
    UserDataComponent,
    LoginComponent,
    SignupComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,  // Necessaria per le direttive per il mapping delle form
    FontAwesomeModule, // Da mettere per usare Font Awesome
    HttpClientModule,
    RoutingModuleModule
  ],
  providers: [
    UserService, AuthService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
