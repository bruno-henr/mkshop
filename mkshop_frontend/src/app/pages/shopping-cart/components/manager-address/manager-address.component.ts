import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Address } from 'src/app/interfaces/Address';

@Component({
  selector: 'app-manager-address',
  templateUrl: './manager-address.component.html',
  styleUrls: ['./manager-address.component.scss'],
})
export class ManagerAddressComponent implements OnInit {
  onSubmit() {
    throw new Error('Method not implemented.');
  }
  @Input() address!: Address;
  formGroup!: FormGroup;
  ngOnInit() {
    this.formGroup = new FormGroup({
      street: new FormControl<string>(this.address.street),
      number: new FormControl<string>(this.address.number),
      neighborhood: new FormControl<string>(this.address.neighborhood),
    });
  }
}
