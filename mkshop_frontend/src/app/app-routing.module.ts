import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { authenticationGuard } from './shared/guard/authentication.guard';
import { HomeComponent } from './pages/home/home.component';
import { ProductComponent } from './pages/product/product.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { ShoppingCartComponent } from './pages/shopping-cart/shopping-cart.component';
import { OrdersComponent } from './pages/orders/orders.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    children: [
      { path: '', component: HomePageComponent },
      { path: 'produto/:product_name', component: ProductComponent },
      { path: 'pedidos', component: OrdersComponent },
      { path: 'carrinho', component: ShoppingCartComponent },
    ],
    canActivate: [authenticationGuard]
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
