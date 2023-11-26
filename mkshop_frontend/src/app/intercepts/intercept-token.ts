import {
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
} from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { UserService } from '../services/user/user-service.service';
import { Router } from '@angular/router';

// @Injectable()
// export class InterceptToken implements HttpInterceptor {
//   intercept(
//     req: HttpRequest<any>,
//     next: HttpHandler
//   ): Observable<HttpEvent<any>> {
//     let token = inject(UserService).getTokenJWT();

//     req = req.clone({
//         setHeaders: {
//             'Authorization': `Bearer ${token}`,
//             'Content-Type': 'application/json',
//             'Access-Control-Allow-Origin': '*'
//         }
//     });

//     return next.handle(req);
//   }
// }
