import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, lastValueFrom, map, take, throwError } from 'rxjs';

interface ILogin {
  username: string;
  password: string;
}

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  constructor(private http: HttpClient) {}

  apiURL = 'http://localhost:8080';

  // Http Options
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };
  // /auth/login

  saveTokenFromLocalStorage(token: string) {
    localStorage.setItem('token', JSON.stringify({ token }));
  }

  login(data: ILogin) {
    return this.http.post(
      this.apiURL + '/auth/login',
      JSON.stringify(data),
      this.httpOptions
    );
    // .pipe(catchError(this.handleError));
  }

  validToken(token: string) {
    return this.http.post(
      this.apiURL + '/auth/validarToken',
      JSON.stringify({ token }),
      this.httpOptions
    ).pipe(
      map((res:any) => res.data)
    )
  }

  // Error handling
  handleError(error: any) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    window.alert(errorMessage);
    return throwError(() => {
      return errorMessage;
    });
  }
}
