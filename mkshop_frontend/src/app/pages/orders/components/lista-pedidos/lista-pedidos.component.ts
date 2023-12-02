import { Component, Input, OnInit } from '@angular/core';
import { OrderUser } from 'src/app/interfaces/OrderUser';

@Component({
  selector: 'app-lista-pedidos',
  templateUrl: './lista-pedidos.component.html',
  styleUrls: ['./lista-pedidos.component.scss'],
})
export class ListaPedidosComponent implements OnInit {
  @Input() orders!: any[];

  ngOnInit(): void {
    console.log('orders => ', this.orders);
  }
}
