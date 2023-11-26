import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login/login.service';
import { UserService } from 'src/app/services/user/user-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {
  formGroup!: FormGroup;

  constructor(
    private userService: UserService,
    private loginService: LoginService,
    private router: Router
  ) {}

  onSubmit() {
    if (this.formGroup.valid) {
      const { login, password } = this.formGroup.value;
      
      this.loginService
        .login({ username: login, password })
        .subscribe((data: any) => {
          if (!data.hasError) {
            
            this.userService.updateTokenJWT(data.data);
            this.router.navigate(['/']);
          }
        });
    }
  }
  ngOnInit() {
    this.formGroup = new FormGroup({
      login: new FormControl<string | null>('bruno_henr'),
      password: new FormControl<string | null>('123'),
    });
  }
}
