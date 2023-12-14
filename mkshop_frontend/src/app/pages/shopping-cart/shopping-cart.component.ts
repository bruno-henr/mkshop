import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ConfirmationService, MenuItem, MessageService } from 'primeng/api';
import { BehaviorSubject, Subscription } from 'rxjs';
import { ProdutsService } from 'src/app/services/products/produts.service';
import { IChangeQuantity } from './components/item/item.component';
import { Product } from 'src/app/interfaces/Product';
import { Address } from 'src/app/interfaces/Address';
import { UserService } from 'src/app/services/user/user-service.service';
import { OrderService } from 'src/app/services/order/order.service';
import { Router } from '@angular/router';
interface ProdutosCarrinho extends Product {
  qtd: number;
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
  showSettingAddress: boolean = false;
  btnFinished: boolean = false;
  products = new BehaviorSubject<ProdutosCarrinho[]>([]);
  productsSubscription!: Subscription;
  mainProducts!: any[];
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
  address!: Address;
  showDialogAddAddress = true;

  showDialog() {
    this.visible = true;
  }

  handleFinishRequest() {
    let carrinho: any = {
      productOrders: [...this.products.getValue()].map((p: any) => {
        delete p.category;
        return p;
      }),
      total: this.total,
      method_payment: '',
      user: {},
    };
    let metodo: any = this.methodDelivery.value;
    carrinho.method_payment =
      metodo.value == 'delivery' ? 'RETIRAR_LOJA' : 'ENTREGA';

    if (carrinho.method_payment == 'ENTREGA') {
      carrinho.address = this.address;
    } else {
      delete carrinho.address;
    }
    this.orderService.createOrder(carrinho).subscribe(
      (response: any) => {
        this.messageService.add({
          severity: 'success',
          summary: 'Confirmado',
          detail: 'Pedido feito com sucesso!',
        });
        setTimeout(() => {
          this.route.navigate(['/']);
          window.localStorage.removeItem('products');
        }, 1000);
      },
      (erro: any) => {
        this.messageService.add({
          severity: 'error',
          summary: 'Erro',
          detail: 'Houve um erro ao salvar seu pedido',
        });
      }
    );
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
    private messageService: MessageService,
    private userService: UserService,
    private orderService: OrderService,
    private route: Router
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

  handleSetAddress(address: Address) {
    console.log('handleSetAddress => ', address);
    if (!this.address) {
      this.userService.addAddressToUser(address).subscribe((result:any) => {
        console.log('result => ', result.data);
        console.log('address => ', result.data.address);
        this.address = result.data.address;
      })
      //this.getAddressToUser();
    }
    this.showDialogAddAddress = false;
    this.visible = false;
  }

  getAddressToUser() {
    let user = JSON.parse(localStorage.getItem('user') as string);

    this.address = user.address;
    this.showDialogAddAddress = false;
  }

  ngOnInit() {
    this.getAddressToUser();

    this.methodDelivery.valueChanges.subscribe((data: any) => {
      if (data) {
        if (data.value === 'address') {
          this.showSettingAddress = true;
          this.btnFinished = this.address.id != null;
        } else {
          this.showSettingAddress = false;
          this.btnFinished = true;
        }
      }
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
