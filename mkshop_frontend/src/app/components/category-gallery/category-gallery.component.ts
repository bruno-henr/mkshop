import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-category-gallery',
  templateUrl: './category-gallery.component.html',
  styleUrls: ['./category-gallery.component.scss'],
})
export class CategoryGalleryComponent implements OnInit {
  categories: any[] = [
    { name: 'Frutas & vegetais', image: 'fruits' },
    { name: 'Proteinas', image: 'eag' },
    { name: 'Cafés & Chás', image: 'coffee' },
    { name: 'Bebidas alcoólicas', image: 'drink' },
    { name: 'Padaria', image: 'bread' },
    { name: 'Higiene', image: 'hygiene' },
    { name: 'Laticinios', image: 'cheese' },
  ];

  responsiveOptions: any[] | undefined;

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
