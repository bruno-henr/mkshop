import { Injectable, OnInit } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { IChangeQuantity } from '../../pages/shopping-cart/components/item/item.component';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserService } from '../user/user-service.service';
import { Product } from 'src/app/interfaces/Product';

interface ProdutosCarrinho extends Product {
  qtd: number
}

@Injectable({
  providedIn: 'root',
})
export class ProdutsService implements OnInit {
  total!: number;
  productsCarrinho = new BehaviorSubject<ProdutosCarrinho[]>([]);
  products!: any[];

  constructor(private http: HttpClient, private userService: UserService) {}

  apiURL = 'http://localhost:8080';

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: `Bearer ${this.userService.getTokenJWT()}`,
    }),
  };

  getMainProducts() {
    return this.http.get(this.apiURL + '/product/main', this.httpOptions);
  }

  getProducts() {
    return this.http.get(this.apiURL + '/product', this.httpOptions);
  }

  ngOnInit(): void {
    this.loadProductsFromLocalStorage();
    this.updateTotal();
  }

  getProductsCarrinho() {
    return this.productsCarrinho.getValue();
  }

  updateProductQuantity(data: IChangeQuantity) {
    const index = this.productsCarrinho
      .getValue()
      .findIndex((item) => item.id === data.product_id);

    if (index !== -1) {
      this.productsCarrinho.getValue()[index] = {
        ...this.productsCarrinho.getValue()[index],
        qtd: data.quantity,
      };
      //this.updateProductsFromLocalStorage(this.products.getValue());
      return this.productsCarrinho.getValue();
    }
    return null;
  }

  updateProductsFromLocalStorage(productsList: ProdutosCarrinho[]) {
    this.productsCarrinho.next(productsList);
    this.updateTotal();
    this.saveProductsToLocalStorage();
  }

  updateTotal() {
    this.total = this.productsCarrinho?.getValue().reduce((prev, current) => {
      return prev + current.price * current.qtd;
    }, 0);
  }

  delete(id: string) {
    this.productsCarrinho.next(
      this.productsCarrinho.getValue().filter((item) => item.id !== id)
    );
  }

  loadProductsFromLocalStorage(): void {
    const savedProducts = localStorage.getItem('products');
    console.log('localstoragfe prod ', savedProducts);
    if (savedProducts) {
      this.productsCarrinho.next(JSON.parse(savedProducts));
    } else {
      this.productsCarrinho.next([]);
    }
  }

  addProduct(product: Product): void {
    const index = this.productsCarrinho
      .getValue()
      .findIndex((item) => item.id === product.id);

    if(index != -1) {
      this.productsCarrinho.getValue()[index].qtd++;
    } else {
      this.productsCarrinho.getValue().push({...product, qtd: 1 });
    }

    this.saveProductsToLocalStorage();
  }

  saveProductsToLocalStorage(): void {
    localStorage.setItem(
      'products',
      JSON.stringify(this.productsCarrinho.getValue())
    );
  }
}
