import { Injectable, OnInit } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { IChangeQuantity } from '../../pages/shopping-cart/components/item/item.component';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { UserService } from '../user/user-service.service';
import { Product } from 'src/app/interfaces/Product';

interface ProdutosCarrinho extends Product {
  qtd: number;
}

@Injectable({
  providedIn: 'root',
})
export class ProdutsService {
  total!: number;

  productsCarrinho!: BehaviorSubject<ProdutosCarrinho[]>;
  productsCarrinhoObservable$!: any;
  products!: any[];

  constructor(private http: HttpClient, private userService: UserService) {
    this.loadProductsFromLocalStorage();

    this.productsCarrinho.subscribe((data: ProdutosCarrinho[]) => {
      this.updateTotal(data);
      this.saveProductsToLocalStorage();
    });
  }

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

  getProducts(productName?: string) {
    if (productName) {
      let params = new HttpParams().set('name', productName);
      return this.http.get(this.apiURL + '/product', {
        params: params,
        headers: this.httpOptions.headers,
      });
    }
    return this.http.get(this.apiURL + '/product', this.httpOptions);
  }

  getProductsCarrinho() {
    return this.productsCarrinho.getValue();
  }

  getTotal() {
    return this.total;
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
      return this.productsCarrinho.getValue();
    }
    return null;
  }

  updateProductsFromLocalStorage(productsList: ProdutosCarrinho[]) {
    this.productsCarrinho.next(productsList);
    //this.updateTotal();
    //this.saveProductsToLocalStorage();
  }

  updateTotal(data?: ProdutosCarrinho[]) {
    this.total = (
      data?.length ? data : this.productsCarrinho?.getValue()
    ).reduce((prev, current) => {
      return prev + current.price * current.qtd;
    }, 0);
  }

  delete(id: string) {
    let carrinho = this.productsCarrinho.getValue();
    const filtrado = carrinho.filter((item) => item.id !== id);

    this.productsCarrinho.next(filtrado);
  }

  loadProductsFromLocalStorage(): void {
    const savedProducts = localStorage.getItem('products');

    if (savedProducts) {
      const parsedProducts: ProdutosCarrinho[] = JSON.parse(savedProducts);
      this.productsCarrinho = new BehaviorSubject<ProdutosCarrinho[]>(
        parsedProducts
      );
    } else {
      this.productsCarrinho = new BehaviorSubject<ProdutosCarrinho[]>([]);
    }
    // this.productsCarrinhoObservable$ = this.productsCarrinho.asObservable();
    this.updateTotal();
  }

  addProduct(product: Product, qtd?: number): void {
    let carrinho = this.productsCarrinho.getValue();

    const index = carrinho.findIndex((item) => item.id === product.id);
    if (index !== -1) {
      carrinho[index].qtd++;
    } else {
      carrinho.push({ ...product, qtd: qtd || 1 });
    }
    this.productsCarrinho.next(carrinho);

    //this.updateTotal();
  }

  saveProductsToLocalStorage(): void {
    localStorage.setItem(
      'products',
      JSON.stringify(this.productsCarrinho.getValue())
    );
  }
}
