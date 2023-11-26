import { Component, OnInit } from '@angular/core';
import { ProdutsService } from 'src/app/services/products/produts.service';
import { Product } from '../../interfaces/Product'
@Component({
  selector: 'app-main-products',
  templateUrl: './main-products.component.html',
  styleUrls: ['./main-products.component.scss'],
})
export class MainProductsComponent implements OnInit {
  constructor(private productService: ProdutsService) {}

  responsiveOptions: any[] | undefined;
  products!: Product[];

  ngOnInit() {
    this.productService.getMainProducts().subscribe((response: any) => {
      console.log('produtos => ', response);
      this.products = response.data
    });

    this.responsiveOptions = [
      {
        breakpoint: '1199px',
        numVisible: 1,
        numScroll: 1,
      },
      {
        breakpoint: '991px',
        numVisible: 2,
        numScroll: 1,
      },
      {
        breakpoint: '767px',
        numVisible: 1,
        numScroll: 1,
      },
    ];
  }
}
