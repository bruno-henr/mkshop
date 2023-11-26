import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserService } from '../user/user-service.service';

@Injectable({
  providedIn: 'root',
})
export class CategoryService {
  constructor(private http: HttpClient, private userService: UserService) {}

  apiURL = 'http://localhost:8080';

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${this.userService.getTokenJWT()}`,
    }),
  };

  getAllCategories() {
    return this.http.get(this.apiURL + '/category', this.httpOptions);
  }
}
