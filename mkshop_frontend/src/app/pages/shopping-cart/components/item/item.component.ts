import { Component, Input } from '@angular/core';
import { ConfirmationService, MessageService } from 'primeng/api';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.scss'],
  providers: [ConfirmationService, MessageService],
})
export class ItemComponent {
  @Input() product!: any;

  constructor(
    private confirmationService: ConfirmationService,
    private messageService: MessageService
  ) {}

  confirm(event: Event) {
    this.confirmationService.confirm({
      target: event.target as EventTarget,
      message: 'Você tem certeza que deseja remover esse produto?',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.messageService.add({
          severity: 'success',
          summary: 'Confirmado',
          detail: 'Produto removido com sucesso!',
        });
      },
      reject: () => {
        this.messageService.add({
          severity: 'info',
          summary: 'Produto mantido no carrinho',
          detail: 'Produto no carrinho',
        });
      },
    });
  }
}
