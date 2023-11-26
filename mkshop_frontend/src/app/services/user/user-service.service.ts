import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private token_jwt = JSON.parse(
    window.localStorage.getItem('token') as string
  ).token;

  constructor(private http: HttpClient) {}
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

  updateTokenJWT(token: string) {
    this.token_jwt = token;
    window.localStorage.setItem('token', JSON.stringify({ token: token }));
  }

  getUserByUsername(username: string) {
    return this.http.get(this.apiURL + '/user/username', {
      params: new HttpParams().set('username', username),
    });
  }

  public getUserIfLogged(): Observable<boolean> {
    return of(true);
  }
}
