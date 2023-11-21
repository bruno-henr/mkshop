import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss'],
})
export class ProductComponent implements OnInit {
  responsiveOptions: any[] | undefined;
  products: any = [
    { name: 'Doritos 300g Elma Chips', image: 'doritos' },
    { name: 'Baggio Café Torrado', image: 'cafe' },
    { name: 'Cerveja Brahma Duplo Malte', image: 'cerveja' },
    { name: 'Doritos 300g Elma Chips', image: 'doritos' },
  ];

  ngOnInit() {
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
