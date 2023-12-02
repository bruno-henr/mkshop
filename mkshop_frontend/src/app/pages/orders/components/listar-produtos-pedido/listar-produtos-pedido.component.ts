import { ChangeDetectorRef, Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-listar-produtos-pedido',
  templateUrl: './listar-produtos-pedido.component.html',
  styleUrls: ['./listar-produtos-pedido.component.scss'],
})
export class ListarProdutosPedidoComponent implements OnInit {
  // uma lista de produtos de um pedido especifico
  @Input() products!: any[]; 
  layout: 'grid' | 'list' = 'grid';
  ngOnInit(): void {
    console.log('lista de produtos PORRA', this.products);
  }
}
