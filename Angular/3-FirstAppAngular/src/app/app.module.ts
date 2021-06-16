import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';

/*
  NgModule è un'interfaccia di configurazione che apporta modifiche tramite un json alla classe sotto (AppModule)
  AppModule è il modulo radice, il modulo d'ingresso
*/
@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
