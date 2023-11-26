import { Component, EventEmitter, Input, Output } from '@angular/core';
import { ConfirmationService, MessageService } from 'primeng/api';

export interface IChangeQuantity {
  quantity: number;
  product_id: string;
}
@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.scss'],
  providers: [ConfirmationService, MessageService],
})
export class ItemComponent {
  @Input() product!: any;
  @Input() handleDeleteItem!: (args: any) => void;
  @Output() changeQuantityProduct = new EventEmitter<IChangeQuantity>();

  getQuantityCurrent(value: any, productItemId: any) {
    this.changeQuantityProduct.emit({
      product_id: productItemId,
      quantity: value,
    });
  }

  constructor(
    private confirmationService: ConfirmationService,
    private messageService: MessageService
  ) {}

  confirm(event: Event, id: string) {
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
        this.handleDeleteItem(id);
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
