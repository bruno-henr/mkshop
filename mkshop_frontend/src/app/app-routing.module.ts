import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InicioComponent } from './pages/inicio/inicio.component';
import { ConteudoComponent } from './pages/conteudo/conteudo.component';
import { TesteComponent } from './pages/teste/teste.component';
import { LoginComponent } from './pages/login/login.component';
import { authenticationGuard } from './shared/guard/authentication.guard';
import { HomeComponent } from './pages/home/home.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    // children: [
      
    //   { path: '1', component: TesteComponent },
    //   { path: 'conteudo', component: ConteudoComponent }
    // ],
    // canActivate: [authenticationGuard]
  },
  {
    path: 'login', component: LoginComponent
  },

  { path: "**", redirectTo: "login" }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
