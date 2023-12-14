import { Component } from '@angular/core';
import { MessageService } from 'primeng/api';
import { Product } from 'src/app/interfaces/Product';
import { CategoryService } from 'src/app/services/category/category.service';
import { ProdutsService } from 'src/app/services/products/produts.service';

interface Option {
  label: string;
  value: string;
}

@Component({
  selector: 'app-show-main-brans',
  templateUrl: './show-main-brans.component.html',
  styleUrls: ['./show-main-brans.component.scss'],
  providers: [MessageService],
})
export class ShowMainBransComponent {
  sortOptions!: Option[];
  sortOrder!: number;
  sortField!: string;

  products!: Product[];
  sortKey: Option | undefined;

  constructor(
    private productService: ProdutsService,
    private categoryService: CategoryService,
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
    this.productService.getProducts().subscribe(async (response: any) => {
      const lista = await Promise.all(
        response.data.map(async (p: any) => {
          this.categoryService
            .getCategoryById(p.categoryId)
            .subscribe((c: any) => {
              p.category = { id: c.data.id, name: c.data.name };
            });
          return p;
        })
      );

      this.products = lista;
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
}
