import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user/user-service.service';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.scss'],
})
export class PerfilComponent implements OnInit {
  user: any;
  userLabel!: string;
  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.user = this.userService.getUser();
    this.userLabel = String(this.user.full_name.split(' ')[0][0]).toUpperCase();
  }
}
