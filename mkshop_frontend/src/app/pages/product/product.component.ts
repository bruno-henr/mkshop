import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ConfirmationService, MenuItem, MessageService } from 'primeng/api';
import { ProdutsService } from 'src/app/services/products/produts.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss'],
  providers: [ConfirmationService, MessageService],
})
export class ProductComponent implements OnInit {
  
  constructor(
    private activatedRoute: ActivatedRoute,
    private productService: ProdutsService,
    private router: Router,
    private messageService: MessageService,
  ) {}

  responsiveOptions: any[] | undefined;
  products!: any[];
  product: any;
  valueQuantity: number = 0;

  addProductInShoppingCart() {
    
    this.productService.addProduct(this.product, this.valueQuantity);

    this.messageService.add({
      severity: 'success',
      summary: 'Confirmado',
      detail: 'Produto adicionado ao carrinho.',
    });

    setTimeout(() => {
      this.router.navigate(['/carrinho']);
    }, 1000);
  }

  handleValueQuantity(value: any) {
    this.valueQuantity = value;
  }

  items: MenuItem[] | undefined;

  home: MenuItem | undefined;

  getProductByName(name: string) {
    this.productService.getProducts(name).subscribe((response: any) => {
      this.product = response.data[0];
    });
  }

  ngOnInit() {
    this.getProductByName(
      this.activatedRoute.snapshot.paramMap.get('product_name') as string
    );
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

    this.items = [
      {
        label: this.activatedRoute.snapshot.paramMap.get(
          'product_name'
        ) as string,
      },
    ];

    this.home = { icon: 'pi pi-home', routerLink: '/' };
  }
}
