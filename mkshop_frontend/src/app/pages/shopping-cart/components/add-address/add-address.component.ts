import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { AddressService } from 'src/app/services/address/address.service';

@Component({
  selector: 'app-add-address',
  templateUrl: './add-address.component.html',
  styleUrls: ['./add-address.component.scss'],
})
export class AddAddressComponent implements OnInit {
  formGroup!: FormGroup;
  street: any;
  @Output() addressEvent = new EventEmitter();

  constructor(private addressService: AddressService) {}

  onSubmit() {
    if (this.formGroup.valid) {
      console.log('essa ', this.formGroup.value);
      this.addressEvent.emit(this.formGroup.value);
    }
  }
  ngOnInit() {
    this.formGroup = new FormGroup({
      street: new FormControl<string | null>(null),
      number: new FormControl<string | null>(null),
      neighborhood: new FormControl<string | null>(null),
    });
  }
}
