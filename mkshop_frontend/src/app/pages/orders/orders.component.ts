import { Component, OnInit } from '@angular/core';
import { OrderUser } from 'src/app/interfaces/OrderUser';
import { CategoryService } from 'src/app/services/category/category.service';
import { OrderService } from 'src/app/services/order/order.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.scss'],
})
export class OrdersComponent implements OnInit {
  orderUser!: OrderUser[];

  constructor(
    private orderService: OrderService,
    private categoryService: CategoryService
  ) {}

  ngOnInit(): void {
    this.orderService.getOrderByUser().subscribe(async (response: any) => {
      const lista = await Promise.all(
        response.data.map(async (p: any) => {
          p.productOrders.map((po: any) => {

            this.categoryService
              .getCategoryById(po.product.categoryId)
              .subscribe((c: any) => {
                po.product.category = { id: c.data.id, name: c.data.name };
              })
          });
          return p
        })
      );
      this.orderUser = response.data;
    });
  }
}
