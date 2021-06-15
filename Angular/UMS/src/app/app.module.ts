import { UserService } from './services/user.service';
import { UsersComponent } from './users/users.component';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import { UserDetailComponent } from './user-detail/user-detail.component';

@NgModule({
  declarations: [ // Dichiarazioni dei componenti utilizzati
    AppComponent,
    UsersComponent,
    UserComponent,
    UserDetailComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
