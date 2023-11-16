import { NgModule } from '@angular/core';
import { HeaderComponent } from './header.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MenubarModule } from 'primeng/menubar';
import { AutoCompleteModule } from 'primeng/autocomplete';
import { InputTextModule } from 'primeng/inputtext';
import { CheckboxModule } from 'primeng/checkbox';
import { RadioButtonModule } from 'primeng/radiobutton';
import { InputSearchComponent } from './components/input-search/input-search.component';
import { ButtonModule } from 'primeng/button';
import { UserInfoHeaderComponent } from './components/user-info-header/user-info-header.component';
import { ShoppingCartHeaderComponent } from './components/shopping-cart-header/shopping-cart-header.component';
import { UserRequestsHeaderComponent } from './components/user-requests-header/user-requests-header.component';

@NgModule({
  declarations: [
    HeaderComponent,
    InputSearchComponent,
    UserInfoHeaderComponent,
    ShoppingCartHeaderComponent,
    UserRequestsHeaderComponent,
  ],
  imports: [
    FormsModule,
    MenubarModule,
    AutoCompleteModule,
    InputTextModule,
    CheckboxModule,
    RadioButtonModule,
    CommonModule,
    ButtonModule,
  ],
  providers: [],
  exports: [HeaderComponent],
})
export class HeaderModule {}
