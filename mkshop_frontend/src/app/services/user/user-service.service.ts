import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor() { }

  public getUserIfLogged(): Observable<boolean> {
    return of(true);
  }
  
}
