import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UsersComponent } from './users/users.component';
import { RouterModule, Routes } from '@angular/router';
import { UserDetailComponent } from './user-detail/user-detail.component';
import { UserDataComponent } from './user-data/user-data.component';
import { RouteGuardService } from './route-guard.service';

// Modulo apposta per impostare le rotte (da importare nell'app module)
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
    path: 'users/:id/edit', // i ':' indicano che l'elemento successivo è un parametro
    component: UserDetailComponent,
    canActivate: [RouteGuardService] // Lista di classi che possono attivare la rotta (devono essere presenti nei providers)
  },
  {
    path: 'users/:id', // i ':' indicano un parametro
    component: UserDataComponent
  }
]

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    // Per usare le rotte (da passare come parametro). forRoot() indica come radice, forChild() come sottorotte
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule  // Necessario per poter far usare il router alle altre parti dell'applicazione
  ],
  providers: [
    RouteGuardService
  ]
})
export class RoutingModuleModule { }
