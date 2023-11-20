import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';

export const authenticationGuard: CanActivateFn = (route, state) => {
  const token = window.localStorage.getItem('auth-token');
  console.log('teste');
  console.log('route => ', route);
  if (token) {
    
    return true;
  }
  inject(Router).navigate(['login']);
  return false;
};
