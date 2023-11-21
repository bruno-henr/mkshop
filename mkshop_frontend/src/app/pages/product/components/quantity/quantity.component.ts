import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-quantity',
  templateUrl: './quantity.component.html',
  styleUrls: ['./quantity.component.scss'],
})
export class QuantityComponent {
  @Input() value: number = 1;

  minus() {
    if (this.value != 0) {
      this.value--;
    }
  }
  add() {
    this.value++;
  }
}
