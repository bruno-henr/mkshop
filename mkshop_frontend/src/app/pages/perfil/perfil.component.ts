import { Component, OnInit } from '@angular/core';
import { ConfirmationService, MessageService } from 'primeng/api';
import { UserService } from 'src/app/services/user/user-service.service';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.scss'],
  providers: [ConfirmationService, MessageService],
})
export class PerfilComponent implements OnInit {
  user: any;
  userLabel!: string;
  constructor(
    private userService: UserService,
    private confirmationService: ConfirmationService,
  ) {}

  ngOnInit(): void {
    this.user = this.userService.getUser();
    this.userLabel = String(this.user.full_name.split(' ')[0][0]).toUpperCase();
  }

  confirm(event: Event) {
    this.confirmationService.confirm({
      target: event.target as EventTarget,
      message: 'Tem certeza que deseja sair da sua conta?',
      icon: 'pi pi-exclamation-triangle',
      acceptLabel: 'Sim',
      rejectLabel: 'Não',
      accept: () => {
        this.userService.signOutUser();
      },
    });
  }
}
