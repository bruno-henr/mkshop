import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.scss'],
})
export class ShoppingCartComponent implements OnInit {
  items: MenuItem[] | undefined;

  home: MenuItem | undefined;
  products!: any[];
  total!: number;
  desconto: number = 0;
  // Dropdown
  optionsDelivery!: any;
  selectDelivery: any;

  ngOnInit() {
    this.optionsDelivery = [
      { name: 'Retirar na loja', value: 'delivery' },
      { name: 'Endereço', value: 'address' },
    ];
    this.products = [
      {
        id: '1000',
        code: 'f230fh0g3',
        name: 'Bamboo Watch',
        description: 'Product Description',
        image: 'bamboo-watch.jpg',
        price: 65,
        category: 'Accessories',
        quantity: 24,
        inventoryStatus: 'INSTOCK',
        rating: 5,
        qtd: 2,
      },
      {
        id: '1000',
        code: 'f230fh0g3',
        name: 'Bamboo Watch 2',
        description: 'Product Description',
        image: 'bamboo-watch.jpg',
        price: 6500,
        category: 'Teste',
        quantity: 24,
        inventoryStatus: 'INSTOCK',
        rating: 5,
        qtd: 2,
      },
      {
        id: '1000',
        code: 'f230fh0g3',
        name: 'Bamboo Watch',
        description: 'Product Description',
        image: 'bamboo-watch.jpg',
        price: 65,
        category: 'Accessories',
        quantity: 24,
        inventoryStatus: 'INSTOCK',
        rating: 5,
        qtd: 2,
      },
      {
        id: '1000',
        code: 'f230fh0g3',
        name: 'Bamboo Watch 2',
        description: 'Product Description',
        image: 'bamboo-watch.jpg',
        price: 6500,
        category: 'Teste',
        quantity: 24,
        inventoryStatus: 'INSTOCK',
        rating: 5,
        qtd: 2,
      },
      {
        id: '1000',
        code: 'f230fh0g3',
        name: 'Bamboo Watch',
        description: 'Product Description',
        image: 'bamboo-watch.jpg',
        price: 65,
        category: 'Accessories',
        quantity: 24,
        inventoryStatus: 'INSTOCK',
        rating: 5,
        qtd: 2,
      },
      {
        id: '1000',
        code: 'f230fh0g3',
        name: 'Bamboo Watch 2',
        description: 'Product Description',
        image: 'bamboo-watch.jpg',
        price: 6500,
        category: 'Teste',
        quantity: 24,
        inventoryStatus: 'INSTOCK',
        rating: 5,
        qtd: 2,
      },
      {
        id: '1000',
        code: 'f230fh0g3',
        name: 'Bamboo Watch',
        description: 'Product Description',
        image: 'bamboo-watch.jpg',
        price: 65,
        category: 'Accessories',
        quantity: 24,
        inventoryStatus: 'INSTOCK',
        rating: 5,
        qtd: 2,
      },
      {
        id: '1000',
        code: 'f230fh0g3',
        name: 'Bamboo Watch 2',
        description: 'Product Description',
        image: 'bamboo-watch.jpg',
        price: 6500,
        category: 'Teste',
        quantity: 24,
        inventoryStatus: 'INSTOCK',
        rating: 5,
        qtd: 2,
      },
    ];

    this.total = this.products?.reduce((prev, current) => {
      return prev + current.price * current.qtd;
    }, 0);

    this.items = [{ label: 'Carrinho de compras' }];

    this.home = { icon: 'pi pi-home', routerLink: '/' };
  }
}
