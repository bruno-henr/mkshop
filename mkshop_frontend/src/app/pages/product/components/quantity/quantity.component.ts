import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-quantity',
  templateUrl: './quantity.component.html',
  styleUrls: ['./quantity.component.scss'],
})
export class QuantityComponent implements OnInit {
  @Input() valueQuantity!: number;
  @Output() valueEmitter = new EventEmitter();

  handleEmmiter(value: any) {
    this.valueEmitter.emit(value);
  }

  minus() {
    
    if (this.valueQuantity > 1) {
      this.valueQuantity--;
      this.handleEmmiter(this.valueQuantity);
    }
  }
  add() {
    this.valueQuantity++;
    this.handleEmmiter(this.valueQuantity);
  }

  ngOnInit() {}
}
