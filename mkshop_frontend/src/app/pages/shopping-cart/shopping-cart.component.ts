import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ConfirmationService, MenuItem, MessageService } from 'primeng/api';
import { BehaviorSubject, Subscription } from 'rxjs';
import { ProdutsService } from 'src/app/services/products/produts.service';
import { IChangeQuantity } from './components/item/item.component';
import { Product } from 'src/app/interfaces/Product';
interface ProdutosCarrinho extends Product {
  qtd: number
}


interface IAddress {
  street: string;
  neighborhood: string;
  number: string;
}

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.scss'],
  providers: [ConfirmationService, MessageService],
})
export class ShoppingCartComponent implements OnInit, OnDestroy {
  confirm($event: MouseEvent) {
    throw new Error('Method not implemented.');
  }
  products = new BehaviorSubject<ProdutosCarrinho[]>([]);
  productsSubscription!: Subscription;
  mainProducts!: any[];
  address: IAddress[] = [];
  addressSelected!: IAddress;
  items: MenuItem[] | undefined;
  home: MenuItem | undefined;
  total!: number;
  desconto: number = 0;
  // Dropdown
  optionsDelivery!: any;
  selectDelivery: any;
  // Form
  methodDelivery = new FormControl(null);

  visible: boolean = false;

  showDialog() {
    this.visible = true;
  }

  handleFinishRequest() {
    this.messageService.add({
      severity: 'success',
      summary: 'Confirmado',
      detail: 'Pedido feito com sucesso!',
    });
  }

  handleDeleteItem = (id: string) => {
    this.productService.delete(id);
    this.total = this.productService.getTotal();
    this.products.next(this.productService.getProductsCarrinho());
  };

  updateTotalShoppingCart() {
    this.productService.updateTotal();
  }

  constructor(
    private productService: ProdutsService,
    private confirmationService: ConfirmationService,
    private messageService: MessageService,
  ) {}

  ngOnDestroy(): void {
    this.productsSubscription.unsubscribe();
  }

  handleUpdateQuantityProduct(data: IChangeQuantity) {
    let productUpdated = this.productService.updateProductQuantity(data);
    if (productUpdated != null) {
      this.products.next(productUpdated);
      this.total = this.productService.total;
    }
  }

  ngOnInit() {
    // this.products.next(this.productService.getProducts()?.getValue());
    this.methodDelivery.valueChanges.subscribe((data) => {
    });
    const produtosCarrinho = this.productService.getProductsCarrinho();
    
    this.products.next(produtosCarrinho);

    this.total = this.productService.total;

    // Inscricao na propriedade de produto para monitorar qq mudança
    this.productsSubscription = this.products.subscribe((data) => {
      this.productService.updateProductsFromLocalStorage(data);
    });

    this.optionsDelivery = [
      { name: 'Retirar na loja', value: 'delivery' },
      { name: 'Endereço', value: 'address' },
    ];

    this.items = [{ label: 'Carrinho de compras' }];

    this.home = { icon: 'pi pi-home', routerLink: '/' };
  }
}
