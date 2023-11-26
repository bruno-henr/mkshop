import { HttpClient, HttpHeaders } from '@angular/common/http';
import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { lastValueFrom } from 'rxjs';
import { LoginService } from 'src/app/services/login/login.service';
import { UserService } from 'src/app/services/user/user-service.service';

export const authenticationGuard: CanActivateFn = async (route, state) => {
  // const token = JSON.parse(
  //   window.localStorage.getItem('token') as string
  // ).token;
  const token = inject(UserService).getTokenJWT();
  const router = inject(Router);
  
  const req$ = inject(LoginService).validToken(token);
  return await lastValueFrom(req$).then(response => {
    return true
  }).catch(e => {
    console.log('essa piriquita ', e);
    router.navigate(['login'])
    return false;
  })
};
