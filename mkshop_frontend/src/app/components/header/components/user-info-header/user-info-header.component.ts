import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user/user-service.service';

@Component({
  selector: 'app-user-info-header',
  templateUrl: './user-info-header.component.html',
  styleUrls: ['./user-info-header.component.scss'],
})
export class UserInfoHeaderComponent implements OnInit {
  user: any;
  constructor(private userService: UserService) {}
  ngOnInit(): void {
    this.user = this.userService.getUser();
  }
  logado = true;
}
