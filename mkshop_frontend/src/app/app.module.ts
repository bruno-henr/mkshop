import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
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
    InputTextModule
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
