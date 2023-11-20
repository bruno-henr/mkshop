import { Component } from '@angular/core';
import { PrimeNGConfig } from 'primeng/api';
import { UserService } from './services/user/user-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  date: Date | undefined;

  title = 'MK.SHOP';

  userIsLogged: boolean = true;

  constructor(
    private primengConfig: PrimeNGConfig,
    private userService: UserService  
  ) {
    this.userService.getUserIfLogged().subscribe(data => {
      this.userIsLogged = data
    })
  }

  ngOnInit() {
    this.primengConfig.ripple = true;
  }
}
