import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class OrderService {
  constructor(private http: HttpClient) {}
  apiURL = 'http://localhost:8080';

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  organizeObjectProductOrder(data: any[]) {
    return data.map((item: any) => {
      return {
        product: {
          name: item.name,
          price: item.price,
          fabricator: item.fabricator,
          composition: item.composition,
          StockQuantity: item.StockQuantity,
          img_url: item.img_url,
          main: item.main,
          categoryId: item.categoryId,
          imageProducts: item.imageProducts,
          productOrders: item.productOrders,
          id: item.id
        },
        qtd: item.qtd,
      };
    });
  }

  createOrder(data: any) {
    data.productOrders = this.organizeObjectProductOrder(data.productOrders);
    
    let user = JSON.parse(localStorage.getItem('user') as string);
    data.user = {
      id: user.id,
      created_at: user.created_at,
      updated_at: user.updated_at,
      full_name: user.full_name,
      username: user.username,
      phone_number: user.phone_number,
      cpf: user.cpf,
      address: user.address || null,
      order: user.order || [],
      role: user.role
      
    };
    console.log('dados create ordem ', data)
    return this.http.post(`${this.apiURL}/order`, data, this.httpOptions);
  }

  getOrderByUser() {
    let user = JSON.parse(localStorage.getItem('user') as string);
    let params = new HttpParams().set('user_id', user.id);

    return this.http.get(this.apiURL + '/order', {
      params: params,
      headers: this.httpOptions.headers,
    });
  }
}
