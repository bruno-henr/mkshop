import { CUSTOM_ELEMENTS_SCHEMA, LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderModule } from './components/header/header.module';
import { GalleryComponent } from './components/gallery/gallery.component';
import { LoginComponent } from './pages/login/login.component';
import { CategoryGalleryComponent } from './components/category-gallery/category-gallery.component';
import { MainProductsComponent } from './components/main-products/main-products.component';
import { OffersComponent } from './components/offers/offers.component';
import { FooterComponent } from './components/footer/footer.component';
import { LogoComponent } from './components/logo/logo.component';
import { ProductComponent } from './pages/product/product.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { QuantityComponent } from './pages/product/components/quantity/quantity.component';
import { ShoppingCartComponent } from './pages/shopping-cart/shopping-cart.component';
import { ItemComponent } from './pages/shopping-cart/components/item/item.component';

// directives
import { IfUserIsLoggedDirective } from './directives/if-user-is-logged.directive';
// prime ng
import { ButtonModule } from 'primeng/button';
import { GalleriaModule } from 'primeng/galleria';
import { HomeComponent } from './pages/home/home.component';
import { CarouselModule } from 'primeng/carousel';
import { DataViewModule } from 'primeng/dataview';
import { RatingModule } from 'primeng/rating';
import { TagModule } from 'primeng/tag';
import { DropdownModule } from 'primeng/dropdown';
import { FormsModule } from '@angular/forms';
import { AvatarModule } from 'primeng/avatar';
import { TableModule } from 'primeng/table';
import { AvatarGroupModule } from 'primeng/avatargroup';
import { InputTextModule } from 'primeng/inputtext';
import { BreadcrumbModule } from 'primeng/breadcrumb';
import { ConfirmPopupModule } from 'primeng/confirmpopup';
import { ToastModule } from 'primeng/toast';
import { DividerModule } from 'primeng/divider';

// **************************************************
import ptBr from '@angular/common/locales/pt';
import { registerLocaleData } from '@angular/common';

registerLocaleData(ptBr);
// **************************************************

@NgModule({
  declarations: [
    AppComponent,
    IfUserIsLoggedDirective,
    LoginComponent,
    GalleryComponent,
    HomeComponent,
    CategoryGalleryComponent,
    MainProductsComponent,
    OffersComponent,
    FooterComponent,
    LogoComponent,
    ProductComponent,
    HomePageComponent,
    QuantityComponent,
    ShoppingCartComponent,
    ItemComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HeaderModule,
    ButtonModule,
    GalleriaModule,
    CarouselModule,
    DataViewModule,
    RatingModule,
    TagModule,
    TableModule,
    DropdownModule,
    FormsModule,
    AvatarModule,
    AvatarGroupModule,
    InputTextModule,
    BreadcrumbModule,
    ConfirmPopupModule,
    ToastModule,
    DividerModule
  ],
  providers: [{ provide: LOCALE_ID, useValue: 'pt' }],
  bootstrap: [AppComponent],
})
export class AppModule {}
