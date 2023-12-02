import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'calcularPedido',
})
export class CalcularPedidoPipe implements PipeTransform {
  transform(items: any[]): number {
    if (!items) return 0;

    // Lógica para calcular o total do carrinho de compras
    return items.reduce((total, item) => total + item.qtd * item.product.price, 0);
  }
}
