import { Component, OnInit } from '@angular/core';
import { OrderUser } from 'src/app/interfaces/OrderUser';
import { OrderService } from 'src/app/services/order/order.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.scss'],
})
export class OrdersComponent implements OnInit {
  orderUser!: OrderUser[];

  constructor(private orderService: OrderService) {}

  ngOnInit(): void {
    this.orderService.getOrderByUser().subscribe((response: any) => {
      console.log('response ', response.data);
      
      this.orderUser = response.data;
    });
  }
}
