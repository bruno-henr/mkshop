import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';
import { Product } from 'src/app/interfaces/Product';
import { ProdutsService } from 'src/app/services/products/produts.service';

interface Option {
  label: string;
  value: string;
}

@Component({
  selector: 'app-offers',
  templateUrl: './offers.component.html',
  styleUrls: ['./offers.component.scss'],
  providers: [MessageService]
})
export class OffersComponent implements OnInit {
  sortOptions!: Option[];
  sortOrder!: number;
  sortField!: string;

  products!: Product[];
  sortKey: Option | undefined;

  constructor(
    private productService: ProdutsService,
    private messageService: MessageService
  ) {}

  addShoppingCard(_product: Product) {
    this.messageService.add({
      severity: 'success',
      summary: 'Success',
      detail: `${_product.name} adicionado ao carrinho`,
    });
    this.productService.addProduct(_product);
  }

  ngOnInit(): void {
    this.productService.getProducts().subscribe((response: any) => {
      console.log('lista de produtos => ', response);
      this.products = response.data;
    });
    this.sortOptions = [
      { label: 'Maior preço para o menor', value: '!price' },
      { label: 'Menor preço para o maior', value: 'price' },
    ];
  }

  layout: 'grid' | 'list' = 'grid';

  onSortChange(event: any) {
    let value = event.value.value;

    if (value.indexOf('!') === 0) {
      this.sortOrder = -1;
      this.sortField = value.substring(1, value.length);
    } else {
      this.sortOrder = 1;
      this.sortField = value;
    }
  }

  getSeverity(product: any) {
    switch (product.inventoryStatus) {
      case 'INSTOCK':
        return 'success';

      case 'LOWSTOCK':
        return 'warning';

      case 'OUTOFSTOCK':
        return 'danger';

      default:
        return null;
    }
  }
}
