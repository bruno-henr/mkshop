import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, of } from 'rxjs';
import { Address } from 'src/app/interfaces/Address';
import { User } from 'src/app/interfaces/User';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private token_jwt =
    window.localStorage.getItem('token') != null
      ? JSON.parse(window.localStorage.getItem('token') as string).token
      : null;

  private user!: User;

  constructor(private http: HttpClient, private router: Router) {}
  apiURL = 'http://localhost:8080';

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  getTokenJWT(): string {
    console.log('TOKEN ', this.token_jwt);
    return this.token_jwt;
  }

  getUser() {
    return JSON.parse(window.localStorage.getItem('user') as string);
  }

  updateTokenJWT(token: string) {
    this.token_jwt = token;
    window.localStorage.setItem('token', JSON.stringify({ token: token }));
  }

  getUserByUsername(username: string) {
    let result = this.http.get(this.apiURL + '/user/username', {
      params: new HttpParams().set('username', username),
    });

    return result;
  }

  addAddressToUser(address: Address) {
    let user = this.getUser();
    
    let result = this.http.put(
      `${this.apiURL}/user/${user.id}`,
      {
        full_name: user.full_name,
        username: user.username,
        password: null,
        phone_number: user.phone_number,
        cpf: user.cpf,
        address: address,
        order: null,
        role: user.role,
        id: user.id,
      }
    );

    return result;
  }

  public getUserIfLogged(): Observable<boolean> {
    return of(true);
  }

  signOutUser() {
    window.localStorage.removeItem('products');
    window.localStorage.removeItem('token');
    window.localStorage.removeItem('user');
    this.router.navigate(['/login']);
  }
}
