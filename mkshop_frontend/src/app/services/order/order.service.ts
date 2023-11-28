import { HttpClient, HttpHeaders } from '@angular/common/http';
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
          category: item.category,
          composition: item.composition,
          created_at: item.created_at,
          fabricator: item.fabricator,
          id: item.id,
          imageProducts: item.imageProducts,
          img_url: item.img_url,
          main: item.main,
          name: item.name,
          price: item.price,
          // qtd: 2
          stockQuantity: item.stockQuantity,
          updated_at: item.updated_at,
        },
        qtd: item.qtd,
      };
    });
  }

  createOrder(data: any) {
    data.productsOrder = this.organizeObjectProductOrder(data.productsOrder);

    let user = JSON.parse(localStorage.getItem('user') as string);
    data.user = {
      id: user.id,
      username: user.username,
      cpf: user.cpf,
      created_at: user.created_at,
      full_name: user.full_name,
      phone_number: user.phone_number,
      updated_at: user.updated_at,
    };
    return this.http.post(`${this.apiURL}/order`, data, this.httpOptions);
  }
}
